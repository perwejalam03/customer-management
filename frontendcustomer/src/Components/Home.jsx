import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function Home() {
    let customer1 = JSON.parse(localStorage.getItem("currentCustomer"));
    let [customer,setCustomer]=useState([])
  useEffect(() => {
    let fetchData = () => {
      axios.get("http://localhost:8080/getCustomerList")
        .then((res) => {
          console.log(res.data.data);
          setCustomer(res.data.data)
        })
        .catch(() => {
          alert("Not a good request");
        });
    };
    fetchData();
  },[]);

  let deleteCustomer = () => {
    axios.post(`http://localhost:8080/deleteCustomer/${customer1.id}`)
      .then((res) => {
        console.log(res.data.data);
      })
      .catch(() => {
        alert("Not a good request");
      });
  };

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th>ID</th>
              <th scope="col">firstname</th>
              <th scope="col">lastname</th>
              <th scope="col">address</th>
              <th scope="col">city</th>
              <th scope="col">state</th>
              <th scope="col">street</th>
              <th scope="col">email</th>
              <th scope="col">phone</th>
              <th scope='col'>Password</th>
              <th class="action" ><span>Action</span></th>
            </tr>
          </thead>
          <tbody>
            {customer.map((x) => (
              <tr>
                 <td>{x.id}</td>
                <td>{x.first_name}</td>
                <td>{x.last_name}</td>
                <td>{x.address}</td>
                <td>{x.city}</td>
                <td>{x.state}</td>
                <td>{x.street}</td>
                <td>{x.email}</td>
                <td>{x.phone}</td>
                <td>{x.password}</td>
                
                <td>
                  <Link
                    className="btn btn-outline-primary mx-2"
                    to={`/updatecustomer`}
                  >
                    Edit
                  </Link>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deleteCustomer(x.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

// import React, { useEffect, useState } from "react";
// import axios from "axios";
// import { Link, useParams } from "react-router-dom";

// export default function Home() {
//   const [users, setUsers] = useState([]);
//   const [loading, setLoading] = useState(true);

//   useEffect(() => {
//     loadUsers();
//   }, []);

//   const loadUsers = async () => {
//     try {
//       const result = await axios.get("http://localhost:8080/getCustomerList");
      
//       let results = result.data;
//       let data = results.body;
//       if(data.length > 0){
        
//         setUsers(data)
//       } else {
//         console.error("Invalid data format received from the server.");
//       }
//     } catch (error) {
//       console.error("Error fetching data:", error);
//     } finally {
//       setLoading(false); // Set loading to false when the request is complete
//     }
//   };

//   const deleteUser = async (id) => {
//     await axios.delete(`http://localhost:8080/customer/${id}`);
//     loadUsers();
//   };

//   return (
//     <div className="container">
//       <div className="py-4">
//         <table className="table border shadow">
//           <thead>
//             <tr>
//               <th>ID</th>
//               <th scope="col">firstname</th>
//               <th scope="col">lastname</th>
//               <th scope="col">address</th>
              
//               <th scope="col">city</th>
//               <th scope="col">state</th>
//               <th scope="col">email</th>
//               <th scope="col">phone</th>
//               <th scope='col'>Password</th>
//               <th class="action" ><span>Action</span></th>
//             </tr>
//           </thead>
//           <tbody>
//             {users.map((user, index) => (
//               <tr>
//                 <th scope="row" key={index}>
//                   {index + 1}
//                 </th>
//                 <td>{user.first_name}</td>
//                 <td>{user.last_name}</td>
//                 <td>{user.address}</td>
               
//                 <td>{user.city}</td>
//                 <td>{user.state}</td>
//                 <td>{user.email}</td>
//                 <td>{user.phone}</td>
//                 <td>{user.password}</td>
                
//                 <td>
//                   {/* <Link
//                     className="btn btn-primary mx-2"
//                     to={`/viewuser/${user.id}`}
//                   >
//                     View
//                   </Link> */}
//                   <Link
//                     className="btn btn-outline-primary mx-2"
//                     to={`/edituser/${user.id}`}
//                   >
//                     Edit
//                   </Link>
//                   <button
//                     className="btn btn-danger mx-2"
//                     onClick={() => deleteUser(user.id)}
//                   >
//                     Delete
//                   </button>
//                 </td>
//               </tr>
//             ))}
//           </tbody>
//         </table>
//       </div>
//     </div>
//   );
// }