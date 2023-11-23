package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("chocolates")
public class ChocolateController {
    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

//    EXTENSION TASK
//    Find all chocolates for a specified cocoa percentage or higher
//    If cocoa percentage not specified, return list of all chocolates
    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(
            @RequestParam(required = false) Integer cocoaPercentage){
        if (cocoaPercentage != null){
            return new ResponseEntity<>(chocolateService.getChocolatesByCocoaContent(cocoaPercentage), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(chocolateService.getChocolates(), HttpStatus.OK);
        }
    }

//    EXTENSION TASK
//    Display an individual chocolate by its id
    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Chocolate> getChocolate(@PathVariable Long id){
        return new ResponseEntity<>(chocolateService.getChocolate(id).get(), HttpStatus.OK);
    }

//    EXTENSION TASK
//    Create a chocolate
    @PostMapping
    public ResponseEntity<Chocolate> createChocolate(@RequestBody ChocolateDTO chocolateDTO){
        chocolateService.saveChocolate(chocolateDTO);
        Estate estate = estateService.getEstateById(chocolateDTO.getEstateId()).get();
        Chocolate newChocolate = new Chocolate(
                chocolateDTO.getName(),
                chocolateDTO.getCocoaPercentage(),
                estate
        );
        return new ResponseEntity<>(newChocolate,  HttpStatus.CREATED);
    }

}
