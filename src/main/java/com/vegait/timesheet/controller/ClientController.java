package com.vegait.timesheet.controller;
import com.vegait.timesheet.mapper.ClientMapper;
import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.dto.request.ClientRequest;
import com.vegait.timesheet.model.dto.response.ClientDTO;
import com.vegait.timesheet.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

@RestController
@RequestMapping("api/v1/clients")
@Validated
public class ClientController {
    private final ClientService clientService;
    private final ModelMapper modelMapper;

    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }
    @GetMapping
    public ResponseEntity<Page<ClientDTO>> getAll(Pageable pageable,
                                                  @RequestParam(required = false) @Size(min = 1, max = 1, message = "Maximum lenght of letter can not be more or less than 1 ") String letter,
                                                  @RequestParam(required = false) String name) {

        Page<Client> clients = clientService.getAll(pageable, letter, name);
        Page<ClientDTO> clientsDTO = ClientMapper.toDTOs(clients);
        return new ResponseEntity<>(clientsDTO, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ClientDTO> add(@RequestBody ClientRequest request) {

        Client client = clientService.save(request);
        return new ResponseEntity<>(modelMapper.map(client, ClientDTO.class), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@RequestBody ClientRequest clientRequest, @PathVariable Long id) {
        try{

            Client editedClient = clientService.update(id, clientRequest);
            ClientDTO response = modelMapper.map(editedClient, ClientDTO.class);

            return new ResponseEntity<>(response, HttpStatus.OK);


        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);



    }



}

