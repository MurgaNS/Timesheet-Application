import { Fragment } from "react";
import { Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import ClientPage from "./pages/ClientPage";

function App() {
  return (
    <Fragment>
      <Header></Header>
      <Routes>
        <Route path="/clients" element={<ClientPage/>}></Route>
      </Routes>
    </Fragment>
  );
}

export default App;
