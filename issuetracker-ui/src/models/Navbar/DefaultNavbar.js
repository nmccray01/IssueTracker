import AppBar from '@mui/material/AppBar';
import {Typography} from "@mui/material";
function DefaultNavbar(){
    return(
        <AppBar position={"static"} sx={{bgcolor: "orange"}}>
            <Typography variant="h6" color="inherit" component="div">
                Issuetracker
            </Typography>
        </AppBar>

    );
}

export default DefaultNavbar;