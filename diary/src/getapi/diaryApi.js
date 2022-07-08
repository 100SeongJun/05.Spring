import axios from "axios";

export const getDiary = (setdata, num) => {
  console.log(num);
  const url = "http://localhost:8080";
  axios.get(url + "/diary", { page: num }).then((response) => {
    setdata(response.data);
  });
};
