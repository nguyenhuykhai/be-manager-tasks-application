package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepo extends JpaRepository<Lecturer,String> {
}
