package org.factoriaf5.projectohalloween.service;

import org.factoriaf5.projectohalloween.model.Ability;
import org.factoriaf5.projectohalloween.repository.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbilityService {
    
    @Autowired
    private AbilityRepository abilityRepository;
    
    public List<Ability> getAllAbilities() {
        return abilityRepository.findAll();
    }
    
    public Optional<Ability> getAbilityById(Long id) {
        return abilityRepository.findById(id);
    }
    
    public Ability saveAbility(Ability ability) {
        return abilityRepository.save(ability);
    }
    
    public void deleteAbility(Long id) {
        abilityRepository.deleteById(id);
    }
    
    public List<Ability> getAbilitiesByType(String type) {
        return abilityRepository.findByType(type);
    }
    
    public List<Ability> searchAbilitiesByName(String name) {
        return abilityRepository.findByNameContainingIgnoreCase(name);
    }
}
