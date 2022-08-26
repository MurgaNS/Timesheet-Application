package com.vegait.timesheet.repository;

import com.vegait.timesheet.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT client from Client client " +
            "WHERE (:letter IS NULL OR client.name LIKE CONCAT(:letter, '%')) " +
            "AND (:name IS NULL OR client.name LIKE CONCAT(:name, '%'))")
    Page<Client> filterAll(Pageable paging, String letter, String name);

    boolean existsByName(String name);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE client SET is_deleted = 1 WHERE client.id =?")
    void deleteById(Long id);

    Optional<Client> findById(Long id);


}
