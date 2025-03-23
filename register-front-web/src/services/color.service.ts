import { Color } from "../interfaces/Color";
import { ApiError } from "./errors/ApiError";

export class ColorService {

    private static instance: ColorService

    private constructor(){}

    static getInstance(): ColorService {
        if(!ColorService.instance){
            ColorService.instance = new ColorService();
        }
        return ColorService.instance
    }

    async getAllColors(){
        try{
            const url: string = `${import.meta.env.VITE_REGISTER_API_URL}colors`
            const response: Response = await fetch(url, {
                method: "GET",
                headers: {
                    "Content-Type": "application/json"
                },
            })

            console.log(JSON.stringify(response, null, 2))

            if(response.status !== 200){
                const responseError: ApiError = await response.json()
                return responseError
            }

            const colors: Color[] = await response.json()    
            return colors
        }
        catch(error: unknown){
            return {
                status: 500
            }
        }
    }
}