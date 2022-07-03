import "./Main.css";
import { Link, Outlet } from "react-router-dom";
function Main() {
  return (
    <>
      <header>
        <div className="home">
          <Link to="/">
            <img src="/home.png"></img>
            <div className="homeText">home</div>
          </Link>
        </div>
        <div className="flex">Dept_CRUD Program</div>
        <div className="flex">22-07-03</div>
      </header>
      <Outlet />
      <footer></footer>
    </>
  );
}
export default Main;
