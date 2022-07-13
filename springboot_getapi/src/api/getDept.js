import axios from "axios";
import { useLocation } from "react-router-dom";
const url = "http://localhost:8080";
export const getDept = async (setdata, query) => {
  const data = query.search.split("=");
  await axios
    .get(url + "/deptPage", {
      params: {
        page: data[1],
      },
    })
    .then((response) => {
      setdata(response.data);
    });
};

export const getOneDept = async (setDept, deptno) => {
  console.log(deptno);
  await axios.get(url + `/dept/${deptno[2]}`).then((response) => {
    setDept(response.data == "" ? false : response.data);
  });
};

export const deleteDept = async (deptno) => {
  console.log(deptno);
  await axios.delete(url + `/dept/${deptno}`).then(() => {
    return true;
  });
};

export const insertDept = async (deptno, dname, loc) => {
  const data = new URLSearchParams();
  data.append("dname", dname);
  data.append("loc", loc);
  try {
    await axios.post(url + `/dept/${deptno}`, data).then(() => {
      return true;
    });
  } catch (error) {
    return false;
  }
};

export const updateDept = async (deptno, dname, loc) => {
  console.log(deptno, dname, loc);
  console.log(url);
  await axios
    .put(
      url + `/dept/${deptno[2]}`,
      {
        dname: dname,
        loc: loc,
      },
      { headers: "Content-Type: application/json" }
    )
    .then(() => {
      return true;
    });
};
