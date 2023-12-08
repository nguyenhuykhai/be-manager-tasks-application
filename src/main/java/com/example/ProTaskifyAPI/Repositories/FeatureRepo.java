package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepo extends JpaRepository<Feature, Integer> {
 
}
