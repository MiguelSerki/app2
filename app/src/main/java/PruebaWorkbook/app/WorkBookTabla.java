package PruebaWorkbook.app;
import java.io.*;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;

public class WorkBookTabla {
	private JTable table;
	private TableModel model;
	
	public WorkBookTabla (JTable table){
		this.table = table;
		this.model = table.getModel();
	}
public void printTable (){

		for (int i = 0; i < model.getRowCount(); i++) {
		  for (int j = 0; j < model.getColumnCount(); j++) {
		    Object o = model.getValueAt(i, j);
		    System.out.println(o);
		    /*if (o instanceof Integer) {
			      System.out.println((Integer)o);
			    } else if (o instanceof String) {
			      System.out.println((String)o);
			    }*/
		  }
	}
}
}