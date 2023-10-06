package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepo extends JpaRepository<Class,String> {

}
