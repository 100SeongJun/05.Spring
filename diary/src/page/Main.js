import { Link, Outlet } from "react-router-dom";
import "../Main.css";
import { Footer } from "./Footer";
function Main() {
  return (
    <div className="container">
      <header>
        <div>
          <Link to="/">
            <div>home</div>
          </Link>
        </div>
      </header>
      <Outlet></Outlet>
      <footer>
        <Footer />
      </footer>
    </div>
  );
}
export default Main;
