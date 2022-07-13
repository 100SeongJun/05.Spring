import { useState } from "react";
import { Link } from "react-router-dom";

export const SelectDept = () => {
  const [selectDeptno, setDeptno] = useState("");
  return (
    <>
      <h2>특정 데이터 출력</h2>
      <input
        placeholder="deptno입력"
        onChange={(e) => {
          setDeptno(e.target.value);
        }}
      />
      <Link to={`/dept/${selectDeptno}`}>
        <button onClick={() => {}}>특정데이터 출력</button>
      </Link>
    </>
  );
};
