import React from 'react';
import {Grid} from "@mui/material";
import Projectcard from "./Projectcard";
import axios from "axios";

export default class ProjectcardGrid extends React.Component{

    state= {
        projects: []
    }

    componentDidMount() {
        axios.get("http://Localhost:8080/api/v1/project").then(res=>{
            console.log(res.data);
            const projects = res.data.content;
            this.setState({projects});
        }).catch(err =>{
            console.log(err);
        })
    }

    render(){
        return(
            <Grid container spacing={2}>
                {this.state.project && this.state.projects.map((project) =>
                    <Grid item xs={6}>
                        <Projectcard name={project.name} description={project.description}/>
                    </Grid>)}
            </Grid>
        )
    }
}