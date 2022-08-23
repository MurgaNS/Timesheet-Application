package com.vegait.timesheet.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vegait.timesheet.model.Client;
import com.vegait.timesheet.model.dto.request.ClientRequest;
import com.vegait.timesheet.model.dto.response.ClientDTO;
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
@RequestMapping("api/v1/clients")
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
                                                  @RequestParam(required = false) @Size(min = 1, max = 1, message = "Maximum lenght of letter can not be more or less than 1 ") String letter,
                                                  @RequestParam(required = false) String name) {
        List<Client> client = clientService.getAll(pageable, letter, name);

//        List<ClientDTO> clientDTO = modelMapper.map(client, new TypeToken<List<ClientDTO>>() {
//        }.getType());
        List<ClientDTO> clientDTO = objectMapper.convertValue(client, new TypeReference<>() {
        });
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);


    }

    @PostMapping
    public ResponseEntity<ClientDTO> add(@RequestBody ClientRequest request) {
//        if (client == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        Client client = clientService.save(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getPostalCode(),
                request.getCountry()
        );

        return new ResponseEntity<>(modelMapper.map(client, ClientDTO.class), HttpStatus.CREATED);
    }


}

