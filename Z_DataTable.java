/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_DB;

import com.sun.javafx.binding.StringFormatter;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
 
 

/**
 *
 *  
 */
public class Z_DataTable {
   
    Cell []cells;

    public Cell[] getCells() {
        return cells;
    }
Cell[] Wherecells;  Cell[] HaVing;
    String TableName;
    String SQLstatment = "";
    String primaryKeyField ;
ResultSet resultSet ;
    ArrayList<String> prpsStringses = new ArrayList<String>() ;

    public void setWherecells(Cell[] Wherecells) {
        this.Wherecells = Wherecells;
        
    }
   public void setHavingcells(Cell[] H) {
        this.HaVing = H;
        
    }


    public void setCells(Cell[] cells) {
    Wherecells = null;
     
        this.cells = cells;
    }
    
     public void setCells(Cell[] cells,Cell[] Wherecells) {
    
         this.Wherecells = Wherecells;
        this.cells = cells;
    }
      public void setCells(Cell[] cells,Cell primarykey) {
           Wherecells = null;
 
        
          primaryKeyField = primarykey.name ;
        this.cells = cells;
    }
      
void getValufromControl(){
int i = 0  ; 
    while (i < cells.length) {   
        
        if ( cells[i].getControl() == null || cells[i].isIsKey()) {
            i++;
  continue ; 
    
    }else {
        cells[i].setValue(cells[i].getControl().getValue());
     i++;}
}  }    
void setprpString(){
    getValufromControl();
int i = 0 ; 
int c  = cells.length;
prpsStringses.clear();
    while (i<c) {
        if (cells[i].isKey){i ++ ; continue; }
      prpsStringses.add(cells[i].Value+"");
      i++;
    }

}
    public void setTableName(String TableName) {
        this.TableName = TableName;
    }
    
    Z_connection z_connection ;
    
   
          String SQL_Selectfields(){
    String s = "";
  
      if (cells != null){
            int c = cells.length;
    int i = 0;
        while (i< c){
            if (cells[i].isKey){ primaryKeyField =  cells[i].getName();}
            if (i == 0 ){s = cells[i].name; i ++ ; continue;}else  {
                s= s+","+cells[i].name ;} i++;
        }
        
        
        SQLstatment = "Select "+ s+ " From " + TableName ;
          System.out.println(SQLstatment);
        return  SQLstatment;
        
        }else{
                SQLstatment = "Select * From " + TableName ;
    
          return  SQLstatment;
      
        }
    
}
   
          
              String SQL_ALTER_ADD (String AFTERC){
    String s = "";
  String AFTER =  AFTERC;
      if (cells != null){
            int c = cells.length;
    int i = 0;
        while (i< c){
        
            if (i == 0 ){s =" ADD "+ cells[i].name + " " +cells[i].getCellType()+" AFTER "+AFTER ; 
            AFTER=cells[i].getName();
            i ++ ; continue;}else  {
                s= s+"," + " ADD "+ cells[i].name + " " +cells[i].getCellType()+" AFTER "+AFTER ; 
           AFTER=cells[i].getName();
            } i++;
        }
        
   
        SQLstatment = "ALTER TABLE "+  TableName+"  "+s+ "  ;" ;
          System.out.println(SQLstatment);
        return  SQLstatment;
        
        }else{
                SQLstatment = "Null";
    
          return  SQLstatment;
      
        }
    
}
   
              String SQL_ALTER_Drop (){
    String s = "";
 
      if (cells != null){
            int c = cells.length;
    int i = 0;
        while (i< c){
        
            if (i == 0 ){s =" Drop "+ cells[i].name; 
          
            i ++ ; continue;}else  {
                s= s+"," + " Drop "+ cells[i].name ; 
        
            } i++;
        }
        
   
        SQLstatment = "ALTER TABLE "+  TableName+"  "+s+ "  ;" ;
          System.out.println(SQLstatment);
        return  SQLstatment;
        
        }else{
                SQLstatment = "Null";
    
          return  SQLstatment;
      
        }
    
}
              String SQL_ALTER_Change (){
    String s = "";
 
      if (cells != null){
            int c = cells.length;
    int i = 0;
        while (i< c){
        
            if (i == 0 ){s =" Change "+ cells[i].name + " " + cells[i].name + " " +cells[i].getCellType(); 
          
            i ++ ; continue;}else  {
                s= s+"," + " Change "+ cells[i].name + " " + cells[i].name + " " +cells[i].getCellType(); 
        
            } i++;
        }
        
   
        SQLstatment = "ALTER TABLE "+  TableName+"  "+s+ "  ;" ;
          System.out.println(SQLstatment);
        return  SQLstatment;
        
        }else{
                SQLstatment = "Null";
    
          return  SQLstatment;
      
        }
    
}
   
