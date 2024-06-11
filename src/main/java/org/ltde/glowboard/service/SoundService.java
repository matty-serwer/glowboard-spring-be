package org.ltde.glowboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import org.ltde.glowboard.model.Sound;
import org.ltde.glowboard.repository.SoundRepository;

@Service
public class SoundService {

    @Autowired
    private SoundRepository soundRepository;

    // Get all sounds
    public List<Sound> findAllSounds() {
        return soundRepository.findAll();
    }

    // Get sound by ID
    public Sound findSoundById(Long id) {
        return soundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sound not found on :: " + id));
    }

    // Create a new sound
    public Sound createSound(Sound sound) {
        return soundRepository.save(sound);
    }

    // Update a sound
    public Sound updateSound(Long id, Sound soundDetails) {
        Sound sound = findSoundById(id);
        sound.setName(soundDetails.getName());
        sound.setFilePath(soundDetails.getFilePath());
        sound.setDuration(soundDetails.getDuration());
        return soundRepository.save(sound);
    }

    // Delete a sound
    public void deleteSound(Long id) {
        Sound sound = findSoundById(id);
        soundRepository.delete(sound);
    }
}