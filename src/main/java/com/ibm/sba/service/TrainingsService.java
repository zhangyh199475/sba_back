package com.ibm.sba.service;

import com.ibm.sba.domain.Trainings;

import java.util.List;

public interface TrainingsService {
    List<Trainings> searchCurrentTrainings();

    List<Trainings> searchCompletedTrainings();
}
