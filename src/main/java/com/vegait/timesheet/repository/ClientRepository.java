package com.vegait.timesheet.repository;

import com.vegait.timesheet.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(nativeQuery = true, value = "SELECT * from client " +
            "WHERE (:letter IS NULL OR client.name LIKE CONCAT(:letter, '%')) " +
            "AND (:name IS NULL OR client.name LIKE CONCAT(:name, '%'))")
    Page<Client> filterAll(Pageable paging, String letter, String name);

    Client findByName(String name);
    boolean existsByName(String name);

}
