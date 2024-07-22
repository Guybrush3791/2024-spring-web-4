package org.java.spring_web4.web.controller;

import java.util.List;

import org.java.spring_web4.db.pojo.Specialization;
import org.java.spring_web4.db.serv.SpecializationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/specs")
@CrossOrigin(origins = "http://localhost:5173")
public class SpecializationController {

    @Autowired
    private SpecializationServ specializationServ;

    @GetMapping("")
    public ResponseEntity<List<Specialization>> getAllSpecializations() {

        return ResponseEntity.ok(specializationServ.findAll());
    }
}