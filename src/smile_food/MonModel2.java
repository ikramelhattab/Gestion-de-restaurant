/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smile_food;

/**
 *
 * @author user
 */


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class MonModel2 extends AbstractTableModel {


	ResultSetMetaData rsmd;
	int nbcol,nbligne;
	ArrayList<Object[]>data;
	public MonModel2(ResultSet rs){
		data= new ArrayList<Object[]>();
		try {	
		rsmd=rs.getMetaData();
		nbcol=rsmd.getColumnCount();
		
		while(rs.next()){
			nbligne++;
			Object[]t=new Object[nbcol];
			 for (int i=0;i<nbcol;i++){
				t[i]=rs.getObject(i+1);
				data.add(t);
			 }
			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nbcol;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return nbligne;
	}

	@Override
	public Object getValueAt(int ligne, int col) {
		Object[]t=data.get(ligne);
		return t[col];
	}
	@Override
	public boolean isCellEditable(int lig, int col) {
		if(col==0){
			return false;
		}
		else
		return true;
	}
	
	
	
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		String ch="";
		try {
			ch=rsmd.getColumnName(col+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ch;
	
	}

	@Override
	public void setValueAt(Object v,int l, int c) {
		Object[]t=data.get(l);
		t[c]=v;
		data.set(l, t);
		String tab = null ;
		try {
			tab = rsmd.getTableName(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
        String req;
		try {
			req = " update "+tab+" set "+getColumnName(c)+"='"+v+"' where "+rsmd.getColumnName(1)+"="+getValueAt(l, 0)+";";
			MaConnection mc=new MaConnection();
	        int n=mc.modifer(req);
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}

	public void ajouter(Object[] t) {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		
	}



}
