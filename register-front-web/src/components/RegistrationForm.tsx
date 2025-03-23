import { useEffect, useState } from "react";
import { Color } from "../interfaces/Color";
import "./RegistrationForm.css"
import { ColorService } from "../services/color.service";

const RegistrationForm = () => {

    const [colors, setColors] = useState<Color[]>([]);

    useEffect(() => {
        const fetchColors = async () => {
            const colorService = ColorService.getInstance();
            const result = await colorService.getAllColors();

            if (Array.isArray(result)) {
                setColors(result);
            } else {
                console.error("Erro ao carregar as cores:", result);
            }
        };
        fetchColors();
    }, []);

    return (
        <div className="registration-form-container">
            <h1 className="title">Cadastro De Usuário</h1>

            <form className="form-content">
                <input type="text" placeholder="Nome Completo"/>
                <input type="text" placeholder="E-mail"/>
                <input type="text" placeholder="CPF (somente números)"/>

                <select className="select-color">
                <option value="">Cor Preferida</option>
                    {colors.map((color) => (
                        <option key={color.id} value={color.name}>
                            {color.name}
                        </option>
                    ))}
                </select>
            </form>

            <button className="registration-button">Cadastrar</button>
        </div>
    )
}

export default RegistrationForm