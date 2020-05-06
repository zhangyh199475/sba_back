package com.ibm.sba.repository;

import com.ibm.sba.domain.MentorCalendar;
import com.ibm.sba.domain.Trainings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorCalendarRepository extends JpaRepository<MentorCalendar, Integer> {
    @Query(value = "SELECT * from Mentor_calendar where userId = ?1", nativeQuery = true)
    MentorCalendar getMentorCalByUserId(int userId);
}