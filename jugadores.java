
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marina28
 */
public class jugadores {
    RandomAccessFile jugadores;
    
public jugadores(){
    try{
    jugadores=new RandomAccessFile("jugadores.t","rw");
        
    }catch(IOException e){
        
    }
}
    public void crearJugadores(int codigo,String nombre,int dorsal,String posicion,int edad,String nacionalidad)throws IOException{
    jugadores.seek(0);
    
    jugadores.writeInt(codigo);
    jugadores.writeUTF(nombre);
    jugadores.writeInt(dorsal);
    jugadores.writeUTF(posicion);
    jugadores.writeInt(edad);
    jugadores.writeUTF(nacionalidad);
    }
    public void listar()throws IOException{
        jugadores.seek(0);
        int codigo;
        while(jugadores.getFilePointer()<jugadores.length()){
         codigo=jugadores.readInt();
         String nombre=jugadores.readUTF();
         int dorsal=jugadores.readInt();
         String posicion=jugadores.readUTF();
         int edad=jugadores.readInt();
         String nacionalidad=jugadores.readUTF();
         
            System.out.println("Codigo "+codigo+" Nombre del jugadore: "+nombre+" Dorsal: "+dorsal+" Posicion : "+posicion+" Edad: "+edad+" Nacionalidad: "+nacionalidad);    
        
    }
    }
    
}
