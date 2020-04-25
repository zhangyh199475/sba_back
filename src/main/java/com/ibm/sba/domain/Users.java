package com.ibm.sba.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Users {
    private int userId;
    private String userName;
    private String password;
    private int roleId;
    private int active;
    private String email;
    private Date createDate;
    private Date workTimingStart;
    private Date workTimingEnd;
    private String linkedinUrl;
    private String mentorProfile;
    private Integer expYear;

    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ROLE_ID")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "ACTIVE")
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "CREATE_DATE")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "WORK_TIMING_START")
    public Date getWorkTimingStart() {
        return workTimingStart;
    }

    public void setWorkTimingStart(Date workTimingStart) {
        this.workTimingStart = workTimingStart;
    }

    @Basic
    @Column(name = "WORK_TIMING_END")
    public Date getWorkTimingEnd() {
        return workTimingEnd;
    }

    public void setWorkTimingEnd(Date workTimingEnd) {
        this.workTimingEnd = workTimingEnd;
    }

    @Basic
    @Column(name = "LINKEDIN_URL")
    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    @Basic
    @Column(name = "MENTOR_PROFILE")
    public String getMentorProfile() {
        return mentorProfile;
    }

    public void setMentorProfile(String mentorProfile) {
        this.mentorProfile = mentorProfile;
    }

    @Basic
    @Column(name = "EXP_YEAR")
    public Integer getExpYear() {
        return expYear;
    }

    public void setExpYear(Integer expYear) {
        this.expYear = expYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId &&
                roleId == users.roleId &&
                active == users.active &&
                Objects.equals(userName, users.userName) &&
                Objects.equals(password, users.password) &&
                Objects.equals(email, users.email) &&
                Objects.equals(createDate, users.createDate) &&
                Objects.equals(workTimingStart, users.workTimingStart) &&
                Objects.equals(workTimingEnd, users.workTimingEnd) &&
                Objects.equals(linkedinUrl, users.linkedinUrl) &&
                Objects.equals(mentorProfile, users.mentorProfile) &&
                Objects.equals(expYear, users.expYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, roleId, active, email, createDate, workTimingStart, workTimingEnd, linkedinUrl, mentorProfile, expYear);
    }
}
