# Buscaminas POO - Versión en Consola

Este proyecto consiste en el desarrollo de una versión para consola del clásico juego **Buscaminas**, programado en **Java**. El desarrollo ha sido realizado de manera grupal en cumplimiento con los requerimientos del examen práctico final para la asignatura de **Programación Orientada a Objetos (POO)** en la **Universidad Politécnica Salesiana**.

---

##  Características del Proyecto

El sistema está diseñado bajo estándares profesionales de desarrollo de software, aplicando los siguientes pilares de la computación:

* **Patrón de Diseño MVC (Modelo-Vista-Controlador):** Separación estricta de responsabilidades entre la lógica interna de juego, la captura de flujos y la interfaz de consola.
* **Programación Orientada a Objetos Avanzada:** Implementación rigurosa de encapsulamiento, herencia, polimorfismo y cohesión modular mediante clases abstractas e interfaces.
* **Robustez y Control de Errores:** Sistema de gestión de errores mediante excepciones nativas y personalizadas para blindar la ejecución ante entradas inválidas o acciones prohibidas.
* **Persistencia Binaria:** Mecanismos de serialización de objetos que permiten guardar y restaurar partidas en disco de manera transparente para el usuario.
* **Calidad de Código y TDD:** Proyecto diseñado bajo principios de código limpio (Clean Code) y validado a través de pruebas unitarias exhaustivas utilizando JUnit 5.

---

##  Arquitectura y Estructura de Paquetes

El código fuente se encuentra organizado dentro del directorio `src` estructurado de la siguiente forma:

* `controller`: Contiene a `JuegoController.java`, la clase cerebro encargada de interceptar las entradas de la vista y despachar las acciones hacia el modelo.
* `model`: El núcleo del negocio. Define las entidades físicas y lógicas: `Juego`, `Tablero`, `Jugador`, `Coordenada`, además de la jerarquía de casillas basada en la clase abstracta `CasillaBase` (`CasillaMina` y `CasillaNormal`).
* `view`: Encargada de la interacción con el usuario mediante flujos limpios de consola (`VistaConsola`, `Menu`, `InicioJuego`).
* `interfaces`: Define los contratos abstractos de comportamiento del sistema como `Descubrible` y `Guardable`.
* `exceptions`: Excepciones personalizadas para reglas de negocio como `CasillaMarcadaException`, `CasillaYaDescubiertaException` y `CoordenadaInvalidaException`.
* `persistence`: Capa de datos encargada del flujo binario a disco operada por `GestorArchivos.java`.
* `util`: Herramientas auxiliares de conversión de datos como `CoordenadaUtils.java`.

---
##  Pruebas Unitarias y TDD (Test-Driven Development)

El proyecto adopta la metodología **TDD**, diseñando y ejecutando pruebas unitarias antes de refactorizar el código fuente final para garantizar la robustez matemática e informática de los algoritmos del Buscaminas.

### Casos de Prueba Implementados (JUnit 5):
* **Validación de Tablero:** Pruebas automatizadas para certificar la correcta inicialización de la matriz de 10x10 y la distribución exacta de las 10 minas sin duplicaciones en coordenadas adyacentes.
* **Control Recursivo (Cascada):** Verificación del método `descubrirVacias(...)` mediante aserciones (`assertEquals`) para constatar que el descubrimiento se detiene estrictamente al topar con una casilla numérica.
* **Pruebas de Robustez (Excepciones):** Escenarios de prueba orientados a forzar errores lógicos para verificar que el sistema dispare y capture con precisión las excepciones personalizadas (`CasillaMarcadaException` y `CasillaYaDescubiertaException`).

### Cómo ejecutar los Tests de forma local:
1. En tu IDE (Eclipse / IntelliJ), haz clic derecho sobre la carpeta raíz `test`.
2. Selecciona la opción **Run As**  **JUnit Test**.
3. Verifica en la pestaña de JUnit que todas las barras se muestren en verde (Green Bar), garantizando que el 100% de los componentes del software pasan las validaciones de control de calidad.

