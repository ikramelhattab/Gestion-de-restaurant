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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MaConnection {

	Connection con;
	Statement st;
	ResultSet rs;

	
	
	public MaConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projet","root","");
			st= con.createStatement();
            String tab="client"; 
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}
	

	
	public int ajouter(String nomprenom,String pwd,String phone,String email,String adr){
	int q=0;
	String rqt="INSERT INTO etudiant VALUES('"+nomprenom+"','"+pwd+"','"+phone+"','"+email+"','"+adr+"')";
	try {
		q = st.executeUpdate(rqt);
		
	} catch (SQLException e) {
		//e.printStackTrace();
                e.toString();
	}
	return q;

}
	
		ResultSet select(String rqt)
		{
			try {
				 rs =st.executeQuery(rqt);
				

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;


		}
			
		
		public int modifer(String req){
			int a = 0;
			
			try {
				 a = st.executeUpdate(req);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	      return a;
			
		}
		
		
}




	
	
		
