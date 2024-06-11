package org.ltde.glowboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.ltde.glowboard.model.Soundboard;
import org.ltde.glowboard.service.SoundboardService;

@RestController
@RequestMapping("/api/soundboards")
public class SoundboardController {

    @Autowired
    private SoundboardService soundboardService;

    // GET: Retrieve all soundboards
    @GetMapping
    public List<Soundboard> getAllSoundboards() {
        return soundboardService.findAllSoundboards();
    }

    // GET: Retrieve a single soundboard by ID
    @GetMapping("/{id}")
    public ResponseEntity<Soundboard> getSoundboardById(@PathVariable(value = "id") Long id) {
        Soundboard soundboard = soundboardService.findSoundboardById(id);
        return ResponseEntity.ok().body(soundboard);
    }

    // GET: Retrieve all soundboards by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Soundboard>> getSoundboardsByUserId(@PathVariable(value = "userId") Long userId) {
        List<Soundboard> soundboards = soundboardService.findSoundboardsByUserId(userId);
        return ResponseEntity.ok().body(soundboards);
    }

    // POST: Create a new soundboard
    @PostMapping
    public ResponseEntity<Soundboard> createSoundboard(@RequestBody Soundboard soundboard) {
        Soundboard newSoundboard = soundboardService.createSoundboard(soundboard);
        return ResponseEntity.ok(newSoundboard);
    }

    // PUT: Update an existing soundboard
    @PutMapping("/{id}")
    public ResponseEntity<Soundboard> updateSoundboard(@PathVariable(value = "id") Long id, @RequestBody Soundboard soundboardDetails) {
        Soundboard updatedSoundboard = soundboardService.updateSoundboard(id, soundboardDetails);
        return ResponseEntity.ok(updatedSoundboard);
    }

    // DELETE: Delete a soundboard
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoundboard(@PathVariable(value = "id") Long id) {
        soundboardService.deleteSoundboard(id);
        return ResponseEntity.ok().build();
    }
}