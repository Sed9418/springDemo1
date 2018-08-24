package com.example.demo.repository;

import com.example.demo.model.Advertisment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertismentRepository extends JpaRepository<Advertisment, Integer> {
    public List<Advertisment> findAdvertismentsByCategory_Id(int id);
}
