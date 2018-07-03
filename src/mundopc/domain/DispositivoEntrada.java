package mundopc.domain;

public class DispositivoEntrada {
    private String marca;
    private String tipoEntrada;
    private float precio;
    
    public DispositivoEntrada(){}
    public DispositivoEntrada(String marca, String tipoEntrada, float precio){
        this.marca = marca;
        this.tipoEntrada = tipoEntrada;
        this.precio = precio;
    }

    public String getMarca() {return marca;}
    public String getTipoEntrada() {return tipoEntrada;}
    public float getPrecio() {return precio;}

    public void setMarca(String marca) {this.marca = marca;}
    public void setTipoEntrada(String tipoEntrada) {this.tipoEntrada = tipoEntrada;}
    public void setPrecio(float precio) {this.precio = precio;}

    @Override
    public String toString() {
        return "Tipo: Dispositivo de entrada"
                + "\nMarca : " + marca
                + "\nTipo de entrada : " + tipoEntrada 
                + "\nPrecio : " + precio + "\n";
    }
}
