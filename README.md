# Aiden's Adventure

## Descripción

**Aiden's Adventure** es un juego de acción ambientado en un pueblo sombrío donde, cada noche de Halloween, las barreras entre el mundo de los vivos y los muertos se debilitan. El hechicero Mortis ha desatado criaturas oscuras para conquistar el alma del pueblo. El jugador asume el rol de Aiden, un joven guerrero con un espíritu indomable, cuyo objetivo es enfrentar a esqueletos, fantasmas y vampiros para devolver la paz al lugar.

## Historia de Fondo

En Halloween, el hechicero Mortis abre portales que liberan criaturas del más allá. Los habitantes del pueblo están en peligro, y Aiden es la última esperanza para salvarlos y cerrar las puertas entre los mundos antes de la medianoche.

## Objetivo del Juego

Guiar a Aiden a través de diversos niveles, enfrentándose a las criaturas de Mortis, recolectando objetos mágicos, y mejorando sus habilidades. El objetivo final es derrotar a Mortis y restaurar la paz.

## Características Principales

1. **Héroe: Aiden**
   - Habilidades desbloqueables y estadísticas que mejoran en cada nivel.
   - **Golpe Potente**: +10 de ataque (cada 3 turnos).
   - **Escudo Protector**: Reduce el daño en 5 puntos durante 2 turnos.

2. **Villanos**
   - **Esqueletos**: Rápidos y débiles; atacan en grupo.
   - **Fantasmas**: Invisibles y esquivos.
   - **Vampiros**: Absorben vida y tienen gran poder de ataque.

3. **Objetos Mágicos**
   - **Espadas encantadas**: Incrementan el daño.
   - **Pociones de vida**: Restauran salud.
   - **Amuletos mágicos**: Otorgan habilidades temporales.

4. **Niveles**
   - **Bosque Encantado**: Primer nivel con esqueletos.
   - **Cementerio Olvidado**: Lleno de fantasmas.
   - **Castillo de Mortis**: Enfrentamiento final con el hechicero.

## Sistema de Puntuación

- **Aiden**: 15 puntos de ataque base. 
- **Villanos**:
  - **Esqueleto**: 5 de ataque; 10 puntos al derrotarlo.
  - **Fantasma**: 7 de ataque; 15 puntos al derrotarlo.
  - **Vampiro**: 10 de ataque; 20 puntos y recuperación de vida al derrotarlo.

## Experiencia y Logros

- Aiden sube de nivel ganando experiencia, mejorando habilidades y estadísticas.
- Logros y trofeos por objetivos adicionales y misiones opcionales.

## Organización del Proyecto

Este proyecto está organizado en **tres sprints** de una semana cada uno. Utilizamos **Jira** para planificar y gestionar el trabajo en equipo.

## Herramientas

- **Spring Boot y Java 21 SE**: Para desarrollar la API.
- **H2**: Base de datos en memoria.
- **Postman**: Para pruebas de API.
- **GitHub**: Para control de versiones.

## Instalación y Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone <url-del-repositorio>
   cd proyectohalloween
   ```

2. **Ejecutar el proyecto:**
   ```bash
   mvn spring-boot:run
   ```

3. **Acceder a la aplicación:**
   - API REST: `http://localhost:8081`
   - Consola H2: `http://localhost:8081/h2-console`
     - JDBC URL: `jdbc:h2:mem:testdb`
     - Usuario: `sa`
     - Contraseña: `password`

## Endpoints de la API

### Objetos del Juego
- `GET /api/objects` - Obtener todos los objetos
- `GET /api/objects/{id}` - Obtener objeto por ID
- `POST /api/objects` - Crear nuevo objeto
- `PUT /api/objects/{id}` - Actualizar objeto
- `DELETE /api/objects/{id}` - Eliminar objeto
- `GET /api/objects/type/{type}` - Filtrar por tipo
- `GET /api/objects/search?name={name}` - Buscar por nombre

### Habilidades
- `GET /api/abilities` - Obtener todas las habilidades
- `GET /api/abilities/{id}` - Obtener habilidad por ID
- `POST /api/abilities` - Crear nueva habilidad
- `PUT /api/abilities/{id}` - Actualizar habilidad
- `DELETE /api/abilities/{id}` - Eliminar habilidad

### Información del Juego
- `GET /api/game/info` - Información general del juego
- `GET /api/game/levels` - Información de niveles

## Ejemplos de Uso

### Crear un objeto
```bash
curl -X POST http://localhost:8081/api/objects \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Espada Mágica",
    "type": "arma",
    "efect": "Daño +15"
  }'
```

### Obtener información del juego
```bash
curl http://localhost:8081/api/game/info
```

## Entregables

- Repositorio en GitHub con todo el código y documentación.
- Diagrama UML de arquitectura.
 ![UML PROYECTOHALLOWEEN](https://github.com/user-attachments/assets/6b0b6b85-79b2-48fb-a274-dc617fe79321)


- Diagrama de flujo
  
  ![DiagramaFlujo](https://github.com/user-attachments/assets/86b3b36b-8500-4833-8098-15e7080d9d13)

- Plan de sprints en Jira.
- Pruebas en Postman.
- Cobertura de tests mínima del 70%.

## Colaboradores

Este proyecto ha sido desarrollado por un equipo increíble de colaboradores. Puedes ver sus perfiles en GitHub a continuación:

- [Óscar Menéndez](https://github.com/Morty1904) (Scrum Master, developer)
- [Ana B. Hernandez](https://github.com/AnaBHernandez) (Product Owner, developer)
- [Guadalupe García](https://github.com/GuadalupeGFigueroa) (Developer)
- [Naudelyn Lucena](https://github.com/NaudelynLucena) (Developer)
- [Alejandra Sierra](https://github.com/alejandra-sierra) (Developer)
- [Lara Gutiérrez](https://github.com/lara-gs) (Developer)
- [Pilar Pato](https://github.com/Pilar-Pato) (Developer)


