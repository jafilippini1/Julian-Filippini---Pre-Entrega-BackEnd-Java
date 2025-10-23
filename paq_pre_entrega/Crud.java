package paq_pre_entrega;

import java.util.ArrayList;
import java.util.Scanner;

public class Crud<T extends FichaTecnica>{

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

    public boolean crud(ArrayList<T> arrayL, String operacion, int arrayIndex, T dato){

        // operaciones posibles:
        // CREAR:
        // "C" sumar un objeto
        // READ:
        // "L" listar todos los objetos
        // "R" leer un objeto del array list referenciado por el arrayIndex
        // UPDATE:
        // "U" editar un objeto del array list referenciado por el arrayIndex
        // "A" alquilar una obra el array list referenciado por el arrayIndex
        // "X" devolver una obra el array list referenciado por el arrayIndex
        // DELETE
        // "D" borrar un objeto del array list referenciado por el arrayIndex

        // "C" sumar un objeto -> aquí el parámetro arrayIndex carece de sentido
        if (operacion =="C") {
            arrayL.add(dato);
            return true;
        }

        // "L" listar todos los objetos
        if (operacion =="L") {
            clearScreen();
            print("====================================");
            print("============== Listado =============");
            print("===================================="); 
            int indice = 0;
            for (T o :arrayL) {
                print("Indice de registro: " + indice++);
                o.mostraFichaTecnica();
            print("====================================");
            }
            return true;
        }

        // "R" leer un objeto del array list referenciado por el arrayIndex
        clearScreen();
        if (operacion =="R") {
            print("====================================");
            print("============== Detalle =============");
            print("===================================="); 
            arrayL.get(arrayIndex).mostraFichaTecnica();
            return true;
        }

        // "U" editar un objeto del array list referenciado por el arrayIndex, NOTA: por simplicidad solo se permitirá modificar el stock de una obra
        clearScreen();
        if (operacion =="U") {
            print("====================================");
            print("====== Update de stock =============");
            print("====================================");
            print("Ingrese nuevo stock: ");
            int nuevoStock = Funciones.sc.nextInt();
            Funciones.sc.nextLine(); // limpia el buffer
            arrayL.get(arrayIndex).setStock(nuevoStock);
            print("  Modificación realizada!");
            return true;        
        }

        // "D" borrar un objeto del array list referenciado por el arrayIndex (arrayIndex = ID -1 = 0), en realidad se pasa Disponible a FALSE
        if (operacion =="D") {
            print("======================================");
            print("Obra con id = " + (arrayIndex+1) +" -> DISPONIBLE a FALSE");
            print("======================================");
            arrayL.get(arrayIndex).setDisponible(false);
            print("  Modificación realizada!");
            return true; 

        }

        // "A" alquilar una obrareferenciada por el arrayIndex, NOTA: se baja una unidad del stock , la obra está disponible y el sctock es mayor que cero
        clearScreen();
        if (operacion == "A") {

            int currentStock = arrayL.get(arrayIndex).getStock();
            if (arrayL.get(arrayIndex).getDisponible() == true && currentStock >0){
                arrayL.get(arrayIndex).setStock(currentStock - 1);
                print(" - Obra alquilada con éxito");

            } else if (arrayL.get(arrayIndex).getDisponible() == true && currentStock == 0) {
                print(" - No es posible alquilar, stock en cero");
            } else if (arrayL.get(arrayIndex).getDisponible() == false) {
                print(" - Obra no disponible para alquiler");
            }
            return true; 
        }

        // "X" devolver una obra alquileda referenciada por el arrayIndex, NOTA: se suma una unidad del stock.
        clearScreen();
        if (operacion == "X") {

            int currentStock = arrayL.get(arrayIndex).getStock();
            if (arrayL.get(arrayIndex).getDisponible() == true){
                arrayL.get(arrayIndex).setStock(currentStock + 1);
                print(" - Obra retornada con éxito");
            }
            return true; 
        }

        return false;

    }
    
}
