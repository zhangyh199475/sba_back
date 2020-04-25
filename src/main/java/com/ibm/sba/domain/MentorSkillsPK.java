package com.ibm.sba.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MentorSkillsPK implements Serializable {
    private int userId;
    private int techId;

    @Column(name = "USER_ID")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "TECH_ID")
    @Id
    public int getTechId() {
        return techId;
    }

    public void setTechId(int techId) {
        this.techId = techId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentorSkillsPK that = (MentorSkillsPK) o;
        return userId == that.userId &&
                techId == that.techId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, techId);
    }
}
