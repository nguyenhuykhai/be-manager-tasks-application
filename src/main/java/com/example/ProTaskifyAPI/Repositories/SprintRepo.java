package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepo extends JpaRepository<Sprint, Integer> {
}
