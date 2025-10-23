package paq_pre_entrega;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Funciones {

    public static Scanner sc = new Scanner(System.in);

    // Método para imprimir en pantalla
    public static void print(String texto) {
        System.err.println(texto);
        return;
    }

    // Método para PROMPT de MENU principal
    // PROMPT 0
    public static int menuPrincipal() {
        print("====================================");
        print("======== Video Club - CRUD =========");
        print("==== BASE de Peliculas y Series ====");
        print("====================================");
        print("1 - CRUD de Generos ");
        print("2 - CRUD de Obras");
        print("3 - Alquiler / Devolucion");
        print("9 - SALIR");
        print("====================================");
        print("Ingrese opción: ");
        
        int opcion = sc.nextInt();
        
        return opcion;
    }

    // Método para PROMPT de CRUD de Generos
    // PROMPT 1
    public static int menuGeneros() {
        print("========= CRUD de Generos ===========");
        print("11 - Carga de Genero ");
        print("12 - Listar Generos");
        print("8  - Menú Principal");
        print("9  - SALIR");
        print("====================================");
        print("Ingrese opción: ");
        
        int opcion = sc.nextInt();
        
        return opcion;
    }

    // Método para PROMPT de CRUD de Obras
    // PROMPT 2
    public static int menuObras() {
        print("========= CRUD de Obras ===========");
        print("20 - Carga de Película ");
        print("21 - Carga de Serie");
        print("22 - Listar Obras");
        print("23 - Detalle de Obra");
        print("24 - Editar Stock de Obra");
        print("25 - Indisponibilizar Obra");
        print("8  - Menú Principal");
        print("9  - SALIR");
        print("====================================");
        print("Ingrese opción: ");
        
        int opcion = sc.nextInt();
        return opcion;
    }

        // Método para PROMPT de MENU principal
    // PROMPT 3
    public static int menuAlquilerDevolucion() {
        print("========Alquiler / Devolución=======");
        print("31 - Listar Obras");
        print("32 - Alquiler de Obra");
        print("33 - Devolucín de obra");
        print("8  - Menú Principal");
        print("9 - SALIR");
        print("====================================");
        print("Ingrese opción: ");
        
        int opcion = sc.nextInt();
        
        return opcion;
    }




    // Método para cargar base de generos de obra. Debe ser llamado así -> Funciones.cargarGenero(baseDeGeneros, crudDeGeneros)
    // PROMPT: 11
    public static int cargarGenero(ArrayList<Genero> baseDeGeneros,  Crud<Genero> crudDeGeneros){

        
        // creo objeto Genero de obra
        Genero genero = new Genero();
        print("Ingrese un genero (comedia/drama/etc): ");
        sc.nextLine(); // limpia el salto de línea residual
        genero.setGenero(sc.nextLine()); // ahora sí espera la entrada del usuario
        
        // Agrego objeto a ArrayList de Generos
        Boolean resultado=crudDeGeneros.crud(baseDeGeneros,"C",-1,genero);

        if (resultado == true) {
            print(" * Carga exitosa *");
        } else {
            print(" * ERROR: Registro no cargado *");
        }
        int opcion = menuGeneros();
        return opcion;
    };




    // Método para listar base de generos de obra. Debe ser llamado así -> Funciones.listarGeneros(baseDeGeneros, crudDeGeneros)
    // PROMPT: 12
    public static int listarGeneros(ArrayList<Genero> baseDeGeneros,  Crud<Genero> crudDeGeneros){

        // creo objeto Genero Dummy de obra
        Genero genero = new Genero();
        Boolean resultado=crudDeGeneros.crud(baseDeGeneros,"L",-1,genero);
        if (resultado) {
            print(" * Orden procesada *");
        } else {
            print(" * ERROR: No es posible listar la base solicitada *");
        }
        int opcion = menuGeneros();
        return opcion;
    };



    // Método de consola para carga de objeto Pelicula. Debe ser llamado así -> Funciones.cargaObjetoPelicula(ArrayList<Obra>, ArrayList<Genero>, Crud<Obra>)
    // PROMPT: 20
    public static int cargaObjetoPelicula(ArrayList<Obra> baseDeObras, ArrayList<Genero> generos, Crud<Obra> crudDeObras){

        Pelicula pelicula = new Pelicula();
        
        print("====================================");
        print("===== Carga de objeto Pelicula =====");
        print("===================================="); 
        print("Ingrese título: ");
        sc.nextLine(); // limpia el salto de línea residual
        pelicula.setTitulo(sc.nextLine());
        print("Ingrese genero: ");
        print(" - Escoja opción ( de 0 a "+ (generos.size()-1) + "): ");
        int indice = 0;
        for (Genero gen : generos ) {
            print(indice++ + " -> " + gen.getGenero() );
        }
        pelicula.setGenero(generos.get(sc.nextInt()).getGenero());
        sc.nextLine(); // para consumir el caracter \n que el sc.nextInt() no consume
        print("Ingrese director: ");
        pelicula.setDirector(sc.nextLine());
        print("Ingrese duración en minutos (entero): ");
        pelicula.setDuracion(sc.nextInt());
        print("Ingrese stock de peliculas (entero): ");
        pelicula.setStock(sc.nextInt());
        sc.nextLine(); // para consumir el caracter \n que el sc.nextInt() no consume
        pelicula.setDisponible(true);
        print("Ingrese formto [DVD, Video, Super8, otros]: ");
        pelicula.setFormato(sc.nextLine());
        print("Ingrese año de lanzamiento (entero): ");
        pelicula.setAnioLanzamiento(sc.nextInt());
        sc.nextLine(); // para consumir el caracter \n que el sc.nextInt() no consume
        print("====================================");
        print("= Ficha técnica de pelicula creada =");
        print("====================================");
        pelicula.mostraFichaTecnica();
        print("====================================");
        

        // Agrego el objeto película a la base de obras
        Boolean resultado=crudDeObras.crud(baseDeObras,"C",1,pelicula);

        if (resultado == true) {
            print(" * Carga exitosa *");
        } else {
            print(" * ERROR: Registro no cargado *");
        }
        int opcion = menuObras();
        return opcion;

    }



    // Método de consola para carga de objeto Serie. Debe ser llamado así -> Funciones.cargaObjetoSerie(ArrayList<Obra>, ArrayList<Genero>, Crud<Obra>)
    // PROMPT: 21
    public static int cargaObjetoSerie(ArrayList<Obra> baseDeObras, ArrayList<Genero> generos, Crud<Obra> crudDeObras){
        Serie serie = new Serie();
        
        print("====================================");
        print("====== Carga de objeto Serie =======");
        print("===================================="); 
        print("Ingrese título: ");
        sc.nextLine(); // limpia el salto de línea residual
        serie.setTitulo(sc.nextLine());
        print("Ingrese genero: ");
        print(" - Escoja opción ( de 0 a "+ (generos.size()-1) + "): ");
        int indice = 0;
        for (Genero gen : generos ) {
            print(indice++ + " -> " + gen.getGenero() );
        }
        serie.setGenero(generos.get(sc.nextInt()).getGenero());
        sc.nextLine(); // para consumir el caracter \n que el sc.nextInt() no consume
        print("Ingrese director: ");
        serie.setDirector(sc.nextLine());
        print("Ingrese duración en minutos (entero): ");
        serie.setDuracion(sc.nextInt());
        print("Ingrese stock de esta serie (entero): ");
        serie.setStock(sc.nextInt());
        serie.setDisponible(true);
        print("Ingrese cantidad de temporadas (entero): ");
        serie.setTemporadas(sc.nextInt());
        print("Ingrese cantidad de capitulos por temporada (entero): ");
        serie.setCapitulosPorTemporadas(sc.nextInt());
        sc.nextLine(); // para consumir el caracter \n que el sc.nextInt() no consume
        print("====================================");
        print("= Ficha técnica de serie creada =");
        print("====================================");
        serie.mostraFichaTecnica();
        print("====================================");
        

        // Agrego el objeto película a la base de obras
        Boolean resultado=crudDeObras.crud(baseDeObras,"C",1,serie);

        if (resultado == true) {
            print(" * Carga exitosa *");
        } else {
            print(" * ERROR: Registro no cargado *");
        }
        int opcion = menuObras();
        return opcion;
    }



    // Método de consola para listar Obras. Debe ser llamado así -> Funciones.cargaObjetoSerie(ArrayList<Obra>, Crud<Obra>)
    // PROMPT: 22
    public static int listarObras(ArrayList<Obra> baseDeObras, Crud<Obra> crudDeObras){

        // creo objeto Obra Dummy
        Pelicula peliDummy = new Pelicula();
        Boolean resultado=crudDeObras.crud(baseDeObras,"L",-1,peliDummy);
        if (resultado) {
            print(" * Orden procesada *");
        } else {
            print(" * ERROR: No es posible listar la base solicitada *");
        }
        int opcion = menuObras();
        return opcion;
    };



    // Método de consola para leer registro de obra particular, seleccionado por indice de base de datos. Debe ser llamado así -> Funciones.leerObra(ArrayList<Obra>, Crud<Obra>)
    // PROMPT: 23
    public static int leerObra(ArrayList<Obra> baseDeObras, Crud<Obra> crudDeObras){
        
        // creo objeto Obra Dummy
        Pelicula peliDummy = new Pelicula();
        print("Ingrese de registro de base de Obras a detallar ( de 0 a "+ (baseDeObras.size()-1) + "): ");
        int arrayIndex = sc.nextInt();
        
        print("Indice de registro: " + arrayIndex );
        Boolean resultado=crudDeObras.crud(baseDeObras,"R",arrayIndex,peliDummy);
        if (resultado) {
            print(" * Orden procesada *");
        } else {
            print(" * ERROR: No es posible listar la base solicitada *");
        }
        int opcion = menuObras();
        return opcion;
    };



    // Método de consola para editar stock de registro de obra particular, seleccionado por indice de base de datos. Debe ser llamado así -> Funciones.editarStockObra(ArrayList<Obra>, Crud<Obra>)
    // PROMPT: 24
    public static int editarStockObra(ArrayList<Obra> baseDeObras, Crud<Obra> crudDeObras){
        
        // creo objeto Obra Dummy
        Pelicula peliDummy = new Pelicula();
        print("Ingrese de registro de base de Obras a editar stock ( de 0 a "+ (baseDeObras.size()-1) + "): ");
        int arrayIndex = sc.nextInt();
        
        Boolean resultado=crudDeObras.crud(baseDeObras,"U",arrayIndex,peliDummy);
        if (resultado) {
            print(" * Orden procesada *");
        } else {
            print(" * ERROR: No es posible listar la base solicitada *");
        }
        int opcion = menuObras();
        return opcion;
    };

    // Método de consola para INDISPONIBILIZAR una obra, simil DELETE, seleccionado por indice de base de datos. Debe ser llamado así -> Funciones.indisponibilizarObra(ArrayList<Obra>, Crud<Obra>)
    // PROMPT: 25
    public static int indisponibilizarObra(ArrayList<Obra> baseDeObras, Crud<Obra> crudDeObras){
        
        // creo objeto Obra Dummy
        Pelicula peliDummy = new Pelicula();
        print("Ingrese de registro de base de Obras indisponibilizar ( de 0 a "+ (baseDeObras.size()-1) + "): ");
        int arrayIndex = sc.nextInt();
        
        Boolean resultado=crudDeObras.crud(baseDeObras,"D",arrayIndex,peliDummy);
        if (resultado) {
            print(" * Orden procesada *");
        } else {
            print(" * ERROR: No es posible listar la base solicitada *");
        }
        int opcion = menuObras();
        return opcion;
    };

    /////////////////SANDBOX/////////////////////////// 
    // Método de consola para alquilar una obra, basicamente resta una unidad en el stockeditar stock, previamente se fija que esté dispoble y que elstock sea mayor que cero. Debe ser llamado así -> Funciones.alquilerObra(ArrayList<Obra>, Crud<Obra>)
    // PROMPT: 32
    public static int alquilerObra(ArrayList<Obra> baseDeObras, Crud<Obra> crudDeObras){
        
        // creo objeto Obra Dummy
        Pelicula peliDummy = new Pelicula();
        print("Ingrese de registro de base de Obras a alquilar ( de 0 a "+ (baseDeObras.size()-1) + "): ");
        int arrayIndex = sc.nextInt();
        
        Boolean resultado=crudDeObras.crud(baseDeObras,"A",arrayIndex,peliDummy);
        if (resultado) {
            print(" * Orden procesada *");
        } else {
            print(" * ERROR: No es posible procesar *");
        }
        int opcion = menuAlquilerDevolucion();
        return opcion;
    };

    // Método de consola para alquilar una obra, basicamente resta una unidad en el stockeditar stock, previamente se fija que esté dispoble y que elstock sea mayor que cero. Debe ser llamado así -> Funciones.alquilerObra(ArrayList<Obra>, Crud<Obra>)
    // PROMPT: 33
    public static int devolverObra(ArrayList<Obra> baseDeObras, Crud<Obra> crudDeObras){
        
        // creo objeto Obra Dummy
        Pelicula peliDummy = new Pelicula();
        print("Ingrese de registro de base de Obras a alquilar ( de 0 a "+ (baseDeObras.size()-1) + "): ");
        int arrayIndex = sc.nextInt();
        
        Boolean resultado=crudDeObras.crud(baseDeObras,"X",arrayIndex,peliDummy);
        if (resultado) {
            print(" * Orden procesada *");
        } else {
            print(" * ERROR: No es posible procesar *");
        }
        int opcion = menuAlquilerDevolucion();
        return opcion;
    };

    // Método de consola para listar Obras. Debe ser llamado así -> Funciones.cargaObjetoSerie(ArrayList<Obra>, Crud<Obra>)
    // PROMPT: 31
    public static int listarObras2(ArrayList<Obra> baseDeObras, Crud<Obra> crudDeObras){

        // creo objeto Obra Dummy
        Pelicula peliDummy = new Pelicula();
        Boolean resultado=crudDeObras.crud(baseDeObras,"L",-1,peliDummy);
        if (resultado) {
            print(" * Orden procesada *");
        } else {
            print(" * ERROR: No es posible listar la base solicitada *");
        }
        int opcion = menuAlquilerDevolucion();
        return opcion;
    };



}
