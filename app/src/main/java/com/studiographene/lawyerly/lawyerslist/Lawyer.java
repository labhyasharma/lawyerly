package com.studiographene.lawyerly.lawyerslist;

public class Lawyer {
    private String name;
    private String speciality;
    private String rate;
    private String ratings;
    private String profilePic;
    private boolean verified;

    public Lawyer(String name, String speciality, String rate, String ratings, String profilePic, boolean verified) {
        this.name = name;
        this.speciality = speciality;
        this.rate = rate;
        this.ratings = ratings;
        this.profilePic = profilePic;
        this.verified = verified;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
