package org.java.spring_web4.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_web4.db.pojo.Farmer;
import org.java.spring_web4.db.repo.FarmerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepo farmerRepo;

    public List<Farmer> findAll() {
        return farmerRepo.findAll();
    }

    public Optional<Farmer> findById(int id) {

        return farmerRepo.findById(id);
    }

    public void save(Farmer farmer) {
        farmerRepo.save(farmer);
    }

    public void delete(Farmer farmer) {
        farmerRepo.delete(farmer);
    }
}
