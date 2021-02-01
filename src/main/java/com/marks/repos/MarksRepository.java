package com.marks.repos;

import com.marks.entities.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MarksRepository extends CrudRepository<GroupEntity, UUID> {
}
