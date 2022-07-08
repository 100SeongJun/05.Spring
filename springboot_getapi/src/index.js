import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter, Route, Router, Routes } from "react-router-dom";
import { Main } from "./page/Main";
import { Select } from "./page/Select";
import { Emp } from "./page/Emp";
import { Depts } from "./component/Depts";
import { Emps } from "./component/Emps";
import { Dept } from "./page/Dept";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Main />}>
        <Route index element={<Select />} />

        <Route path="/dept" element={<Dept />} />
        <Route path="/dept/:id" element={<Depts />} />

        <Route path="/emp" element={<Emp />} />
        <Route path="/emp/:id" element={<Emps />} />
      </Route>
    </Routes>
  </BrowserRouter>
);
reportWebVitals();
