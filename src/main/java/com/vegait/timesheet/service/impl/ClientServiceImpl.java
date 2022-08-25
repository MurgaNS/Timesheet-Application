package com.vegait.timesheet.service.impl;

import com.vegait.timesheet.exception.ClientExistsException;
import com.vegait.timesheet.exception.NotFoundException;
import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.Country;
import com.vegait.timesheet.model.dto.request.ClientRequest;
import com.vegait.timesheet.repository.ClientRepository;
import com.vegait.timesheet.repository.CountryRepository;
import com.vegait.timesheet.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final CountryRepository countryRepository;

    private final ModelMapper modelMapper;

    public ClientServiceImpl(ClientRepository clientRepository, CountryRepository countryRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
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
                .orElse(countryRepository.save(
                                new Country(
                                        clientRequest.getCountry().getName(),
                                        clientRequest.getCountry().getCountryCode())
                        )
                );
        Client client = modelMapper.map(clientRequest, Client.class);
        client.setCountry(country);

        return clientRepository.save(client);

    }

    @Override
    public Client update(Long id, ClientRequest clientEditRequest) {

        if (!clientRepository.existsById(id)) {
            throw new ClientExistsException("Client doesn't exist.");
        }

        Client clientForEdit = findById(id);

        if (clientForEdit == null) {
            throw new NotFoundException("Client you want to edit is not found.");
        }

        clientForEdit.setName(clientEditRequest.getName());
        clientForEdit.setAddress(clientEditRequest.getAddress());
        clientForEdit.setCity(clientEditRequest.getCity());

        if (!clientForEdit.getCountry().getCountryCode().equals(clientEditRequest.getCountry().getCountryCode())) {
            clientForEdit.setCountry( countryRepository.findCountryByCountryCode(clientEditRequest.getCountry().getCountryCode())
                    .orElse(countryRepository.save(
                                    new Country(
                                            clientEditRequest.getCountry().getName(),
                                            clientEditRequest.getCountry().getCountryCode())
                            )
                    ));
        }

        clientForEdit.setPostalCode(clientEditRequest.getPostalCode());

        return clientRepository.save(clientForEdit);
    }


    @Override
    public Client findById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientExistsException("Client doesn't exist.");
        }

        return clientRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

}
