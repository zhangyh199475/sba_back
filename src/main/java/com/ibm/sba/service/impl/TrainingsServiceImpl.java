package com.ibm.sba.service.impl;

import com.ibm.sba.domain.Trainings;
import com.ibm.sba.repository.TrainingsRepository;
import com.ibm.sba.service.TrainingsService;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainingsServiceImpl implements TrainingsService {

    @Autowired
    private TrainingsRepository trainingsRepository;

    @Override
    public List<Trainings> searchCurrentTrainings() {
        Specification<Trainings> query = (Specification<Trainings>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.greaterThan(root.get("endDate"), new Date()));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<Trainings> trainingsList = trainingsRepository.findAll(query);
        return trainingsList;
    }

    @Override
    public List<Trainings> searchCompletedTrainings() {
        Specification<Trainings> query = (Specification<Trainings>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("endDate"), new Date()));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<Trainings> trainingsList = trainingsRepository.findAll(query);
        return trainingsList;
    }

    @Override
    public int searchTrainingsByUserName(String userName) {
        if (StringUtils.isEmpty(String.valueOf(this.trainingsRepository.searchTrainingsByUserName(userName).get(1).getTrainId()))){
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public void addTraining(Trainings trainings) {
        trainings.setStartDate(java.sql.Date.valueOf(String.valueOf(new Date())));
        trainings.setEndDate(java.sql.Date.valueOf(String.valueOf(new Date(10))));
        trainings.setReceived(0);
        trainings.setActive("1");
        trainings.setCurrentPrice(0);
        trainings.setCurrentPercent(0);
        trainings.setRate(0);
        this.trainingsRepository.save(trainings);
        // send email func
        System.out.println("Email has been sent to mentor!");
    }

    @Override
    public void updateTraining(Trainings trainings) {
        Trainings trainingsNew = this.trainingsRepository.findById(trainings.getTrainId()).orElse(null);
        if (trainings.getCurrentPrice() > trainingsNew.getCurrentPrice()){
            // payment func
            System.out.println("Payment function works!");
        }
        this.trainingsRepository.save(trainings);
        // send email func
        System.out.println("Email has been sent to mentor!");
    }
}
