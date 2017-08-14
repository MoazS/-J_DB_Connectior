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
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author New
 */
public class Z_connection{
    Connection connection ;
    Statement statment  ;
    
    ArrayList<Z_ImessConnectionEvent> event  = new ArrayList<Z_ImessConnectionEvent>(); 
    String  DATABASEName  ;
    String unicode= "?useUnicode=yes&characterEncoding=UTF-8";

    String Hostname ="localhost";
    String username; String pasward ;

    public String getDATABASEName() {
        return DATABASEName;
    }

    public String getHostname() {
        return Hostname;
    }

    public void setDATABASEName(String DATABASEName) {
        this.DATABASEName = DATABASEName;
    }

    public void setHostname(String Hostname) {
        this.Hostname = Hostname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasward(String pasward) {
        this.pasward = pasward;
    }
    public  void AddConnectionEvent(Z_ImessConnectionEvent evet){
    
    event.add(evet);
    }
void raisEvent(){
    for (Z_ImessConnectionEvent z_ImessConnectionEvent : event) {
        z_ImessConnectionEvent.ConnictionFaild();
    }
}
    public Z_connection() {
    }
    
     public Z_connection(String hst ,String  dbname, String user , String pass ) {
         DATABASEName = dbname;
         Hostname = hst;
         username  = user ;
         pasward = pass ;
    }
        public Z_connection(String  dbname, String user , String pass ) {
         DATABASEName = dbname;
         Hostname = "localhost";
         username  = user ;
         pasward = pass ;
    }
  
    public  Connection Connecte () throws SQLException, IOException{
         try{
            Class.forName("com.mysql.jdbc.Driver"); 
       System.out.println("welcom "); 
     //  Runmysql();
            // provider 
             System.out.println("Database "+DATABASEName);
connection =  DriverManager.getConnection(  
"jdbc:mysql://"+Hostname+"/"+DATABASEName+unicode,username,pasward); 
// database name user nam
//here sonoo is database name, root is username and password  
System.out.println("Conncted");
connected=true ;
return  connection;
}catch(Exception e){ 
    
    System.out.println("error Connection" + e  );
    raisEvent();
close();
Runmysql();
return  null ; } 

    }
    public  void Creat() throws ClassNotFoundException, SQLException{
    
    
        Class.forName("com.mysql.jdbc.Driver");
        
         Connection conn = DriverManager.getConnection("jdbc:mysql://"+Hostname+"/?user="+username+"&password="+pasward);
        System.out.println("Welcom");  
        Statement s = conn.createStatement();
        int Result = s.executeUpdate("CREATE DATABASE "+DATABASEName + ";");
        System.out.println("Data Base created");
        
         s.executeQuery("SET NAMES 'UTF8'");
    s.executeQuery("SET CHARACTER SET 'UTF8'");
        System.out.println("set UTF-8");
     
    }
  
      public  void Drop() throws ClassNotFoundException, SQLException{
    
    
        Class.forName("com.mysql.jdbc.Driver");
        
         Connection conn = DriverManager.getConnection("jdbc:mysql://"+Hostname+"/?user="+username+"&password="+pasward);
        System.out.println("Welcom");
        Statement s = conn.createStatement();
        int Result = s.executeUpdate("DROP  DATABASE "+DATABASEName + ";");
        
          System.out.println("Dropd");
        
    }
  boolean connected = false; 
   
    public  void PasswardChange() throws ClassNotFoundException, SQLException{
    
    
        Class.forName("com.mysql.jdbc.Driver");
        
         Connection conn = DriverManager.getConnection("jdbc:mysql://"+Hostname+"/?user="+username+"&password="+pasward);
        System.out.println("Welcom");
        Statement s = conn.createStatement();
        s.executeLargeUpdate("SET PASSWORD = PASSWORD('"+pasward+"')");
          System.out.println("PASSWORD Changed");
        
    }
  
  
    public  Statement ConnectionStatement () throws SQLException, IOException{
         try{
             if (!connected){
            Class.forName("com.mysql.jdbc.Driver"); 
       System.out.println("welcom ");  
       Runmysql();
            // provider 
connection =  DriverManager.getConnection(  
"jdbc:mysql://"+Hostname+"/"+DATABASEName+unicode,username,pasward); 
// database name user nam
//here sonoo is database name, root is username and password  
System.out.println("Conncted");
connected=true;
             }
statment =   connection.createStatement();
System.out.println("statment created");
         return statment ;
         }catch(Exception e){ System.out.println("error Connection "
                 + "c " + e  );
          raisEvent();
close();
Runmysql();
         return  null ; } 
         
         

    }
     
     void Runmysql() throws IOException{
//Process process = Runtime.getRuntime().exec("C:/xampp/mysql/bin/mysqld.exe");
   
     }
   
public  void close() throws SQLException{
    connection.close();
    connected=false;
}


public  void dirictOpen() throws IOException{
    String con  = "D:\\xamp\\mysql\\bin\\mysqld.exe";
Process process = Runtime.getRuntime().exec(con);
}



public  void dirictOpen(String name ) throws IOException{
    String con  = name ;
Process process = Runtime.getRuntime().exec(con);
}


public  void dirictClosse() throws IOException {
Process process = Runtime.getRuntime().exec("D:\\xamp\\mysql\\bin\\mysqld -u root shutdown");
}

public  void ChangePasward(String pasenter ,  String username ,   String pass){
Change_passowrd e = new Change_passowrd();
e.Passward=pass;
e.userName= username; 
e.passEnter=pasenter;
  try {
         FileOutputStream fileOut =
         new FileOutputStream("Pass.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved ");
      }catch(IOException i) {
         i.printStackTrace();
      }
}
public String getPassward(){
    Change_passowrd e = new Change_passowrd();
    try {
         FileInputStream fileIn = new FileInputStream("Pass.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Change_passowrd) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         return null;
      }catch(ClassNotFoundException c) {
         System.out.println("paswrd error "+ c );
         c.printStackTrace();
         return null;
      }
      
      System.out.println("Deserialized pasward...");
     return e.Passward;

}

    public Z_connection(Connection connection, Statement statment, String DATABASEName, String username, String pasward) {
        this.connection = connection;
        this.statment = statment;
        this.DATABASEName = DATABASEName;
        this.username = username;
        this.pasward = pasward;
    }
    
    
      public Z_connection( String username, String pasward) {
 this.Hostname="localhost";
        this.username = username;
        this.pasward = pasward;
    }

public  ArrayList<String > getDatabaseList() throws ClassNotFoundException, SQLException{
Class.forName("com.mysql.jdbc.Driver");
 
Connection con=DriverManager.getConnection("jdbc:mysql://"+Hostname,username,pasward);
DatabaseMetaData meta = con.getMetaData();
ResultSet res = meta.getCatalogs();

ArrayList<String > dblist = new ArrayList<String>();
while (res.next()) {
   String db=res.getString("TABLE_CAT");
  dblist.add(db);
}
res.close();
return dblist ;
 
} 

 
public  ArrayList<String > getTableList() throws ClassNotFoundException, SQLException{
Class.forName("com.mysql.jdbc.Driver");
 
Connection con=DriverManager.getConnection("jdbc:mysql://"+Hostname+"/"+DATABASEName+unicode,username,pasward);
DatabaseMetaData meta = con.getMetaData();


 String[] types = { "TABLE" };
    ResultSet res = con.getMetaData()
         .getTables(DATABASEName, null, "%", types);
     String tableName = "";

ArrayList<String > dblist = new ArrayList<String>();
while (res.next()) {
   String db=res.getString("TABLE_NAME");
  dblist.add(db);
}
res.close();
return dblist ;
 
} 

 
}
