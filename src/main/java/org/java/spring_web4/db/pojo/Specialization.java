package org.java.spring_web4.db.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = false)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "specializations")
    private List<Farmer> farmers;

    public Specialization() {
    }

    public Specialization(String name) {

        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Farmer> getFarmers() {

        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {

        this.farmers = farmers;
    }

    @Override
    public String toString() {

        return "Specialization{\n" +
                "\tid=" + id + ",\n" +
                "\tname='" + name + "'\n" +
                "}";
    }
}
