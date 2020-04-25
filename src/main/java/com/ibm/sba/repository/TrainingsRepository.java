package com.ibm.sba.repository;

import com.ibm.sba.domain.Trainings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingsRepository extends JpaRepository<Trainings, Integer> {
}
