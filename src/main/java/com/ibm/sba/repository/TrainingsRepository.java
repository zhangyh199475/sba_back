package com.ibm.sba.repository;

import com.ibm.sba.domain.Trainings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingsRepository extends JpaRepository<Trainings, Integer>, JpaSpecificationExecutor {
    @Query(value = "SELECT * from trainings where student_name = ?1 or mentor_name = ?1 and received = 0", nativeQuery = true)
    List<Trainings> searchTrainingsByUserName(String userName);
}
