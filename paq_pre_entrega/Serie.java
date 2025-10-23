package paq_pre_entrega;

public class Serie extends Obra {
    private int temporadas;
    private int capitulosPorTemporadas;

    // Getters y Setters
    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

    public int getCapitulosPorTemporadas() { return capitulosPorTemporadas; }
    public void setCapitulosPorTemporadas(int capitulosPorTemporadas) { this.capitulosPorTemporadas = capitulosPorTemporadas;  }

    @Override
    public void mostraFichaTecnica() {
        super.mostraFichaTecnica(); // imprime título, género, director, duración
        System.out.println("- Temporadas: " + getTemporadas());
        System.out.println("- Capítulos por temporada: " + getCapitulosPorTemporadas());
    }


}