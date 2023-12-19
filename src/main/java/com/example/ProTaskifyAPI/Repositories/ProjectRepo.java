package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Project;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
    @Query(value = """
    select p from Group g 
    left join Project p on p.project_id = g.projectID.project_id
    where g.group_id = :group_id and g.classID.class_id = :class_id and g.status = true
""")
    Optional<Project> findGroupProjectDetails(@Param(value = "group_id") Integer group_id, @Param(value = "class_id") Integer class_id);

    @Query(value = """
    select p.project_name,p.processSet 
    from Group g
    left join Project p on p.project_id = g.projectID.project_id
    where g.group_id = :group_id and g.classID.class_id = :class_id and g.status = true
""")
    List<Object> testFindProject(@Param(value = "group_id") Integer group_id, @Param(value = "class_id") Integer class_id);

  @Query(value = """
    select p
    from Project p
    where not exists (
        select 1 
        from Group g
        where g.projectID.project_id = p.project_id
    )
""")
  List<Project> getAll_NonChooseProjects();
}
