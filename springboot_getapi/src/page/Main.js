import React from "react";
import { Link, Outlet } from "react-router-dom";

export const Main = () => {
  return (
    <>
      <header>
        <div>
          <Link to="/">
            <div>home</div>
          </Link>
        </div>
      </header>
      <Outlet />
      <footer></footer>
    </>
  );
};
