import React, { useEffect, useRef, useState } from "react";
import { Link, useLocation } from "react-router-dom";
import { deleteDept, getDept, getOneDept, insertDept } from "../api/getDept";
import { Depts } from "../component/Depts";

export const Dept = () => {
  const [allDept, setdept] = useState([]);
  const deptnoRef = useRef();
  const dnameRef = useRef();
  const locRef = useRef();
  const [selectDeptno, setDeptno] = useState("");
  const [check, setcheck] = useState(false);
  useEffect(() => {
    getDept(setdept);
  }, [check]);

  return (
    <div>
      <hr />
      <h2>추가</h2>
      <div>
        <input ref={deptnoRef} placeholder="deptno" />
        <br />
        <input ref={dnameRef} placeholder="dname" />
        <br />
        <input ref={locRef} placeholder="loc" />
        <button
          onClick={async () => {
            const deptno = deptnoRef.current.value;
            const dname = dnameRef.current.value;
            const loc = locRef.current.value;
            await insertDept(deptno, dname, loc);
            setcheck(!check);
          }}
        >
          추가
        </button>
      </div>
      <hr />
      <h2>특정 데이터 출력</h2>
      <input
        placeholder="deptno입력"
        onChange={(e) => {
          setDeptno(e.target.value);
        }}
      />
      <Link to={`/dept/${selectDeptno}`}>
        <button
          onClick={() => {
            setcheck(!check);
          }}
        >
          특정데이터 출력
        </button>
      </Link>

      <hr />
      <table>
        <thead>
          <tr>
            <td>deptno</td>
            <td>dname</td>
            <td>loc</td>
            <td>삭제</td>
            <td>수정</td>
          </tr>
        </thead>
        {allDept.map((data) => {
          return (
            <tbody key={data.deptno}>
              <tr>
                <td>{data.deptno}</td>
                <td>{data.loc}</td>
                <td>{data.dname}</td>
                <td>
                  <button
                    onClick={async () => {
                      const deptno = data.deptno;
                      await deleteDept(deptno);
                      setcheck(!check);
                    }}
                  >
                    삭제
                  </button>
                </td>
                <td>
                  <Link to={`/dept/${data.deptno}`}>
                    <button>수정</button>
                  </Link>
                </td>
              </tr>
            </tbody>
          );
        })}
      </table>
    </div>
  );
};
