package org.factoriaf5.projectohalloween.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "*")
public class GameController {
    
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getGameInfo() {
        Map<String, Object> gameInfo = new HashMap<>();
        gameInfo.put("name", "Aiden's Adventure");
        gameInfo.put("description", "Un juego de acción ambientado en Halloween");
        gameInfo.put("version", "1.0.0");
        gameInfo.put("status", "active");
        
        Map<String, Object> hero = new HashMap<>();
        hero.put("name", "Aiden");
        hero.put("baseAttack", 15);
        hero.put("abilities", new String[]{"Golpe Potente", "Escudo Protector"});
        gameInfo.put("hero", hero);
        
        Map<String, Object> enemies = new HashMap<>();
        enemies.put("skeleton", Map.of("attack", 5, "points", 10));
        enemies.put("ghost", Map.of("attack", 7, "points", 15));
        enemies.put("vampire", Map.of("attack", 10, "points", 20));
        gameInfo.put("enemies", enemies);
        
        return ResponseEntity.ok(gameInfo);
    }
    
    @GetMapping("/levels")
    public ResponseEntity<Map<String, Object>> getLevels() {
        Map<String, Object> levels = new HashMap<>();
        
        Map<String, Object> level1 = new HashMap<>();
        level1.put("name", "Bosque Encantado");
        level1.put("description", "Primer nivel con esqueletos");
        level1.put("enemies", new String[]{"skeleton"});
        level1.put("difficulty", "easy");
        
        Map<String, Object> level2 = new HashMap<>();
        level2.put("name", "Cementerio Olvidado");
        level2.put("description", "Lleno de fantasmas");
        level2.put("enemies", new String[]{"ghost"});
        level2.put("difficulty", "medium");
        
        Map<String, Object> level3 = new HashMap<>();
        level3.put("name", "Castillo de Mortis");
        level3.put("description", "Enfrentamiento final con el hechicero");
        level3.put("enemies", new String[]{"vampire", "mortis"});
        level3.put("difficulty", "hard");
        
        levels.put("level1", level1);
        levels.put("level2", level2);
        levels.put("level3", level3);
        
        return ResponseEntity.ok(levels);
    }
}
