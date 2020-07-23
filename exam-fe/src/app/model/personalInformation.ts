import { Contacts } from './contact';
import { Addresses } from './Address';

export class PersonalInformation {
    id: number;
    firstName: string;
    middleName: string;
    lastName: string;
    gender: string;
    maritalStatus: string;
    age: number;
    contacts: Contacts[];
    addresses: Addresses[];
}

