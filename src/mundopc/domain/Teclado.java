package mundopc.domain;

public class Teclado extends DispositivoEntrada{
    private int idTeclado;
    
    public Teclado(int idTeclado){
        this.idTeclado = idTeclado;
    }
    
    public Teclado(int idTeclado, String marca, String tipoEntrada, float precio){
        super(marca, tipoEntrada, precio);
        this.idTeclado = idTeclado;
    }

    public int getIdTeclado() {return idTeclado;}
    public void setIdTeclado(int idTeclado) {this.idTeclado = idTeclado;}

    @Override
    public String toString() {
        return "Teclado\n" + "ID : " + idTeclado + "\n" + super.toString() + "\n";
    }  
}