          String SQL_creatTabE (){
    String s = "";
  
      if (cells != null){
            int c = cells.length;
    int i = 0;
        while (i< c){
        if (cells[i].isKey){ primaryKeyField =  cells[i].getName();}
            if (i == 0 ){s = cells[i].name + " " +cells[i].getCellType(); i ++ ; continue;}else  {
                s= s+","+  cells[i].name + " "+cells[i].getCellType();} i++;
        }
        
        String PKS = " , PRIMARY KEY("+primaryKeyField+")";
        SQLstatment = "CREATE TABLE "+  TableName+" ("+s+" "+PKS+" );" ;
          System.out.println(SQLstatment);
        return  SQLstatment;
        
        }else{
                SQLstatment = "Null";
    
          return  SQLstatment;
      
        }
    
}
   
          
          String SQL_Selectfields(String Where){
        String s = "";
      
        if (cells != null){
              int c = cells.length;
        int i = 0;
        while (i< c){
            if (cells[i].isKey){ primaryKeyField =  cells[i].getName();}
            if (i == 0 ){s = cells[i].name; i ++ ; continue;}else  {
                s= s+","+cells[i].name ;} i++;
        }
        
        
        SQLstatment = "Select "+ s+ " From " + TableName + " Where "+ Where;
      System.out.println(SQLstatment);
        return  SQLstatment;
        }else{
                SQLstatment = "Select * From " + TableName + " Where "+ Where;
            System.out.println(SQLstatment);
          return  SQLstatment;
      
        }
    }
String SQL_SelectExp(String Where){
String s = "";
      
        if (cells != null){
              int c = cells.length;
        int i = 0;
        while (i< c){
            if (cells[i].isKey){ primaryKeyField =  cells[i].getName();}
            if (i == 0 ){s = selectsum(cells[i]); i ++ ; continue;}else  {
                s= s+","+ selectsum(cells[i]) ;} i++;
        }
        
        i = 0 ;
        String grob = "";
        while (i< c){
       
            if (grob == "" ){ 
                 if (cells[i].isSelectAsSum()|| cells[i].isSelectAsCount()){i++ ; continue; }else {
                grob = cells[i].name ; i ++ ; continue;}}else  {
                
                  if (cells[i].isSelectAsSum() || cells[i].isSelectAsCount()){i++ ; continue; }else {
             
                grob =  grob+","+ cells[i].name ;} i++;
        }}
        String Groupby ;
         
        if (grob == "" ){
            Groupby = "";
         }else {
          Groupby = "  GROUP BY  "+ grob;}
        
        String Wheres  ;
        if (Where == "" ){
            Wheres = "";
         }else {
          Wheres = " WHERE "+ Where;}
        
        String Havings;
        if (HaVing == null ){Havings="";}else{
       Havings =  SQL_Having();
        }
        
        SQLstatment = "Select "+ s+ " From " + TableName + " " + Wheres +  " "+ Groupby +" " + Havings;
      System.out.println(SQLstatment);
        return  SQLstatment;
        }else{
                SQLstatment = "Select * From " + TableName + " Where ";
            System.out.println(SQLstatment);
          return  SQLstatment;
      
        }
 
}
String  selectsum(Cell cell){
if (cell.isSelectAsSum() ){
return cell.selectsum();
}else{
    if(cell.isSelectAsCount()){
    return cell.selectCount_2c();
    }else {
    return cell.name ;}

}
}
       String SQL_Insertfields(){
     String s = "";
    int c = cells.length;
    int i = 0;
    
    String s1 = "";
    while (i< c){
     
        if (i == 0 ){s = cells[i].name; i ++ ; continue;}else  {
            s= s+","+cells[i].name ;} i++;
    }
    i = 0;
             
          while (i< c){
                  
        if (i == 0 ){s1 = "?"; i ++ ; continue;}else  {
            s1= s1+","+ "?";} i++;
    }
        String stament = "insert into " + TableName + "("+s+") values "+"("+s1+")";
           System.out.println(stament);
        return  stament;
    }
    
    
         String SQL_updatefields(String where){
     String s = "";
    int c = cells.length;
    int i = 0;
    
    String s1 = "";
    
    
    while (i< c){
        if (i == 0 ){
           if (cells[i].isKey){ primaryKeyField =  cells[i].getName();i++; continue;}
   
          s = cells[i].name+"=?"; i ++ ; continue;}else  {
          if (cells[i].isKey){ primaryKeyField =  cells[i].getName();i++; continue;}
   
            s= s+","+cells[i].name +"=?";} i++;
    }
   String swhere ;
             if (where == "") {
               swhere = primaryKeyField +"=?"   ;
              }else {swhere = where ;}
           
         
        String stament = "UPDATE  " + TableName + " set "+s+" where "+ swhere+" ;";
  System.out.println(stament);
        return  stament;
    }
  
      
           String SQL_delete(String where){
     String s = "";
     
   int i = 0; 
    String s1 = "";
   
   String swhere ;
             if (where == "") {
               swhere = primaryKeyField +"=?"   ;
              }else {swhere = where ;}
           
         
        String stament = "delete from "+TableName+" where "+swhere+" ;";
        System.out.println(stament);
    return  stament;
    }
  
