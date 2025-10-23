package paq_pre_entrega;

public class Genero implements FichaTecnica{
    private String genero;

    public void setGenero(String genero) {
        this.genero=genero;
    }

    public String getGenero() {
        return this.genero;
    }
    // Método abstracto heredado de la interfaz
    public void mostraFichaTecnica() {
        System.out.println("- Genero: " + this.genero);
    }

    public void setStock(int stock){};
    public void setDisponible(boolean disponible){};

}
