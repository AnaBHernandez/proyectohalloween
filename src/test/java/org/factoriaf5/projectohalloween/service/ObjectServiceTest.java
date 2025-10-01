package org.factoriaf5.projectohalloween.service;

import org.factoriaf5.projectohalloween.model.Object;
import org.factoriaf5.projectohalloween.repository.ObjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObjectServiceTest {
    
    @Mock
    private ObjectRepository objectRepository;
    
    @InjectMocks
    private ObjectService objectService;
    
    @Test
    void testGetAllObjects() {
        Object object1 = new Object("Espada", "arma", "Daño +10");
        Object object2 = new Object("Poción", "consumible", "Vida +20");
        List<Object> objects = Arrays.asList(object1, object2);
        
        when(objectRepository.findAll()).thenReturn(objects);
        
        List<Object> result = objectService.getAllObjects();
        
        assertEquals(2, result.size());
        assertEquals("Espada", result.get(0).getName());
        assertEquals("Poción", result.get(1).getName());
    }
    
    @Test
    void testGetObjectById() {
        Object object = new Object("Espada", "arma", "Daño +10");
        object.setId(1L);
        
        when(objectRepository.findById(1L)).thenReturn(Optional.of(object));
        
        Optional<Object> result = objectService.getObjectById(1L);
        
        assertTrue(result.isPresent());
        assertEquals("Espada", result.get().getName());
    }
    
    @Test
    void testSaveObject() {
        Object object = new Object("Espada", "arma", "Daño +10");
        Object savedObject = new Object("Espada", "arma", "Daño +10");
        savedObject.setId(1L);
        
        when(objectRepository.save(any(Object.class))).thenReturn(savedObject);
        
        Object result = objectService.saveObject(object);
        
        assertEquals(1L, result.getId());
        assertEquals("Espada", result.getName());
    }
    
    @Test
    void testDeleteObject() {
        objectService.deleteObject(1L);
        verify(objectRepository, times(1)).deleteById(1L);
    }
}
