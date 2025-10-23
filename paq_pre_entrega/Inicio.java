package paq_pre_entrega;

import java.util.ArrayList;

public class Inicio {

    // Método para imprimir en pantalla
    public void print(String texto) {
        System.err.println(texto);
        return;
    }

    // Método para limpieza de pantalla
    public void clearScreen() { 
        for (int i = 0; i < 0; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) {

         // Array lists para bases de datos
        ArrayList<Obra> baseDeObras = new ArrayList<>();
        ArrayList<Genero> baseDeGeneros = new ArrayList<>();
    
        // CRUDs genericos
        Crud<Obra> crudDeObras = new Crud<>();
        Crud<Genero> crudDeGeneros = new Crud<>();

        int opcion = Funciones.menuPrincipal();
        
        while (opcion != 9) {

            switch(opcion){

                case 1:
                    opcion=Funciones.menuGeneros();
                    break;

                case 2:
                    opcion=Funciones.menuObras();
                    break;

                case 3:
                    opcion=Funciones.menuAlquilerDevolucion();
                    break;

                case 8:
                    opcion=Funciones.menuPrincipal();
                    break;

                case 11:
                    opcion=Funciones.cargarGenero(baseDeGeneros, crudDeGeneros);
                    break;

                case 12:
                    opcion=Funciones.listarGeneros(baseDeGeneros, crudDeGeneros);
                    break;

                case 20:
                    opcion=Funciones.cargaObjetoPelicula(baseDeObras, baseDeGeneros, crudDeObras);
                    break;

                case 21:
                    opcion=Funciones.cargaObjetoSerie(baseDeObras, baseDeGeneros, crudDeObras);
                    break;

                case 22:
                    opcion=Funciones.listarObras(baseDeObras, crudDeObras);
                    break;

                case 23:
                    opcion=Funciones.leerObra(baseDeObras, crudDeObras);
                    break; 

                case 24:
                    opcion=Funciones.editarStockObra(baseDeObras, crudDeObras);
                    break; 

                case 25:
                    opcion=Funciones.indisponibilizarObra(baseDeObras, crudDeObras);
                    break;

                case 31:
                    opcion=Funciones.listarObras2(baseDeObras, crudDeObras);
                    break;

                case 32:
                    opcion=Funciones.alquilerObra(baseDeObras, crudDeObras);
                    break;

                case 33:
                    opcion=Funciones.devolverObra(baseDeObras, crudDeObras);
                    break;

            }

        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("****** Sistema cerrado ******");
        System.out.println("  -- HASTA LA VISTA BABY! --");
        System.out.println("");
        System.out.println("");

        
    }
}    



