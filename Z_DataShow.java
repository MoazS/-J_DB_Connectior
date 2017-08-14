/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_DB;

import com.sun.javafx.scene.control.skin.CellSkinBase;
import java.awt.Cursor;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author New
 */
public class Z_DataShow {
      Cell[] cell ;

    public Cell[] getCell() {
        return cell;
    }

    public void setCell(Cell[] cell) {
        this.cell = cell;
    }
    Row row ;
   public  ArrayList<Row> Rows = new ArrayList<Row>();
    ArrayList<Row> maineRows = new ArrayList<Row>();
String[] [] Table;
ResultSet resultset;
    public Z_DataShow(Cell[] cell) {
        this.cell = cell;
        row = new Row(cell);

    }
    int culomntcount  ; int  rowcount  ;

    public int getCulomntcount() {
        return culomntcount;
    }

    public int getRowcount() {
        return rowcount;
    }
    
    private int getcount(ResultSet resultSet) throws SQLException{
    int count=0 ; 
        while (resultSet.next()) {
            count++;
        }
        rowcount =count ;
        return count;
    }
   private int getculomntcount(){
   
   culomntcount=cell.length;
   return culomntcount;
   }
   
    public String [][] get_Rows(ResultSet rs) throws SQLException{
        int ic = 0 ; int ir = 0 ;
      
        
         resultset = rs;
        rowcount= getcount(resultset);
        culomntcount= getculomntcount();
      

        String [] [] table= new String [culomntcount][rowcount];
        while (resultset.next() ){
            ic = 0 ;
            Row rowval = new Row(cell) ;
            String [] stringval = new String[culomntcount];
while (ic < culomntcount){
    table[ir][ic] =  resultset.getString(cell[ic].name);
stringval[ic] = resultset.getString(cell[ic].name);;
    rowval.setValues(stringval);
ic ++ ;
}
            Rows.add(rowval);
            maineRows.add(rowval);
      
        }

        Table = table;
        return  Table;
    }
    
    public ArrayList<Row> get_Rowslist(ResultSet rs) throws SQLException{
  int ic = 0 ; int ir = 0 ;
      resultset = rs;
        
         
        rowcount= getcount(resultset);
        culomntcount= getculomntcount();
    
 
        String [] [] table= new String [culomntcount][rowcount];
     rs.absolute(0);
        while (rs.next() ){
            ic = 0 ;
            Row rowval = new Row(cell) ;
            String [] stringval = new String[culomntcount];
while (ic < culomntcount){
    stringval[ic] = resultset.getString(cell[ic].name);;
    rowval.setValues(stringval);
ic ++;
}
            Rows.add(rowval);
            maineRows.add(rowval);
      
        }
        return  Rows;

}
  
    
  
    int CurrentRow = 0 ;

    public int getCurrentRow() {
        return CurrentRow;
    }
    
    
   public  int MoveFirst(){
        CurrentRow = 0;
           System.err.println("row no " + CurrentRow);
    return 0;
    }
   public     int MoveNext(){
    CurrentRow ++;
       System.err.println("row no " + CurrentRow);
       if (CurrentRow>rowcount-1){CurrentRow = rowcount-1;}
    return CurrentRow;
    }
     public int Moveprivuose(){
              CurrentRow --;
                if (CurrentRow<0){CurrentRow = 0;}
                 System.err.println("row no " + CurrentRow);
    return CurrentRow;  
    
    }
   public int MoveLast(){
    CurrentRow = rowcount-1;
       System.err.println("row no " + CurrentRow);
    return CurrentRow;
    }
   
   public int MoveTo(int r){
    CurrentRow = r;
    return CurrentRow;
    }  
    public  String getvalue(int r , int c ){
 try{
     
     
        if(c>culomntcount ){c=culomntcount-1;} if(r>rowcount){r=rowcount-1;}
        return   Rows.get(r).values[c];
 }catch(Exception ex ){
 return "Sorry no record";
         
 }   
 }
    public  String getvalue( int c ){
 try{
    int r = CurrentRow;
     
        if(c>culomntcount ){c=culomntcount-1;} 
        if(r>rowcount){r=rowcount-1;}
            if (r<0 ){r=0;}
        return   Rows.get(CurrentRow).values[c];
 }catch(Exception ex ){
     System.err.println("Sorry no record");
     return "";
         
 }   
 }    
    public  String getvalue(int r , Cell cel ){
 try{
        int c = 0 ;
     
     int cs =0 ;
     while (cs < culomntcount) {
               if (cel.name.equals(cell[cs].name)){
     c = cs;
     break;
     }    
         
cs++;     }
     
  
        if(c>culomntcount ){c=culomntcount-1;} if(r>rowcount){r=rowcount-1;}
        return   Rows.get(r).values[c];
 }catch(Exception e ){
     System.err.println("Sorry no record"+e);
 return "";
 }
         
 }   
   public  String getvalue( Cell cel ){
 
        int c = 0 ;
     
     int cs =0 ;
     while (cs < culomntcount) {
               if (cel.name.equals(cell[cs].name)){
     c = cs;
     break;
     }    
         
cs++;     }
     int r = CurrentRow;
  try{
        if(c>culomntcount ){c=culomntcount-1;} 
        if(r>rowcount){r=rowcount-1;}
        if (r<0 ){r=0;}
        return   Rows.get(r).values[c];
 
  }catch(Exception e ){System.out.println(" no Row  loaded"+e);
  return "";} 
 
   }   
 
}
 
   

 
    
    

