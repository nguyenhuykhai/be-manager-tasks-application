package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.StudentTask;
import com.example.ProTaskifyAPI.Models.StudentTaskCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTaskRepo extends JpaRepository<StudentTask, StudentTaskCompositeKey> {
  @Query("""
    select count(t.task_id) 
    from StudentTask st 
    left join Task t on t.task_id = st.task.task_id
    left join Feature f on f.feature_id = t.feature.feature_id
    left join Process p on p.feature.feature_id = f.feature_id
    left join Sprint s on s.sprint_id = p.sprint.sprint_id
    where t.status = "Finished" and st.student.student_id = :student_id and s.sprint_id = :sprint_id and s.deleted = false
    group by t.task_id
""")
  Integer countStudentTaskPerSprint_Finished(@Param(value = "student_id") Integer student_id, @Param(value = "sprint_id") Integer sprint_id);

  @Query("""
      select count(t.task_id) 
      from StudentTask st 
      left join Task t on t.task_id = st.task.task_id
      left join Feature f on f.feature_id = t.feature.feature_id
      left join Process p on p.feature.feature_id = f.feature_id
      left join Project pro on pro.project_id = p.project.project_id
      where t.status = :status and st.student.student_id = :student_id and pro.project_id = :project_id and pro.deleted = false
      group by t.task_id
  """)
  Integer countStudentTaskInProject(@Param(value = "status") String status, @Param(value = "student_id") Integer student_id, @Param(value = "project_id") Integer project_id);
}