        String SQL_deleteAll(){
     String s = "";
    int c = cells.length;
    int i = 0; 
    String s1 = "";
    
     while (i< c){
        if (cells[i].isKey){ primaryKeyField =  cells[i].getName();i++; continue;}
     }
  
         
        String stament = "delete from "+TableName+";";
            System.out.println(stament );
    return  stament;
    }
     
  public    String SQL_Where()
     {
         // حتى لا يتم تكرار المعاملات و لا يتكرر الشرط
    
         int i = 0 ;int c = Wherecells.length;
     String s = "";
         while (i<c) {             
             if (i==0){
                 if (Wherecells[i].isbetween){
                 prpsStringses.add(Wherecells[i].getDates()[0]);
                  prpsStringses.add(Wherecells[i].getDates()[1]);
                  s =  Wherecells[i].getWhereString(); 
                i++;
                  continue;
                 }else{
                     
          s = Wherecells[i].getWhereString();  } 
             }else{
                 if (Wherecells[i].isbetween){
                   prpsStringses.add(cells[i].getDates()[0]);
                  prpsStringses.add(cells[i].getDates()[1]);
                  s =s+Wherecells[i].getWhereString(); 
                i++;
                  continue;
                 }else{
             s=s+Wherecells[i].getAndor()+" "+Wherecells[i].getWhereString();
                 } }
                prpsStringses.add(Wherecells[i].getValue()+"");
             i++;
         }
         System.out.println(s);
     return s;
     }
  
  
  public    String SQL_Having()
     {
         // حتى لا يتم تكرار المعاملات و لا يتكرر الشرط
    
         int i = 0 ;int c = HaVing.length;
     String s = "";
         while (i<c) {             
             if (i==0){
                 
                     
          s = HaVing[i].getHavingString();  } 
             else{
                
             s=s+HaVing[i].getAndor()+" "+Wherecells[i].getWhereString();
                   }
                prpsStringses.add(HaVing[i].getValue()+"");
             i++;
         }
         System.out.println(s);
     return "Having "+ s;
     }
    public Z_DataTable(Z_connection z_connection) {
        this.z_connection = z_connection;
    }
 public Z_DataTable(Z_connection z_connection,String TN) {
        this.z_connection = z_connection;
        TableName=TN;
    }
    public Z_DataTable(String host , String Dbname , String user , String pas) {
  z_connection = new Z_connection(host , Dbname , user, pas);
    
    }
    public  ResultSet Load() throws SQLException{
        try {
      
        Statement st = z_connection.ConnectionStatement();
if (st == null ){st= z_connection.ConnectionStatement(); }
resultSet= st.executeQuery(SQL_Selectfields());
        System.out.println(SQLstatment);
 return resultSet;
         
        } catch (Exception e) {
            System.err.println("Table Load error"+e);
      return null;
        }
    }
  
    
       public  ResultSet Load_Where() throws SQLException, ParseException{
prpsStringses.clear();
           try {
               
         
           Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
         setpreparedstatmentQuery(SQL_Selectfields(SQL_Where()));
    
   return resultSet;
     } catch (Exception e) {
               System.err.println(" Table Load Where"+ e );
     return  null; 
     }
    }
  
       
          public  void  CreatTable_() throws SQLException, ParseException{
 
          
              try {
                      Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
              st.executeUpdate(SQL_creatTabE());
        System.out.println("Table Created");
    
              } catch (Exception e) {
                  System.out.println("Table Creat Error"+e );
              }
     
         
       
  
    }
     
          
              public  void  ADD_Cullome_(Cell AfterCell) throws SQLException, ParseException{
 
          
              try {
                      Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
              st.executeUpdate(SQL_ALTER_ADD(AfterCell.getName()));
        System.out.println("Table ALTerd");
    
              } catch (Exception e) {
                  System.out.println("Table ALter Error"+e );
              }
     
         
       
  
    }
     
      
                      public  void  Change_Cullome_() throws SQLException, ParseException{
 
          
              try {
                      Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
              st.executeUpdate(SQL_ALTER_Change());
        System.out.println("Table ALTerd Change");
    
              } catch (Exception e) {
                  System.out.println("Table ALter Error"+e );
              }
     
         
       
  
    }
         public  void  Drop_Cullome_() throws SQLException, ParseException{
 
          
              try {
                      Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
              st.executeUpdate(SQL_ALTER_Drop());
        System.out.println("Table ALTerd Change");
    
              } catch (Exception e) {
                  System.out.println("Table ALter Error"+e );
              }
     
         
       
  
    }
     
      
                public  void  DropTable_() throws SQLException, ParseException{
 
          
              try {
                      Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
              st.executeUpdate("DROP TABLE " + TableName+ " ;");
        System.out.println("Table Drop");
    
              } catch (Exception e) {
                  System.out.println("Table Drop Error"+e );
              }
     
         
       
  
    }
     
