package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Sprint;
import com.example.ProTaskifyAPI.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SprintRepo extends JpaRepository<Sprint, Integer> {
    @Query(value = """
    select s
    from Sprint s
    where s.deleted = false and s.end_date < current_date and s.status = 'Pending' 
""")
    List<Sprint> findAllMissDeadlineSprints();

}
