package mundopc.domain;

import java.util.Date;

public class Venta {
    private int idVenta;
    private Computadora computadora;
    private float totalDeVenta;
    private Date fecha;
    
    public Venta(int idVenta){
        this.idVenta = idVenta;
    }
    
    public Venta(int idVenta, Computadora computadora){
        this(idVenta);
        this.computadora = computadora;
        fecha = new Date();
        totalDeVenta = computadora.getPrecioTotal();
    }

    public int getIdVenta() {return idVenta;}
    public Computadora getComputadora() {return computadora;}
    public Date getFecha() {return fecha;}
    public float getTotalDeVenta(){return totalDeVenta;}

    public void setIdVenta(int idVenta) {this.idVenta = idVenta;}
    public void setComputadora(Computadora computadora) {this.computadora = computadora;}
    
    @Override
    public String toString() {
        return "Venta\n" 
                + "ID : " + idVenta 
                + "Computadora : " + computadora 
                + "\nFecha=" + fecha + "\n";
    }   
}
