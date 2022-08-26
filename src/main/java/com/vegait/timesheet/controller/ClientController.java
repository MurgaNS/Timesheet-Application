package com.vegait.timesheet.controller;
import com.vegait.timesheet.exception.ClientExistsException;
import com.vegait.timesheet.mapper.ClientMapper;
import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.dto.request.ClientRequest;
import com.vegait.timesheet.model.dto.response.ClientDTO;
import com.vegait.timesheet.service.ClientService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.slf4j.Logger;

@RestController
@RequestMapping("api/v1/clients")
@Validated

public class ClientController {

    Logger logger = LoggerFactory.getLogger(Client.class);

    private final ClientService clientService;
    private final ModelMapper modelMapper;

    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }
    @GetMapping
    public ResponseEntity<Page<ClientDTO>> getAll(Pageable pageable,
                                                  @Valid @RequestParam(required = false) @Size(min = 1, max = 1, message = "Letter parameter must cointain exactly one character ") String letter,
                                                  @RequestParam(required = false) String name) {

        Page<Client> clients = clientService.getAll(pageable, letter, name);
        Page<ClientDTO> clientsDTO = ClientMapper.toDTOs(clients);
        return new ResponseEntity<>(clientsDTO, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ClientDTO> add(@Valid @RequestBody ClientRequest request) {

        Client client = clientService.save(request);
        return new ResponseEntity<>(modelMapper.map(client, ClientDTO.class), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
//    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    public ResponseEntity<ClientDTO> update(@Valid @RequestBody ClientRequest clientRequest, @PathVariable Long id) {
        try{

            Client editedClient = clientService.update(id, clientRequest);
            ClientDTO response = modelMapper.map(editedClient, ClientDTO.class);

            return new ResponseEntity<>(response, HttpStatus.OK);


        } catch (ClientExistsException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
        logger.info("Client with id" + id + " is deleted ");

        return new ResponseEntity<>(HttpStatus.OK);



    }



}

