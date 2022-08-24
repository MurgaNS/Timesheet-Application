package com.vegait.timesheet.service.impl;

import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.Country;
import com.vegait.timesheet.model.dto.request.ClientRequest;
import com.vegait.timesheet.model.dto.request.CountryDetails;
import com.vegait.timesheet.repository.ClientRepository;
import com.vegait.timesheet.repository.CountryRepository;
import com.vegait.timesheet.service.ClientService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final CountryRepository countryRepository;

    public ClientServiceImpl(ClientRepository clientRepository, CountryRepository countryRepository) {
        this.clientRepository = clientRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Client> getAll(Pageable pageable, String letter, String name) {

        return clientRepository.filterAll(pageable, letter, name).getContent();

    }

    @Override
    public Client save(String name, String address, String city, String postalCode, CountryDetails countryDetails) {
        if (clientRepository.existsByName(name)) {
            throw new RuntimeException("there cannot be 2 clients with the same name");
        }
        Country country = countryRepository.findCountryByCountryCode(countryDetails.getCountryCode())
                .orElse(countryRepository.save(
                                new Country(
                                        countryDetails.getName(),
                                        countryDetails.getCountryCode())
                        )
                );
        Client client = new Client(name, address, city, postalCode, country);

        return clientRepository.save(client);

    }

    @Override
    public Client update(Long id, ClientRequest clientEditRequest) {

        Client clientForEdit = findById(id);

        if (clientForEdit == null) {
            return null;
        }

        clientForEdit.setName(clientEditRequest.getName());
        clientForEdit.setAddress(clientEditRequest.getAddress());
        clientForEdit.setCity(clientEditRequest.getCity());

        if (!clientForEdit.getCountry().getCountryCode().equals(clientEditRequest.getCountry().getCountryCode())) {
            Country country = countryRepository.findCountryByCountryCode(clientEditRequest.getCountry().getCountryCode())
                    .orElse(countryRepository.save(
                                    new Country(
                                            clientEditRequest.getCountry().getName(),
                                            clientEditRequest.getCountry().getCountryCode())
                            )
                    );

            clientForEdit.setCountry(country);
        }

        clientForEdit.setPostalCode(clientEditRequest.getPostalCode());

        clientForEdit = clientRepository.save(clientForEdit);
        return clientForEdit;
    }


    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }

}
