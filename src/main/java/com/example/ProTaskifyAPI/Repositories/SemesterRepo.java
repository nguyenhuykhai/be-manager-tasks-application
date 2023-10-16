package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepo extends JpaRepository<Semester, Integer> {
}
