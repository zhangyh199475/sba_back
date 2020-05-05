package com.ibm.sba.controller;

import com.ibm.sba.domain.TechnologiesCriteria;
import com.ibm.sba.domain.Trainings;
import com.ibm.sba.service.TrainingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingsController {
    @Autowired
    private TrainingsService trainingsService;

    @GetMapping("/searchCurrentTrainings")
    public ResponseEntity<Trainings> searchCurrentTrainings(){
        List<Trainings> trainingsList = this.trainingsService.searchCurrentTrainings();
        return new ResponseEntity(trainingsList, HttpStatus.OK);
    }

    @GetMapping("/searchCompletedTrainings")
    public ResponseEntity<Trainings> searchCompletedTrainings(){
        List<Trainings> trainingsList = this.trainingsService.searchCompletedTrainings();
        return new ResponseEntity(trainingsList, HttpStatus.OK);
    }

    @GetMapping("/searchTrainingsByUserName")
    public ResponseEntity<Integer> searchTrainingsByUserName(String userName){
        return new ResponseEntity(this.trainingsService.searchTrainingsByUserName(userName), HttpStatus.OK);
    }

    @PostMapping("/addTraining")
    public ResponseEntity<HttpStatus> addTraining(Trainings trainings){
        this.trainingsService.addTraining(trainings);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateTraining")
    public ResponseEntity<HttpStatus> updateTraining(Trainings trainings){
        this.trainingsService.updateTraining(trainings);
        return new ResponseEntity(HttpStatus.OK);
    }
}
