package com.trilogi.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Record {
    private Researcher researcher;
    @ManyToOne
    @JoinColumn(name = "oddity_id")
    private Oddity oddity;

    private LocalDateTime borrowedDate;
    private  LocalDateTime returnDate;
    private LocalDateTime actualReturnDate;
    private String condition;


    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    public Oddity getOddity() {
        return oddity;
    }

    public void setOddity(Oddity oddity) {
        this.oddity = oddity;
    }

    public LocalDateTime getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDateTime borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDateTime getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDateTime actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Record{" +
                "researcher=" + researcher +
                ", oddity=" + oddity +
                ", borrowedDate=" + borrowedDate +
                ", returnDate=" + returnDate +
                ", actualReturnDate=" + actualReturnDate +
                ", condition='" + condition + '\'' +
                '}';
    }
}
