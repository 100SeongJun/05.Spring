import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter, Route, Router, Routes } from "react-router-dom";
import { Emps } from "./component/Emps";
import { SubDept } from "./component/dept/index";
import { Select, Main, Emp, Dept } from "./page/index";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Main />}>
        <Route index element={<Select />} />

        <Route path="/dept" element={<Dept />} />
        <Route path="/dept/:id" element={<SubDept />} />

        <Route path="/emp" element={<Emp />} />
        <Route path="/emp/:id" element={<Emps />} />
      </Route>
    </Routes>
  </BrowserRouter>
);
reportWebVitals();
