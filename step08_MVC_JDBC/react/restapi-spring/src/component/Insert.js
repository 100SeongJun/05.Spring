import React, { useRef } from "react";
import { insertData } from "../api/getCRUD";

export const Insert = ({ setcheck, check }) => {
  const deptnoRef = useRef();
  const dnameRef = useRef();
  const locRef = useRef();

  return (
    <div>
      <input
        placeholder="deptno"
        ref={deptnoRef}
        onChange={() => {
          setcheck(false);
        }}
      />
      <input placeholder="dname" ref={dnameRef}></input>
      <input placeholder="loc" ref={locRef}></input>

      <button
        onClick={() => {
          const deptno = deptnoRef.current.value;
          const dname = dnameRef.current.value;
          const loc = locRef.current.value;
          setcheck(insertData(deptno, dname, loc));
        }}
      >
        저장
      </button>

      {check ? <div>저장에 성공하였습니다.</div> : <></>}
    </div>
  );
};
