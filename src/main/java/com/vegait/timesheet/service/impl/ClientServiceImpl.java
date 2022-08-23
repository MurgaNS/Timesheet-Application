package com.vegait.timesheet.service.impl;

import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.repository.ClientRepository;
import com.vegait.timesheet.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll(Pageable pageable, String letter, String name) {
        Page<Client> pagedResult;
        if(letter != null) {
            pagedResult = clientRepository.findClientsByNameStartsWith(pageable, letter);

        }
        else if (name != null) {
            pagedResult = clientRepository.findClientsByName(name, pageable);
        }
        else{
            pagedResult = clientRepository.findAll(pageable);

        }
        return pagedResult.getContent();

    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }



}
