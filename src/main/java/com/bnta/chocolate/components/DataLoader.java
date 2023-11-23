package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    EstateService estateService;

    @Autowired
    ChocolateService chocolateService;

    @Override
    public void run (ApplicationArguments args){

//        ESTATES
        Estate bountyEstate = new Estate("Bounty Estate", "UK");
        estateService.saveEstate(bountyEstate);

        Estate marsEstate = new Estate("Mars Estate", "St. Lucia");
        estateService.saveEstate(marsEstate);

        Estate CadburyEstate = new Estate("Cadbury Estate", "UK");
        estateService.saveEstate(CadburyEstate);

//        CHOCOLATES
        ChocolateDTO bounty = new ChocolateDTO("Bounty", 60, 2L);
        chocolateService.saveChocolate(bounty);

        ChocolateDTO mars = new ChocolateDTO("Mars", 60, 1L);
        chocolateService.saveChocolate(mars);

        ChocolateDTO dairyMilk = new ChocolateDTO("Dairy Milk", 90, 3L);
        chocolateService.saveChocolate(dairyMilk);

    }

}
