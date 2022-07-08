import axios from "axios";
const url = "http://localhost:8080";
export const getDept = async (setdata) => {
  await axios.get(url + "/deptAll").then((response) => {
    setdata(response.data);
  });
};

export const getOneDept = async (setDept, deptno) => {
  await axios
    .get(url + `/dept/${deptno}`)
    .then((response) => setDept(response.data));
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
  axios
    .put(
      url + `/${deptno}`,
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
