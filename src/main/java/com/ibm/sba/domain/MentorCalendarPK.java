package com.ibm.sba.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MentorCalendarPK implements Serializable {
    private int tranId;
    private int userId;

    @Column(name = "TRAN_ID")
    @Id
    public int getTranId() {
        return tranId;
    }

    public void setTranId(int tranId) {
        this.tranId = tranId;
    }

    @Column(name = "USER_ID")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentorCalendarPK that = (MentorCalendarPK) o;
        return tranId == that.tranId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tranId, userId);
    }
}
