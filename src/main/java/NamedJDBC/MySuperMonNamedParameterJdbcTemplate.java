package NamedJDBC;

import Util.CommentAssistant;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class MySuperMonNamedParameterJdbcTemplate extends NamedParameterJdbcTemplate {
    public MySuperMonNamedParameterJdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM difar";

        System.out.println(CommentAssistant.addSystemData(query));
    }

    @Nullable
    @Override
    public <T> T query(String sql, SqlParameterSource paramSource, ResultSetExtractor<T> rse) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.query(value, paramSource, rse);
    }

    @Nullable
    @Override
    public <T> T query(String sql, Map<String,?> paramMap, ResultSetExtractor<T> rse) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.query(value, paramMap, rse);
    }

    @Nullable
    @Override
    public <T> T query(String sql, ResultSetExtractor<T> rse) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.query(value, rse);
    }

    @Override
    public void query(String sql, SqlParameterSource paramSource, RowCallbackHandler rch) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        super.query(value, paramSource, rch);
    }

    @Override
    public void query(String sql, Map<String,?> paramMap, RowCallbackHandler rch) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        super.query(value, paramMap, rch);
    }

    @Override
    public void query(String sql, RowCallbackHandler rch) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        super.query(value, rch);
    }

    @Override
    public <T> List<T> query(String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.query(value, paramSource, rowMapper);
    }

    @Nullable
    @Override
    public <T> List<T> query(String sql, Map<String,?> paramMap, RowMapper<T> rowMapper) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.query(value, paramMap, rowMapper);
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.query(value, rowMapper);
    }

    @Override
    public int update(String sql, SqlParameterSource paramSource) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.update(value, paramSource);
    }

    @Override
    public int update(String sql, Map<String,?> paramMap) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.update(value, paramMap);
    }

    @Override
    public int update(String sql, SqlParameterSource paramSource, KeyHolder generatedKeyHolder) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.update(value, paramSource, generatedKeyHolder);
    }

    @Override
    public int update(String sql,
                      SqlParameterSource paramSource,
                      KeyHolder generatedKeyHolder,
                      @Nullable
                              String[] keyColumnNames)
            throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.update(value, paramSource, generatedKeyHolder, keyColumnNames);
    }
}