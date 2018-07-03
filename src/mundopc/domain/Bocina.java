package mundopc.domain;

public class Bocina extends DispositivoSalida {
    private int idBocina;
    
    public Bocina(int idBocina){
        this.idBocina = idBocina;
    }
    
    public Bocina(int idBocina,String marca, String tipoSalida,float precio){
        super(marca, tipoSalida, precio);
        this.idBocina = idBocina;
    }

    public int getIdBocina() {return idBocina;}
    public void setIdBocina(int idBocina) {this.idBocina = idBocina;}

    @Override
    public String toString() {
        return "Bocina\n" + "ID : " + idBocina + "\n" + super.toString() + "\n";
    }
}
