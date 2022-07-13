import { useEffect, useState } from "react";
import { history, useLocation, useNavigate } from "react-router-dom";
import { getOneDept } from "../../api/getDept";
import { DeptTable } from "./DeptTable";
import { UpdateDept, SelectDept } from "./index";

export const SubDept = () => {
  const [dept, setDept] = useState({});
  const deptno = useLocation().pathname.split("/");
  const [check, setCheck] = useState(false);
  const history = useNavigate();

  useEffect(() => {
    getOneDept(setDept, deptno);
  }, [check]);
  return (
    <>
      {dept && (
        <table>
          <thead>
            <tr>
              <td>deptno</td>
              <td>dname</td>
              <td>loc</td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>{dept.deptno}</td>
              <td>{dept.dname}</td>
              <td>{dept.loc}</td>
            </tr>
          </tbody>
        </table>
      )}
      <UpdateDept deptno={deptno} setCheck={setCheck} check={check} />
    </>
  );
};
