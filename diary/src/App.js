import { BrowserRouter, Route, Routes } from "react-router-dom";
import Main from "./page/Main";
import { Page } from "./page/Page";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main />}>
          <Route index element={<Page />}></Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
