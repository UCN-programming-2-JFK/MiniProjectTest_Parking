package supercoders.parking.model.dao.database;
import java.sql.*;

public interface DataContext {
	Connection getConnection() throws SQLException;
}