package org.java.spring_web4.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_web4.db.pojo.Farm;
import org.java.spring_web4.db.repo.FarmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmServ {

    @Autowired
    private FarmRepo farmRepo;

    public List<Farm> findAll() {

        return farmRepo.findAll();
    }

    public Optional<Farm> findById(int id) {

        return farmRepo.findById(id);
    }

    public void save(Farm farm) {

        farmRepo.save(farm);
    }

    public void delete(Farm farm) {

        farmRepo.delete(farm);
    }
}
