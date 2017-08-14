/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_DB;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author New
 */
public class Z_DataFillShow_swing extends Z_DataShow {

    public Z_DataFillShow_swing(Cell[] cell) {
        super(cell);
        
    }
    public Z_DataShow ReportDataShow;

    public Z_DataShow getReportDataShow() {
        return ReportDataShow;
    }
    
   public DefaultTableModel ShowData(){
        
      DefaultTableModel model = new DefaultTableModel();
      int i = 0 ; int c = cell.length;
        while (i<c) { 
            
            if(cell[i].isShowInTable()){
                
                model.addColumn(cell[i].Caption); i ++ ;
            } else{i++;}
        }
      Vector vr = new Vector();
   
  int  ic = 0 ; int ir = 0 ;
   int r = rowcount;
   
       System.out.println(r+ "");
       while (ir<r) {
           while (ic <c) {  
               if(cell[ic].isShowInTable()){
               vr.add(getvalue(ir,ic));}
           ic++;
           }
            ic= 0 ;
                 model.addRow(vr);
                 vr= new Vector();
                ir++;
               
       }
       ReportDataShow = this;
    return model;
    }
     

  
  public   void Fillcombo(JComboBox c, Cell cell  ){
    c.removeAllItems();
    int i = 0 ;
        while (i<rowcount) {   
            c.addItem(getvalue(i, cell));
            i++;
            
        }
  }
  public void MoveFirist(){
  MoveFirst();
  FillControls();
  }
  
   public void MovePrivious(){
  Moveprivuose();
  FillControls();
  }
   public void Movenext(){
  MoveNext();
  FillControls();
  }
    public void Movelast(){
  MoveLast();
  FillControls();
  }
    public  void Move(int Cr){
        MoveTo(Cr);
        FillControls(); 
    }
  public  void FillControls(){
      
      int i = 0 ; 
      while (i< culomntcount) {   
          if(cell[i].getControl() == null){
     i++;
              continue;
          }
          System.out.println("Load value to control"+ getvalue(i));
 cell[i].getControl().setValue(getvalue(i)); 
          i ++;
          
      }
      i=0;
      
      
  
      
  }
   
}
