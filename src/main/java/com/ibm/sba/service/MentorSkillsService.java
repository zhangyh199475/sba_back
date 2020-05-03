package com.ibm.sba.service;

import com.ibm.sba.domain.SkillsCriteria;

import java.util.List;

public interface MentorSkillsService {
    List<SkillsCriteria> searchSkills();
}
