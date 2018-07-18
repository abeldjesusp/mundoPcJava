package mundopc.test;

import java.util.Scanner;
import java.util.List;
import mundopc.domain.*;
import mundopc.datos.*;

public class MundoPc {
    
    public static void main(String[] args) {        
        try{
            Scanner entrada = new Scanner(System.in);
            int salir,opcion, id = 0;
            boolean validar;
            iDataBase manejarDatos;
            String marca, tipo;
            float precio,tamano;
            Teclado teclado;
            Raton raton;
            Bocina bocina;
            Monitor monitor;
            Computadora computadora;
            Venta venta;
            
            do{
                System.out.println("#####- Mundo Pc -#####\n");                
                System.out.println("1.-Teclados");
                System.out.println("2.-Monitores");
                System.out.println("3.-Ratones");
                System.out.println("4.-Bocinas");
                System.out.println("5.-Computadoras");
                System.out.println("6.-Ventas");
                System.out.println("0.-Salir");
                salir = entrada.nextInt();
                
                switch(salir){
                    case 1:
                        CLS.clearScreen();
                        System.out.println("#####- Mundo Pc -#####\n");
                        System.out.println("-----------------------");
                        System.out.println("***** Teclados *****\n");
                        System.out.println("1.-Agregar teclado");
                        System.out.println("2.-Actualizar teclado");
                        System.out.println("3.-Eliminar teclado");
                        System.out.println("0.-atras");
                        
                        manejarDatos = new DBTeclado();
                        
                        List<Object> teclados = manejarDatos.select();
                        for(Object objTeclado : teclados){
                            System.out.println("---------------------------------");
                            System.out.println(objTeclado);
                            System.out.println("---------------------------------");
                        }
                        validar = true;
                        do{
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    marca = entrada.nextLine();
                                    tipo = entrada.nextLine();
                                    precio = entrada.nextFloat();
                                    teclado = new Teclado(id,marca,tipo,precio);
                                    manejarDatos.insert(teclado);
                                    teclado = null;
                                    validar = false;
                                    break;
                                case 2:
                                    id = entrada.nextInt();
                                    marca = entrada.nextLine();
                                    tipo = entrada.nextLine();
                                    precio = entrada.nextFloat();
                                    teclado = new Teclado(id,marca,tipo,precio);
                                    manejarDatos.update(teclado);
                                    teclado = null;
                                    validar = false;                                    
                                    break;
                                case 3:
                                    id = entrada.nextInt();
                                    teclado = new Teclado(id);
                                    manejarDatos.delete(teclado);
                                    teclado = null;
                                    validar = false;
                                    break;
                                case 0:
                                    validar = true;
                                    break;
                                default :
                                    System.out.println("Opcion no valida.");
                                    validar = false;
                            }
                        }while(validar);
                    break;
                    case 2:
                        CLS.clearScreen();
                        System.out.println("#####- Mundo Pc -#####\n");
                        System.out.println("-----------------------");
                        System.out.println("***** Monitores *****\n");
                        System.out.println("1.-Agregar monitor");
                        System.out.println("2.-Actualizar monitor");
                        System.out.println("3.-Eliminar monitor");
                        System.out.println("0.-atras");
                        
                        manejarDatos = new DBMonitor();
                        
                        List<Object> monitores = manejarDatos.select();
                        for(Object objMonitor : monitores){
                            System.out.println("---------------------------------");
                            System.out.println(objMonitor);
                            System.out.println("---------------------------------");
                        }
                        validar = true;
                        do{
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    marca = entrada.nextLine();
                                    tipo = entrada.nextLine();
                                    precio = entrada.nextFloat();
                                    tamano = entrada.nextFloat();
                                    monitor = new Monitor(id,marca,tipo,tamano,precio);
                                    manejarDatos.insert(monitor);
                                    monitor = null;
                                    validar = false;
                                    break;
                                case 2:
                                    id = entrada.nextInt();
                                     marca = entrada.nextLine();
                                    tipo = entrada.nextLine();
                                    precio = entrada.nextFloat();
                                    tamano = entrada.nextFloat();
                                    monitor = new Monitor(id,marca,tipo,tamano,precio);
                                    manejarDatos.update(monitor);
                                    monitor = null;
                                    validar = false;                                    
                                    break;
                                case 3:
                                    id = entrada.nextInt();
                                    monitor = new Monitor(id);
                                    manejarDatos.delete(monitor);
                                    monitor = null;
                                    validar = false;
                                    break;
                                case 0:
                                    validar = true;
                                    break;
                                default :
                                    System.out.println("Opcion no valida.");
                                    validar = false;
                            }
                        }while(validar);
                    break;
                    case 3:
                        CLS.clearScreen();
                        System.out.println("#####- Mundo Pc -#####\n");
                        System.out.println("-----------------------");
                        System.out.println("***** Ratones *****\n");
                        System.out.println("1.-Agregar raton");
                        System.out.println("2.-Actualizar raton");
                        System.out.println("3.-Eliminar raton");
                        System.out.println("0.-atras");
                        
                        manejarDatos = new DBMonitor();
                        
                        List<Object> ratones = manejarDatos.select();
                        for(Object objRaton : ratones){
                            System.out.println("---------------------------------");
                            System.out.println(objRaton);
                            System.out.println("---------------------------------");
                        }
                        validar = true;
                        do{
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    marca = entrada.nextLine();
                                    tipo = entrada.nextLine();
                                    precio = entrada.nextFloat();
                                    raton = new Raton(id,marca,tipo,precio);
                                    manejarDatos.insert(raton);
                                    raton = null;
                                    validar = false;
                                    break;
                                case 2:
                                    id = entrada.nextInt();
                                    marca = entrada.nextLine();
                                    tipo = entrada.nextLine();
                                    precio = entrada.nextFloat();
                                    raton = new Raton(id,marca,tipo,precio);
                                    manejarDatos.update(raton);
                                    raton = null;
                                    validar = false;
                                    break;
                                case 3:
                                    id = entrada.nextInt();
                                    raton = new Raton(id);
                                    manejarDatos.delete(raton);
                                    raton = null;
                                    validar = false;
                                    break;
                                case 0:
                                    validar = true;
                                    break;
                                default :
                                    System.out.println("Opcion no valida.");
                                    validar = false;
                            }
                        }while(validar);
                    break;
                    case 4:
                        CLS.clearScreen();
                        System.out.println("#####- Mundo Pc -#####\n");
                        System.out.println("-----------------------");
                        System.out.println("***** Bocinas *****\n");
                        System.out.println("1.-Agregar bocina");
                        System.out.println("2.-Actualizar bocina");
                        System.out.println("3.-Eliminar bocina");
                        System.out.println("0.-atras");
                        
                        manejarDatos = new DBBocinas();
                        
                        List<Object> bocinas = manejarDatos.select();
                        for(Object objBocina : bocinas){
                            System.out.println("---------------------------------");
                            System.out.println(objBocina);
                            System.out.println("---------------------------------");
                        }
                        validar = true;
                        do{
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    marca = entrada.nextLine();
                                    tipo = entrada.nextLine();
                                    precio = entrada.nextFloat();
                                    bocina = new Bocina(id,marca,tipo,precio);
                                    manejarDatos.insert(bocina);
                                    bocina = null;
                                    validar = false;
                                    break;
                                case 2:
                                    id = entrada.nextInt();
                                    marca = entrada.nextLine();
                                    tipo = entrada.nextLine();
                                    precio = entrada.nextFloat();
                                    bocina = new Bocina(id,marca,tipo,precio);
                                    manejarDatos.update(bocina);
                                    bocina = null;
                                    validar = false;
                                    break;
                                case 3:
                                    id = entrada.nextInt();
                                    bocina = new Bocina(id);
                                    manejarDatos.delete(bocina);
                                    bocina = null;
                                    validar = false;
                                    break;
                                case 0:
                                    validar = true;
                                    break;
                                default :
                                    System.out.println("Opcion no valida.");
                                    validar = false;
                            }
                        }while(validar);
                    break;
                    case 5:
                        CLS.clearScreen();
                        System.out.println("#####- Mundo Pc -#####\n");
                        System.out.println("-----------------------");
                        System.out.println("***** Computadora *****\n");
                        System.out.println("1.-Armar computadora");
                        System.out.println("2.-Actualizar computadora");
                        System.out.println("3.-Eliminar computadora");
                        System.out.println("0.-atras");
                        
