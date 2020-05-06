package com.ibm.sba.service.impl;

import com.ibm.sba.domain.MentorCalendar;
import com.ibm.sba.repository.MentorCalendarRepository;
import com.ibm.sba.repository.MentorSkillsRepository;
import com.ibm.sba.service.MentorCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorCalendarServiceImpl implements MentorCalendarService {

    @Autowired
    private MentorCalendarRepository mentorCalendarRepository;

    @Override
    public MentorCalendar getMentorCalByUserId(int userId) {
        MentorCalendar mentorCalendar = this.mentorCalendarRepository.getMentorCalByUserId(userId);
        return mentorCalendar;
    }

    @Override
    public void addMentorCal(MentorCalendar mentorCalendar) {
        this.mentorCalendarRepository.save(mentorCalendar);
    }

    @Override
    public void updateMentorCal(MentorCalendar mentorCalendar) {
        this.mentorCalendarRepository.save(mentorCalendar);
    }

    @Override
    public void deleteMentorCal(int tranId) {
        this.mentorCalendarRepository.deleteById(tranId);
    }
}
