import "./RegistrationForm.css"

const RegistrationForm = () => {

    return (
        <div className="registration-form-container">
            <h1 className="title">Cadastro De Usuário</h1>

            <form className="form-content">
                <input type="text" placeholder="Nome Completo"/>
                <input type="text" placeholder="E-mail"/>
                <input type="text" placeholder="CPF (somente números)"/>

                <select className="select-option">
                <option value="">Cor Preferida</option>
                    <option value="Azul">Azul</option>
                    <option value="Amarelo">Amarelo</option>
                    <option value="Verde">Verde</option>
                </select>
                
            </form>

            <button className="registration-button">Cadastrar</button>
        </div>
    )
}

export default RegistrationForm