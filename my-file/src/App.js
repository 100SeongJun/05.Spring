import "./App.css";
import { useEffect, useState } from "react";
import axios from "axios";
import { useLocation } from "react-router-dom";

function App() {
  const [files, setFiles] = useState([]);
  const location = useLocation().search;

  useEffect(() => {
    axios.get("http://localhost:8080/file-list").then((response) => {
      setFiles(response.data);
    });
  }, []);
  useEffect(() => {
    const id = location.split("=")[1];
    console.log(id);
    axios.get(`http://localhost:8080/file-download/${id}`);
  }, [location]);
  return (
    <div>
      <form
        method="post"
        action="http://localhost:8080/file-save"
        encType="multipart/form-data"
      >
        <input type="file" name="file"></input>
        <br />
        <input type="submit" value="전송" />
      </form>
      <div>
        <table>
          <thead>
            <tr>
              <td>id</td>
              <td>fileName</td>
              <td>filePath</td>
              <td>originalFileName</td>
            </tr>
          </thead>
          <tbody>
            {files.length !== 0 &&
              files.map((file) => (
                <tr key={file.id}>
                  <td>
                    <a href={`?id=${file.id}`}>{file.id}</a>
                  </td>
                  <td>{file.fileName}</td>
                  <td>{file.filePath}</td>
                  <td>{file.originalFileName}</td>
                </tr>
              ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default App;
