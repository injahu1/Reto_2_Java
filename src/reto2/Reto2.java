package reto2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reto2 {
private static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        
        mostrarMenu();
        
    }
    
    public static void mostrarMenu(){
        ArrayList <Semoviente> semovientes = new ArrayList();
        ArrayList <Empleado> empleados = new ArrayList();
         int salir=0;
while(salir==0){
        System.out.println("Normandia");
        System.out.println("Estimado usuario por favor seleccione una opción.");
        System.out.println("\n1. Registrar empleado.");
        System.out.println("2. Consultar empleado");
        System.out.println("3. Eliminar empleado.");
        System.out.println("4. Listar empleado.");
        System.out.println("5. Registrar semoviente.");
        System.out.println("6. Consultar semoviente.");
        System.out.println("7. Eliminar semoviente.");
        System.out.println("8. Listar semovientes.");
        System.out.println("9. Salir.\n");
        int opcion;
        
        try{
        opcion=lector.nextInt();
        }
        catch(Exception e)   {
            lector.next();
            opcion=0;
        }
        
        switch(opcion){
            case 1: 
                registrarEmpleado(empleados);
            break;
            case 2: 
                consultarEmpleado(empleados);
            break;
            case 3: 
                eliminarEmpleado(empleados);
            break;
            case 4: 
                 listarEmpleado(empleados);
            break;
            case 5: 
                registrarSemoviente(semovientes, empleados);
            break;
            case 6: 
                consultarSemoviente(semovientes);
            break;
            case 7: 
                eliminarSemoviente(semovientes);
            break;
            case 8: 
                listarSemoviente(semovientes);
            break;
            case 9: 
                System.out.println("\nNormandia");
                System.out.println("¡Muchas gracias por usar nuestro sistema!\n");
                salir=1;
            break;
            default: System.out.println("\nIngrese un número entre (1-5)\n"); 
        }}
    }

    private static void registrarSemoviente(ArrayList<Semoviente> semovientes, ArrayList<Empleado> empleados) {

        int placa=0;
        String raza;
        String color;
        String proposito;
        boolean veriplaca=false;
        boolean verien=false;
        String cadena;
        int encargado;
        int xsave=0;
               while(true){
    System.out.println("Ingrese el número de placa del semoviente: ");
    try{placa = lector.nextInt();
    if(placa>0){break;}
    else{System.out.println("Ingreso incorrecto"); }}
    catch(Exception f){
    System.out.println("Ingreso incorrecto");
    lector.next();
    placa=0;}}
    veriplaca=false;
    for(int x=0;x<semovientes.size();x++){
    if(semovientes.get(x).getIdSemoviente()==placa){
    veriplaca=true;
    }
    }
                 
               if(veriplaca==true){
                     System.out.println("\nNormandia");
                    System.out.println("¡Semoviente ya existe!\n\n\n");
                }
                else{
                    System.out.println("Ingrese la raza del semoviente: "); 
                    raza=lector.next();
                    System.out.println("Ingrese el color del semoviente: "); 
                    color=lector.next();
                    while(true){
                    System.out.println("Ingrese el propósito del semoviente (Carne ó Leche): ");  
                    try{proposito=lector.next(); }
                    catch(Exception g){
                        lector.next();
                        proposito="";}
                    if((proposito.equals("Carne"))||(proposito.equals("carne"))||(proposito.equals("CARNE"))){
                        cadena="Carne";
                        break;}
                    else if (proposito.equals("Leche")||(proposito.equals("leche"))||(proposito.equals("LECHE"))){
                        cadena="Leche";
                        break;}
                    }
                    while(true){
    System.out.println("Ingrese el documento del encargado: ");
    try{encargado = lector.nextInt();
    if(encargado>0){break;}
    else{System.out.println("Ingreso incorrecto"); }}
    catch(Exception g){
    System.out.println("Ingreso incorrecto");
    lector.next();
    encargado=0;}}
                     verien=false;
         for(int x=0;x<empleados.size();x++){             
                 if(empleados.get(x).getDocumento()==encargado){
                 verien=true;
                 xsave=x;
                 break;
                 }
         }
        if(verien==true){
                        Semoviente se=new Semoviente(placa,raza, color, cadena, empleados.get(xsave));
                        semovientes.add(se);
                        System.out.println("\nNormandia");
                        System.out.println("¡Semoviente registrado!\n\n\n");
        }     
        else{System.out.println("\nno existe ese empleado\n");}
                }

    }
    
    private static void consultarSemoviente(ArrayList<Semoviente> semovientes) {
        
        boolean veriplaca=false;
         int placa=0;
         int xguarde=0;
      while(true){
                System.out.println("Ingrese el número de placa del semoviente: "); 
                try{placa = lector.nextInt();
                    if(placa>0){break;}
                    else{System.out.println("Ingreso incorrecto"); }}
                catch(Exception f){ 
                    System.out.println("Ingreso incorrecto");
                    lector.next();
                    placa=0;}}
                
                veriplaca=false;
         for(int x=0;x<semovientes.size();x++){
                 
                 if(semovientes.get(x).getIdSemoviente()==placa){
                 veriplaca=true;
                 xguarde=x;
                 break;
                 }

         //System.out.println(veriplaca  );
         }
             //  System.out.println("v es igual a: "+v); 
        if(veriplaca==true){
                    System.out.println("\nNormandia");
                    System.out.println("Los datos son: \n");
                    System.out.println(semovientes.get(xguarde));
                }
                else{System.out.println("\nNormandia");
                     System.out.println("¡Semoviente no existe!\n\n\n");
                    
                }
   
    }

    private static void listarSemoviente(ArrayList<Semoviente> semovientes) {
        
           int cont=0;
             for(int x=0;x<semovientes.size();x++){
                 cont=cont+1;
                    System.out.println("\nSemoviente "+cont+":\n");
    System.out.println(semovientes.get(x));
  //  System.out.println(i=i+1);
    }
        System.out.println("\n\n");
    }

    private static void eliminarSemoviente(ArrayList<Semoviente> semovientes) {
     int placa=0;
        boolean veriplaca=false;
        int xplaca=0;
     while(true){
                System.out.println("Ingrese el número de placa del semoviente: "); 
                try{placa=lector.nextInt();
                    if(placa>0){break;}
                    else{System.out.println("Ingreso incorrecto"); }}
                catch(Exception f){ 
                    System.out.println("Ingreso incorrecto");
                    lector.next();
                    placa=0;}}
     
     veriplaca=false;
    for(int x=0;x<semovientes.size();x++){
    if(semovientes.get(x).getIdSemoviente()==placa){
    veriplaca=true;
    xplaca=x;
    break;
    }
    }
     
                if(veriplaca==true){
                    semovientes.remove(xplaca);
                    System.out.println("\nNormandia");
                    System.out.println("¡Semoviente eliminado!\n\n\n");
                }
                else{System.out.println("\nNormandia");
                     System.out.println("¡Semoviente no existe!\n\n\n");
                    
                }
        
    }

    private static void registrarEmpleado(ArrayList<Empleado> empleados) {
        int documento=0;
        String nombre;
        String telefono;
        String direccion;

        boolean veriplaca=false; 
        LocalDate fecha=LocalDate.now();
  
               while(true){
    System.out.println("Ingrese el número de documento del empleado: ");
    try{documento = lector.nextInt();
    if(documento>0){break;}
    else{System.out.println("Ingreso incorrecto"); }}
    catch(Exception f){
    System.out.println("Ingreso incorrecto");
    lector.next();
    documento=0;}}
    veriplaca=false;
    for(int x=0;x<empleados.size();x++){
    if(empleados.get(x).getDocumento()==documento){
    veriplaca=true;
    }

    }
                 
               if(veriplaca==true){
                     System.out.println("\nNormandia");
                    System.out.println("¡Empleado ya existe!\n\n\n");
                }
                else{
                    System.out.println("Ingrese el nombre del empleado: "); 
                    nombre=lector.next();
                    System.out.println("Ingrese el telefono del empleado: "); 
                    telefono=lector.next();
                    System.out.println("Ingrese el direccion del empleado: "); 
                    direccion=lector.next();
                    while(true){
                    System.out.println("Ingrese la fecha de contrato del empleado (AAAA-MM-DD): ");  
                    try{fecha=LocalDate.parse(lector.next());
                    break;
                    }
                    catch(Exception g){
                       // lector.next();
                        fecha=LocalDate.now();}

                    }
                    //    LocalDate fe =LocalDate.now();
                        Empleado em=new Empleado(documento,nombre, telefono, direccion, fecha);
                        //Semoviente se=new Semoviente(placa,raza, color, cadena, em);
                        empleados.add(em);
                        System.out.println("\nNormandia");
                        System.out.println("¡Empleado registrado!\n\n\n");
                        }
    }

    private static void consultarEmpleado(ArrayList<Empleado> empleados) {
       boolean veriplaca=false;
         int documento=0;
         int xguarde=0;
      while(true){
                System.out.println("Ingrese el número de documento del empleado: "); 
                try{documento = lector.nextInt();
                    if(documento>0){break;}
                    else{System.out.println("Ingreso incorrecto"); }}
                catch(Exception f){ 
                    System.out.println("Ingreso incorrecto");
                    lector.next();
                    documento=0;}}
                
                veriplaca=false;
         for(int x=0;x<empleados.size();x++){
                 
                 if(empleados.get(x).getDocumento()==documento){
                 veriplaca=true;
                 xguarde=x;
                 break;
                 }

         //System.out.println(veriplaca  );
         }
             //  System.out.println("v es igual a: "+v); 
        if(veriplaca==true){
                    System.out.println("\nNormandia");
                    System.out.println("Los datos del empleado son: \n");
                    System.out.println(empleados.get(xguarde));
                }
                else{System.out.println("\nNormandia");
                     System.out.println("¡Empleado no existe!\n\n\n");
                    
                }
    }

    private static void eliminarEmpleado(ArrayList<Empleado> empleados) {
        int documento=0;
        boolean veriplaca=false;
        int xplaca=0;
        String name;
     while(true){
                System.out.println("Ingrese el número de documento del empleado: "); 
                try{documento=lector.nextInt();
                    if(documento>0){break;}
                    else{System.out.println("Ingreso incorrecto"); }}
                catch(Exception f){ 
                    System.out.println("Ingreso incorrecto");
                    lector.next();
                    documento=0;}}
     
     veriplaca=false;
    for(int x=0;x<empleados.size();x++){
    if(empleados.get(x).getDocumento()==documento){
    veriplaca=true;
    xplaca=x;
    break;
    }
    }
     name=empleados.get(xplaca).getNombre();
                if(veriplaca==true){
                    empleados.remove(xplaca);
                    System.out.println("\nNormandia");
                    System.out.println("Se ha eliminado el empleado: "+name+"\n\n\n");
                }
                else{System.out.println("\nNormandia");
                     System.out.println("¡Empleado no existe!\n\n\n");
                    
                }
    }

    private static void listarEmpleado(ArrayList<Empleado> empleados) {
          int cont=0;
             for(int x=0;x<empleados.size();x++){
                 cont=cont+1;
                    System.out.println("\nEmpleado "+cont+":\n");
    System.out.println(empleados.get(x));
  //  System.out.println(i=i+1);
    }
        System.out.println("\n\n");
    }
    
}

