import React from "react";
import Alphabet from "../components/client/Alphabet";
import CreateClient from "../components/client/CreateClient";
import Pagination from "../components/client/Pagination";
import classes from "../components/NavHeaderCss.module.css";
import { useState } from "react";
import clientService from "../services/clientService";
import ClientList from "../components/client/ClientList";

function ClientPage() {
  const [name, setName] = useState(null);
  const [letter, setLetter] = useState(null);
  const [clients, setClients] = useState([]);

  const [loading, setLoading] = useState(false);
  const [currentPage, setCurrentPage] = useState(1);
  const [clientsPerPage] = useState(4);
  const [totalNum, setTotalNum] = useState(null);

  //works when component runs or when update
  React.useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      const response = await clientService.getClients(letter, name);
      setClients(response.data.content);
      setLoading(false);
      setTotalNum(response.data.numberOfElements);
    };
    fetchData();
  }, [letter, name]);

  const getLetter = (letter) => {
    setLetter(letter);
  };

  const getName = (name) => {
    setName(name);
  };

  const onDeleteHandler = (id) => {
    const filteredClients = clients.filter((client) => client.id !== id);
    setClients(filteredClients);
  };

  const addHandler = (newClient) => {
    setClients((prevState) => [...prevState, newClient]);
  };

  const indexOfLastClient = currentPage * clientsPerPage;
  const indexOfFirstClient = indexOfLastClient - clientsPerPage;
  const currentClients = clients.slice(indexOfFirstClient, indexOfLastClient);

  //change page
  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  return (
    <div className={classes.wrapper}>
      <section className={classes.content}>
        <div className={`${classes["main-content__title"]}`}>Clients</div>
        <CreateClient onAdd={addHandler} getName={getName} />
        <Alphabet getLetter1={getLetter} />
        <ClientList
          clients={currentClients}
          loading={loading}
          onDelete={onDeleteHandler}
        ></ClientList>
        <Pagination
          clientsPerPage={clientsPerPage}
          totalClients={totalNum}
          paginate={paginate}
        ></Pagination>
      </section>
    </div>
  );
}

export default ClientPage;
