package mundopc.test;

import java.util.Scanner;
import java.util.List;
import mundopc.domain.*;
import mundopc.datos.*;

public class MundoPc {
    
    public static void main(String[] args) {        
        try{
            Scanner entrada = new Scanner(System.in);
            int salir,opcion, id = 0, item;
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
                        manejarDatos = new DBTeclado();
                        validar = true;
                        do{
                            CLS.clearScreen();
                            System.out.println("#####- Mundo Pc -#####\n");
                            System.out.println("***** Teclados *****\n");
                            
                            List<Object> teclados = manejarDatos.select();
                            for(Object objTeclado : teclados){
                                System.out.println("---------------------------------");
                                System.out.print(objTeclado);
                            }                        
                        
                            System.out.println("1.-Agregar teclado");
                            System.out.println("2.-Actualizar teclado");
                            System.out.println("3.-Eliminar teclado");
                            System.out.println("0.-atras");
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    entrada.nextLine();
                                    System.out.print("Marca : ");
                                    marca = entrada.nextLine();
                                    System.out.print("Tipo de entrada : ");
                                    tipo = entrada.nextLine();
                                    System.out.print("Precio : ");
                                    precio = entrada.nextFloat();
                                    teclado = new Teclado(id,marca,tipo,precio);
                                    manejarDatos.insert(teclado);
                                    teclado = null;
                                    validar = false;
                                    break;
                                case 2:
                                    System.out.print("ID : ");                                    
                                    id = entrada.nextInt();
                                    entrada.nextLine();
                                    System.out.print("Marca : ");
                                    marca = entrada.nextLine();
                                    System.out.print("Tipo de entrada : ");
                                    tipo = entrada.nextLine();
                                    System.out.print("Precio : ");
                                    precio = entrada.nextFloat();
                                    teclado = new Teclado(id,marca,tipo,precio);
                                    manejarDatos.update(teclado);
                                    teclado = null;
                                    validar = false;                                    
                                    break;
                                case 3:
                                    System.out.print("ID : ");
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
                        }while(!validar);
                    break;
                    case 2:
                        manejarDatos = new DBMonitor();
                        validar = true;
                        do{
                            CLS.clearScreen();
                            System.out.println("#####- Mundo Pc -#####\n");
                            System.out.println("***** Monitores *****\n");
                            
                            List<Object> monitores = manejarDatos.select();
                            for(Object objMonitor : monitores){
                                System.out.println("---------------------------------");
                                System.out.print(objMonitor);
                            }
                            System.out.println("\n1.-Agregar monitor");
                            System.out.println("2.-Actualizar monitor");
                            System.out.println("3.-Eliminar monitor");
                            System.out.println("0.-atras");
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    entrada.nextLine();
                                    System.out.print("Marca : ");
                                    marca = entrada.nextLine();
                                    System.out.print("Tipo de salida : ");
                                    tipo = entrada.nextLine();
                                    System.out.print("Tamaño : ");
                                    tamano = entrada.nextFloat();
                                    System.out.print("Precio : ");
                                    precio = entrada.nextFloat();
                                    monitor = new Monitor(id,marca,tipo,tamano,precio);
                                    manejarDatos.insert(monitor);
                                    monitor = null;
                                    validar = false;
                                    break;
                                case 2:
                                    System.out.print("ID : ");
                                    id = entrada.nextInt();
                                    entrada.nextLine();
                                    System.out.print("Marca : ");
                                    marca = entrada.nextLine();
                                    System.out.print("Tipo de salida : ");
                                    tipo = entrada.nextLine();
                                    System.out.print("Tamaño : ");
                                    tamano = entrada.nextFloat();
                                    System.out.print("Precio : ");
                                    precio = entrada.nextFloat();
                                    monitor = new Monitor(id,marca,tipo,tamano,precio);
                                    manejarDatos.update(monitor);
                                    monitor = null;
                                    validar = false;                                    
                                    break;
                                case 3:
                                    System.out.print("ID : ");
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
                        }while(!validar);
                    break;
                    case 3:                        
                        manejarDatos = new DBRaton();
                        validar = true;
                        do{
                            CLS.clearScreen();
                            System.out.println("#####- Mundo Pc -#####\n");
                            System.out.println("***** Ratones *****\n");

                            List<Object> ratones = manejarDatos.select();
                            for(Object objRaton : ratones){
                                System.out.println("---------------------------------");
                                System.out.print(objRaton);
                            }
                            System.out.println("1.-Agregar raton");
                            System.out.println("2.-Actualizar raton");
                            System.out.println("3.-Eliminar raton");
                            System.out.println("0.-atras");
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    entrada.nextLine();
                                    System.out.print("Marca : ");
                                    marca = entrada.nextLine();
                                    System.out.print("Tipo de entrada : ");
                                    tipo = entrada.nextLine();
                                    System.out.print("Precio : ");
                                    precio = entrada.nextFloat();
                                    raton = new Raton(id,marca,tipo,precio);
                                    manejarDatos.insert(raton);
                                    raton = null;
                                    validar = false;
                                    break;
                                case 2:
                                    System.out.print("ID : ");
                                    id = entrada.nextInt();
                                    entrada.nextLine();
                                    System.out.print("Marca : ");
                                    marca = entrada.nextLine();
                                    System.out.print("Tipo de entrada : ");
                                    tipo = entrada.nextLine();
                                    System.out.print("Precio : ");
                                    precio = entrada.nextFloat();
                                    raton = new Raton(id,marca,tipo,precio);
                                    manejarDatos.update(raton);
                                    raton = null;
                                    validar = false;
                                    break;
                                case 3:
                                    System.out.print("ID : ");
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
                        }while(!validar);
                    break;
                    case 4:
                        manejarDatos = new DBBocinas();
                        validar = true;
                        do{
                            CLS.clearScreen();
                            System.out.println("#####- Mundo Pc -#####\n");
                            System.out.println("***** Bocinas *****\n");

                            List<Object> bocinas = manejarDatos.select();
                            for(Object objBocina : bocinas){
                                System.out.println("---------------------------------");
                                System.out.print(objBocina);
                            }
                            System.out.println("1.-Agregar bocina");
                            System.out.println("2.-Actualizar bocina");
                            System.out.println("3.-Eliminar bocina");
                            System.out.println("0.-atras");
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    entrada.nextLine();
                                    System.out.print("Marca : ");
                                    marca = entrada.nextLine();
                                    System.out.print("Tipo de entrada : ");
                                    tipo = entrada.nextLine();
                                    System.out.print("Precio : ");
                                    precio = entrada.nextFloat();
                                    bocina = new Bocina(id,marca,tipo,precio);
                                    manejarDatos.insert(bocina);
                                    bocina = null;
                                    validar = false;
                                    break;
                                case 2:
                                    System.out.print("ID : ");
                                    id = entrada.nextInt();
                                    entrada.nextLine();
                                    System.out.print("Marca : ");
                                    marca = entrada.nextLine();
                                    System.out.print("Tipo de salida : ");
                                    tipo = entrada.nextLine();
                                    System.out.print("Precio : ");
                                    precio = entrada.nextFloat();
                                    bocina = new Bocina(id,marca,tipo,precio);
                                    manejarDatos.update(bocina);
                                    bocina = null;
                                    validar = false;
                                    break;
                                case 3:
                                    System.out.print("ID : ");
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
                        }while(!validar);
                    break;
                    case 5:
                        manejarDatos = new DBComputadora();
                        validar = true;
                        do{
                            CLS.clearScreen();
                            System.out.println("#####- Mundo Pc -#####\n");
                            System.out.println("***** Computadora *****\n");

                            List<Object> computadoras = manejarDatos.select();
                            for(Object objComputadora : computadoras){
                                System.out.println("---------------------------------");
                                System.out.print(objComputadora);
                            }
                            System.out.println("1.-Armar computadora");
                            System.out.println("2.-Actualizar computadora");
                            System.out.println("3.-Eliminar computadora");
                            System.out.println("0.-atras");
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    DBTeclado dbTeclado = new DBTeclado();
                                    List<Object> listTeclado = dbTeclado.select();
                                    item = 1;
                                    System.out.println("Teclados");
                                    for(Object ObjLista : listTeclado){
                                        System.out.println("---------------------------------");
                                        System.out.println("Opción : " + item++);
                                        System.out.print(ObjLista);
                                    }
                                    
                                    System.out.print("Selecciona un teclado : ");
                                    teclado = (Teclado)listTeclado.get(entrada.nextInt() - 1);
                                    
                                    DBBocinas dbBocina = new DBBocinas();
                                    List<Object> listBocina = dbBocina.select();
                                    item = 1;
                                    System.out.println("Bocinas");
                                    for(Object ObjLista : listBocina){
                                        System.out.println("---------------------------------");
                                        System.out.println("Opción : " + item++);
                                        System.out.print(ObjLista);
                                    }
                                    System.out.print("Selecciona una bocina : ");
                                    bocina = (Bocina)listBocina.get(entrada.nextInt() - 1);
                                    
                                    DBRaton dbRaton = new DBRaton();
                                    List<Object> listRaton = dbRaton.select();
                                    item = 1;
                                    System.out.println("Ratones");
                                    for(Object ObjLista : listRaton){
                                        System.out.println("---------------------------------");
                                        System.out.println("Opción : " + item++);
                                        System.out.print(ObjLista);
                                    }
                                    System.out.print("Selecciona un raton : ");
                                    raton = (Raton)listRaton.get(entrada.nextInt() - 1);
                                    
                                    DBMonitor dbMonitor = new DBMonitor();
                                    List<Object> listMonitor = dbMonitor.select();
                                    item = 1;
                                    System.out.println("Monitores");
                                    for(Object ObjLista : listMonitor){
                                        System.out.println("---------------------------------");
                                        System.out.println("Opción : " + item++);
                                        System.out.print(ObjLista);
                                    }
                                    System.out.print("Selecciona un monitor por id : ");
                                    monitor = (Monitor)listMonitor.get(entrada.nextInt() - 1);
                                    
                                    computadora = new Computadora(id,teclado,bocina,raton,monitor);
                                    manejarDatos.insert(computadora);
                                    computadora = null;
                                    validar = false;
                                    break;
                                case 2:
                                    System.out.print("Selecciona el id de la computadora : ");                                    
                                    id = entrada.nextInt();
                                    
                                    DBTeclado dbTecladoupdate = new DBTeclado();
                                    List<Object> listTecladoupdate = dbTecladoupdate.select();
                                    item = 1;
                                    System.out.println("Teclados");
                                    for(Object ObjLista : listTecladoupdate){
                                        System.out.println("---------------------------------");
                                        System.out.println("Opción : " + item++);
                                        System.out.print(ObjLista);
                                    }
                                    
                                    System.out.print("Selecciona un teclado : ");
                                    teclado = (Teclado)listTecladoupdate.get(entrada.nextInt() - 1);
                                    
                                    DBBocinas dbBocinaupdate = new DBBocinas();
                                    List<Object> listBocinaupdate = dbBocinaupdate.select();
                                    item = 1;
                                    System.out.println("Bocinas");
                                    for(Object ObjLista : listBocinaupdate){
                                        System.out.println("---------------------------------");
                                        System.out.println("Opción : " + item++);
                                        System.out.print(ObjLista);
                                    }
                                    System.out.print("Selecciona una bocina : ");
                                    bocina = (Bocina)listBocinaupdate.get(entrada.nextInt() - 1);
                                    
                                    DBRaton dbRatonupdate = new DBRaton();
                                    List<Object> listRatonupdate = dbRatonupdate.select();
                                    item = 1;
                                    System.out.println("Ratones");
                                    for(Object ObjLista : listRatonupdate){
                                        System.out.println("---------------------------------");
                                        System.out.println("Opción : " + item++);
                                        System.out.print(ObjLista);
                                    }
                                    System.out.print("Selecciona un raton : ");
                                    raton = (Raton)listRatonupdate.get(entrada.nextInt() - 1);
                                    
                                    DBMonitor dbMonitorupdate = new DBMonitor();
                                    List<Object> listMonitorupdate = dbMonitorupdate.select();
                                    item = 1;
                                    System.out.println("Monitores");
                                    for(Object ObjLista : listMonitorupdate){
                                        System.out.println("---------------------------------");
                                        System.out.println("Opción : " + item++);
                                        System.out.print(ObjLista);
                                    }
                                    System.out.print("Selecciona un monitor por id : ");
                                    monitor = (Monitor)listMonitorupdate.get(entrada.nextInt() - 1);
                                    
                                    computadora = new Computadora(id,teclado,bocina,raton,monitor);
                                    manejarDatos.update(computadora);
                                    computadora = null;
                                    validar = false;
                                    break;
                                case 3:
                                    System.out.print("Selecciona el id de la computadora : "); 
                                    id = entrada.nextInt();
                                    computadora = new Computadora(id);
                                    manejarDatos.delete(computadora);
                                    computadora = null;
                                    break;
                                case 0:
                                    validar = true;
                                    break;
                                default :
                                    System.out.println("Opcion no valida.");
                                    validar = false;
                            }
                        }while(!validar);
                    break;
                    case 6:
                        manejarDatos = new DBVentas();
                        validar = true;
                        do{
                            CLS.clearScreen();
                            System.out.println("#####- Mundo Pc -#####\n");
                            System.out.println("***** Ventas *****\n");
                            List<Object> ventas = manejarDatos.select();
                            for(Object objVenta : ventas){
                                System.out.println("---------------------------------");
                                System.out.print(objVenta);
                            }
                            System.out.println("\n1.-Realizar una venta");
                            System.out.println("0.-atras");
                            opcion = entrada.nextInt();
                            switch(opcion){
                                case 1:
                                    DBComputadora dbComp = new DBComputadora();
                                    List<Object> listComp = dbComp.select();
                                    item = 1;
                                    System.out.println("Computadoras");
                                    for(Object ObjLista : listComp){
                                        System.out.println("---------------------------------");
                                        System.out.print(ObjLista);
                                        System.out.println("Opción : " + item++);
                                        
                                    }                                   
                                    System.out.print("\nSelecciona una computadora : ");
                                    computadora = (Computadora)listComp.get(entrada.nextInt() - 1);                                    
                                    
                                    venta = new Venta(id,computadora);
                                    manejarDatos.insert(venta);
                                    venta = null;
                                    validar = false;
                                    break;                             
                                case 0:
                                    validar = true;
                                    break;
                                default :
                                    System.out.println("Opcion no valida.");
                                    validar = false;
                            }
                        }while(!validar);
                    break;
                    case 0:
                    break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }while(salir != 0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
