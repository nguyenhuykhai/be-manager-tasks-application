package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Sprint;
import com.example.ProTaskifyAPI.Models.Star;
import com.example.ProTaskifyAPI.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StarRepo extends JpaRepository<Star, Integer> {
    List<Star> findStarsBySprintAndStudentNot(Sprint sprint, Student id);

    Optional<Star> findStarBySprintAndStudent(Sprint sprint, Student student);
}
