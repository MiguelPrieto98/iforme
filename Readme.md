https://github.com/MiguelPrieto98/iforme

# Estructura del Proyecto

El proyecto está organizado por la clase main y en dos paquetes principales: `comandos` y `informes` .


---

##  Paquete `comandos`

Contiene la lógica de ejecución de comandos del sistema:

- **Interfaz `Comando`**  
  Define el contrato para todos los comandos: nombre y método de ejecución.

- **Clases concretas**  
  - `ComandoPs`  
  - `ComandoDf`  
  - `ComandoFree`  
  Cada una encapsula un comando específico del sistema.

- **`ComandoBase`**  
  Clase abstracta que centraliza la ejecución usando `Runtime.getRuntime().exec()`.

- **`EjecutadorComandos`**  
  Orquesta la ejecución de todos los comandos y construye el informe.

---

## Paquete `informes`

Encargado de la generación y exportación del informe:

- **Interfaz `Exportador`**  
  Define el método `exportar(Informe)` para convertir el informe a distintos formatos.

- **Clase `Informe`**  
  Contiene una lista de secciones con los resultados de los comandos.

- **Clase `Seccion`**  
  Representa cada bloque de información con título y contenido.

- **Clase `ExportadorMarkdown`**  
  Implementa `Exportador` y genera el informe en formato Markdown (`.md`).

  ##  Clase `App`

La clase `App` es el punto de entrada del programa. Su función principal es coordinar la ejecución de comandos y la generación del informe.

### Responsabilidades:

- Instanciar el `EjecutadorComandos`.
- Ejecutar todos los comandos definidos en el paquete `comandos`.
- Recoger los resultados y construir un objeto `Informe`.
- Exportar el informe usando una implementación de `Exportador` (por defecto, `ExportadorMarkdown`).
- Guardar el resultado en un archivo `.md`.

### Ejemplo de flujo:

```java
EjecutadorComandos ejecutador = new EjecutadorComandos();
Informe informe = ejecutador.ejecutarTodos();
Exportador exportador = new ExportadorMarkdown();
String markdown = exportador.exportar(informe);
// Guardar markdown en archivo
