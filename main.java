
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marina28
 */
public class main {
    public static void main(String[] args) throws IOException {
        int capacidad,codigo,dorsal,edad;
        int menu=0;
        String equipo,ciudad,jugador,posicion,nacionalidad;
        equipo e=new equipo();
        jugadores juga=new jugadores();
        Scanner lea=new Scanner(System.in);
        lea.useDelimiter("\n");
        
        do{
            try{
        System.out.println("----------------------M E N U   P R I N C I P A L ---------------------");
        System.out.println("1.Crear Equipo \n2.Crear Jugadores \n3.Eliminar equipo \n4.Reportes");
        System.out.println("Su opcion: ");
        menu=lea.nextInt();
            switch(menu){
                case 1:
                    System.out.println("----------------C r e a r   E q u i p o-------------------------");
                    System.out.println("Ingrese el nombre del equipo: ");
                    equipo=lea.next();
                    System.out.println("Ingrese la ciudad: ");
                    ciudad=lea.next();
                    System.out.println("Ingrese la capacidad del estadio: ");
                    capacidad=lea.nextInt();
                    e.crearEquipo(equipo, ciudad, capacidad);
                    break;
                case 2:
                    System.out.println("----------------C r e a r   J u g a d o r e s----------------------");
                    System.out.println("Ingrese el codigo del jugador: ");
                    codigo=lea.nextInt();
                    System.out.println("Ingrese el nombre del jugador: ");
                    jugador=lea.next();
                    System.out.println("Ingrese el dorsal: ");
                    dorsal=lea.nextInt();
                    System.out.println("Ingrese la posicion: ");
                    posicion=lea.next();
                    System.out.println("Ingrese la edad del jugador: ");
                    edad=lea.nextInt();
                    System.out.println("Ingrese la nacionalidad: ");
                    nacionalidad=lea.next();
                    juga.crearJugadores(codigo, jugador, dorsal, posicion, edad, nacionalidad);
                    System.out.println("Jugador creado");
                    break;
                case 3:
                    System.out.println("-------------------E l i m i n a r   e q u i p o-------------------------------------");
                    System.out.println("Ingrese el codigo del equipo: ");
                    codigo=lea.nextInt();
                    e.eliminarEquipo(codigo);
                    System.out.println("Equipo eliminado");
                    break;
                case 4:
                    System.out.println("---------------R e p o r t e s--------------------------------------");
                    System.out.println("Listando equipos: ");
                  
                    juga.listar();
                    System.out.println("Listando jugadores: ");
                    e.listar();
                    break;
            }
            
            }catch(IOException n){
                
            }
            }while(menu!=3);       
        
        
    }
    
}
