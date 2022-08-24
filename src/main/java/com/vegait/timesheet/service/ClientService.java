package com.vegait.timesheet.service;

import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.dto.request.ClientRequest;
import com.vegait.timesheet.model.dto.request.CountryDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    Page<Client> getAll(Pageable pageable, String letter, String name);

    Client save(String name, String address, String city, String postalCode, CountryDetails countryDetails);

    Client update(Long id, ClientRequest clientEditRequest);

    Client findById(Long id);

    void deleteClientById(Long id);


}