                        manejarDatos = new DBComputadora();
                        
                        List<Object> computadoras = manejarDatos.select();
                        for(Object objComputadora : computadoras){
                            System.out.println("---------------------------------");
                            System.out.println(objComputadora);
                            System.out.println("---------------------------------");
                        }
                        validar = true;
                        do{
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    DBTeclado dbTeclado = new DBTeclado();
                                    List<Object> listTeclado = dbTeclado.select();
                                    System.out.println("Teclados");
                                    for(Object ObjLista : listTeclado){
                                        System.out.println("---------------------------------");
                                        System.out.println(ObjLista);
                                        System.out.println("---------------------------------");
                                    }
                                    DBBocinas dbBocina = new DBBocinas();
                                    List<Object> listBocina = dbBocina.select();
                                    System.out.println("Bocinas");
                                    for(Object ObjLista : listTeclado){
                                        System.out.println("---------------------------------");
                                        System.out.println(ObjLista);
                                        System.out.println("---------------------------------");
                                    }
                                    DBRaton dbRaton = new DBRaton();
                                    List<Object> listRaton = dbRaton.select();
                                    System.out.println("Ratones");
                                    for(Object ObjLista : listRaton){
                                        System.out.println("---------------------------------");
                                        System.out.println(ObjLista);
                                        System.out.println("---------------------------------");
                                    }
                                    DBMonitor dbMonitor = new DBMonitor();
                                    List<Object> listMonitor = dbMonitor.select();
                                    System.out.println("Monitores");
                                    for(Object ObjLista : listMonitor){
                                        System.out.println("---------------------------------");
                                        System.out.println(ObjLista);
                                        System.out.println("---------------------------------");
                                    }
                                    System.out.println("Selecciona un teclado por id");                                    
                                    opcion = entrada.nextInt();
                                    teclado = (Teclado)listTeclado.get(opcion);
                                    
                                    System.out.println("Selecciona un bocina por id");                                    
                                    opcion = entrada.nextInt();
                                    bocina = (Bocina)listBocina.get(opcion);
                                    
                                    System.out.println("Selecciona un raton por id");                                    
                                    opcion = entrada.nextInt();
                                    raton = (Raton)listRaton.get(opcion);
                                    
                                    System.out.println("Selecciona un monitor por id");                                    
                                    opcion = entrada.nextInt();
                                    monitor = (Monitor)listMonitor.get(opcion);
                                    
                                    computadora = new Computadora(id,teclado,bocina,raton,monitor);
                                    manejarDatos.insert(computadora);
                                    computadora = null;
                                    validar = false;
                                    break;
                                case 2:
                                   
                                    validar = false;
                                    break;
                                case 3:
                                   
                                    break;
                                case 0:
                                    validar = true;
                                    break;
                                default :
                                    System.out.println("Opcion no valida.");
                                    validar = false;
                            }
                        }while(validar);
                    break;
                }
            }while(salir == 0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
