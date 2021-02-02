package com.marks.repos;

import com.marks.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudentRepository extends CrudRepository<StudentEntity, UUID> {
}
