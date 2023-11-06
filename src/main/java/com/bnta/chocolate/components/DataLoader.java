package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    EstateRepository estateRepository;

    @Autowired
    ChocolateRepository chocolateRepository;

    @Override
    public void run (ApplicationArguments args){
        Estate r3Bnta = new Estate("Room 3 BNTA", "UK");
           estateRepository.save(r3Bnta);           //have to create estate before saving the chocolate.
        Chocolate chocolate = new Chocolate("Bounty", 20, r3Bnta);
        chocolateRepository.save(chocolate);

    }

}
