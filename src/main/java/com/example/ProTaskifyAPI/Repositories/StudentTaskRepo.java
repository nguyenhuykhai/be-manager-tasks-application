package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.StudentTask;
import com.example.ProTaskifyAPI.Models.StudentTaskCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTaskRepo extends JpaRepository<StudentTask, StudentTaskCompositeKey> {
}
