package NamedJDBC;

import Util.CommentAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.ParsedSql;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class MySuperMonNamedParameterJdbcTemplate extends NamedParameterJdbcTemplate {
    private final CommentAssistant commentAssistant;

    @Autowired
    public MySuperMonNamedParameterJdbcTemplate(DataSource dataSource) {
        super(dataSource);
        this.commentAssistant = new CommentAssistant(Logger.getGlobal());
    }

    @Autowired
    public MySuperMonNamedParameterJdbcTemplate(JdbcOperations classicJdbcTemplate) {
        super(classicJdbcTemplate);
        this.commentAssistant = new CommentAssistant(Logger.getGlobal());
    }

    @Override
    @Nullable
    public <T> T execute(@NonNull String sql, @NonNull SqlParameterSource paramSource, @NonNull PreparedStatementCallback<T> action) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.execute(value, paramSource, action);
    }

    @Override
    @Nullable
    public <T> T execute(String sql, Map<String,?> paramMap, PreparedStatementCallback<T> action) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.execute(value, paramMap, action);
    }

    @Override
    @Nullable
    public <T> T execute(String sql, PreparedStatementCallback<T> action) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.execute(value, action);
    }

    @Override
    @Nullable
    public <T> T query(String sql, SqlParameterSource paramSource, ResultSetExtractor<T> rse) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, paramSource, rse);
    }

    @Override
    @Nullable
    public <T> T query(String sql, Map<String,?> paramMap, ResultSetExtractor<T> rse) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, paramMap, rse);
    }

    @Override
    @Nullable
    public <T> T query(String sql, ResultSetExtractor<T> rse) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, rse);
    }

    @Override
    public void query(String sql, SqlParameterSource paramSource, RowCallbackHandler rch) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        super.query(value, paramSource, rch);
    }

    @Override
    public void query(String sql, Map<String,?> paramMap, RowCallbackHandler rch) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        super.query(value, paramMap, rch);
    }

    @Override
    public void query(String sql, RowCallbackHandler rch) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        super.query(value, rch);
    }

    @Override
    public <T> List<T> query(String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, paramSource, rowMapper);
    }

    @Override
    @Nullable
    public <T> List<T> query(String sql, Map<String,?> paramMap, RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, paramMap, rowMapper);
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, rowMapper);
    }

    @Override
    public <T> Stream<T> queryForStream(String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForStream(value, paramSource, rowMapper);
    }

    @Override
    public <T> Stream<T> queryForStream(String sql, Map<String,?> paramMap, RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForStream(value, paramMap, rowMapper);
    }

    @Override
    @Nullable
    public <T> T queryForObject(String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForObject(value, paramSource, rowMapper);
    }

    @Override
    @Nullable
    public <T> T queryForObject(String sql, Map<String,?> paramMap, RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForObject(value, paramMap, rowMapper);
    }

    @Override
    @Nullable
    public <T> T queryForObject(String sql, SqlParameterSource paramSource, Class<T> requiredType) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForObject(value, paramSource, requiredType);
    }

    @Override
    @Nullable
    public <T> T queryForObject(String sql, Map<String,?> paramMap, Class<T> requiredType) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForObject(value, paramMap, requiredType);
    }

    @Override
    public Map<String,Object> queryForMap(String sql, SqlParameterSource paramSource) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForMap(value, paramSource);
    }

    @Override
    public Map<String,Object> queryForMap(String sql, Map<String,?> paramMap) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForMap(value, paramMap);
    }

    @Override
    public <T> List<T> queryForList(String sql, SqlParameterSource paramSource, Class<T> elementType) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForList(value, paramSource, elementType);
    }

    @Override
    public <T> List<T> queryForList(String sql, Map<String,?> paramMap, Class<T> elementType) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForList(value, paramMap, elementType);
    }

    @Override
    public List<Map<String,Object>> queryForList(String sql, SqlParameterSource paramSource) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForList(value, paramSource);
    }

    @Override
    public List<Map<String,Object>> queryForList(String sql, Map<String,?> paramMap) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForList(value, paramMap);
    }

    @Override
    public SqlRowSet queryForRowSet(String sql, SqlParameterSource paramSource) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForRowSet(value, paramSource);
    }

    @Override
    public SqlRowSet queryForRowSet(String sql, Map<String,?> paramMap) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForRowSet(value, paramMap);
    }

    @Override
    public int update(String sql, SqlParameterSource paramSource) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.update(value, paramSource);
    }

    @Override
    public int update(String sql, Map<String,?> paramMap) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.update(value, paramMap);
    }

    @Override
    public int update(String sql, SqlParameterSource paramSource, KeyHolder generatedKeyHolder) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.update(value, paramSource, generatedKeyHolder);
    }

    @Override
    public int update(String sql,
                      SqlParameterSource paramSource,
                      KeyHolder generatedKeyHolder,
                      @Nullable
                              String[] keyColumnNames)
            throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.update(value, paramSource, generatedKeyHolder, keyColumnNames);
    }

    @Override
    public int[] batchUpdate(String sql, Map<String,?>[] batchValues) {
        String value = commentAssistant.addSystemData(sql);
        return super.batchUpdate(value, batchValues);
    }

    @Override
    public int[] batchUpdate(String sql, SqlParameterSource[] batchArgs) {
        String value = commentAssistant.addSystemData(sql);
        return super.batchUpdate(value, batchArgs);
    }

    @Override
    protected PreparedStatementCreator getPreparedStatementCreator(String sql, SqlParameterSource paramSource) {
        String value = commentAssistant.addSystemData(sql);
        return super.getPreparedStatementCreator(value, paramSource);
    }

    @Override
    protected PreparedStatementCreator getPreparedStatementCreator(String sql,
                                                                   SqlParameterSource paramSource,
                                                                   @Nullable
                                                                               Consumer<PreparedStatementCreatorFactory> customizer) {
        String value = commentAssistant.addSystemData(sql);
        return super.getPreparedStatementCreator(value, paramSource, customizer);
    }

    @Override
    protected ParsedSql getParsedSql(String sql) {
        String value = commentAssistant.addSystemData(sql);
        return super.getParsedSql(value);
    }

    @Override
    protected PreparedStatementCreatorFactory getPreparedStatementCreatorFactory(ParsedSql parsedSql, SqlParameterSource paramSource) {
        ParsedSql value = getParsedSql(parsedSql.toString());
        return super.getPreparedStatementCreatorFactory(value, paramSource);
    }
}