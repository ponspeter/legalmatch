import { PersonalInformation } from './personalInformation';

export class User {
    isLogin: boolean;
    username: string;
    password: string;
    role: string;
    status: string;
    information: PersonalInformation;
}
