import {Card, CardActionArea, CardContent, Typography} from "@mui/material";

//<Card sx={{ minWidth: 275, maxWidth: 445}}>
function Projectcard(props){
    return(
        <div>
            <Card>
                <CardActionArea>
                    <CardContent onClick={()=>{}}>
                        <Typography variant="h5" component="div">
                            {props.name}
                        </Typography>
                        <Typography sx={{ mb: 1.5 }} color="text.secondary">
                            {props.description}
                        </Typography>
                    </CardContent>
                </CardActionArea>
            </Card>
        </div>
    )
}

export default Projectcard;