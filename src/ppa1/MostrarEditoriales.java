package ppa1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


 public class MostrarEditoriales {
 public static void main(String[] args) {
		

        ConexionDB conexion = new ConexionDB ();
     
    
        
        System.out.println("Conectando a la base de datos...");
        //Paso 1. Obtener la conexion 
        Connection con = conexion.getConexion();
        
        // Objetos necesarios para hacer una consulta
    
        Statement sentencia= null;
        ResultSet resultado = null;
		
        //Algun procesamiento con la base de datos...
       
        
        try {
     	   // Paso 2. Obtener el Statement
			sentencia = con.createStatement();
			
			//Paso 3. Ejecutr la sentencia
			resultado=sentencia.executeQuery("select * from editoriales ");
			System.out.println("cod- Editorial\tNombre\tAño");
			
			//Paso 4. Recorrer el resultado
			while (resultado.next ()) {
				int cod_Editorial = resultado.getInt("cod_Editorial");
				String nombre= resultado.getString("nombre");
				int año = resultado.getInt("año");
				
				System.out.println(cod_Editorial+"\t"+nombre+"\t"+año);
			}
		} catch (SQLException e) {
		System.out.println("Error al consultar los datos." +e.getMessage());
		}finally {
			try {
				resultado.close();
				sentencia.close();
			} catch (SQLException e) {
			System.out.println("Error al liberar los recursos");
			}
		}
        
        
        //Liberamos la conexion
        System.out.println("Desconectando de la base de datos");
        conexion.desconectar(); 
		
 }

 

	}


