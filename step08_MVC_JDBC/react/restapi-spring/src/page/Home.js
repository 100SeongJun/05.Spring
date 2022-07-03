import React from "react";
import { Link } from "react-router-dom";
import "./Main.css";
function Home() {
  return (
    <div className="homeContainer">
      <div className="home">
        <Link to="/search" property="search">
          <span>조회</span>
        </Link>
      </div>
      <div className="home">
        <Link to="/insert">
          <span>추가</span>
        </Link>
      </div>
      <div className="home">
        <Link to="/update">
          <span>수정</span>
        </Link>
      </div>
      <div className="home">
        <Link to="/delete">
          <span>삭제</span>
        </Link>
      </div>
    </div>
  );
}
export default Home;
