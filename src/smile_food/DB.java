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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;


public class DB {


	public static void main(String[] args)  {
		Connection con;
		Statement st;
		try {


			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1/projet","root","");
			st= con.createStatement();
/*
			String t="client";
			String nomprenom="Foulen";
			String pwd="Ben Foulen";
                        String email="ikram@yahoo.com";
			String phone="Ben Foulen";
                        String adr="rue";
			int q=st.executeUpdate("INSERT INTO "+t+" VALUES('"+ nomprenom+"','"+pwd+"','"+phone+"','"+email+"','"+adr+"');");

			if(q==0)
				System.out.println("error");
			else
				System.out.println("success");
			*/
			ResultSet rs=st.executeQuery("select * from client");
			ResultSetMetaData rsmd=rs.getMetaData();
			int nbc=rsmd.getColumnCount();
			
			String [] titre=new String[nbc];
			for (int i=1;i<=nbc;i++){
				titre[i]=rsmd.getColumnName(i);
				System.out.println(titre[i]);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}




