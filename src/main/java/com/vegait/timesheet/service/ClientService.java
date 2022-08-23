package com.vegait.timesheet.service;

import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.dto.request.CountryDetails;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    List<Client> getAll(Pageable pageable, String letter, String name);

    Client save(String name, String address, String city, String postalCode, CountryDetails countryDetails);

}
