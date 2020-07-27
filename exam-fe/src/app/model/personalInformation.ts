import { Contact } from './contact';
import { Address } from './address';

export class PersonalInformation {
    id: number;
    firstName: string;
    middleName: string;
    lastName: string;
    gender: string;
    maritalStatus: string;
    age: number;
    birthDate: string;
    contacts: Contact[];
    addresses: Address[];
}

