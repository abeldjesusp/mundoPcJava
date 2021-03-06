package mundopc.domain;

public class Computadora {
    private int idComputadora;
    private String codigo_computadora;
    private Teclado teclado;
    private Bocina bocina;
    private Raton raton;
    private Monitor monitor;
    private float precioTotal;
    
    
    //Overload constructors
    public Computadora(){}
    public Computadora(int idComputadora){
        this.idComputadora = idComputadora;
        this.codigo_computadora = "CP-" + (int) ((Math.random() * 99999) + 9999);
    }    
    public Computadora(int idComputadora, Teclado teclado){
        this(idComputadora);
        this.teclado = teclado;
        precioTotal = calcularPrecioTotal(teclado);
    }    
    public Computadora(int idComputadora, Teclado teclado, Bocina bocina){
        this(idComputadora, teclado);
        this.bocina = bocina;
        precioTotal = calcularPrecioTotal(teclado,bocina);
    }
    public Computadora(int idComputadora,Teclado teclado,Bocina bocina,Raton raton){        
        this(idComputadora, teclado, bocina);
        this.raton = raton;
        precioTotal = calcularPrecioTotal(teclado,bocina,raton);
    }
    public Computadora(int idComputadora,Teclado teclado,Bocina bocina,Raton raton,Monitor monitor){        
        this(idComputadora, teclado, bocina, raton);
        this.monitor = monitor;
        precioTotal = calcularPrecioTotal(teclado,bocina,raton,monitor);
    }
    
    public Computadora(
            int idComputadora,
            String codigo_computadora,
            Teclado teclado,
            Bocina bocina,
            Raton raton,
            Monitor monitor,
            float precioTotal){        
        this(idComputadora, teclado, bocina, raton,monitor);
        this.codigo_computadora = codigo_computadora;
        this.precioTotal = precioTotal;
    }
    
    //end constructors
    
    //Methods Getter
    public int getIdComputadora() {return idComputadora;}
    public Teclado getTeclado() {return teclado;}
    public Bocina getBocina() {return bocina;}
    public Raton getRaton() {return raton;}
    public Monitor getMonitor() {return monitor;}
    public String getCodigo_computadora() {return codigo_computadora;}    
    public float getPrecioTotal() {return precioTotal;}
    //end Getter

    //Methods Setters
    public void setIdComputadora(int idComputadora) {this.idComputadora = idComputadora;}
    public void setTeclado(Teclado teclado) {this.teclado = teclado;}
    public void setBocina(Bocina bocina) {this.bocina = bocina;}
    public void setRaton(Raton raton) {this.raton = raton;}
    public void setMonitor(Monitor monitor) {this.monitor = monitor;}
    //end setters
    
    //Overload method calcularPrecioTotal    
    private float calcularPrecioTotal(Teclado teclado){
        return teclado.getPrecio();
    }
    
    private float calcularPrecioTotal(Teclado teclado, Bocina bocina){
        return this.calcularPrecioTotal(teclado) + bocina.getPrecio();
    }
    
    private float calcularPrecioTotal(Teclado teclado,Bocina bocina,Raton raton){
        return this.calcularPrecioTotal(teclado, bocina) + raton.getPrecio();
    }
    
    private float calcularPrecioTotal(Teclado teclado,Bocina bocina,Raton raton,Monitor monitor){
        return this.calcularPrecioTotal(teclado, bocina, raton) + monitor.getPrecio();
    }
    //end calcularPrecioTotal

    @Override
    public String toString() {
        return "Computadora\n" 
                + "ID : " + idComputadora 
                + "\nCodigo : " + codigo_computadora
                + "\nTeclado : " + teclado.getMarca()
                + "\nBocina : " + bocina.getMarca()
                + "\nRaton : " + raton.getMarca()
                + "\nMonitor : " + monitor.getMarca()
                + "\nPrecio : " + precioTotal + "\n\n";
    } 
}
