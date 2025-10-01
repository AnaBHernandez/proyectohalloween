package org.factoriaf5.projectohalloween.repository;

import org.factoriaf5.projectohalloween.model.Health_Potion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthPotionRepository extends JpaRepository<Health_Potion, Long> {
    
    List<Health_Potion> findByType(String type);
    
    List<Health_Potion> findByNameContainingIgnoreCase(String name);
}
