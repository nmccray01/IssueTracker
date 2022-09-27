//Placeholder   , {useState}
import React from "react";
import Button from '@mui/material/Button';
import { useNavigate } from "react-router-dom";


function Frontpage(){
    let navigate = useNavigate();

    return(
        <div>
            <div>
                <h1>Issuetracker</h1> <br/>
            </div>
            <div>
                <Button variant={"outlined"} onClick={() => navigate("/menu")}>Enter</Button>
            </div>
        </div>
    )
}

export default Frontpage;