          public  void  CreatTable_(String SQL_Creat) throws SQLException, ParseException{
 
          
              try {
                      Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
              st.executeUpdate(SQL_Creat);
        System.out.println("Table Created");
    
              } catch (Exception e) {
                  System.out.println("Table Creat Error"+e );
              }
     
         
       
  
    }
  
  
         public  ResultSet Load_Expission_Where() {
prpsStringses.clear();
           try {
           Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
if (Wherecells == null ){
 resultSet= st.executeQuery(SQL_SelectExp(""));;
}else{
 setpreparedstatmentQuery(SQL_SelectExp(SQL_Where()));
}
       

   return resultSet;
     } catch (Exception e) {
               System.out.println(" load wher error"+ e );
     return  null; 
     }
    }
  
            public  ResultSet Load_Expission_Where(String sql) {
           try {
           Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
 resultSet= st.executeQuery(sql);;
    
 return resultSet;

}       catch (SQLException ex) {
               System.err.println("Sql Load exprission error"+ex);         
return  null ;
} catch (IOException ex) {
System.err.println(" IO Load exprission error"+ex);         
return null ; 
}          
            }
  
         
    public  void close() throws SQLException{
 //  z_connection.close();
    }
    public  void setvalue(){
        int i = 0 ;
        int c = cells.length ;
        while (i <c) {            
            if (cells[i].getControl() == null){
            i++; continue;
            }else{
            cells[i].setValue(cells[i].getControl().getValue());
            i++;
            }
            
        }
    
    
    
    }
    
    @SuppressWarnings("empty-statement")
    void setpreparedstatment(String Sql) throws SQLException, ParseException, IOException{
    
            
        
        Connection cn =z_connection.Connecte();
         
        
        PreparedStatement prs = cn.prepareStatement(Sql);

        int i = 0 ; int ic = 1 ; int c = prpsStringses.size();
        while (i<c) {
      String s =       prpsStringses.get(i) +"";
      
       
      String types = ce.get(i) .getTypes();
      if (types == ""){
           if (isint(s)){
           prs.setDouble(ic,Integer.parseInt(s));
           
           }else if(isdouble(s)){
               prs.setDouble(ic,Double.parseDouble(s));
            
        }else if (isdate(s)){
java.util.Date m =new Date();
m= new OtherMethods().GetStringVal(s);
java.sql.Date D= new java.sql.Date(m.getTime());
prs.setDate(ic, D);


    }else{
        prs.setString(ic, s);
        }
           //Types 
           }else {
          
             if (types == "int"){
           prs.setDouble(ic,Integer.parseInt(s));
           
           }else if(types == "double"){
               prs.setDouble(ic,Double.parseDouble(s));
            
        }else if (types=="date"){
java.util.Date m =new Date();
m= new OtherMethods().GetStringVal(s);
java.sql.Date D= new java.sql.Date(m.getTime());
prs.setDate(ic, D);


    }else{
        prs.setString(ic, s);
        }
        
            
            
            }
    ic ++ ;
    i++ ;}
        
        prs.execute();
        close();
 
    }
   
    
    
