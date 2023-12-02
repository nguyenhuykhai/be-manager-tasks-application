package com.example.ProTaskifyAPI.Repositories;

import com.example.ProTaskifyAPI.Models.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokensRepo extends JpaRepository<Tokens, Integer> {
    @Query("""
            select t from Tokens t inner join Student u on t.student.student_id = u.student_id 
            where u.student_id = :studentID and (t.expired = false or t.revoke = false)
            """)
    List<Tokens> findAllValidTokenByUser(@Param(value = "studentID") Integer userid);

    Optional<Tokens> findByToken(String token);
}
