import { useState } from "react";
import "./App.css";
import Container from "./components/Container";
import FileForm from "./components/FileForm";
import Result from "./components/Result";

function App() {
  const [status, setStatus] = useState("initial");
  const [data, setData] = useState([]);

  const changeStatus = (name, data) => {
    setStatus(name);

    console.log(name, data)

    if (data) {
      setData(data);
    }
  };

  return (
    <Container>
      {status === "initial" ? <FileForm changeStatus={changeStatus} /> : null}
      {status === "success" && data !== undefined ? (
        <Result data={data} changeStatus={changeStatus} />
      ) : null}
    </Container>
  );
}

export default App;
