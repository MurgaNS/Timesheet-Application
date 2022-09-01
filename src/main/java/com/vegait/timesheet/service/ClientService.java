package com.vegait.timesheet.service;

import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.dto.request.ClientRequest;
import com.vegait.timesheet.model.dto.request.UpdateClientRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClientService {

    Page<Client> getAll(Pageable pageable, String letter, String name);

    Client save(ClientRequest clientRequest);

    Client update(Long id, UpdateClientRequest updateClientRequest);

    Client findById(Long id);

    void deleteById(Long id);



}
