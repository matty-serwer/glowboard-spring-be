package org.ltde.glowboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.ltde.glowboard.model.Effect;
import org.ltde.glowboard.service.EffectService;

@RestController
@RequestMapping("/api/effects")
public class EffectController {

    @Autowired
    private EffectService effectService;

    // GET: Retrieve all effects
    @GetMapping
    public List<Effect> getAllEffects() {
        return effectService.findAllEffects();
    }

    // GET: Retrieve a single effect by ID
    @GetMapping("/{id}")
    public ResponseEntity<Effect> getEffectById(@PathVariable(value = "id") Long id) {
        Effect effect = effectService.findEffectById(id);
        return ResponseEntity.ok().body(effect);
    }

    // POST: Create a new effect
    @PostMapping
    public ResponseEntity<Effect> createEffect(@RequestBody Effect effect) {
        Effect newEffect = effectService.createEffect(effect);
        return ResponseEntity.ok(newEffect);
    }

    // PUT: Update an existing effect
    @PutMapping("/{id}")
    public ResponseEntity<Effect> updateEffect(@PathVariable(value = "id") Long id, @RequestBody Effect effectDetails) {
        Effect updatedEffect = effectService.updateEffect(id, effectDetails);
        return ResponseEntity.ok(updatedEffect);
    }

    // DELETE: Delete an effect
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEffect(@PathVariable(value = "id") Long id) {
        effectService.deleteEffect(id);
        return ResponseEntity.ok().build();
    }
}