---

##  Instrucciones de Uso y Mecánicas del Juego

Al iniciar la aplicación, se desplegará un menú principal interactivo en la consola con las siguientes opciones:

1. **Iniciar Nueva Partida:** Solicita el nombre del jugador y genera un tablero aleatorio de 10 X 10 con 10 minas ocultas.
2. **Cargar Partida:** Busca el archivo binario local `partida.dat` para reanudar el juego desde el último estado guardado.
3. **Salir:** Cierra el juego de forma segura.

### Durante la partida, podrás ejecutar las siguientes acciones:
* **Descubrir Casilla (Opción 1):** Introduce la coordenada deseada en formato alfanumérico (ej: `A5`). Si la casilla seleccionada contiene una mina, detonará mostrando el mensaje `"BOOM! Has perdido."` y finalizará el juego. Si está libre, mostrará el número de minas circundantes. Si está completamente vacía, se ejecutará automáticamente un algoritmo recursivo en cascada revelando las casillas adyacentes seguras.
* **Marcar Casilla / Poner Bandera (Opción 2):** Permite colocar de forma visual una bandera (`⚑`) sobre coordenadas sospechosas de contener minas. Al marcar la casilla, el sistema la bloquea preventivamente, impidiendo que sea descubierta por error y lanzando un resguardo seguro mediante `CasillaMarcadaException`.
* **Guardar Partida (Opción 3):** Guarda en tiempo real el estado actual del tablero y el jugador en el archivo binario físico para su posterior continuación.

---

##  Requisitos del Sistema e Instalación
* **Java Development Kit (JDK):** Versión 17 o superior.
* **IDE / Entorno:** Eclipse, IntelliJ IDEA, NetBeans o soporte para ejecución desde terminal.
* **Librerías de Pruebas:** JUnit 5 (incluido en el entorno de desarrollo).

---

### Clonación y ejecución local:
1. Clona este repositorio usando tu terminal de Git:
   ```bash
   git clone [https://github.com/oscar2026-iure/BuscaminasPOO.git](https://github.com/oscar2026-iure/BuscaminasPOO.git)

---
##  Metodología de Desarrollo y Colaboración

Para asegurar un desarrollo cohesivo, eficiente y cumplir con el enfoque de código limpio del proyecto, el equipo adoptó una metodología de trabajo basada en dos pilares fundamentales:

1. **Sesiones Temáticas de Programación:** El desarrollo de la arquitectura del software se dividió de forma modular mediante reuniones de trabajo sincrónicas (sesiones temáticas). En cada sesión se abordó un componente específico del patrón MVC:
   * **Sesión 1 (Estructura Base):** Definición de las interfaces (`Descubrible`, `Guardable`) y la jerarquía del paquete `model` (clases abstractas y herencia de casillas).
   * **Sesión 2 (Lógica y Control):** Implementación de los algoritmos recursivos de expansión en el `Tablero` y el flujo de captura de datos en el `JuegoController`.
   * **Sesión 3 (Robustez y Calidad):** Diseño conjunto de los casos de prueba unitarios (JUnit 5), control y simulación de excepciones lógicas, y refactorización de código limpio.

2. **Entorno de Trabajo Compartido (Cloud Document):**
   La redacción, estructuración y consolidación del informe final escrito se llevó a cabo utilizando un archivo compartido en la nube en tiempo real. Esto permitió que todos los integrantes del grupo aportaran de manera simultánea en la documentación de los criterios de diseño, la explicación del diagrama UML y la justificación técnica de la persistencia de datos binaria, garantizando un documento homogéneo y de alta calidad académica.

---

### Integrantes del Grupo:
- Alava Cristina
- Legarda Oscar
- Naranjo Marcelo
- Zuquilanda Jack

