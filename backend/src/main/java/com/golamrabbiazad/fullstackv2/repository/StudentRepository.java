package com.golamrabbiazad.fullstackv2.repository;

import com.golamrabbiazad.fullstackv2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = """
            SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END
            FROM Student s WHERE s.email = ?1
            """)
    Boolean selectExistsEmail(String email);
}
