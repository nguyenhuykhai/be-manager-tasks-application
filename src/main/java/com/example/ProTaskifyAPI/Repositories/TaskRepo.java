package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Feature;
import com.example.ProTaskifyAPI.Models.Task;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findTaskByFeature(Feature feature);

}
