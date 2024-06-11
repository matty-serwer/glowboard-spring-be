package org.ltde.glowboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import org.ltde.glowboard.model.Soundboard;
import org.ltde.glowboard.repository.SoundboardRepository;


@Service
public class SoundboardService {

    @Autowired
    private SoundboardRepository soundboardRepository;

    // Get all soundboards
    public List<Soundboard> findAllSoundboards() {
        return soundboardRepository.findAll();
    }

    // Get soundboard by ID
    public Soundboard findSoundboardById(Long id) {
        return soundboardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soundboard not found on :: " + id));
    }

    // Get all soundboards by user ID
    public List<Soundboard> findSoundboardsByUserId(Long userId) {
        return soundboardRepository.findByUserId(userId);
    }

    // Create a new soundboard
    public Soundboard createSoundboard(Soundboard soundboard) {
        return soundboardRepository.save(soundboard);
    }

    // Update a soundboard
    public Soundboard updateSoundboard(Long id, Soundboard soundboardDetails) {
        Soundboard soundboard = findSoundboardById(id);
        soundboard.setName(soundboardDetails.getName());
        soundboard.setDescription(soundboardDetails.getDescription());
        return soundboardRepository.save(soundboard);
    }

    // Delete a soundboard
    public void deleteSoundboard(Long id) {
        Soundboard soundboard = findSoundboardById(id);
        soundboardRepository.delete(soundboard);
    }
}