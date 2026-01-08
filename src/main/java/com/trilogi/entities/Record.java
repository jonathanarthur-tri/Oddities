package com.trilogi.entities;

import com.trilogi.entities.keys.RecordKey;
import jakarta.persistence.*;

import javax.xml.namespace.QName;
import java.time.LocalDateTime;
@Entity
@Table(name = "record")
public class Record {


    @EmbeddedId
    private RecordKey id;

    @ManyToOne
    @MapsId("researcherId")
    @JoinColumn(name = "researcher_id")
    private Researcher researcher;
    @ManyToOne
    @MapsId("oddityId")
    @JoinColumn(name = "oddity_id")
    private Oddity oddity;

    @Column(nullable = false)
    private LocalDateTime borrowedDate;
    @Column(nullable = false)
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
