package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Feature;
import com.example.ProTaskifyAPI.Models.Task;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findTaskByFeature(Feature feature);

  @Query(value = """
    select t
    from Task t 
    left join Feature f on f.feature_id = t.feature.feature_id
    left join Process p on p.feature.feature_id = f.feature_id
    left join Sprint s on s.sprint_id = p.sprint.sprint_id
    where s.status = true and s.end_date < current_date 
""")
  List<Task> findAllMissDeadlineTasks();
}
