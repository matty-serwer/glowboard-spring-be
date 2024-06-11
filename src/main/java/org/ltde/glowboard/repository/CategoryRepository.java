package org.ltde.glowboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ltde.glowboard.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
