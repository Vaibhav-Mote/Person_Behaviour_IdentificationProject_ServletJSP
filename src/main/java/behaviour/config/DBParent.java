package behaviour.config;
import java.sql.*;
public class DBParent {
	
	public static String path;
	protected DBConfig config=DBConfig.getInstance(path);
	protected Connection conn=config.getConnection();
	protected PreparedStatement stmt=config.getPreparedStatements();
	protected ResultSet  rs=config.getResultSet();
}
