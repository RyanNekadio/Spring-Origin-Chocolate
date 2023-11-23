package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.EstateService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLParagraphElement;

import java.util.List;

@RestController
@RequestMapping("/estates")
public class EstateController {

    @Autowired
    EstateService estateService;

    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates(){
        List<Estate> estates = estateService.getEstates();
        return new ResponseEntity<>(estates, HttpStatus.OK);
    }

//    EXTENSION TASK
//    Display a specified estate by its id
    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Estate> getEstate(@PathVariable Long id){
        return new ResponseEntity(estateService.getEstateById(id).get(), HttpStatus.OK);
    }

//    EXTENSION TASK
//    Create Estate
    @PostMapping
    public ResponseEntity<Estate> createEstate(@RequestBody Estate estate){
        estateService.saveEstate(estate);
        Estate newEstate = estateService.getEstateById(estate.getId()).get();
        return new ResponseEntity<>(newEstate, HttpStatus.CREATED);
    }

}
