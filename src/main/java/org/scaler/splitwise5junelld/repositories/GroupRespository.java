package org.scaler.splitwise5junelld.repositories;

import org.scaler.splitwise5junelld.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRespository extends JpaRepository<Group, Long> {
}
