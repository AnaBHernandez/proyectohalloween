package org.factoriaf5.projectohalloween.repository;

import org.factoriaf5.projectohalloween.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Long> {
    
    List<Object> findByType(String type);
    
    List<Object> findByNameContainingIgnoreCase(String name);
}
