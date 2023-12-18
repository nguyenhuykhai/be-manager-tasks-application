package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureRepo extends JpaRepository<Feature, Integer> {
//    Optional<Feature> findByFeature_id(Integer featureId);
}
