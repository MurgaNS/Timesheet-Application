package com.vegait.timesheet.repository;

import com.vegait.timesheet.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Page<Client> findClientsByNameStartsWith(Pageable paging, String letter);
    Page<Client> findAll(Pageable paging);
    Page<Client> findClientsByName(String name, Pageable paging);

}
