package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstateService {

    // saving estate method:
    @Autowired
    EstateRepository estateRepository;
    public void saveEstate(Estate estate){
        estateRepository.save(estate);
    }

    public List<Estate> getEstates(){
        return estateRepository.findAll();
    }


    public Optional<Estate> getEstateById(Long id) {
        return estateRepository.findById(id);
    }
}
