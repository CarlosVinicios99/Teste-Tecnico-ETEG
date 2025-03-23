import { Color } from "./Color"

export interface User {
    id: string
    name: string
    email: string
    cpf: string
    favoriteColor: Color
}