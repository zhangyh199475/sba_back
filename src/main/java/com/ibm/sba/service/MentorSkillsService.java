package com.ibm.sba.service;

import com.ibm.sba.domain.MentorSkills;
import com.ibm.sba.domain.SkillsCriteria;

import java.util.List;

public interface MentorSkillsService {
    List<SkillsCriteria> searchSkills();

    void addSkills(MentorSkills mentorSkills);

    void updateSkills(MentorSkills mentorSkills);

    void deleteSkills(MentorSkills mentorSkills);
}
