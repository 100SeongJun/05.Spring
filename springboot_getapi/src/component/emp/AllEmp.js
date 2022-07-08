export const AllEmp = ({ empData }) => {
  return (
    <table>
      <thead>
        <tr>
          <th>EMPNO</th>
          <th>ENAME</th>
          <th>JOB</th>
          <th>MGR</th>
          <th>HIREDATE</th>
          <th>SAL</th>
          <th>COMM</th>
          <th>DEPTNO</th>
        </tr>
      </thead>
      <tbody>
        {empData.map((emp, index) => {
          return (
            <tr key={emp.empno + index}>
              <td>{emp.empno}</td>
              <td>{emp.ename}</td>
              <td>{emp.job}</td>
              <td>{emp.mgr}</td>
              <td>{emp.hiredate}</td>
              <td>{emp.sal}</td>
              <td>{emp.comm}</td>
              <td>{emp.dept != null ? emp.dept.deptno : <></>}</td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
};
