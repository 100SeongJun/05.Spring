import axios from "axios";
const url = "http://localhost:8080/emp";
export const getData = async (setEmpData) => {
  await axios.get(url).then((response) => {
    setEmpData(response.data);
  });
};

export const deleteData = async (empno) => {
  await axios.delete(url + `/${empno}`).then(() => {
    return true;
  });
};

export const insertData = async (emp) => {
  console.log(emp);
  try {
    await axios.post(url, emp).then(() => {
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
