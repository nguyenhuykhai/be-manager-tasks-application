package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
    @Query(value = """
    select p from Group g 
    left join Project p on p.project_id = g.projectID.project_id
    where g.group_id = :group_id and g.classID.class_id = :class_id
""")
    Optional<Project> findGroupProjectDetails(@Param(value = "group_id") Integer group_id, @Param(value = "class_id") Integer class_id);
}
