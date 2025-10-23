package paq_pre_entrega;

public class Pelicula extends Obra {
    private String formato;
    private int anioLanzamiento;

    // Getters y Setters
    public String getFormato() { return this.formato; }
    public void setFormato(String formato) { this.formato = formato; }

    public int getAnioLanzamiento() { return this.anioLanzamiento; }
    public void setAnioLanzamiento(int anioLanzamiento) { this.anioLanzamiento = anioLanzamiento;  }

    @Override
    public void mostraFichaTecnica() {
        super.mostraFichaTecnica(); // imprime título, género, director, duración
        System.out.println("- Formato: " + getFormato());
        System.out.println("- Año de lanzamiento: " + getAnioLanzamiento());
    }   

}