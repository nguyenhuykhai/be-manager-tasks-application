package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.DTO.ListStudentResponse;
import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findByEmail(String email);

    @Query(value = "SELECT a.student_id, a.student_name, a.score, a.link_facebook, a.email, a.password, a.github, a.skills, a.about, a.picture, a.status, a.is_leader\n" + "FROM student a", nativeQuery = true)
    List<ListStudentResponse> getAll();

    @Query(value = """
    select s 
    from Group g 
    left join Student s on s.groupID.group_id = g.group_id
    where g.group_id = :group_id and g.classID.class_id = :class_id
""")
    Set<Student> findGroupProjectDetails(@Param(value = "group_id") Integer group_id, @Param(value = "class_id") Integer class_id);
}
