package org.factoriaf5.projectohalloween.repository;

import org.factoriaf5.projectohalloween.model.Magic_Amulet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagicAmuletRepository extends JpaRepository<Magic_Amulet, Long> {
    
    List<Magic_Amulet> findByType(String type);
    
    List<Magic_Amulet> findByNameContainingIgnoreCase(String name);
}
