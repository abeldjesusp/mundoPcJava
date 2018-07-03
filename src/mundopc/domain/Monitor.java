package mundopc.domain;

public class Monitor extends DispositivoSalida{
    private int idMonitor;
    private float tamano;
     
    public Monitor(int idMonitor){
        this.idMonitor = idMonitor;
    }
    
    public Monitor(int idMonitor, String marca, String tipoSalida,float tamano, float precio){
        super(marca,tipoSalida,precio);
        this.idMonitor = idMonitor;
        this.tamano = tamano;
    }

    public int getIdMonitor() {return idMonitor;}
    public float getTamano() {return tamano;}

    public void setIdMonitor(int idMonitor) {this.idMonitor = idMonitor;}
    public void setTamano(float tamano) {this.tamano = tamano;}

    @Override
    public String toString() {
        return "Monitor\n" + "ID : " + idMonitor + "\n" + super.toString() + "Tamaño : " + tamano + "\n";
    } 
}
