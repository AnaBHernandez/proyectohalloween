package org.factoriaf5.projectohalloween.config;

import org.factoriaf5.projectohalloween.model.Ability;
import org.factoriaf5.projectohalloween.model.Object;
import org.factoriaf5.projectohalloween.repository.AbilityRepository;
import org.factoriaf5.projectohalloween.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private ObjectRepository objectRepository;
    
    @Autowired
    private AbilityRepository abilityRepository;
    
    @Override
    public void run(String... args) throws Exception {
        loadInitialData();
    }
    
    private void loadInitialData() {
        // Cargar objetos si no existen
        if (objectRepository.count() == 0) {
            Object sword = new Object("Espada Encantada", "arma", "Incrementa el daño en +10");
            Object potion = new Object("Poción de Vida", "consumible", "Restaura 20 puntos de vida");
            Object amulet = new Object("Amuleto Mágico", "accesorio", "Otorga resistencia mágica");
            
            objectRepository.save(sword);
            objectRepository.save(potion);
            objectRepository.save(amulet);
        }
        
        // Cargar habilidades si no existen
        if (abilityRepository.count() == 0) {
            Ability powerfullBlow = new Ability(null, "Golpe Potente", "ataque", "+10 de ataque cada 3 turnos");
            Ability protectiveShield = new Ability(null, "Escudo Protector", "defensa", "Reduce el daño en 5 puntos durante 2 turnos");
            
            abilityRepository.save(powerfullBlow);
            abilityRepository.save(protectiveShield);
        }
    }
}
