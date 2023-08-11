import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import RegisterCustomer from './Components/RegisterCustomer';
import Home from './Components/Home';
import UpdateCustomer from './Components/UpdateCustomer';
import CustomerLogin from './Components/CustomerLogin';
import { Route, Routes } from 'react-router';
import Navbar from './Components/Navbar';
import { BrowserRouter } from 'react-router-dom';
const App = () => {
  return (
    <div>
      <BrowserRouter>
        <Navbar/>
        <Routes>
          <Route  exact path="/" element={<Home />} />
          <Route exact path="/addcustomer" element={<RegisterCustomer/> }/>
          <Route exact path="/updatecustomer" element={<UpdateCustomer/>} />
          {/* <Route exact path="/viewuser/:id" element={<ViewUser/>} /> */}
          <Route exact path="/login" element={<CustomerLogin/>} />
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
