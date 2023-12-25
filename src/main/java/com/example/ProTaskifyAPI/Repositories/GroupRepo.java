package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.DTO.Response.GroupProjectDetailsDTO;
import com.example.ProTaskifyAPI.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepo extends JpaRepository<Group,Integer> {
  @Query(value = """
    select g from Group g where g.group_id = :group_id and g.classID.class_id = :class_id and g.status = true
""")
  Optional<Group> findGroupProjectDetails(@Param(value = "group_id") Integer group_id, @Param(value = "class_id") Integer class_id);

  @Query(value = """
    select g from Group g where g.projectID.project_id = :topic_id
""")
  Optional<Group> findExistedGroupContainProject(@Param(value = "topic_id") Integer topic_id);

  @Query("""
      select count(t.task_id) 
      from Task t 
      left join Feature f on f.feature_id = t.feature.feature_id
      left join Process p on p.feature.feature_id = f.feature_id
      left join Project pro on pro.project_id = p.project.project_id
      left join Group g on g.projectID.project_id = pro.project_id
      where t.status = :status and g.group_id = :group_id and pro.project_id = :project_id and pro.deleted = false and t.deleted = false
      group by t.task_id
  """)
  Integer countGroupTaskInProject(@Param(value = "status") String status, @Param(value = "group_id") Integer group_id, @Param(value = "project_id") Integer project_id);
}
