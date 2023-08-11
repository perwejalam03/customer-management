import axios from 'axios'
import React, { useState } from 'react'
import Form from 'react-bootstrap/Form';
import "../styles/customerregister.css"
const RegisterCustomer = () => {
   const[first_name,setFirst_name]=useState("")
   const[last_name,setLast_name]=useState("")
   const[street,setStreet]=useState()
   const[address,setAddress]=useState("")
   const[city,setCity]=useState("")
   const[state,setState]=useState("")
   const[email,setEmail]=useState("")
   const[phone,setPhone]=useState("")
   const[password,setPassword]=useState("")
  
    const handleRegister=(e)=>{
      const customer={first_name,last_name,street,address,city,state,email,phone,password}
      axios.post("http://localhost:8080/createCustomer",customer)
      .then(()=>{
        alert("Data added successfully")
        console.log("Data has been registered");})
      .catch(()=>{console.log("something wrong");})
      e.preventDefault();
    }
  return (
    <div>
      <form action="" id='form'>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>First Name:</Form.Label>
        <Form.Control type="text" placeholder="Enter your first Name" value={first_name}  onChange={(e)=>setFirst_name(e.target.value)}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Last Name:</Form.Label>
        <Form.Control type="text" placeholder="Enter your last Name" value={last_name}  onChange={(e)=>setLast_name(e.target.value)}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Phone Number:</Form.Label>
        <Form.Control type="tel" pattern='[789][0-9]{10}' placeholder="Enter your phone number" value={phone}  onChange={(e)=>setPhone(e.target.value)}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control type="email" placeholder="Enter your email" value={email}  onChange={(e)=>setEmail(e.target.value)} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Enter Password" value={password}  onChange={(e)=>setPassword(e.target.value)} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Street:</Form.Label>
        <Form.Control type="text" placeholder="Enter your Street Name" value={street}  onChange={(e)=>setStreet(e.target.value)}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Address:</Form.Label>
        <Form.Control type="text" placeholder="Enter your Address" value={address}  onChange={(e)=>setAddress(e.target.value)}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>State:</Form.Label>
        <Form.Control type="text" placeholder="Enter your State" value={state}  onChange={(e)=>setState(e.target.value)}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>City:</Form.Label>
        <Form.Control type="text" placeholder="Enter your City" value={city}  onChange={(e)=>setCity(e.target.value)}/>
      </Form.Group>
        <button type="submit" onClick={handleRegister} className='btn btn-success px-4 mx-5'>Register</button>
      </form>
    </div>
  )
}

export default RegisterCustomer
