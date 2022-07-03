import React from "react";
import { getData } from "../api/getCRUD";
export const SelectAll = ({ setdata, data }) => {
  return (
    <div>
      <button
        onClick={() => {
          getData(setdata);
        }}
      >
        모든 데이터 출력
      </button>
      {data.map((dept) => {
        return (
          <div key={dept.deptno}>
            {dept.deptno} : {dept.dname} : {dept.loc}
          </div>
        );
      })}
    </div>
  );
};
