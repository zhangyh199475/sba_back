package com.ibm.sba.repository;

import com.ibm.sba.domain.MentorCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorCalendarRepository extends JpaRepository<MentorCalendar, Integer> {
}