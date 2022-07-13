import { useEffect, useState } from "react";
import { getDept, getOneDept } from "../../api/getDept";
import { insertData } from "../../api/getEmp";

const onClickHandler = async (setDept, dept) => {
  const deptno = document.getElementsByName("deptno")[0].value;

  await getOneDept(setDept, deptno);
};

export const InsertEmp = ({ setDept, dept }) => {
  const [check, setcheck] = useState(false);
  useEffect(() => {
    var emp;
    dept
      ? (emp = {
          empno: document.getElementsByName("empno")[0].value,
          ename: document.getElementsByName("ename")[0].value,
          job: document.getElementsByName("job")[0].value,
          mgr: document.getElementsByName("mgr")[0].value,
          hiredate: null,
          // hiredate: document.getElementsByName("hiredate")[0].value,
          sal: document.getElementsByName("sal")[0].value,
          comm: document.getElementsByName("comm")[0].value,
          dept: dept,
        })
      : alert("입력값이 잘못되었습니다.");
    console.log(emp);
    emp && (emp.empno ? insertData(emp) : <></>);
  }, [check]);
  return (
    <>
      <div>추가</div>
      <div>
        <input name="empno" placeholder="empno" />
      </div>
      <div>
        <input name="ename" placeholder="ename" />
      </div>
      <div>
        <input name="job" placeholder="job" />
      </div>
      <div>
        <input name="mgr" placeholder="mgr" />
      </div>
      <div>
        <input name="hiredate" placeholder="hiredate" />
      </div>
      <div>
        <input name="sal" placeholder="sal" />
      </div>
      <div>
        <input name="comm" placeholder="comm" />
      </div>
      <div>
        <input name="deptno" placeholder="deptno" />
      </div>
      <div>
        <button
          onClick={async () => {
            await onClickHandler(setDept, dept);
            setcheck(!check);
          }}
        >
          추가
        </button>
      </div>
      <hr />
    </>
  );
};
