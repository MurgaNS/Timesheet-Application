package com.vegait.timesheet.service.impl;

import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.repository.ClientRepository;
import com.vegait.timesheet.service.ClientService;
import javafx.scene.control.Alert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Client> pagedResult = clientRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        }else {
            return new ArrayList<Client>();
        }
    }
}
