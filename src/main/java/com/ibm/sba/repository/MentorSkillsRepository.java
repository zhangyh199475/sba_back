package com.ibm.sba.repository;

import com.ibm.sba.domain.MentorSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorSkillsRepository extends JpaRepository<MentorSkills, Integer> {
}
