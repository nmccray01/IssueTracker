import {Card, CardActionArea, CardContent, Typography} from "@mui/material";


function Projectcard(){
    return(
        <div>
            <Card sx={{ minWidth: 275, maxWidth: 445 }}>
                <CardActionArea>
                <CardContent onClick={()=>{}}>
                    <Typography variant="h5" component="div">
                        Projectname
                    </Typography>
                    <Typography sx={{ mb: 1.5 }} color="text.secondary">
                        Projectdescription
                    </Typography>

                </CardContent>
                </CardActionArea>
            </Card>

        </div>
    )
}

export default Projectcard;