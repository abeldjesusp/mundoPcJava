package mundopc.domain;

public class DispositivoSalida {
    private String marca;
    private String tipoSalida;
    private float precio;
    
    public DispositivoSalida(){}
    public DispositivoSalida(String marca, String tipoSalida, float precio){
        this.marca = marca;
        this.tipoSalida = tipoSalida;
        this.precio = precio;
    }

    public String getMarca() {return marca;}
    public String getTipoSalida() {return tipoSalida;}
    public float getPrecio() {return precio;}

    public void setMarca(String marca) {this.marca = marca;}
    public void setTipoSalida(String tipoSalida) {this.tipoSalida = tipoSalida;}
    public void setPrecio(float precio) {this.precio = precio;}

    @Override
    public String toString() {
        return "Tipo: Dispositivo de salida"
                + "\nMarca : " + marca
                + "\nTipo de salida : " + tipoSalida 
                + "\nPrecio : " + precio + "\n";
    }
}
