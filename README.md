# Julian-Filippini--Pre Entrega BackEnd-Java
Talento Tech: BackEnd Java (Julián Filippini)

**Informe de Proyecto: Sistema de Gestión de Videoclub**

Este proyecto implementa un sistema "muy básico" de gestión de stock de "obras" para un videoclub, permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar), además de alquiler y devolución de obras audiovisuales. Está desarrollado en Java aplicando principios de programación orientada a objetos.

Por Obras entendemos películas y series.

La acción de alquilar es básica y lo que reduce en una unidad el stock de la obra escogida, previemente valida que la misma esté "disponible" para alquiler y que el stock sea mayor que cero.
Por indisponible entendemos una obra que está marcada como DISPONIBLE=FALSE y es para implementar el método Delete del CRUD

Importante, antes de cargar una obra (CLASS), se debe cargar al menos un género (CLASS). Esto es porque el atributo genero de el objeto obra es otro objeto previamente cargado de la clase genero

Importante 1: las obras deben ser referenciadas por su núero de registro (indice de array list) y no por su ID, para saber el ID de registro, previamente listar la base, ya sea de OBRAS o de GENEROS. 

Importante 2: no hay control de excepciones ni muchas validaciones. No tuve tiempo.

---

## Estructura del sistema

### Interfaz `FichaTecnica`
Define el contrato que deben cumplir todas las clases que pueden ser gestionadas por el sistema. Incluye métodos para mostrar información técnica, modificar y consultar stock y disponibilidad.

### Clase abstracta `Obra`
Superclase que representa una obra audiovisual genérica. Implementa `FichaTecnica` y define atributos comunes como `id`, `titulo`, `genero`, `director`, `duracion`, `stock`, y `disponible`. Incluye métodos para alquilar y devolver obras, modificando el stock según disponibilidad.

### Subclases `Pelicula` y `Serie`
Extienden `Obra` y agregan atributos específicos:
- `Pelicula`: `formato`, `anioLanzamiento`
- `Serie`: `temporadas`, `capitulosPorTemporadas`

Ambas sobrescriben el método `mostraFichaTecnica()` para incluir sus datos particulares.

### Clase `Genero`
Representa el género de una obra (comedia, drama, etc.). Implementa `FichaTecnica` para compatibilidad con el CRUD, aunque sus métodos de stock y disponibilidad no tienen lógica funcional.

### Clase genérica `Crud<T>`
Permite realizar operaciones CRUD sobre cualquier clase que implemente `FichaTecnica`. Las operaciones disponibles son:

    CREATE
    - `C`: Crear
    READ 
    - `R`: Leer
    - `L`: Listar
    UPDATE 
    - `U`: Actualizar stock
    - `A`: Alquilar
    - `X`: Devolver
    DELETE
    - `D`: Indisponibilizar

### Clase `Funciones`
Contiene métodos estáticos que implementan la lógica de interacción por consola. Gestiona los menús, la carga de datos, y las operaciones sobre las listas de obras y géneros.

### Clase `Inicio`
Contiene el método `main()` que inicia el programa, crea las listas de datos y gestiona el flujo de navegación entre los menús.

---

## Principios aplicados

- **Herencia**: `Pelicula` y `Serie` heredan de `Obra`.
- **Polimorfismo**: Uso de la interfaz `FichaTecnica` para tratar distintos tipos de objetos de forma uniforme.
- **Encapsulamiento**: Atributos privados con getters/setters.
- **Genéricos**: `Crud<T>` permite reutilizar lógica para distintos tipos de datos.

  ### Diagrama de Clases -> 
  
