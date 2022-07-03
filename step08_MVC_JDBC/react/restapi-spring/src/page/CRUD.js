import { useState } from "react";
import { useLocation } from "react-router-dom";
import { Delete } from "../component/Delete";
import { Insert } from "../component/Insert";
import { SelectAll } from "../component/SelectAll";
import "./Main.css";
import { Update } from "../component/Update";
const CRUD = () => {
  const location = useLocation();
  const [data, setdata] = useState([]);
  const [check, setcheck] = useState(false);
  switch (location.pathname) {
    case "/search":
      return <SelectAll setdata={setdata} data={data} />;
    case "/delete":
      return <Delete setcheck={setcheck} check={check} />;
    case "/update":
      return <Update setcheck={setcheck} check={check} />;
    case "/insert":
      return <Insert setcheck={setcheck} check={check} />;
  }
};

export default CRUD;
