package com.vegait.timesheet.repository;

import com.vegait.timesheet.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findCountryByCountryCode(String countryCode);

}