       @SuppressWarnings("empty-statement")
    void setpreparedstatmentQuery(String Sql) throws SQLException, ParseException{
           try {
               
         
        Connection cn =z_connection.Connecte();
         
        
        PreparedStatement prs = cn.prepareStatement(Sql);

        int i = 0 ; int ic = 1 ; int c = prpsStringses.size();
        while (i<c) {
      String s =       prpsStringses.get(i) +"";
            System.err.println("prp"+s);
           if (isint(s)){
           prs.setDouble(ic,Integer.parseInt(s));
           
           }else if(isdouble(s)){
               prs.setDouble(ic,Double.parseDouble(s));
            
        }else if (isdate(s)){
  java.util.Date m =new Date();
m= new OtherMethods().GetStringVal(s);
java.sql.Date D= new java.sql.Date(m.getTime());
prs.setDate(ic, D);


    }else{
        prs.setString(ic, s);
        }
    ic ++ ;
    i++ ;}
       resultSet =  prs.executeQuery();

  } catch (Exception e) {
               System.out.println("setPrp Error"+e );
  }
    }
   
    public  void insert() throws SQLException, ParseException, IOException{
        setprpString();
           ce.clear();
       int i=0 , c ; c= cells.length;
         while (i<c) {             
             ce.add(cells[i]);i++;
         }
        
        setpreparedstatment(SQL_Insertfields());
        System.out.println("inserted");
          }
   
       public  void update(String where ) throws SQLException, ParseException, IOException{
            ce.clear();
       int i=0 , c ; c= cells.length;
         while (i<c) {             
             ce.add(cells[i]);i++;
         }
         i=0 ;c=Wherecells.length;
        while (i<c) {             
             ce.add(Wherecells[i]);i++;
         } 
         
           setpreparedstatment(SQL_updatefields(where));
   System.out.println("updataed");
       }
 
          ArrayList<Cell> ce= new ArrayList<Cell>();
        
           public  void update_id(Cell cell_id ) throws SQLException, ParseException, IOException{
            setprpString();
               System.out.println("key is "+ cell_id.getValue());  
            prpsStringses.add(cell_id.getValue()+"");
    ce.clear();
       int i=0 , c ; c= cells.length;
         while (i<c) {             
             ce.add(cells[i]);i++;
         }
       ce.add(cell_id);
            setpreparedstatment(SQL_updatefields(""));
            System.out.println("updataed");
    }
 
          public  void delete(String where ) throws SQLException, ParseException, IOException{
                           
        
            setpreparedstatment(SQL_delete(where));
  
    }
 
          
             public  void delete_id(Cell key ) throws SQLException, ParseException, IOException{                
          prpsStringses.clear();
                 prpsStringses.add(key.getValue()+"");
            ce.clear();
       ce.add(key);
                 System.out.println("Key is "+ key);
            setpreparedstatment(SQL_delete(""));
             System.out.println("Deleted");
    }
 
      public  void deleteALL() throws SQLException{
          try {
              
        
          Connection cn =z_connection.Connecte();
        SQLstatment = SQL_deleteAll();
              System.out.println(SQLstatment);
        PreparedStatement prs = cn.prepareStatement(SQLstatment);
        prs.execute();
        close();
           
            } catch (Exception e) {
          } 
    }
    
