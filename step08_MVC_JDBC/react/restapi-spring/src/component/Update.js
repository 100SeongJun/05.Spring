import React, { useRef } from "react";
import { updateData } from "../api/getCRUD";

export const Update = ({ setcheck, check }) => {
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
      ></input>
      <input placeholder="dname" ref={dnameRef}></input>
      <input placeholder="loc" ref={locRef}></input>

      <button
        onClick={() => {
          const deptno = deptnoRef.current.value;
          const dname = dnameRef.current.value;
          const loc = locRef.current.value;
          setcheck(updateData(deptno, dname, loc));
        }}
      >
        수정
      </button>
      {check ? <div>수정에 성공하였습니다.</div> : <></>}
    </div>
  );
};
