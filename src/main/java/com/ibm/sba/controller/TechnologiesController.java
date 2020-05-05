package com.ibm.sba.controller;

import com.ibm.sba.domain.Technologies;
import com.ibm.sba.domain.TechnologiesCriteria;
import com.ibm.sba.domain.Users;
import com.ibm.sba.service.TechnologiesService;
import com.ibm.sba.service.TrainingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technologies")
public class TechnologiesController {
    @Autowired
    private TechnologiesService technologiesService;

    @GetMapping("/searchTrainings")
    public ResponseEntity<TechnologiesCriteria> searchTrainings(){
        List<TechnologiesCriteria> technologiesCriteriaList = this.technologiesService.searchTrainings();
        return new ResponseEntity(technologiesCriteriaList, HttpStatus.OK);
    }

    @GetMapping("/searchTechnologies")
    public ResponseEntity<Technologies> searchTechnologies(){
        List<Technologies> technologiesList = this.technologiesService.searchTechnologies();
        return new ResponseEntity(technologiesList, HttpStatus.OK);
    }

    @PostMapping("/addTechnologies")
    public ResponseEntity<Technologies> addTechnologies(@RequestBody Technologies technologies){
        this.technologiesService.addTechnologies(technologies);
        return new ResponseEntity(technologies, HttpStatus.OK);
    }

    @PutMapping("/updateTechnologies")
    public ResponseEntity<Technologies> updateTechnologies(@RequestBody Technologies technologies){
        this.technologiesService.updateTechnologies(technologies);
        return new ResponseEntity(technologies, HttpStatus.OK);
    }

    @PostMapping("/addTechnologies/{techId}")
    public ResponseEntity<Technologies> addTechnologies(@PathVariable int techId){
        Technologies technologies = this.technologiesService.deleteTechnologies(techId);
        return new ResponseEntity(technologies, HttpStatus.OK);
    }
}
