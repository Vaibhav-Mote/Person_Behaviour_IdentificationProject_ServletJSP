package behaviour.config;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBConfig {
private Connection conn;
private ResultSet rs;
private PreparedStatement stmt;
private static DBConfig db=null;

private DBConfig(String path) {
	try {
	FileInputStream fin=new FileInputStream(path);
	Properties p =new Properties();
    p.load(fin);
    String username=p.getProperty("db.username");
    String password=p.getProperty("db.password");
    String url=p.getProperty("db.url");
   String driverClassName=p.getProperty("db.driverClassName");
   Class.forName(driverClassName);
    conn=DriverManager.getConnection(url,username,password);
    
   
	}catch(Exception ex) {
		System.out.println(ex);
		
	}
}

public static DBConfig getInstance(String path) {
	if(db==null) {
		
	db=new DBConfig(path);
	
	}
	return db;
}
public Connection getConnection() {
	return conn;
}
public PreparedStatement getPreparedStatements() {
	return stmt;
}
public ResultSet getResultSet() {
	return rs;
}


}

