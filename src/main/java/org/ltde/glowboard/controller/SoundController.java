package org.ltde.glowboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.ltde.glowboard.model.Sound;
import org.ltde.glowboard.service.SoundService;

@RestController
@RequestMapping("/api/sounds")
public class SoundController {

    @Autowired
    private SoundService soundService;

    // GET: Retrieve all sounds
    @GetMapping
    public List<Sound> getAllSounds() {
        return soundService.findAllSounds();
    }

    // GET: Retrieve a single sound by ID
    @GetMapping("/{id}")
    public ResponseEntity<Sound> getSoundById(@PathVariable(value = "id") Long id) {
        Sound sound = soundService.findSoundById(id);
        return ResponseEntity.ok().body(sound);
    }

    // POST: Create a new sound
    @PostMapping
    public ResponseEntity<Sound> createSound(@RequestBody Sound sound) {
        Sound newSound = soundService.createSound(sound);
        return ResponseEntity.ok(newSound);
    }

    // PUT: Update an existing sound
    @PutMapping("/{id}")
    public ResponseEntity<Sound> updateSound(@PathVariable(value = "id") Long id, @RequestBody Sound soundDetails) {
        Sound updatedSound = soundService.updateSound(id, soundDetails);
        return ResponseEntity.ok(updatedSound);
    }

    // DELETE: Delete a sound
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSound(@PathVariable(value = "id") Long id) {
        soundService.deleteSound(id);
        return ResponseEntity.ok().build();
    }
}