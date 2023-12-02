package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Models.ProcessCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepo extends JpaRepository<Process, ProcessCompositeKey> {
}
