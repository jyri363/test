package itk.praks3;

import java.util.*;
import java.sql.*;

public class GuardDao {
    public List<Guard> getGuards() throws Exception {
        List<Guard> rv = new ArrayList<Guard>();
        Class.forName("org.hsqldb.jdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:/home/hsqldb/testdb", "sa", "");
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT id, name, age FROM guard");
        while(rs.next()) {
            Guard g = new Guard();
            g.setId(rs.getInt(1));
            g.setName(rs.getString(2));
            g.setAge(rs.getInt(3));
            rv.add(g);
        }

        return rv;
    }
}
