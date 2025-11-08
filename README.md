🎮 Proyecto: Simulación de Juego de Póker — ORT 2024

Este proyecto fue desarrollado como parte de la materia Algoritmia y Estructuras de Datos II en la Universidad ORT Uruguay, durante el año 2024.
El objetivo fue diseñar y programar un juego inspirado en el póker, siguiendo las reglas definidas por la cátedra, aplicando distintos patrones de diseño y principios de arquitectura de software.

🧠 Enfoque general

El sistema se construyó con una clara división lógica entre sus módulos, separando las responsabilidades en capas bien definidas.
Se implementó una arquitectura basada en el patrón MVC (Modelo–Vista–Controlador) para mantener la independencia entre la lógica del juego, la presentación gráfica y el flujo de interacción.
Esto permitió desarrollar una aplicación modular, flexible y fácil de mantener, donde cada parte puede evolucionar sin afectar al resto.

🧩 Patrones de diseño aplicados

Durante el desarrollo se integraron varios patrones clásicos y principios de diseño:

🏗️ Factory Pattern: para la creación dinámica de objetos relacionados con las distintas combinaciones de cartas y figuras del juego.

👁️ Observer Pattern: para mantener actualizadas las distintas ventanas del juego cuando ocurren cambios en el estado (como apuestas, cartas nuevas o resultados).

🔄 State Pattern: para manejar los diferentes estados del juego (inicio, turno, ronda y final) con transiciones controladas.

🧠 Patrón Experto: para asignar la responsabilidad del cálculo de resultados y validación de manos a las clases que poseen la información necesaria, mejorando la cohesión y reduciendo dependencias.

Estos patrones no solo mejoran la estructura del código, sino que también reflejan buenas prácticas de ingeniería de software, como la reutilización, extensibilidad y separación de responsabilidades.

🧱 Arquitectura y componentes

Modelo: Contiene la lógica del juego, las reglas, los jugadores, las mesas y las estructuras de datos necesarias para evaluar las manos.

Vista: Interfaz gráfica desarrollada en Java Swing, utilizando JFrame y JDialog para representar cada ventana del jugador y la mesa.

Controlador: Coordina la interacción entre el modelo y la vista, gestionando eventos y actualizaciones en tiempo real mediante observadores.

Además, la división lógica entre estos componentes favoreció la depuración y la escalabilidad del proyecto, permitiendo modificar o mejorar la lógica del juego sin alterar la interfaz visual.

🧮 Estructuras y aspectos algorítmicos

El sistema incorpora árboles binarios de búsqueda, listas y otras estructuras eficientes para la gestión y organización de los jugadores y las partidas, con análisis de complejidad temporal para cada operación.
De esta forma, incluso con un gran número de jugadores o manos, las búsquedas, inserciones y listados se mantienen en tiempos óptimos.

✨ Resultado final

El resultado es un juego de póker interactivo, modular y mantenible, que demuestra la aplicación práctica de patrones de diseño, estructuras de datos y principios de arquitectura de software.
Más allá de ser un trabajo académico, representa una experiencia sólida en desarrollo orientado a objetos, organización de sistemas complejos y pensamiento arquitectónico, competencias esenciales para el desarrollo profesional.
