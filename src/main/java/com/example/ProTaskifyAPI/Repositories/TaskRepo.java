package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {


}
