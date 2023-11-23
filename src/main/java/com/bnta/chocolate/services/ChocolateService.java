package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    //saving chocolate method

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateService estateService;

//    public void saveChocolate(Chocolate chocolate){
//        chocolateRepository.save(chocolate);        //returning object, chocolate
//    }

    public void saveChocolate(ChocolateDTO chocolateDTO){
        Estate estate = estateService.getEstateById(chocolateDTO.getEstateId()).get();
        Chocolate chocolate = new Chocolate(
                chocolateDTO.getName(),
                chocolateDTO.getCocoaPercentage(),
                estate);
        chocolateRepository.save(chocolate);
    }

    public List<Chocolate> getChocolates() {
        return chocolateRepository.findAll();
    }

    public Optional<Chocolate> getChocolate(Long id){
        return chocolateRepository.findById(id);
    }

    public List<Chocolate> getChocolatesByCocoaContent(int cocoaContent){
        return chocolateRepository.findByCocoaPercentageGreaterThanEqual(cocoaContent);
    }
}
