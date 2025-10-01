package org.factoriaf5.projectohalloween.repository;

import org.factoriaf5.projectohalloween.model.PowerfullBlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerfullBlowRepository extends JpaRepository<PowerfullBlow, Long> {
    
    List<PowerfullBlow> findByType(String type);
    
    List<PowerfullBlow> findByNameContainingIgnoreCase(String name);
}
