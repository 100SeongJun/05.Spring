import { Link } from "react-router-dom";
import { deleteDept } from "../../api/getDept";

export const DeptTable = ({ allData, check, setcheck }) => {
  return (
    <>
      <h2>Dept Table</h2>
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
        {allData &&
          allData.dtoList.map((data) => {
            return (
              <tbody key={data.deptno}>
                <tr>
                  <td>{data.deptno}</td>
                  <td>{data.dname}</td>
                  <td>{data.loc}</td>
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
      {allData &&
        allData.pageList.map((page) => {
          return (
            <Link key={page} to={`/dept?page=${page}`} className="paging">
              {page}
            </Link>
          );
        })}
    </>
  );
};
