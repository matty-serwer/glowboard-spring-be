package org.ltde.glowboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import org.ltde.glowboard.model.Effect;
import org.ltde.glowboard.repository.EffectRepository;

@Service
public class EffectService {

    @Autowired
    private EffectRepository effectRepository;

    // Get all effects
    public List<Effect> findAllEffects() {
        return effectRepository.findAll();
    }

    // Get effect by ID
    public Effect findEffectById(Long id) {
        return effectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Effect not found on :: " + id));
    }

    // Create a new effect
    public Effect createEffect(Effect effect) {
        return effectRepository.save(effect);
    }

    // Update an effect
    public Effect updateEffect(Long id, Effect effectDetails) {
        Effect effect = findEffectById(id);
        effect.setName(effectDetails.getName());
        effect.setDescription(effectDetails.getDescription());
        effect.setParameters(effectDetails.getParameters());
        return effectRepository.save(effect);
    }

    // Delete an effect
    public void deleteEffect(Long id) {
        Effect effect = findEffectById(id);
        effectRepository.delete(effect);
    }
}