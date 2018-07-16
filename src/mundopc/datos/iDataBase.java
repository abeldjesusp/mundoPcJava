package mundopc.datos;

import java.sql.SQLException;
import java.util.List;

public interface iDataBase {
    public int insert(Object obj) throws SQLException;
    public int update(Object obj) throws SQLException;
    public int delete(Object obj) throws SQLException;
    public List<Object> select() throws SQLException;
}
