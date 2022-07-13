import { useRef } from "react";
import { insertDept } from "../../api/getDept";

export const InsertDept = ({ check, setcheck }) => {
  const deptnoRef = useRef();
  const dnameRef = useRef();
  const locRef = useRef();
  return (
    <>
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
    </>
  );
};
