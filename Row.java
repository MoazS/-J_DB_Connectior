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
 public class  Row {
  Cell[] cell ;String[]values ;

    public Cell[] getCell() {
        return cell;
    }



    public Row(Cell[] cell) {

        this.cell = cell;
    }
    public Row() {

    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        if (cell.length == values.length){
        this.values = values;
        }
    }

 }
