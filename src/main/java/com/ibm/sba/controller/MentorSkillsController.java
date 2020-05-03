package com.ibm.sba.controller;

import com.ibm.sba.domain.SkillsCriteria;
import com.ibm.sba.domain.TechnologiesCriteria;
import com.ibm.sba.service.MentorSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mentorSkills")
public class MentorSkillsController {
    @Autowired
    private MentorSkillsService mentorSkillsService;

    @GetMapping("/searchSkills")
    public ResponseEntity<SkillsCriteria> searchSkills(){
        List<SkillsCriteria> skillsCriteriaList = this.mentorSkillsService.searchSkills();
        return new ResponseEntity(skillsCriteriaList, HttpStatus.OK);
    }
}
