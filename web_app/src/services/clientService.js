import axios from "axios";

const getClients = async () => {
    const response = await axios.get("http://localhost:8080/api/v1/clients");

    return response;
}

const clientService = {
    getClients 
}

export default clientService;

