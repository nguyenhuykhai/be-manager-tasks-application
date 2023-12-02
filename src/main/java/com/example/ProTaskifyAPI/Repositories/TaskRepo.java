package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
}
