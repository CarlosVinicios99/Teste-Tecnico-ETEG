import { useEffect, useState } from "react";
import { Color } from "../interfaces/Color";
import "./RegistrationForm.css"
import { ColorService } from "../services/color.service";
import { CreateUserDTO } from "../services/dto/CreateUserDTO";
import { UserService } from "../services/user.service";

const RegistrationForm = () => {

    const [colors, setColors] = useState<Color[]>([])
    const [name, setName] = useState<string>("")
    const [email, setEmail] = useState<string>("")
    const [cpf, setCpf] = useState<string>("")
    const [selectedColor, setSelectedColor] = useState<string>("")

    useEffect(() => {
        const fetchColors = async () => {
            const colorService = ColorService.getInstance()
            const result = await colorService.getAllColors()

            if (Array.isArray(result)) {
                setColors(result)
            } else {
                console.error("Erro ao carregar as cores:", result)
            }
        };
        fetchColors();
    }, []);

    const handleRegister = async (event: React.FormEvent) => {
        
        event.preventDefault();

        if (!name || !email || !cpf || !selectedColor) {
            alert("Por favor, preencha todos os campos.")
            return
        }

        const userService = UserService.getInstance()
        const newUser: CreateUserDTO = {
            name,
            email,
            cpf,
            favoriteColorId: selectedColor
        }

        console.log

        const response = await userService.createUser(newUser)

        if ("id" in response) {
            alert("Usuário cadastrado com sucesso!")
        } 
        else {
            alert(`erro ao cadastrar usuário. ${response?.message}`)
        }

        setName("")
        setEmail("")
        setCpf("")
        setSelectedColor("")
    }

    return (
        <div className="registration-form-container">
            <h1 className="title">Cadastro De Usuário</h1>

            <form className="form-content">
                <input 
                    type="text" 
                    placeholder="Nome Completo"
                    value={name} 
                    onChange={(e) => setName(e.target.value)}
                />
                <input 
                    type="text" 
                    placeholder="E-mail"
                    value={email} 
                    onChange={(e) => setEmail(e.target.value)}
                />
                <input 
                    type="text" 
                    placeholder="CPF (somente números)"
                    value={cpf} 
                    onChange={(e) => setCpf(e.target.value)}
                />

                <select className="select-color"
                    value={selectedColor} 
                    onChange={(e) => setSelectedColor(e.target.value)}
                >
                    <option value="">Cor Preferida</option>
                        {colors.map((color) => (
                            <option key={color.id} value={color.id}>
                                {color.name}
                            </option>
                        ))}
                </select>
            </form>

            <button className="registration-button" onClick={handleRegister}>
                Cadastrar
            </button>
        </div>
    )
}

export default RegistrationForm