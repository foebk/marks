package com.marks.repos;

import com.marks.entities.MarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MarkRepository extends JpaRepository<MarkEntity, UUID> {
    @Query(value = "select * from marks where marks.student_id = ?1 AND discipline_id = ?2",
    nativeQuery = true)
    List<MarkEntity> findByStudentAndDiscipline(UUID studentId, UUID disciplineId);

    @Query(value = "select * from marks m inner join students s on m.student_id = s.id " +
            "where group_id = ?1 AND m.discipline_id = ?2",
    nativeQuery = true)
    List<MarkEntity> findByGroupAndDiscipline(UUID groupId, UUID disciplineId);
}
