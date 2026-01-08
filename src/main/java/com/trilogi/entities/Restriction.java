package com.trilogi.entities;

import jakarta.persistence.*;

@Entity
public class Restriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String rule;
    @EnumeratedValue
    private Severity severity;
    @ManyToOne
    @JoinColumn(name = "oddity_id")
    private Oddity oddity;

    public Oddity getOddity() {
        return oddity;
    }

    public void setOddity(Oddity oddity) {
        this.oddity = oddity;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        return "Restriction{" +
                "rule='" + rule + '\'' +
                ", severity=" + severity +
                ", oddity=" + oddity +
                '}';
    }
}
