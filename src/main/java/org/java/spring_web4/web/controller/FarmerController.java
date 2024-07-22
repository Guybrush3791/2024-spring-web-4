package org.java.spring_web4.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.java.spring_web4.db.pojo.Farm;
import org.java.spring_web4.db.pojo.Farmer;
import org.java.spring_web4.db.pojo.Specialization;
import org.java.spring_web4.db.serv.FarmServ;
import org.java.spring_web4.db.serv.FarmerService;
import org.java.spring_web4.db.serv.SpecializationServ;
import org.java.spring_web4.web.dto.FarmerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/farmer")
@CrossOrigin(origins = "http://localhost:5173")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @Autowired
    private FarmServ farmServ;

    @Autowired
    private SpecializationServ specializationServ;

    @GetMapping("/test/add")
    public ResponseEntity<Void> addTestData() {

        Specialization spec1 = new Specialization("Cultivation");
        Specialization spec2 = new Specialization("Irrigation");
        Specialization spec3 = new Specialization("Harvesting");
        Specialization spec4 = new Specialization("Fertilization");

        specializationServ.save(spec1);
        specializationServ.save(spec2);
        specializationServ.save(spec3);
        specializationServ.save(spec4);

        List<Specialization> specList1 = List.of(spec1, spec2);
        List<Specialization> specList2 = List.of(spec3, spec4);
        List<Specialization> specList3 = List.of(spec1, spec3);

        Farm farm1 = new Farm("Farm1", "Milan");
        Farm farm2 = new Farm("Farm2", "Rome");
        Farm farm3 = new Farm("Farm3", "Naples");

        farmServ.save(farm1);
        farmServ.save(farm2);
        farmServ.save(farm3);

        Farmer farmer1 = new Farmer("Guybrush", "Threepwood", 30, farm1, specList1);
        Farmer farmer2 = new Farmer("Elaine", "Marley", 35, farm3, specList2);
        Farmer farmer3 = new Farmer("LeChuck", "LeChuck", 40, farm3, specList3);

        farmerService.save(farmer1);
        farmerService.save(farmer2);
        farmerService.save(farmer3);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Farmer>> getAllFarmer() {

        List<Farmer> farmers = farmerService.findAll();
        return ResponseEntity.ok(farmers);
    }

    @PostMapping("")
    public ResponseEntity<Farmer> addFarmer(
            @RequestBody FarmerDto farmerDto) {

        System.out.println("Farmer DTO: " + farmerDto);

        List<Specialization> specList = new ArrayList<>();
        for (Integer specId : farmerDto.getSpecs()) {

            Optional<Specialization> optSpec = specializationServ.findById(specId);

            if (optSpec.isEmpty())
                return ResponseEntity.badRequest().build();

            Specialization spec = optSpec.get();

            specList.add(spec);
        }

        Optional<Farm> optFarm = farmServ.findById(farmerDto.getFarmId());

        if (optFarm.isEmpty())
            return ResponseEntity.internalServerError().build();

        Farm farm = optFarm.get();
        Farmer newFarmer = new Farmer(farmerDto);
        newFarmer.setSpecializations(specList);

        newFarmer.setFarm(farm);
        farmerService.save(newFarmer);

        return ResponseEntity.ok(newFarmer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFarmer(
            @PathVariable int id) {

        Optional<Farmer> optFarmer = farmerService.findById(id);

        if (optFarmer.isEmpty())
            return ResponseEntity.notFound().build();

        Farmer farmer = optFarmer.get();
        farmerService.delete(farmer);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Farmer> updateFarmer(
            @PathVariable int id,
            @RequestBody FarmerDto farmerDto) {

        Optional<Farm> optFarm = farmServ.findById(farmerDto.getFarmId());
        Optional<Farmer> optFarmer = farmerService.findById(id);

        if (optFarm.isEmpty() || optFarmer.isEmpty())
            return ResponseEntity.badRequest().build();

        Farm farm = optFarm.get();
        Farmer farmer = optFarmer.get();

        farmer.update(farmerDto);
        farmer.setFarm(farm);

        farmerService.save(farmer);

        return ResponseEntity.ok(farmer);
    }
}
