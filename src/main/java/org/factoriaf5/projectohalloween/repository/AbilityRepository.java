package org.factoriaf5.projectohalloween.repository;

import org.factoriaf5.projectohalloween.model.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, Long> {
    
    List<Ability> findByType(String type);
    
    List<Ability> findByNameContainingIgnoreCase(String name);
}
