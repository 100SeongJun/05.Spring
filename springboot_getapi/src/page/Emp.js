import React, { useEffect, useReducer, useState } from "react";
import { getData } from "../api/getEmp";
import "../component/style.css";
import { InsertEmp } from "../component/emp/InsertEmp";
import { AllEmp } from "../component/emp/AllEmp";
export const Emp = () => {
  const [empData, setEmpData] = useState([]);
  const [dept, setDept] = useState({});
  // const [emp,setEmp]= useState({});
  useEffect(() => {
    getData(setEmpData);
  }, []);

  return (
    <div>
      <hr />
      <AllEmp empData={empData} />
      <hr />
      <InsertEmp setDept={setDept} dept={dept} />
    </div>
  );
};
