import React, { useRef } from "react";
import { deleteData } from "../api/getCRUD";

export const Delete = ({ setcheck, check }) => {
  const deptnoRef = useRef();
  return (
    <div>
      <input
        placeholder="deptno"
        ref={deptnoRef}
        onChange={() => {
          setcheck(false);
        }}
      ></input>
      <button
        onClick={() => {
          setcheck(deleteData(deptnoRef.current.value));
        }}
      >
        버튼
      </button>
      {check ? <div>삭제에 성공하였습니다.</div> : <></>}
    </div>
  );
};
