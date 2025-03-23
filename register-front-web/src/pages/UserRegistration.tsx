import LogoSection from "../components/LogoSection"
import RegistrationForm from "../components/RegistrationForm"
import "./UserRegistration.css"

const UserRegistration = () => {
    return (
        <div className="page-container">
            <LogoSection/>
            <RegistrationForm/>
        </div>
    )
}

export default UserRegistration