package com.ibm.sba.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mentor_skills", schema = "sba", catalog = "")
@IdClass(MentorSkillsPK.class)
public class MentorSkills {
    private int userId;
    private int techId;

    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "TECH_ID")
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
        MentorSkills that = (MentorSkills) o;
        return userId == that.userId &&
                techId == that.techId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, techId);
    }
}
