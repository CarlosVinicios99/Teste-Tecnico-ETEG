import { User } from "../interfaces/User";
import { ApiError } from "./errors/ApiError";
import { CreateUserDTO } from "./dto/CreateUserDTO";

export class UserService {

    private static instance: UserService

    private constructor(){}

    static getInstance(): UserService {
        if(!UserService.instance){
            UserService.instance = new UserService();
        }
        return UserService.instance
    }

    async createUser(data: CreateUserDTO): Promise<User | ApiError>{
        try{
            const url: string = `${import.meta.env.VITE_REGISTER_API_URL}users`
            const response: Response = await fetch(url, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data),
            })

            if(response.status !== 201){
                const responseError: ApiError = await response.json()
                return responseError
            }

            const user: User = await response.json()    
            return user
        }
        catch(error: unknown){
            return {
                status: 500
            }
        }
    }

}