    boolean isnumiric(String val){
    
   NumberFormat formatter = NumberFormat.getInstance();
  ParsePosition pos = new ParsePosition(0);
  formatter.parse(val, pos);
  return val.length() == pos.getIndex();  
    }
     boolean  isdouble(String val){
   try
{
  Double.parseDouble(val);
  return  true;
}
catch(NumberFormatException e)
{
 return  false ;
}
   }
    public   boolean  isint(String val){
   try
{
  Integer.parseInt(val);
  return  true;
}
catch(NumberFormatException e)
{
 return  false ;
}
   }
       boolean isdate(String val){
    DateFormat formatter ; 
Date date ; 

           
           formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(val);
           
            return true;
            // TODO add your handling code here:
        } catch (ParseException ex) {
        return false;
        }
    }
 
  
  
  
       
     
       public  void test() throws SQLException{
       Z_DataShow dataShow = new Z_DataShow(cells) ;
resultSet = Load();
       dataShow.get_Rowslist(resultSet);
 

  int c = dataShow.getCulomntcount();  int r = dataShow.getRowcount(); int ic = 0;int ir =  0;
           while (ir < r ) {
               
          
   
    while (ic<c) {            
        
            System.out.println(dataShow.getvalue(ir, ic ));
    ic++;
        } 
           ir ++ ;
           }
        this.close();
    
    }
    
       
  public  Z_DataShow showDatta(ResultSet res) throws SQLException, ParseException{
       Z_DataShow dataShow = new Z_DataShow(cells) ;
resultSet = res;
       dataShow.get_Rowslist(resultSet);
 

 
        this.close();
    return dataShow;
    }
   
         public  Z_DataFillShow_swing showDattaFill(ResultSet res) throws SQLException, ParseException{
       Z_DataFillShow_swing dataShow = new Z_DataFillShow_swing(cells) ;
resultSet = res;
       dataShow.get_Rowslist(res);
 

 
        this.close();
    return dataShow;
    }
  
   public  int  getcount(ResultSet res) throws SQLException, ParseException{
       Z_DataFillShow_swing dataShow = new Z_DataFillShow_swing(cells) ;
resultSet = res;
       dataShow.get_Rowslist(resultSet);
 

 
        this.close();
    return dataShow.getRowcount();
    }
 
  
  
                public  void test(ResultSet res) throws SQLException, ParseException{
       Z_DataShow dataShow = new Z_DataShow(cells) ;
resultSet = res;
       dataShow.get_Rowslist(resultSet);
 

  int c = dataShow.getCulomntcount();  int r = dataShow.getRowcount(); 
  int ic = 0;int ir =  0;
           while (ir < r ) {
    while (ic<c) {            
        
            System.out.println(dataShow.getvalue(ir, ic ));
    ic++;
        } 
           ir ++ ;
           ic=0;
           }
        this.close();
  
    }
    public  void ComboFill (JComboBox  c , Cell c1) throws SQLException, ParseException{

    Cell [] cell = {c1};
    setCells(cell);
   
    Z_DataFillShow_swing dataFillShow_swing = new Z_DataFillShow_swing(cell);
    dataFillShow_swing.get_Rowslist(Load_Expission_Where()) ;
   dataFillShow_swing.Fillcombo(c, c1);
}

    public void Load_Fillcondeol(ResultSet rs) throws SQLException, ParseException{
       Z_DataFillShow_swing dataFillShow_swing = new Z_DataFillShow_swing(this.cells);
 
    dataFillShow_swing = showDattaFill(rs);
dataFillShow_swing.FillControls();
}
    
    
    public  String    getTotalValue(Cell ce  ) throws SQLException, ParseException{
ce.setSelectAsSum(true); 
Cell[] cells = new Cell[]{ce  };
 
    setCells(cells  );
ResultSet res =   Load_Expission_Where()  ;
   res.absolute(0);
   res.next();
    DecimalFormat f = new DecimalFormat("#0.00");
   return f.format(res.getObject(1));
   
}
    
    
    public Cell[] GetCellsFromTable() throws SQLException, IOException{
        Statement stmt = z_connection.ConnectionStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM "+TableName);
ResultSetMetaData rsmd = rs.getMetaData();
int columnCount = rsmd.getColumnCount();
Cell[] cel = new Cell[columnCount];
int is = 0 ;
// The column count starts from 1
for (int i = 1; i <= columnCount; i++ ) {
  String name = rsmd.getColumnName(i);
    System.out.println("name "+ name);
  Cell cc = new Cell(name);
    cel[is] = cc ;
  // Do stuff with name
}
    
    return  cel ;
    }

    
    public  DefaultTableModel fillShow_swiwing_UnKowonCell() throws SQLException, IOException{
    
            Statement stmt = z_connection.ConnectionStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM "+TableName);
ResultSetMetaData rsmd = rs.getMetaData();
int columnCount = rsmd.getColumnCount();
Cell[] cel = new Cell[columnCount];
int is = 0 ;
// The column count starts from 1
for (int i = 1; i <= columnCount; i++ ) {
  String name = rsmd.getColumnName(i);
    System.out.println("name "+ name);
  Cell cc = new Cell(name);
  cc.setShowInTable(true);
  cc.setCaption(name);
    cel[is] = cc ;is++;
  // Do stuff with 
}
      Z_DataFillShow_swing dataShow = new Z_DataFillShow_swing(cel) ;
 
       dataShow.get_Rowslist(rs);
 

 
        this.close();
    return dataShow.ShowData();
    
    }
    }
    
     


 
