package com.legalmatch.exam.service;

import com.legalmatch.exam.dto.AddressDto;
import com.legalmatch.exam.dto.ContactDto;
import com.legalmatch.exam.dto.EmployeeDto;
import com.legalmatch.exam.dto.PersonalInformationDto;
import com.legalmatch.exam.enums.EmployeeStatusEnum;
import com.legalmatch.exam.enums.RoleEnum;
import com.legalmatch.exam.model.*;
import com.legalmatch.exam.repository.*;
import com.legalmatch.exam.util.Helper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService implements DefaultEmployeeService {

    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;
    private final EmployeeRepository employeeRepository;
    private final PersonalInformationRepository personalInformationRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<EmployeeDto> getEmployees() {

          return employeeRepository.findEmployeeByStatus(EmployeeStatusEnum.ACTIVE)
                .stream()
                .collect(Collectors.toList())
                .stream()
                .map(res -> EmployeeDto.builder()
                        .employeeId(res.getId())
                        .position(res.getPosition())
                        .status(res.getStatus())
                        .dateHired(Helper.convertLocalDateToString(res.getDateHired()))
                        .yearsInCompany(Helper.calculateDateToStringNumber(res.getDateHired(), LocalDate.now(), false))
                        .personalInformation(
                                PersonalInformationDto.builder()
                                        .personalInformationId(res.getInformation().getId())
                                        .firstName(res.getInformation().getFirstName())
                                        .middleName(res.getInformation().getMiddleName())
                                        .lastName(res.getInformation().getLastName())
                                        .birthDate(Helper.convertLocalDateToString(res.getInformation().getBirthDate()))
                                        .age(Helper.calculateDateToStringNumber(res.getInformation().getBirthDate(), LocalDate.now(),true))
                                        .gender(res.getInformation().getGender())
                                        .maritalStatus(res.getInformation().getMaritalStatus())
                                        .contacts(
                                                contactRepository.findByPersonalInformationId(res.getInformation().getId())
                                                .stream()
                                                .filter(contact -> contact.isPrimary() == Boolean.TRUE)
                                                .map(contact -> ContactDto.builder()
                                                        .contactId(contact.getId())
                                                        .phone(contact.getPhone())
                                                        .mobile(contact.getMobile())
                                                        .email(contact.getEmail())
                                                        .isPrimary(contact.isPrimary())
                                                        .build())
                                                .collect(Collectors.toList())
                                        )
                                        .addresses(
                                                addressRepository.findByPersonalInformationId(res.getInformation().getId())
                                                        .stream()
                                                        .filter(address -> address.isPrimary() == Boolean.TRUE)
                                                        .map(address -> AddressDto.builder()
                                                                .addressId(address.getId())
                                                                .houseNumber(address.getHouseNumber())
                                                                .street(address.getStreet())
                                                                .town(address.getTown())
                                                                .province(address.getProvince())
                                                                .postalCode(address.getPostalCode())
                                                                .isPrimary(address.isPrimary())
                                                                .build())
                                                        .collect(Collectors.toList())
                                        )
                                        .build())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findByIdAndStatus(id, EmployeeStatusEnum.ACTIVE).get();

        return  EmployeeDto.builder()
                .employeeId(employee.getId())
                .position(employee.getPosition())
                .status(employee.getStatus())
                .dateHired(Helper.convertLocalDateToString(employee.getDateHired()))
                .yearsInCompany(Helper.calculateDateToStringNumber(employee.getDateHired(), LocalDate.now(), false))
                .personalInformation(
                        PersonalInformationDto.builder()
                                .personalInformationId(employee.getInformation().getId())
                                .firstName(employee.getInformation().getFirstName())
                                .middleName(employee.getInformation().getMiddleName())
                                .lastName(employee.getInformation().getLastName())
                                .birthDate(Helper.convertLocalDateToString(employee.getInformation().getBirthDate()))
                                .gender(employee.getInformation().getGender())
                                .maritalStatus(employee.getInformation().getMaritalStatus())
                                .age(Helper.calculateDateToStringNumber(employee.getInformation().getBirthDate(), LocalDate.now(), false))
                                .contacts(
                                        contactRepository.findByPersonalInformationId(employee.getInformation().getId())
                                                .stream()
                                                .map(contact -> ContactDto.builder()
                                                        .contactId(contact.getId())
                                                        .phone(contact.getPhone())
                                                        .mobile(contact.getMobile())
                                                        .email(contact.getEmail())
                                                        .isPrimary(contact.isPrimary())
                                                        .build())
                                                .collect(Collectors.toList())
                                        )
                                .addresses(
                                        addressRepository.findByPersonalInformationId(employee.getInformation().getId())
                                                .stream()
                                                .map(address -> AddressDto.builder()
                                                        .addressId(address.getId())
                                                        .houseNumber(address.getHouseNumber())
                                                        .street(address.getStreet())
                                                        .town(address.getTown())
                                                        .province(address.getProvince())
                                                        .postalCode(address.getPostalCode())
                                                        .isPrimary(address.isPrimary())
                                                        .build())
                                                .collect(Collectors.toList())
                                )
                                .build())
                .build();


    }

    @Override
    @Transactional
    public EmployeeDto saveEmployee(EmployeeDto request) {

        PersonalInformation personalInformation = personalInformationRepository.save(
                PersonalInformation.builder()
                    .firstName(request.getPersonalInformation().getFirstName())
                    .middleName(request.getPersonalInformation().getMiddleName())
                    .lastName(request.getPersonalInformation().getLastName())
                    .birthDate(Helper.convertStringToLocalDate(request.getPersonalInformation().getBirthDate()))
                    .gender(request.getPersonalInformation().getGender())
                    .maritalStatus(request.getPersonalInformation().getMaritalStatus())
                    .age(Helper.convertDateToNumber(Helper.convertStringToLocalDate(request.getPersonalInformation().getBirthDate()), LocalDate.now()))
                    .contacts(request.getPersonalInformation().getContacts()
                            .stream()
                            .map(data -> Contact.builder()
                                    .phone(data.getPhone())
                                    .mobile(data.getMobile())
                                    .email(data.getEmail())
                                    .isPrimary(data.isPrimary())
                                    .build())
                            .collect(Collectors.toSet()))
                    .addresses(request.getPersonalInformation().getAddresses()
                            .stream()
                            .map(data -> Address.builder()
                                    .houseNumber(data.getHouseNumber())
                                    .street(data.getStreet())
                                    .town(data.getTown())
                                    .province(data.getProvince())
                                    .postalCode(data.getPostalCode())
                                    .isPrimary(data.isPrimary())
                                    .build())
                            .collect(Collectors.toSet()))
                .build()
        );

        Employee employee = employeeRepository.save(
                Employee.builder()
                .information(personalInformation)
                .position(request.getPosition())
                .dateHired(Helper.convertStringToLocalDate(request.getDateHired()))
                .yearsInService(Helper.convertDateToNumber(Helper.convertStringToLocalDate(request.getDateHired()), LocalDate.now()))
                .status(EmployeeStatusEnum.ACTIVE)
                .build()
        );

        User user = userRepository.save(
                User.builder()
                .information(personalInformation)
                .username(request.getPersonalInformation().getLastName().toUpperCase().concat("_").concat(request.getPersonalInformation().getFirstName().toUpperCase()))
                .password(passwordEncoder.encode("Salty@123456"))
                .status(EmployeeStatusEnum.ACTIVE)
                .role(RoleEnum.ROLE_STANDARD_USER)
                .build()
        );


        return EmployeeDto.builder()
                .employeeId(employee.getId())
                .status(employee.getStatus())
                .dateHired(Helper.convertLocalDateToString(employee.getDateHired()))
                .yearsInCompany(Helper.calculateDateToStringNumber(employee.getDateHired(), LocalDate.now(), false))
                .personalInformation(PersonalInformationDto.builder()
                                    .personalInformationId(personalInformation.getId())
                                    .firstName(personalInformation.getFirstName())
                                    .lastName(personalInformation.getLastName())
                                    .build())
                .build();
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto request) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            Optional<PersonalInformation> optionalPersonalInformation =
                    personalInformationRepository.findById(employee.getInformation().getId());

            if(optionalPersonalInformation.isPresent()) {

                PersonalInformation personalInformation = optionalPersonalInformation.get();

                personalInformationRepository.save(
                        personalInformation.builder()
                                .id(personalInformation.getId())
                                .firstName(request.getPersonalInformation().getFirstName())
                                .middleName(request.getPersonalInformation().getMiddleName())
                                .lastName(request.getPersonalInformation().getLastName())
                                .birthDate(Helper.convertStringToLocalDate(request.getPersonalInformation().getBirthDate()))
                                .gender(request.getPersonalInformation().getGender())
                                .maritalStatus(request.getPersonalInformation().getMaritalStatus())
                                .contacts(request.getPersonalInformation().getContacts()
                                        .stream()
                                        .map(data -> Contact.builder()
                                                .phone(data.getPhone())
                                                .mobile(data.getMobile())
                                                .email(data.getEmail())
                                                .isPrimary(data.isPrimary())
                                                .build())
                                        .collect(Collectors.toSet()))
                                .addresses(request.getPersonalInformation().getAddresses()
                                        .stream()
                                        .map(data -> Address.builder()
                                                .houseNumber(data.getHouseNumber())
                                                .street(data.getStreet())
                                                .town(data.getTown())
                                                .province(data.getProvince())
                                                .postalCode(data.getPostalCode())
                                                .isPrimary(data.isPrimary())
                                                .build())
                                        .collect(Collectors.toSet()))
                                .build()
                );

                employeeRepository.save(
                        employee.builder()
                                .id(employee.getId())
                                .information(personalInformation)
                                .position(request.getPosition())
                                .dateHired(Helper.convertStringToLocalDate(request.getDateHired()))
                                .status(request.getStatus())
                                .build()
                );


                return EmployeeDto.builder()
                        .employeeId(employee.getId())
                        .status(employee.getStatus())
                        .dateHired(Helper.convertLocalDateToString(employee.getDateHired()))
                        .yearsInCompany(Helper.calculateDateToStringNumber(employee.getDateHired(), LocalDate.now(), false))
                        .personalInformation(PersonalInformationDto.builder()
                                .personalInformationId(personalInformation.getId())
                                .firstName(personalInformation.getFirstName())
                                .lastName(personalInformation.getLastName())
                                .build())
                        .build();

            }
        }

        return null;

    }

    @Override
    @Transactional
    public Void removeEmployee(Long id) {
        long personalInformationId = personalInformationRepository.findById(id).get().getId();
        personalInformationRepository.deleteById(personalInformationId);
        userRepository.deleteById(personalInformationId);
        employeeRepository.deleteById(personalInformationId);
        return null;
    }
}
