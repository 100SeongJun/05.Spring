import { useEffect, useState } from "react";
import { getDiary } from "../getapi/diaryApi";

export const Page = () => {
  const [data, setdata] = useState();
  const [num, setNum] = useState(1);
  useEffect(() => {
    getDiary(setdata, num);
  }, num);
  return (
    <div>
      <div>asdsad</div>
    </div>
  );
};
