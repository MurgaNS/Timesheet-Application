package com.vegait.timesheet.service;

import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.dto.request.ClientRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClientService {
    Page<Client> getAll(Pageable pageable, String letter, String name);

    Client save(ClientRequest clientRequest);

    Client update(Long id, ClientRequest clientEditRequest);

    Client findById(Long id);

    void deleteById(Long id);



}
