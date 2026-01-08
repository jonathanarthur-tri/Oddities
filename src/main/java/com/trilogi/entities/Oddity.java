package com.trilogi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "oddity")
public class Oddity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 1000)
    private String description;
    @Column(nullable = false)

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;
    @EnumeratedValue
    private DangerLevel dangerLevel;
    private  boolean hasSpecialClearance;

    @OneToMany(mappedBy = "oddity")
    private List<Restriction> restrictions;
    @OneToMany(mappedBy = "oddity")
    private List<Record> lendingRecords;

    public Oddity(){

    }

    public String getNamee() {
        return name;
    }

    public void setNamee(String namee) {
        this.name = namee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public DangerLevel getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(DangerLevel dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public boolean isHasSpecialClearance() {
        return hasSpecialClearance;
    }

    public void setHasSpecialClearance(boolean hasSpecialClearance) {
        this.hasSpecialClearance = hasSpecialClearance;
    }

    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<Restriction> restrictions) {
        this.restrictions = restrictions;
    }

    public List<Record> getLendingRecords() {
        return lendingRecords;
    }

    public void setLendingRecords(List<Record> lendingRecords) {
        this.lendingRecords = lendingRecords;
    }


    public void addRestriction(Restriction restriction){
        this.restrictions.add(restriction);
        restriction.setOddity(this);
    }

    public void removeRestriction(Restriction restriction){
        this.restrictions.remove(restriction);
        restriction.setOddity(null);
    }

    public void addLendingRecord(Record record){
        this.lendingRecords.add(record);
        record.setOddity(this);
    }
    public void removeLendingRecord(Record record){
        this.lendingRecords.remove(record);
        record.setOddity(null);
    }

    @Override
    public String toString() {
        return "Oddity{" +
                "namee='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", dangerLevel=" + dangerLevel +
                ", hasSpecialClearance=" + hasSpecialClearance +
                ", restrictions=" + restrictions +
                ", lendingRecords=" + lendingRecords +
                '}';
    }

}
