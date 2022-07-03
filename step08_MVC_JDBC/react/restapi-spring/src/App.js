import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Main from "./page/Main";
import CRUD from "./page/CRUD";
import Home from "./page/Home";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main />}>
          <Route index element={<Home />} />
          <Route path=":crud" element={<CRUD />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
