import DefaultNavbar from "../../models/Navbar/DefaultNavbar";
import ProjectcardGrid from "../../models/Projectcard/ProjectcardGrid";

function MenuPage(){

    return(
        <div>
            <DefaultNavbar/>
            <h1>This is the menu</h1>
            <ProjectcardGrid/>
        </div>
    )

}

export default MenuPage;