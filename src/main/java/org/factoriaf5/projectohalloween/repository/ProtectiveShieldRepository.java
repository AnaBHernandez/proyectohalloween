package org.factoriaf5.projectohalloween.repository;

import org.factoriaf5.projectohalloween.model.ProtectiveShield;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProtectiveShieldRepository extends JpaRepository<ProtectiveShield, Long> {
    
    List<ProtectiveShield> findByType(String type);
    
    List<ProtectiveShield> findByNameContainingIgnoreCase(String name);
}
