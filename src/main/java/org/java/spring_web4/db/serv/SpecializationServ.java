package org.java.spring_web4.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_web4.db.pojo.Specialization;
import org.java.spring_web4.db.repo.SpecializationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecializationServ {

    @Autowired
    private SpecializationRepo specializationRepo;

    public List<Specialization> findAll() {

        return specializationRepo.findAll();
    }

    public Optional<Specialization> findById(int id) {

        return specializationRepo.findById(id);
    }

    public void save(Specialization specialization) {

        specializationRepo.save(specialization);
    }

    public void delete(Specialization specialization) {

        specializationRepo.delete(specialization);
    }
}
