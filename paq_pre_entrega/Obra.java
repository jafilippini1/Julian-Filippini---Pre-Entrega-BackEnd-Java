package paq_pre_entrega;

public abstract class Obra implements FichaTecnica {

    // contador para implementar identificador de cada obra
    private static int contador = 1 ; 
    
    // atributos de las obras
    private int id = contador;
    private String titulo;
    private Genero genero = new Genero();
    private String director;
    private int duracion; 
    private int stock;  // indica la cantidad de copias disponibles
    private boolean disponible; 

    // Constructor de Obra
    public Obra() {
        this.id = contador++;
    }

    // Método abstracto heredado de la interfaz
    public void mostraFichaTecnica() {
        System.out.println("- Id de Obra: " + this.id);
        System.out.println("- Título: " + this.titulo);
        System.out.println("- Genero: " + this.genero.getGenero());
        System.out.println("- Director: " + this.director);
        System.out.println("- Duración: " + this.duracion + " minutos");
        System.out.println("- Stock disponible: " + this.stock);
        System.out.println("- Disponibilidad para alquilar: " + this.disponible);
    }

    public void alquilar() {
        if (!disponible) {
            System.out.println("Obra no disponible.");
        } else if (stock > 0) {
            stock = stock -1;
            System.out.println("Obra alquilada: " + titulo);
        } else {
            System.out.println("Obra no disponible temporalmente (sin stock).");
        }
    }

    public void devolver() {
        stock = stock + 1;
        System.out.println("Obra devuelta: " + titulo);
    }


    // Getters y Setters
    public int getId() { return this.id; }

    public String getTitulo() { return this.titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return this.genero.getGenero(); }
    public void setGenero(String genero) { (this.genero).setGenero(genero); }

    public String getDirector() { return this.director; }
    public void setDirector(String director) { this.director = director; }

    public int getDuracion() { return this.duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public int getStock() { return this.stock; }
    public void setStock(int stock) { this.stock = stock; }

    public boolean getDisponible() { return this.disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

}