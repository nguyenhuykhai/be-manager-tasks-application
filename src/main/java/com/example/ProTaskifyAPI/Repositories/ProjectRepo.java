package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
