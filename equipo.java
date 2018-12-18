
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
public class equipo {
    RandomAccessFile equipo,equi;
    public equipo(){
        try{
            equipo=new RandomAccessFile("equipo.t","rw");
            equi=new RandomAccessFile("equi.t","rw");
            initCodes();
        }catch(IOException e){
            
        }
    }
        
   public long getFinal()throws IOException{
    if(equipo.length()!=0){
     equipo.seek(0);   
    
    
    while(equipo.getFilePointer()< equipo.length()){
        equipo.readUTF();
        equipo.readUTF();
    }
    }
    return equipo.getFilePointer();
}
     private void initCodes()throws IOException{
        if(equi.length()==0){
            equi.writeInt(1);
            equi.writeInt(1);
        }
        
    }
    private int getCode(long offset) throws IOException{
    equi.seek(offset);
    int code=equi.readInt();
    equi.seek(offset);
    equi.writeInt(code+1);
        return code;
    }
     public void crearEquipo(String nombre,String ciudad, int capacidad)throws IOException{
         equipo.seek(0);
    int code=getCode(0);
    equipo.writeInt(code);
    equipo.writeUTF(nombre);
    equipo.writeUTF(ciudad);
    equipo.write(capacidad);
    
     }
     
     public boolean eliminarEquipo(int code)throws IOException{
     equipo.seek(0);
     int codigo;
     while(equipo.getFilePointer()<equipo.length()){
         codigo=equipo.readInt();
      
         if(codigo==code){
         equipo.writeUTF(null);
         equipo.writeUTF(null);
         equipo.writeInt(0);
         }
             
     
     }
     System.out.println("Codigo no existe");
     return false;
     }
    public void listar()throws IOException{
        equipo.seek(0);
        int codigo;
        while(equipo.getFilePointer()<equipo.length()){
         codigo=equipo.readInt();
         String nombre=equipo.readUTF();
         String ciudad=equipo.readUTF();
         int capacidad=equipo.readInt();
         
            System.out.println("Codigo "+codigo+" Nombre del equipo: "+nombre+" Ciudad: "+ciudad+" Capacidad: "+capacidad);    
        
    }
    }
}
