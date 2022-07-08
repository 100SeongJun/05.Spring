import React from "react";
import { Link, useLocation } from "react-router-dom";

export const Select = () => {
  // const url = useLocation();
  // console.log(url.pathname);
  return (
    <div>
      <Link to={"/emp"}>
        <div>Emp 조회</div>
      </Link>
      <Link to={"/dept"}>
        <div>Dept 조회</div>
      </Link>
    </div>
  );
};
