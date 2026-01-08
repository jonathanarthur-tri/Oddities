package com.trilogi.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    private String description;
    @OneToMany(mappedBy = "category")
    private List<Oddity> oddities;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Oddity> getOddities() {
        return oddities;
    }

    public void setOddities(List<Oddity> oddities) {
        this.oddities = oddities;
    }

    public void addOddity(Oddity oddity) {
        this.oddities.add(oddity);
        oddity.setCategory(this);
    }

    public void removeOddity(Oddity oddity) {
        this.oddities.remove(oddity);
        oddity.setCategory(null);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", oddities=" + oddities +
                '}';
    }
}
