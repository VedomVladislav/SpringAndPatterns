package by.javavedom.training.spring.exeptions;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import java.sql.SQLException;

public class SQLiteExceptionsTranslator
        extends SQLErrorCodeSQLExceptionTranslator {

    @Override
    protected DataAccessException customTranslate(String task, String sql, SQLException sqlEx) {
        if (sqlEx.getErrorCode() == 0) {
            return new MyExeption(sql + " - " + sqlEx.getMessage());
        }
        return null;
    }
}
