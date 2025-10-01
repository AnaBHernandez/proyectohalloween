package org.factoriaf5.projectohalloween.controller;

import org.factoriaf5.projectohalloween.model.Object;
import org.factoriaf5.projectohalloween.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/objects")
@CrossOrigin(origins = "*")
public class ObjectController {
    
    @Autowired
    private ObjectService objectService;
    
    @GetMapping
    public ResponseEntity<List<Object>> getAllObjects() {
        List<Object> objects = objectService.getAllObjects();
        return ResponseEntity.ok(objects);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getObjectById(@PathVariable Long id) {
        Optional<Object> object = objectService.getObjectById(id);
        return object.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Object> createObject(@Valid @RequestBody Object object) {
        Object savedObject = objectService.saveObject(object);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedObject);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateObject(@PathVariable Long id, @Valid @RequestBody Object object) {
        if (!objectService.getObjectById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        object.setId(id);
        Object updatedObject = objectService.saveObject(object);
        return ResponseEntity.ok(updatedObject);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObject(@PathVariable Long id) {
        if (!objectService.getObjectById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        objectService.deleteObject(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Object>> getObjectsByType(@PathVariable String type) {
        List<Object> objects = objectService.getObjectsByType(type);
        return ResponseEntity.ok(objects);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Object>> searchObjectsByName(@RequestParam String name) {
        List<Object> objects = objectService.searchObjectsByName(name);
        return ResponseEntity.ok(objects);
    }
}
