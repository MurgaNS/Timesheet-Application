package com.vegait.timesheet.service;

import com.vegait.timesheet.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients(Integer pageNo, Integer pageSize);
}
