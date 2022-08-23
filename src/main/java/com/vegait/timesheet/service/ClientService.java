package com.vegait.timesheet.service;
import com.vegait.timesheet.model.Client;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    List<Client> getAll(Pageable pageable, String letter, String name);
    Client save(Client client);

}
