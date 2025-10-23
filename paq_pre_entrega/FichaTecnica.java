package paq_pre_entrega;

public interface FichaTecnica {
    void mostraFichaTecnica();
    void setStock(int stock);
    void setDisponible(boolean disponible);

    // Métodos para lectura
    int getStock();
    boolean getDisponible();
    
}
