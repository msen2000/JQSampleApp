package org.sen.limo.domain;

public class Request {
    public String ID;
    public String typeOfLimo;
    public String startDate;
    public String endDate;
    public String startTime;
    public String endTime;
    public String passengers;
    public String yourName;
    public String contactNumber;
    public String email;
    public String occasion;
    public String needADrink;
    public String status;
    
    
    public Request() {
        super();
    }

    public void setTypeOfLimo(String typeOfLimo) {
        this.typeOfLimo = typeOfLimo;
    }

    public String getTypeOfLimo() {
        return typeOfLimo;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setYourName(String yourName) {
        this.yourName = yourName;
    }

    public String getYourName() {
        return yourName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setNeedADrink(String needADrink) {
        this.needADrink = needADrink;
    }

    public String getNeedADrink() {
        return needADrink;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
