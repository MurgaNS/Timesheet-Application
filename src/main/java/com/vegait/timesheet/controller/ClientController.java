package com.vegait.timesheet.controller;

import com.vegait.timesheet.mapper.ClientMapper;
import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.dto.request.ClientRequest;
import com.vegait.timesheet.model.dto.response.ClientDTO;
import com.vegait.timesheet.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("api/v1/clients")
@Validated
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> getAll(
            Pageable pageable,
            @Valid @RequestParam(required = false) @Size(min = 1, max = 1, message = "Letter parameter must cointain exactly one character ") String letter,
            @RequestParam(required = false) String name
    ) {

        Page<Client> clients = clientService.getAll(pageable, letter, name);
        Page<ClientDTO> clientsDTO = ClientMapper.toDTOs(clients);

        return new ResponseEntity<>(clientsDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> add(@Valid @RequestBody ClientRequest request) {
        Client client = clientService.save(request);
        ClientDTO clientDTO = ClientMapper.toDTO(client);

        return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@Valid @RequestBody ClientRequest clientRequest, @PathVariable Long id) {
        Client editedClient = clientService.update(id, clientRequest);
        ClientDTO response = ClientMapper.toDTO(editedClient);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

