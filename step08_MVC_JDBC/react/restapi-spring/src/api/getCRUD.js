import axios from "axios";
const url = "http://localhost:8080/jdbc/api/dept";
export const getData = async (setdata) => {
  await axios.get(url).then((response) => {
    setdata(response.data);
  });
};

export const deleteData = async (deptno) => {
  await axios.delete(url + `/${deptno}`).then(() => {
    return true;
  });
};

export const insertData = async (deptno, dname, loc) => {
  const data = new URLSearchParams();
  data.append("deptno", deptno);
  data.append("dname", dname);
  data.append("loc", loc);
  try {
    await axios.post(url, data).then(() => {
      return true;
    });
  } catch (error) {
    return false;
  }
};

export const updateData = async (deptno, dname, loc) => {
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
