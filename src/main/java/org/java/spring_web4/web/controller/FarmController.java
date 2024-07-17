package org.java.spring_web4.web.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.java.spring_web4.db.pojo.Farm;
import org.java.spring_web4.db.serv.FarmServ;
import org.java.spring_web4.web.dto.FarmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/farm")
public class FarmController {

    @Autowired
    private FarmServ farmServ;

    @GetMapping("")
    public ResponseEntity<List<Farm>> getAllFarm() {

        List<Farm> farms = farmServ.findAll();
        return ResponseEntity.ok(farms);
    }

    @PostMapping("")
    public ResponseEntity<Farm> addFarm(
            @RequestBody FarmDto farmDto) {

        Farm newFarm = new Farm(farmDto);
        farmServ.save(newFarm);

        return ResponseEntity.ok(newFarm);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Farm> updateFarm(
            @PathVariable int id,
            @RequestBody FarmDto farmDto) {

        Optional<Farm> optFarm = farmServ.findById(id);

        if (optFarm.isEmpty())
            return ResponseEntity.notFound().build();

        Farm farm = optFarm.get();
        farm.update(farmDto);
        farmServ.save(farm);

        return ResponseEntity.ok(farm);
    }

}
