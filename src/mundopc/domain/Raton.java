package mundopc.domain;

public class Raton extends DispositivoEntrada{
    private int idRaton;
    
    public Raton(int idRaton){
        this.idRaton = idRaton;
    }
    
    public Raton(int idRaton, String marca, String tipoEntrada, float precio){
        super(marca,tipoEntrada,precio);
        this.idRaton = idRaton;
    }

    public int getIdRaton() {return idRaton;}
    public void setIdRaton(int idRaton) {this.idRaton = idRaton;}

    @Override
    public String toString() {
        return "Raton\n" + "ID : " + idRaton + "\n" + super.toString() + "\n";
    }
}
