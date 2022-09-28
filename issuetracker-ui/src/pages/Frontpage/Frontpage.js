//Placeholder   , {useState}
import React from "react";
import Button from '@mui/material/Button';
import { useNavigate } from "react-router-dom";
import axios from "axios";


function Frontpage(){


    let navigate = useNavigate();

    const login = () =>{
        console.log("Login");

        let bodyFormData = new FormData();
        bodyFormData.append("username", "admin@admin.de");
        bodyFormData.append("password", "admin123");

        axios.post("http://localhost:8080/login", bodyFormData).then(r =>{
        console.log(r); console.log(r.data)})
            .catch(err => console.log(err));
    }

    return(
        <div>
            <div>
                <h1>Issuetracker</h1> <br/>
            </div>
            <div>
                <Button variant={"outlined"} onClick={() => {navigate("/menu");login();}}>Login</Button>
            </div>
        </div>
    )
}

export default Frontpage;