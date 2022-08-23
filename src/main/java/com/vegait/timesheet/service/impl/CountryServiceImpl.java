package com.vegait.timesheet.service.impl;

import com.vegait.timesheet.model.Country;
import com.vegait.timesheet.repository.CountryRepository;
import com.vegait.timesheet.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

}
