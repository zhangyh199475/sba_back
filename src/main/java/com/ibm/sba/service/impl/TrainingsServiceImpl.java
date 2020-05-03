package com.ibm.sba.service.impl;

import com.ibm.sba.domain.Trainings;
import com.ibm.sba.repository.TrainingsRepository;
import com.ibm.sba.service.TrainingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
}
