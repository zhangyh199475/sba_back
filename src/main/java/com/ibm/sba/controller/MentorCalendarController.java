package com.ibm.sba.controller;

import com.ibm.sba.domain.MentorCalendar;
import com.ibm.sba.service.MentorCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentorCalendar")
public class MentorCalendarController {
    @Autowired
    private MentorCalendarService mentorCalendarService;

    @GetMapping("/getMentorCalByUserId")
    public ResponseEntity<MentorCalendar> getMentorCalByUserId(@PathVariable int userId){
        MentorCalendar mentorCalendar = this.mentorCalendarService.getMentorCalByUserId(userId);
        return new ResponseEntity(mentorCalendar, HttpStatus.OK);
    }

    @PostMapping("/addMentorCal")
    public ResponseEntity<HttpStatus> addMentorCal(@RequestBody MentorCalendar mentorCalendar) {
        this.mentorCalendarService.addMentorCal(mentorCalendar);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateMentorCal")
    public ResponseEntity<HttpStatus> updateMentorCal(@RequestBody MentorCalendar mentorCalendar) {
        this.mentorCalendarService.updateMentorCal(mentorCalendar);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteMentorCal")
    public ResponseEntity<HttpStatus> deleteMentorCal(@PathVariable int tranId) {
        this.mentorCalendarService.deleteMentorCal(tranId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
