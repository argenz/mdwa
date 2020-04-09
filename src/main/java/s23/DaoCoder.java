package s23;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dd.Coder;

public class DaoCoder implements Closeable {
	private static final Logger logger = LoggerFactory.getLogger(DaoRegion.class);
    private Connection conn;

    public DaoCoder(DataSource ds) {  
        logger.trace("called");

        try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }
    
    public List<Coder> getAll() {
        logger.trace("called");
        List<Coder> results = new ArrayList<>();

        try (Statement stmt = conn.createStatement(); //
                ResultSet rs = stmt.executeQuery("select * from coders")) {
            while (rs.next()) {
                results.add(new Coder(rs.getInt("coder_id"), rs.getString("first_name"), rs.getString("last_name")));
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }

        return results;
    }

    @Override
    public void close() throws IOException {
        try {
            conn.close();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }
}
