package com.ibm.sba.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Payments {
    private int payId;
    private int studentId;
    private int mentorId;
    private int trainId;
    private int price;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PAY_ID")
    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    @Basic
    @Column(name = "STUDENT_ID")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "MENTOR_ID")
    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    @Basic
    @Column(name = "TRAIN_ID")
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "PRICE")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments payments = (Payments) o;
        return payId == payments.payId &&
                studentId == payments.studentId &&
                mentorId == payments.mentorId &&
                trainId == payments.trainId &&
                price == payments.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payId, studentId, mentorId, trainId, price);
    }
}
