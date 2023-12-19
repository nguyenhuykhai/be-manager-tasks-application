package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.DTO.ProcessDTO;
import com.example.ProTaskifyAPI.DTO.Response.ProcessDetailsResponse;
import com.example.ProTaskifyAPI.Models.Feature;
import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Models.ProcessCompositeKey;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.ProTaskifyAPI.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepo extends JpaRepository<Process, ProcessCompositeKey> {
    @Query(value = """
    select pro from Group g 
    left join Project p on p.project_id = g.projectID.project_id
    left join Process pro on pro.project.project_id = p.project_id
    where g.group_id = :group_id and g.classID.class_id = :class_id
""")
    Set<Process> findGroupProjectDetails(@Param(value = "group_id") Integer group_id, @Param(value = "class_id") Integer class_id);

    @Query(value = """
    select new com.example.ProTaskifyAPI.DTO.Response.ProcessDetailsResponse(pro.id, pro.project, pro.sprint, pro.feature)
    from Group g
    left join Project p on p.project_id = g.projectID.project_id
    left join Process pro on pro.project.project_id = p.project_id
    left join Feature f on f.feature_id = pro.feature.feature_id
    left join Task t on t.feature.feature_id = f.feature_id
    where g.group_id = :group_id and g.classID.class_id = :class_id
""")
    Set<ProcessDetailsResponse> findProcessDetails(@Param(value = "group_id") Integer group_id, @Param(value = "class_id") Integer class_id);

    List<Process> findProcessByFeature(Feature feature);

    List<Process> findProcessesByProject(Project project);
}
