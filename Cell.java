/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_DB;

/**
 *
 * @author New
 */
public class  Cell{
String name ;

    public void setName(String name) {
        this.name = name;
    }
Object Value ;
String Dates[]= new String[2];
boolean isbetween;
 
boolean  selectAsSum;
boolean selectAsCount; 

    public setAndor getSetaAndors() {
        return setaAndors;
    }

    public boolean isSelectAsCount() {
        return selectAsCount;
    }

    public void setSelectAsCount(boolean selectAsCount) {
        this.selectAsCount = selectAsCount;
    }

    public void setSetaAndors(setAndor setaAndors) {
        this.setaAndors = setaAndors;
    }


String CellType ; 

    public String getCellType() {
        return CellType;
    }
String  Types = "";

    public String getTypes() {
        return Types;
    }

    public void setCellType_VarChar(int length) {
        this.CellType =  "VARCHAR("+length+") CHARACTER SET utf8";
  Types = "String";
    }
    
     public void setCellType_VarChar_NotNull(int length) {
        this.CellType =  "VARCHAR("+length+")  CHARACTER SET utf8 NOT NULL";
   Types = "String";
     }
  public void setCellType_IntPrimareyKey() {
        this.CellType =  "INT(64) NOT NULL AUTO_INCREMENT" ;
      setIsKey(true);
       Types = "int";
  }
  
   public void setCellType_Intetger() {
        this.CellType =  "INTEGER " ;
   Types = "int";
   }
   
    public void setCellType_Intetger_NotNull() {
        this.CellType =  "INTEGER  Not Null" ;
  Types = "int";
    }
    
    
        public void setCellType_Intetger_NotNull(String def ) {
        this.CellType =  "INTEGER  Not Null DEFAULT '"+def+"'" ;
  Types = "int";
    }
    public void setCellType_Double() {
        this.CellType =  "double" ;
    Types = "double";
    }
    
      public void setCellType_Double_NotNull() {
        this.CellType =  "double Not Null" ;
      Types = "double";
     }
      
          public void setCellType_Double_NotNull(String def ) {
        this.CellType =  "double Not Null DEFAULT '"+def+"' " ;
      Types = "double";
      }
     public void setCellType_Dete () {
        this.CellType =  "Datetime " ;
      Types = "date";
     }
     public void setCellType_VarChar(int length,String  DefVal) {
        this.CellType =  "VARCHAR("+length+")  CHARACTER SET utf8  Not Null DEFAULT '"+DefVal+"' ";
      Types = "String";
     }
    public boolean isSelectAsSum() {
        return selectAsSum;
    }

    public void setSelectAsSum(boolean selectAsSum) {
        this.selectAsSum = selectAsSum;
    }


    public boolean isIsbetween() {
        return isbetween;
    }


    public String[] getDates() {
        return Dates;
    }

    public void setDates(String[] Dates) {
        this.Dates = Dates;
    }
     
String WhereString; String Andor ; String HavingString;

    public String getHavingString() {
        return HavingString;
    }
boolean ShowInTable ;
String Caption ;
IControl control;

    public IControl getControl() {
        return control;
    }

    public void setControl(IControl control) {
        this.control = control;
    }

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String Caption) {
        this.Caption = Caption;
    }

    public boolean isShowInTable() {
        return ShowInTable;
    }

    public void setShowInTable(boolean ShowInTable) {
        this.ShowInTable = ShowInTable;
    }
 public void setShowInTable(boolean ShowInTable, String Capt) {
        this.ShowInTable = ShowInTable;
Caption = Capt;   
 }

    public String getWhereString() {
        return WhereString;
    }

    public String getAndor() {
        return Andor;
    }
 public Cell(String name , String Caotion ) {
        this.name = name;
        this.Caption = Caotion;
    }
 
  public Cell(String name) {
        this.name = name;
    }
  
   
  public Cell(String name, boolean iskey) {
      this.setIsKey(iskey);
        this.name = name;
    }
    public Object getValue() {
        return Value;
    }

    public void setValue(Object Value) {
        this.Value = Value;
    }

    public String getName() {
        return name;
       
    }
       boolean  isKey = false;

    public boolean isIsKey() {
        return isKey;
    }

    public void setIsKey(boolean isKey) {
        this.isKey = isKey;
    }
public  setAndor setaAndors;

 
 public  void SetWhere(setwhere setwhere , setAndor setAndor1 , Object Val){
 switch(setAndor1){
     case And :
         Andor = "And";
         break;
     case or:
         Andor="Or";
         break;
 }
     switch (setwhere) {
         case Equl:
             WhereString=  name + " =?";
             break;
             case  Like :
             WhereString=  name + " Like ?";     
             break;
          case betweenNom:
              WhereString=  name + " <=? And "+ name + ">=?";
             break;
          case greater:
              WhereString=  name + " >?";
             break;
          case greaterequal:
              WhereString=  name + " <=?";
             break;
          case losser:
              WhereString=  name + " <?";
             break;
          case losserequal:
              WhereString=  name + " <=?";
             break;
         
             
         default:
              WhereString=  name + " =?";
             throw new AssertionError();
     }
     setValue(Val);
     isbetween = false;
 }
 
 public  void SetHaving(setwhere setwhere , setAndor setAndor1 , Object Val){
 switch(setAndor1){
     case And :
         Andor = "And";
         break;
     case or:
         Andor="Or";
         break;
 }
 
     switch (setwhere) {
        
         case Equl:
             HavingString=  name + " =?";
             break;
             case  Like :
             HavingString=  name + " Like ?";     
             break;
          case betweenNom:
              HavingString=  name + " <=? And "+ name + ">=?";
             break;
          case greater:
              HavingString=  name + " >?";
             break;
          case greaterequal:
              HavingString=  name + " <=?";
             break;
          case losser:
              HavingString=  name + " <?";
             break;
          case losserequal:
              HavingString=  name + " <=?";
             break;
         
          case sumLosserEqule:
              HavingString=  "Sum("+name + ") <=?";
             break;
          case sumgreaterequle:
              HavingString=  "Sum("+name + ") >=?";
             break;
             
              case SumEqul:
              HavingString=  "Sum("+name + ")  =?";
             break;
              case SumLoasser:
              HavingString=  "Sum("+name + ") <?";
             break;
              case Sumgreater:
              HavingString= "Sum("+name + ") >?";
             break;
             
         default:
              HavingString=  name + " =?";
             throw new AssertionError();
             
     } 
 
     setValue(Val);
 }
 
 
 String selectsum(){
  
 return "IF(ISNull(sum("+name+")),0,sum("+name+")) As "+ name;
 }
   String selectCount_2c(){
 return  "  COUNT("+name+")";
 }
  public  void SetWhereDateBetween( setAndor setAndor1 , String Val1 , String Val2){
 switch(setAndor1){
     case And :
         Andor = "And";
         break;
     case or:
         Andor="Or";
         break;
 }
   
 
              WhereString=  name + " Between ? And ?";
        
              
    Dates[0] = Val1 ; 
    Dates[1] = Val2;
    isbetween = true ; 
     
 }
 
}
