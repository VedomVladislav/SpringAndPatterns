package by.javavedom.training.spring.dao.impls;

import by.javavedom.training.spring.dao.interfaces.MP3Dao;
import by.javavedom.training.spring.dao.objects.Author;
import by.javavedom.training.spring.dao.objects.MP3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component("sqliteDAO")
public class SQLiteDAO implements MP3Dao {

    private static final String mp3Table = "mp3";
    private static final String mp3View = "mp3_view";

    private SimpleJdbcInsert insertMP3;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public int insertMP3(MP3 mp3) {
//        String sql = "insert into mp3 (name, author) VALUES (:name, :author)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("name", mp3.getName());
//        params.addValue("author", mp3.getAuthor());
//        jdbcTemplate.update(sql, params, keyHolder);
//        return keyHolder.getKey().intValue();

//        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        int author_id = insertAuthor(mp3.getAuthor());
        String sqlInsertMP3 = "insert into mp3 (author_id, name) VALUES (:authorId, :mp3Name)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("mp3Name", mp3.getName());
        params.addValue("authorId", author_id);
        return jdbcTemplate.update(sqlInsertMP3, params);
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public int insertAuthor(Author author) {
//        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        String sqlInsertAuthor = "insert into author (name) VALUES (:authorName)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("authorName", author.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sqlInsertAuthor, params, keyHolder);
        return keyHolder.getKey().intValue();
    }



/*    @Override
    public int insertList(List<MP3> mp3List) {
        String sql = "insert into mp3 (name, author) VALUES (:name, :author)";
        //не будет ошибки с последовательностью добавления значений в колонки
        SqlParameterSource[] params = new SqlParameterSource[mp3List.size()];
        int i = 0;
        for (MP3 mp3 : mp3List) {
            MapSqlParameterSource p = new MapSqlParameterSource();
            p.addValue("name", mp3.getName());
            p.addValue("author", mp3.getAuthor());
            params[i] = p;
            i++;
        }
        int[] updateCounts = jdbcTemplate.batchUpdate(sql, params);

//        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(mp3List.toArray());
//        int[] updateCounts = jdbcTemplate.batchUpdate(sql, batch);
        return updateCounts.length;
    }*/

    @Override
    public int insertList(List<MP3> mp3List) {
        int count = 0;
        for (MP3 mp3 : mp3List) {
            insertMP3(mp3);
            count++;
        }
        return count;
    }

    @Override
    public void delete(MP3 mp3) {
        delete(mp3.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from mp3 where id = :id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        jdbcTemplate.update(sql, mapSqlParameterSource);
    }

    @Override
    public int getMP3Count() {
        String sql = "select count(*) from " + mp3Table;
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    @Override
    public MP3 getMP3ByID(int id) {
        String sql = "select * from " + mp3View + " where mp3_id=:mp3_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("mp3_id", id);
        return jdbcTemplate.queryForObject(sql, params, new MP3RowMapper());
    }

    @Override
    public List<MP3> getMP3ListByName(String mp3Name) {
        String sql = "select * from " + mp3View + " where upper(mp3_name) like :mp3_name";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("mp3_name", "%" + mp3Name.toUpperCase() + "%");
        return jdbcTemplate.query(sql, params, new MP3RowMapper());
    }

    @Override
    public List<MP3> getMP3ListByAuthor(String author) {
        String sql = "select * from " + mp3View + " where upper(author_name) like :author_name";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("author_name", "%" + author.toUpperCase() + "%");
        return jdbcTemplate.query(sql, params, new MP3RowMapper());
    }

    @Override
    public Map<String, Integer> getStat() {
        String sql = "SELECT author as author_name, count(*) as count_songs from " + mp3View + " group by author";
        return jdbcTemplate.query(sql, new MP3Extractor());
    }


/*    @Deprecated
    public void insertWithJDBC(MP3 mp3) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:db/SpringDB_old.db";
            conn = DriverManager.getConnection(url, "", "");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "insert into mp3 (name, author) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mp3.getName());
            ps.setString(2, mp3.getAuthor());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }*/


    private static final class MP3RowMapper implements RowMapper<MP3> {

        @Override
        public MP3 mapRow(ResultSet rs, int i) throws SQLException {
            Author author = new Author();
            author.setId(rs.getInt("author_id"));
            author.setName("author_name");

            MP3 mp3 = new MP3();
            mp3.setId(rs.getInt("mp3_id"));
            mp3.setName(rs.getString("mp3_name"));
            mp3.setAuthor(author);
            return mp3;

        }
    }

    public class MP3Extractor implements ResultSetExtractor<Map<String, Integer>> {

        @Override
        public Map<String, Integer> extractData(ResultSet rs) throws SQLException {
            Map<String, Integer> map = new TreeMap<>();
            while (rs.next()) {
                String author = rs.getString("author_name");
                int count = rs.getInt("count");
                map.put(author, count);
            }
            return map;

        }
    }

}
