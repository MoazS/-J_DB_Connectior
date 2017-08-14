/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_DB;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

 

/**
 *
 * @author aman
 */
public class OtherMethods {
    
    public  Date GetStringVal(String val) throws ParseException{
   String str_date=val;
DateFormat formatter ; 
Date date ; 
   formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(str_date);
        return date;
            
            // TODO add your handling code here:
        } catch (ParseException ex) {
            
       return null ;
        }
        
    }
    public String ChangeFrmat(Date d) throws ParseException{
      return    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
      
    }
    
    public int getage(Date parth){
       int pd = parth.getYear();
       int nowd= new Date().getYear();
       
return nowd-pd ;      
    }
  
       public Date AddDate_Day( Date now , int  i ){
    
    Date d1 = now ;   
Date d2 = new Date(d1.getTime() + i* (1000 * 60 * 60 * 24));
 return d2;   
    }
   
    public  void JTableformat(JTable  t ){
       Font ff  = new Font("Vernada", Font.BOLD, 15);

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
    //    DefaultTableCellHeaderRenderer  dtchr = new DefaultTableCellHeaderRenderer();
    //    dtchr.setBackground(Color.GRAY);
     //   dtchr.setForeground(Color.red);
        dtcr.setBackground(Color.decode("#f8fcc7"));
        dtcr.setForeground(Color.decode("#072659"));
        dtcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
 //dtchr.setFont(ff);
 t.setFont(new Font("Vernada", Font.BOLD, 20));
    t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    t.setRowHeight(ff.getSize()+5);
     
// t.getTableHeader().setDefaultRenderer(dtchr);
    t.setDefaultRenderer(Object.class, dtcr);
    t.setShowGrid(true);
    t.setGridColor(Color.gray);
    }
    public  void JTableformatReport(JTable  t ){
       Font ff  = new Font("Vernada", Font.BOLD, 18);

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
    //    DefaultTableCellHeaderRenderer  dtchr = new DefaultTableCellHeaderRenderer();
    //    dtchr.setBackground(Color.GRAY);
     //   dtchr.setForeground(Color.red);
        dtcr.setBackground(Color.decode("#56cbf0"));
        dtcr.setForeground(Color.decode("#072659"));
        dtcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
 //dtchr.setFont(ff);
 t.setFont(new Font("Vernada", Font.BOLD, 15));
    t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    t.setRowHeight(ff.getSize()+5);
     
// t.getTableHeader().setDefaultRenderer(dtchr);
    t.setDefaultRenderer(Object.class, dtcr);
    t.setShowGrid(true);
    t.setGridColor(Color.gray);
    }
   public  void JTableformatWait(JTable  t ){
       Font ff  = new Font("Vernada", Font.BOLD, 24);

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
    //    DefaultTableCellHeaderRenderer  dtchr = new DefaultTableCellHeaderRenderer();
     //   dtchr.setBackground(Color.GRAY);
     //   dtchr.setForeground(Color.red);
        dtcr.setBackground(Color.decode("#f8fcc7"));
        dtcr.setForeground(Color.decode("#072659"));
        dtcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
 //dtchr.setFont(ff);
 t.setFont(new Font("Vernada", Font.BOLD, 15));
    t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    t.setRowHeight(ff.getSize()+5);
     
// t.getTableHeader().setDefaultRenderer(dtchr);
    t.setDefaultRenderer(Object.class, dtcr);
    t.setShowGrid(true);
    t.setGridColor(Color.gray);
    }
 public void setNewItimInCompo(JComboBox cm , String tiltel){
  String test1= JOptionPane.showInputDialog(tiltel);
cm.addItem(test1);
cm.getSelectedItem();
 
 }    
 
 public void Close_frm(JFrame frm){
  Timer timer = new Timer(20, new ActionListener() {
           float  i = (float) 0.05;
            float   io = (float) 1.0 ;

            @Override
                 public void actionPerformed(ActionEvent e) {
                   io =  io-i;
                frm.setOpacity( io) ;
             
                 if (io<.05){;
               System.exit(0);
                
                }
                 }
             });
  
     timer.start();

 }
 
 
 
  public void Open_frm(JFrame frm){
  Timer timer = new Timer(20, new ActionListener() {
           float  i = (float) 0.05;
            float   io = (float) 0.05 ;

            @Override
                 public void actionPerformed(ActionEvent e) {
                   io =  io+i;
                frm.setOpacity( io) ;
             
                 if (io>0.95){
               frm.setOpacity((float) 0.99) ;
                
                }
                 }
             });
  
     timer.start();

 }
}
