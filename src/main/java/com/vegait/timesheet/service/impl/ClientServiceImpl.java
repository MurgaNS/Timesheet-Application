package com.vegait.timesheet.service.impl;

import com.vegait.timesheet.exception.CheckVersionException;
import com.vegait.timesheet.exception.ClientExistsException;
import com.vegait.timesheet.exception.ClientNameExistException;
import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.Country;
import com.vegait.timesheet.model.dto.request.ClientRequest;
import com.vegait.timesheet.model.dto.request.UpdateClientRequest;
import com.vegait.timesheet.repository.ClientRepository;
import com.vegait.timesheet.repository.CountryRepository;
import com.vegait.timesheet.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(Client.class);
    private final CountryRepository countryRepository;

    public ClientServiceImpl(ClientRepository clientRepository, CountryRepository countryRepository) {
        this.clientRepository = clientRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Page<Client> getAll(Pageable pageable, String letter, String name) {

        return clientRepository.filterAll(pageable, letter, name);
    }

    @Override
    public Client save(ClientRequest clientRequest) {

        if (clientRepository.existsByName(clientRequest.getName())) {
            throw new ClientExistsException("There cannot be 2 clients with the same name");
        }

        Country country = countryRepository.findCountryByCountryCode(clientRequest.getCountry().getCountryCode())
                .orElseGet(() -> countryRepository.save(
                                new Country(
                                        clientRequest.getCountry().getName(),
                                        clientRequest.getCountry().getCountryCode())
                        )
                );

        Client newClient = new Client(
                clientRequest.getName(),
                clientRequest.getAddress(),
                clientRequest.getCity(),
                clientRequest.getPostalCode(),
                country
        );

        return clientRepository.save(newClient);
    }

    @Override
    public Client update(Long id, UpdateClientRequest clientEditRequest) {

        if (!clientRepository.existsById(id)) {
            throw new ClientExistsException("Client doesn't exist.");
        }

        Client clientForEdit = findById(id);

        if (clientRepository.existsByNameAndIdNot(clientEditRequest.getName(), id)) {
            throw new ClientNameExistException("Client with that name already exists");
        }

        if (!clientForEdit.getVersion().equals(clientEditRequest.getVersion())) {
            throw new CheckVersionException("You can't make changes because of the newer version");
        }

        if (!clientForEdit.getCountry().getName().equals(clientEditRequest.getCountry().getName())) {
            Country country = countryRepository.findCountryByCountryCode(clientEditRequest.getCountry().getCountryCode())
                    .orElseGet(() -> countryRepository.save(
                                    new Country(
                                            clientEditRequest.getCountry().getName(),
                                            clientEditRequest.getCountry().getCountryCode())
                            )
                    );
            clientForEdit.setCountry(country);
        }
        clientForEdit.updateClient(clientEditRequest);

        return clientRepository.save(clientForEdit);
    }


    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new ClientExistsException("Client doesn't exist.");
        }

        return client.get();
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("Client with id" + id + " is deleted ");
        clientRepository.deleteById(id);
    }

}
