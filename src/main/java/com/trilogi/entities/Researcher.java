package com.trilogi.entities;

import java.util.List;

public class Researcher {
    private String fullName;
    private String fieldOfStudy;
    private int clearanceLevel;
    private boolean isActive;
    private List<Record> borrowedRecords;

    public Researcher(){}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public int getClearanceLevel() {
        return clearanceLevel;
    }

    public void setClearanceLevel(int clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Record> getBorrowedRecords() {
        return borrowedRecords;
    }

    public void setBorrowedRecords(List<Record> borrowedRecords) {
        this.borrowedRecords = borrowedRecords;
    }

    @Override
    public String toString() {
        return "Researcher{" +
                "fullName='" + fullName + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", clearanceLevel=" + clearanceLevel +
                ", isActive=" + isActive +
                ", borrowedRecords=" + borrowedRecords +
                '}';
    }
}
