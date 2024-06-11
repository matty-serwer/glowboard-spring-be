package org.ltde.glowboard.repository;

import org.ltde.glowboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}