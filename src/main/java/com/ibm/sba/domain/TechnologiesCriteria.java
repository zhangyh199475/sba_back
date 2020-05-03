package com.ibm.sba.domain;


public class TechnologiesCriteria {
    private String techName;
    private String userName;
    private int price;
    private String linkedinUrl;
    private String mentorProfile;
    private Integer expYear;

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getMentorProfile() {
        return mentorProfile;
    }

    public void setMentorProfile(String mentorProfile) {
        this.mentorProfile = mentorProfile;
    }

    public Integer getExpYear() {
        return expYear;
    }

    public void setExpYear(Integer expYear) {
        this.expYear = expYear;
    }

    @Override
    public String toString() {
        return "TechnologiesCriteria{" +
                "techName='" + techName + '\'' +
                ", userName='" + userName + '\'' +
                ", price=" + price +
                ", linkedinUrl='" + linkedinUrl + '\'' +
                ", mentorProfile='" + mentorProfile + '\'' +
                ", expYear=" + expYear +
                '}';
    }
}
