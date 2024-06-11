package org.ltde.glowboard.repository;

import org.ltde.glowboard.model.Soundboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoundboardRepository extends JpaRepository<Soundboard, Long>{
    List<Soundboard> findByUserId(Long userId);
}
