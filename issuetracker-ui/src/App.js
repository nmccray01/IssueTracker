import './App.css';
import Frontpage from "./pages/Frontpage/Frontpage";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import MenuPage from "./pages/MenuPage/MenuPage";

function App() {
  return (
      <Router>
          <div className="App" >
            <Routes>
                <Route path={"/"} element={<Frontpage/>}/>
                <Route path={"/menu"} element={<MenuPage/>}/>
            </Routes>
          </div>
      </Router>
  );
}

export default App;
