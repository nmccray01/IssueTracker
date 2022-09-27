import DefaultNavbar from "../../models/Navbar/DefaultNavbar";
import Projectcard from "../../models/Projectcard/Projectcard";

function MenuPage(){

    return(
        <div>
            <DefaultNavbar/>
            <h1>This is the menu</h1>
            <Projectcard/>
        </div>
    )

}

export default MenuPage;