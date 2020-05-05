package com.ibm.sba.controller;

import com.ibm.sba.domain.MentorSkills;
import com.ibm.sba.domain.SkillsCriteria;
import com.ibm.sba.domain.TechnologiesCriteria;
import com.ibm.sba.service.MentorSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addSkills")
    public ResponseEntity<HttpStatus> addSkills(@RequestBody MentorSkills mentorSkills) {
        this.mentorSkillsService.addSkills(mentorSkills);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateSkills")
    public ResponseEntity<HttpStatus> updateSkills(@RequestBody MentorSkills mentorSkills) {
        this.mentorSkillsService.updateSkills(mentorSkills);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteSkills")
    public ResponseEntity<HttpStatus> deleteSkills(@RequestBody MentorSkills mentorSkills) {
        this.mentorSkillsService.deleteSkills(mentorSkills);
        return new ResponseEntity(HttpStatus.OK);
    }
}
