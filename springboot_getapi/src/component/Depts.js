import React, { useState } from "react";
import { useLocation } from "react-router-dom";
import { getOneDept } from "../api/getDept";
import "./style.css";
export const Depts = () => {
  const deptno = useLocation("id").pathname.split("/")[2];
  const [checkUpdate, setCheckUpdate] = useState(false);
  const [getOne, setDept] = useState([]);
  getOneDept(setDept, deptno);

  return checkUpdate ? (
    <div>
      <input placeholder="dname"></input>
      <br />
      <input placeholder="loc"></input>
      <br />
      <button onClick={() => {}}>수정하기</button>
    </div>
  ) : (
    <div>
      {/* <div>{getOne.deptno}</div>
      <div>{getOne.dname}</div>
      <div>{getOne.loc}</div> */}
      <table>
        <tbody>
          <tr>
            <td>deptno</td>
            <td>{getOne.deptno}</td>
          </tr>
          <tr>
            <td>dname</td>
            <td>{getOne.dname}</td>
          </tr>
          <tr>
            <td>loc</td>
            <td>{getOne.loc}</td>
          </tr>
        </tbody>
      </table>
      <button
        onClick={() => {
          setCheckUpdate(true);
        }}
      >
        수정하기
      </button>
    </div>
  );
};
