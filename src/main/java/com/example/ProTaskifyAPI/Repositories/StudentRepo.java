package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.DTO.Response.ListStudentResponseV1;
import com.example.ProTaskifyAPI.DTO.StudentDTOV2;
import com.example.ProTaskifyAPI.Models.Student;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
  Optional<Student> findByEmail(String email);

  @Query(
      value =
          "SELECT a.student_id, a.student_name, a.score, a.link_facebook, a.email, a.password, a.github, a.skills, a.about, a.picture, a.status, a.is_leader\n"
              + "FROM student a",
      nativeQuery = true)
  List<ListStudentResponseV1> getAll();

  @Query(
      value = """
    select new com.example.ProTaskifyAPI.DTO.StudentDTOV2(s.student_id, s.student_name, s.classID, s.groupID, s.score, s.link_facebook, s.email, s.github, s.skills, s.about, s.picture, s.status, s.is_leader)
    from Group g
    left join Student s on s.groupID.group_id = g.group_id
    where g.group_id = :group_id and g.classID.class_id = :class_id and g.status = true
""")
  Set<StudentDTOV2> findGroupProjectDetails(
      @Param(value = "group_id") Integer group_id, @Param(value = "class_id") Integer class_id);

  @Query(
      value =
          """
    select s
    from Group g
    left join Student s on s.groupID.group_id = g.group_id
    where g.group_id = :group_id and g.classID.class_id = :class_id and s.email = :email
""")
  Optional<Student> findIndividualStudent(
      @Param(value = "group_id") Integer group_id,
      @Param(value = "class_id") Integer class_id,
      @Param(value = "email") String email);
}
