package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChocolateService {

    //saving chocolate method

    @Autowired
    ChocolateRepository chocolateRepository;

    public void saveChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);        //returning object, chocolate
    }

    public List<Chocolate> getChocolates() {
        return chocolateRepository.findAll();
    }
}
