package com.vegait.timesheet.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.dto.request.ClientDTO;
import com.vegait.timesheet.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("api/clients")
@Validated
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService, ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.clientService = clientService;

        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    private final ModelMapper modelMapper;

    private final ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAll(Pageable pageable,
                                                  @RequestParam(required = false) @Size(min = 1,max = 1,message = "maksimalno 1") String letter,
                                                  @RequestParam(required = false) String name) {
        List<Client> client = clientService.getAll(pageable, letter, name);

//        List<ClientDTO> clientDTO = modelMapper.map(client, new TypeToken<List<ClientDTO>>() {
//        }.getType());
        List<ClientDTO> clientDTO = objectMapper.convertValue(client, new TypeReference<>() {
        });
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);


    }

    @PostMapping("/add")
    public ResponseEntity<ClientDTO> add(@RequestBody ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        clientService.save(client);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }


}

