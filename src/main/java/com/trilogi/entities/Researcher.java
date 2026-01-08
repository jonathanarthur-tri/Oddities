package com.trilogi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "researcher")
public class Researcher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String fullName;

    private String fieldOfStudy;
    private int clearanceLevel;
    private boolean isActive;

    @OneToMany(mappedBy = "researcher")
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


    public void addBorrowedRecord(Record record) {
        this.borrowedRecords.add(record);
        record.setResearcher(this);
    }
    public void removeBorrowedRecord(Record record) {
        this.borrowedRecords.remove(record);
        record.setResearcher(null);
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
