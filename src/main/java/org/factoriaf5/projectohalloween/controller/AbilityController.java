package org.factoriaf5.projectohalloween.controller;

import org.factoriaf5.projectohalloween.model.Ability;
import org.factoriaf5.projectohalloween.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/abilities")
@CrossOrigin(origins = "*")
public class AbilityController {
    
    @Autowired
    private AbilityService abilityService;
    
    @GetMapping
    public ResponseEntity<List<Ability>> getAllAbilities() {
        List<Ability> abilities = abilityService.getAllAbilities();
        return ResponseEntity.ok(abilities);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ability> getAbilityById(@PathVariable Long id) {
        Optional<Ability> ability = abilityService.getAbilityById(id);
        return ability.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Ability> createAbility(@Valid @RequestBody Ability ability) {
        Ability savedAbility = abilityService.saveAbility(ability);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAbility);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Ability> updateAbility(@PathVariable Long id, @Valid @RequestBody Ability ability) {
        if (!abilityService.getAbilityById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ability.setId(id);
        Ability updatedAbility = abilityService.saveAbility(ability);
        return ResponseEntity.ok(updatedAbility);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbility(@PathVariable Long id) {
        if (!abilityService.getAbilityById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        abilityService.deleteAbility(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Ability>> getAbilitiesByType(@PathVariable String type) {
        List<Ability> abilities = abilityService.getAbilitiesByType(type);
        return ResponseEntity.ok(abilities);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Ability>> searchAbilitiesByName(@RequestParam String name) {
        List<Ability> abilities = abilityService.searchAbilitiesByName(name);
        return ResponseEntity.ok(abilities);
    }
}
