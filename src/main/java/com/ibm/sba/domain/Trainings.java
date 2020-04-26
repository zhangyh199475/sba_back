package com.ibm.sba.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Trainings {
    private int trainId;
    private String techName;
    private Date startDate;
    private Date endDate;
    private String studentName;
    private String mentorName;
    private int received;
    private String active;
    private Integer price;
    private Integer currentPrice;
    private Integer currentPercent;
    private Integer rate;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "TRAIN_ID")
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "TECH_NAME")
    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    @Basic
    @Column(name = "START_DATE")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "END_DATE")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "STUDENT_NAME")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "MENTOR_NAME")
    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    @Basic
    @Column(name = "RECEIVED")
    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
        this.received = received;
    }

    @Basic
    @Column(name = "ACTIVE")
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Basic
    @Column(name = "PRICE")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "CURRENT_PRICE")
    public Integer getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Integer currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Basic
    @Column(name = "CURRENT_PERCENT")
    public Integer getCurrentPercent() {
        return currentPercent;
    }

    public void setCurrentPercent(Integer currentPercent) {
        this.currentPercent = currentPercent;
    }

    @Basic
    @Column(name = "RATE")
    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainings trainings = (Trainings) o;
        return trainId == trainings.trainId &&
                received == trainings.received &&
                Objects.equals(techName, trainings.techName) &&
                Objects.equals(startDate, trainings.startDate) &&
                Objects.equals(endDate, trainings.endDate) &&
                Objects.equals(studentName, trainings.studentName) &&
                Objects.equals(mentorName, trainings.mentorName) &&
                Objects.equals(active, trainings.active) &&
                Objects.equals(price, trainings.price) &&
                Objects.equals(currentPrice, trainings.currentPrice) &&
                Objects.equals(currentPercent, trainings.currentPercent) &&
                Objects.equals(rate, trainings.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainId, techName, startDate, endDate, studentName, mentorName, received, active, price, currentPrice, currentPercent, rate);
    }
}
