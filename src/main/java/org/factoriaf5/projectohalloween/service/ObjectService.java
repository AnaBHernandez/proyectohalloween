package org.factoriaf5.projectohalloween.service;

import org.factoriaf5.projectohalloween.model.Object;
import org.factoriaf5.projectohalloween.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectService {
    
    @Autowired
    private ObjectRepository objectRepository;
    
    public List<Object> getAllObjects() {
        return objectRepository.findAll();
    }
    
    public Optional<Object> getObjectById(Long id) {
        return objectRepository.findById(id);
    }
    
    public Object saveObject(Object object) {
        return objectRepository.save(object);
    }
    
    public void deleteObject(Long id) {
        objectRepository.deleteById(id);
    }
    
    public List<Object> getObjectsByType(String type) {
        return objectRepository.findByType(type);
    }
    
    public List<Object> searchObjectsByName(String name) {
        return objectRepository.findByNameContainingIgnoreCase(name);
    }
}
