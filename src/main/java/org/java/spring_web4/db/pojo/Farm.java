package org.java.spring_web4.db.pojo;

import java.util.List;

import org.java.spring_web4.web.dto.FarmDto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 64)
    private String name;
    @Column(nullable = false, length = 64)
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    private List<Farmer> farmers;

    public Farm() {
    }

    public Farm(String name, String city) {
        setName(name);
        setCity(city);
    }

    public Farm(FarmDto farmDto) {

        update(farmDto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }

    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }

    public void update(FarmDto farmDto) {

        setName(farmDto.getName());
        setCity(farmDto.getCity());
    }

    @Override
    public String toString() {

        return "Farm {\n" +
                "\tid: " + id + ",\n" +
                "\tname: " + name + ",\n" +
                "\tcity: " + city + "\n" +
                "}";
    }
}
