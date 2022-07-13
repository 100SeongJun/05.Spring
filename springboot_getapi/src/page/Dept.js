import React, { useEffect, useRef, useState } from "react";
import { Link, useLocation } from "react-router-dom";
import { deleteDept, getDept, getOneDept, insertDept } from "../api/getDept";
import {
  DeptTable,
  UpdateDept,
  InsertDept,
  SelectDept,
} from "../component/dept/index";
import "./Dept.css";

export const Dept = () => {
  const [allData, setdept] = useState("");
  const [check, setcheck] = useState(false);
  const query = useLocation();

  useEffect(() => {
    getDept(setdept, query);
  }, [check, query]);

  return (
    <div>
      <InsertDept check={check} setcheck={setcheck} />
      <hr />
      <DeptTable allData={allData} check={check} setcheck={setcheck} />
      <hr />
      <SelectDept />
    </div>
  );
};
