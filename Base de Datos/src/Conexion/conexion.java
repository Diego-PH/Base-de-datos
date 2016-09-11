package Conexion;


	import java.sql.DriverManager;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import javax.swing.JOptionPane;

	public class conexion {	
		private String usuario ="root";
		private String pwd = "";
		private static String bd = "registros";
		static String url = "jdbc:mysql://localhost/"+bd;
		private static Connection conn = null;
		    
		
		Statement sentencia;
		private ResultSet ResultSet;
	
		
		
		
		//Constructor
		public conexion(){
			
			try{
				Class.forName("com.mysql.jdbc.Connection");
				conn= (Connection)DriverManager.getConnection(url,usuario,pwd);
				if(conn != null){
					System.out.println("Conexion a base de datos "+   url  +  "    E X I T O S A ! ");
					JOptionPane.showMessageDialog(null, "Conexión Exitosa !");
					}
			}
			catch(SQLException ex){
				System.out.println("Se presento un problema al intentar conectarse a la base de datos"+ url);
			}
			
			catch(ClassNotFoundException ex){
				System.out.println(ex);
			}
		}
		

//		public ResultSet getQuery(String query){ //para los select 
//			Statement state = null;
//			ResultSet resultado = null;
//			try {
//				state = (Statement) conn.createStatement();
//				resultado = state.executeQuery(query);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return resultado;
//		}
//		
//		public void setQuery (String query){ // 
//			Statement state = null;
//			try {
//				state=(Statement) conn.createStatement();
//				state.execute(query);
//			} catch (SQLException e) {
//				e.printStackTrace();
//				
//			}
//		}
		
		  public String obtenerNombre(String SQL) {
			
		        ResultSet cdr =null;
		        try {
		            sentencia=conn.createStatement(); 
		             cdr=sentencia.executeQuery("select * from nombre");
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "No se pudo realizar la operacion\n"+ex, "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        //return cdr;
				return SQL;
		    }
		
	
	
	}
