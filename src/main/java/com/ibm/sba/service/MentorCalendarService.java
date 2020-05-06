package com.ibm.sba.service;

import com.ibm.sba.domain.MentorCalendar;

public interface MentorCalendarService {
    MentorCalendar getMentorCalByUserId(int userId);

    void addMentorCal(MentorCalendar mentorCalendar);

    void updateMentorCal(MentorCalendar mentorCalendar);

    void deleteMentorCal(int tranId);
}
