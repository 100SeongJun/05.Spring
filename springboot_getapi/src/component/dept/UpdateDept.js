import { toBeChecked } from "@testing-library/jest-dom/dist/matchers";
import { useEffect, useRef, useState } from "react";
import { updateDept } from "../../api/getDept";

export const UpdateDept = ({ deptno, setCheck, check }) => {
  const dnameRef = useRef();
  const locRef = useRef();
  return (
    <div>
      <div>
        <input placeholder="dname" ref={dnameRef}></input>
      </div>
      <div>
        <input placeholder="loc" ref={locRef}></input>
      </div>
      <button
        onClick={async () => {
          const loc = locRef.current.value;
          const dname = dnameRef.current.value;
          loc && (await updateDept(deptno, dname, loc));
          console.log(check);
          setCheck(!check);
        }}
      >
        변경
      </button>
    </div>
  );
};
