package com.vegait.timesheet.mapper;

import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.dto.response.ClientDTO;
import org.springframework.data.domain.Page;
import java.util.function.Function;

public class ClientMapper {

    public static ClientDTO toDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setCity(client.getCity());
        clientDTO.setPostalCode(client.getPostalCode());
        clientDTO.setCountry(client.getCountry());

        return clientDTO;
    }

    public static Page<ClientDTO> toDTOs(Page<Client> clients) {

        return clients.map(new Function<Client, ClientDTO>() {
            @Override
            public ClientDTO apply(Client client) {
                ClientDTO clientDTO = new ClientDTO();
                clientDTO.setId(client.getId());
                clientDTO.setName(client.getName());
                clientDTO.setAddress(client.getAddress());
                clientDTO.setCity(client.getCity());
                clientDTO.setPostalCode(client.getPostalCode());
                clientDTO.setCountry(client.getCountry());

                return clientDTO;
            }
        });
    }

}
