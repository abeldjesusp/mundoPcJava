package mundopc.domain;

import java.util.Date;

public class Venta {
    private int idVenta;
    private String codigo_venta;
    private Computadora computadora;
    private float totalDeVenta;
    private Date fecha;
    
    public Venta(int idVenta){
        this.idVenta = idVenta;
    }
    
    public Venta(int idVenta, Computadora computadora){
        this(idVenta);
        this.codigo_venta  = "VT-" + (int) ((Math.random() * 99999) + 9999);
        this.computadora = computadora;
        fecha = new Date();
        totalDeVenta = computadora.getPrecioTotal();
    }
    
    public Venta(int idVenta, String codigo_venta, Computadora computadora, float totalVenta, Date fecha){
        this(idVenta,computadora);
        this.codigo_venta  = codigo_venta;
        this.fecha = fecha;
        totalDeVenta = totalVenta;
    }

    public int getIdVenta() {return idVenta;}

    public String getCodigo_venta() {return codigo_venta;}    
    public Computadora getComputadora() {return computadora;}
    public long getFecha() {return fecha.getTime();}
    public float getTotalDeVenta(){return totalDeVenta;}

    public void setIdVenta(int idVenta) {this.idVenta = idVenta;}
    public void setComputadora(Computadora computadora) {this.computadora = computadora;}
    
    @Override
    public String toString() {
        return "Venta\n" 
                + "ID : " + idVenta 
                + "\nComputadora : " + computadora.getCodigo_computadora()
                + "\nFecha : " + fecha + "\n";
    }   
}
