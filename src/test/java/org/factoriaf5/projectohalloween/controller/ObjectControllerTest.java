package org.factoriaf5.projectohalloween.controller;

import org.factoriaf5.projectohalloween.model.Object;
import org.factoriaf5.projectohalloween.service.ObjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ObjectController.class)
class ObjectControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ObjectService objectService;
    
    @Test
    void testGetAllObjects() throws Exception {
        Object object1 = new Object("Espada", "arma", "Daño +10");
        Object object2 = new Object("Poción", "consumible", "Vida +20");
        
        when(objectService.getAllObjects()).thenReturn(Arrays.asList(object1, object2));
        
        mockMvc.perform(get("/api/objects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }
    
    @Test
    void testGetObjectById() throws Exception {
        Object object = new Object("Espada", "arma", "Daño +10");
        object.setId(1L);
        
        when(objectService.getObjectById(1L)).thenReturn(Optional.of(object));
        
        mockMvc.perform(get("/api/objects/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Espada"))
                .andExpect(jsonPath("$.type").value("arma"));
    }
    
    @Test
    void testGetObjectByIdNotFound() throws Exception {
        when(objectService.getObjectById(999L)).thenReturn(Optional.empty());
        
        mockMvc.perform(get("/api/objects/999"))
                .andExpect(status().isNotFound());
    }
}
