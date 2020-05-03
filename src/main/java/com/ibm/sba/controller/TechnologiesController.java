package com.ibm.sba.controller;

import com.ibm.sba.domain.Technologies;
import com.ibm.sba.domain.TechnologiesCriteria;
import com.ibm.sba.domain.Users;
import com.ibm.sba.service.TechnologiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<TechnologiesCriteria> searchTechnologies(){
        List<Technologies> technologiesList = this.technologiesService.searchTechnologies();
        return new ResponseEntity(technologiesList, HttpStatus.OK);
    }
}
