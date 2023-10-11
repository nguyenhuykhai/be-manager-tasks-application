package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group,Integer> {
}
