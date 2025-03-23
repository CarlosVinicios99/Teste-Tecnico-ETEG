import { BrowserRouter, Route, Routes } from 'react-router-dom'
import UserRegistration from './pages/UserRegistration'

function App() {

  return (
    <BrowserRouter>
    <Routes>
      <Route index element={<UserRegistration />}/>
      <Route path="/user-registration" element={<UserRegistration/>}/>
    </Routes>
  </BrowserRouter>
  )
}

export default App
