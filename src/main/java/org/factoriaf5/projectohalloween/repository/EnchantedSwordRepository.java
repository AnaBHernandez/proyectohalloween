package org.factoriaf5.projectohalloween.repository;

import org.factoriaf5.projectohalloween.model.Enchanted_Sword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnchantedSwordRepository extends JpaRepository<Enchanted_Sword, Long> {
    
    List<Enchanted_Sword> findByType(String type);
    
    List<Enchanted_Sword> findByNameContainingIgnoreCase(String name);
}
