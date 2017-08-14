/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_DB;

 import   java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author New
 */
public class Z_Archeef {
   String Mysqlfile;
   String ArchifFile ;

    public Z_Archeef() {
    }

    public Z_Archeef(String Mysqlfile, String ArchifFile) {
        this.Mysqlfile = Mysqlfile;
        this.ArchifFile = ArchifFile;
        Mysql = new File(Mysqlfile);
        archef = new File(ArchifFile);
    }

    public String getMysqlfile() {
        return Mysqlfile;
    }

    public String getArchifFile() {
        return ArchifFile;
    }
  File Mysql  ;
    	File archef ;
 
    public   boolean  Chieckfile(String src )
    {
    	File srcs = new File(src) ;
    	//make sure source exists
    	if(!srcs.exists()){

           System.out.println("Directory does not exist.");
           //just exit
           return  false;

        }else{

          return true;
        }

    	 
    }

    
   public  void CopytoArcheef()  {
     if ( Chieckfile(Mysqlfile)){
       try{  copyFolder(Mysql, archef);}
       catch(Exception e ){
           System.out.println("Coppy error"+ e );
       }
     } 
   }
   public  void Copytomysql(){
   
     if ( Chieckfile(ArchifFile)){
       try{  copyFolder(archef, Mysql);}
       catch(Exception e ){
           System.out.println("Coppy error"+ e );
       }
     } 
   }
    void copyFolder(File src, File dest)
    	throws IOException{

    	if(src.isDirectory()){

    		//if directory not exists, create it
    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory copied from "
                              + src + "  to " + dest);
    		}

    		//list all the directory contents
    		String files[] = src.list();

    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
    		   copyFolder(srcFile,destFile);
    		}

    	}else{
    		//if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest);

    	        byte[] buffer = new byte[1024];

    	        int length;
    	        //copy the file content in bytes
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }

    	        in.close();
    	        out.close();
    	        System.out.println("File copied from " + src + " to " + dest);
    	}
    }
  
 
    
}
