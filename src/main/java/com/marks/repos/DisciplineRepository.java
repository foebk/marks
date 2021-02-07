package com.marks.repos;

import com.marks.entities.DisciplineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DisciplineRepository extends JpaRepository<DisciplineEntity, UUID> {
}
