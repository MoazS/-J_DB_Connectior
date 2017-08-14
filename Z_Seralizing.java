/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_DB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author VGA
 */
public class Z_Seralizing {
    String fileName ; 

    public String getFileName()  {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
   Project_Vraibles Project_Vraibles = new Project_Vraibles();

    public Project_Vraibles getProject_Vraibles() {
        return Project_Vraibles;
    }

    public void setProject_Vraibles(Project_Vraibles Project_Vraibles) {
        this.Project_Vraibles = Project_Vraibles;
    }
   
    public Object   read(){
        Object  e ;
  try {
         FileInputStream fileIn = new FileInputStream(fileName+".zser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e =in.readObject();
         in.close();
         fileIn.close();
         return e ;
      }catch(IOException i) {
         i.printStackTrace();
     return null;
      }catch(ClassNotFoundException c) {
         System.out.println("paswrd error "+ c );
         c.printStackTrace();
 return  null;
      }
    }
    
    
    public void    read_projcetVariable(){
 
  try {
         FileInputStream fileIn = new FileInputStream(fileName+".zser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         setProject_Vraibles((z_DB.Project_Vraibles) in.readObject());
         in.close();
         fileIn.close();
       
      }catch(IOException i) {
      System.err.println("error"+i);
 
      }catch(ClassNotFoundException c) {
         System.out.println("paswrd error "+ c );
         c.printStackTrace();
 
      }
    }
    public void Write(Serializable e ){
     try {
         FileOutputStream fileOut =
         new FileOutputStream(fileName+".zser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved ");
      }catch(IOException i) {
         i.printStackTrace();
      }
    
    } 
}
