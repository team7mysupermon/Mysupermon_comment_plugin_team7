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
    public <T> T execute(@NonNull String sql,
                         @NonNull SqlParameterSource paramSource,
                         @NonNull PreparedStatementCallback<T> action) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.execute(value, paramSource, action);
    }

    @Override
    @Nullable
    public <T> T execute(@NonNull String sql,
                         @NonNull Map<String,?> paramMap,
                         @NonNull PreparedStatementCallback<T> action) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.execute(value, paramMap, action);
    }

    @Override
    @Nullable
    public <T> T execute(@NonNull String sql, @NonNull PreparedStatementCallback<T> action) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.execute(value, action);
    }

    @Override
    @Nullable
    public <T> T query(@NonNull String sql,
                       @NonNull SqlParameterSource paramSource,
                       @NonNull ResultSetExtractor<T> rse) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, paramSource, rse);
    }

    @Override
    @Nullable
    public <T> T query(@NonNull String sql,
                       @NonNull Map<String,?> paramMap,
                       @NonNull ResultSetExtractor<T> rse) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, paramMap, rse);
    }

    @Override
    @Nullable
    public <T> T query(@NonNull String sql,
                       @NonNull ResultSetExtractor<T> rse) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, rse);
    }

    @Override
    public void query(@NonNull String sql,
                      @NonNull SqlParameterSource paramSource,
                      @NonNull RowCallbackHandler rch) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        super.query(value, paramSource, rch);
    }

    @Override
    public void query(@NonNull String sql,
                      @NonNull Map<String,?> paramMap,
                      @NonNull RowCallbackHandler rch) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        super.query(value, paramMap, rch);
    }

    @Override
    public void query(@NonNull String sql,
                      @NonNull RowCallbackHandler rch) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        super.query(value, rch);
    }

    @Override
    @NonNull
    public <T> List<T> query(@NonNull String sql,
                             @NonNull SqlParameterSource paramSource,
                             @NonNull RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, paramSource, rowMapper);
    }

    @Override
    @NonNull
    public <T> List<T> query(@NonNull String sql,
                             @NonNull Map<String,?> paramMap,
                             @NonNull RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, paramMap, rowMapper);
    }

    @Override
    @NonNull
    public <T> List<T> query(@NonNull String sql,
                             @NonNull RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.query(value, rowMapper);
    }

    @Override
    @NonNull
    public <T> Stream<T> queryForStream(@NonNull String sql,
                                        @NonNull SqlParameterSource paramSource,
                                        @NonNull RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForStream(value, paramSource, rowMapper);
    }

    @Override
    @NonNull
    public <T> Stream<T> queryForStream(@NonNull String sql,
                                        @NonNull Map<String,?> paramMap,
                                        @NonNull RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForStream(value, paramMap, rowMapper);
    }

    @Override
    @Nullable
    public <T> T queryForObject(@NonNull String sql,
                                @NonNull SqlParameterSource paramSource,
                                @NonNull RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForObject(value, paramSource, rowMapper);
    }

    @Override
    @Nullable
    public <T> T queryForObject(@NonNull String sql,
                                @NonNull Map<String,?> paramMap,
                                @NonNull RowMapper<T> rowMapper) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForObject(value, paramMap, rowMapper);
    }

    @Override
    @Nullable
    public <T> T queryForObject(@NonNull String sql,
                                @NonNull SqlParameterSource paramSource,
                                @NonNull Class<T> requiredType) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForObject(value, paramSource, requiredType);
    }

    @Override
    @Nullable
    public <T> T queryForObject(@NonNull String sql,
                                @NonNull Map<String,?> paramMap,
                                @NonNull Class<T> requiredType) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForObject(value, paramMap, requiredType);
    }

    @Override
    @NonNull
    public Map<String,Object> queryForMap(@NonNull String sql,
                                          @NonNull SqlParameterSource paramSource) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForMap(value, paramSource);
    }

    @Override
    @NonNull
    public Map<String,Object> queryForMap(@NonNull String sql,
                                          @NonNull Map<String,?> paramMap) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForMap(value, paramMap);
    }

    @Override
    @NonNull
    public <T> List<T> queryForList(@NonNull String sql,
                                    @NonNull SqlParameterSource paramSource,
                                    @NonNull Class<T> elementType) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForList(value, paramSource, elementType);
    }

    @Override
    @NonNull
    public <T> List<T> queryForList(@NonNull String sql,
                                    @NonNull Map<String,?> paramMap,
                                    @NonNull Class<T> elementType) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForList(value, paramMap, elementType);
    }

    @Override
    @NonNull
    public List<Map<String,Object>> queryForList(@NonNull String sql,
                                                 @NonNull SqlParameterSource paramSource) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForList(value, paramSource);
    }

    @Override
    @NonNull
    public List<Map<String,Object>> queryForList(@NonNull String sql,
                                                 @NonNull Map<String,?> paramMap) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForList(value, paramMap);
    }

    @Override
    @NonNull
    public SqlRowSet queryForRowSet(@NonNull String sql,
                                    @NonNull SqlParameterSource paramSource) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForRowSet(value, paramSource);
    }

    @Override
    @NonNull
    public SqlRowSet queryForRowSet(@NonNull String sql,
                                    @NonNull Map<String,?> paramMap) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.queryForRowSet(value, paramMap);
    }

    @Override
    public int update(@NonNull String sql,
                      @NonNull SqlParameterSource paramSource) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.update(value, paramSource);
    }

    @Override
    public int update(@NonNull String sql,
                      @NonNull Map<String,?> paramMap) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.update(value, paramMap);
    }

    @Override
    public int update(@NonNull String sql,
                      @NonNull SqlParameterSource paramSource,
                      @NonNull KeyHolder generatedKeyHolder) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.update(value, paramSource, generatedKeyHolder);
    }

    @Override
    public int update(@NonNull String sql,
                      @NonNull SqlParameterSource paramSource,
                      @NonNull KeyHolder generatedKeyHolder,
                      @Nullable String[] keyColumnNames) throws DataAccessException {
        String value = commentAssistant.addSystemData(sql);
        return super.update(value, paramSource, generatedKeyHolder, keyColumnNames);
    }

    @Override
    @NonNull
    public int[] batchUpdate(@NonNull String sql,
                             @NonNull Map<String,?>[] batchValues) {
        String value = commentAssistant.addSystemData(sql);
        return super.batchUpdate(value, batchValues);
    }

    @Override
    @NonNull
    public int[] batchUpdate(@NonNull String sql,
                             @NonNull SqlParameterSource[] batchArgs) {
        String value = commentAssistant.addSystemData(sql);
        return super.batchUpdate(value, batchArgs);
    }

    @Override
    @NonNull
    protected PreparedStatementCreator getPreparedStatementCreator(@NonNull String sql,
                                                                   @NonNull SqlParameterSource paramSource) {
        String value = commentAssistant.addSystemData(sql);
        return super.getPreparedStatementCreator(value, paramSource);
    }

    @Override
    @NonNull
    protected PreparedStatementCreator getPreparedStatementCreator(@NonNull String sql,
                                                                   @NonNull SqlParameterSource paramSource,
                                                                   @Nullable Consumer<PreparedStatementCreatorFactory> customizer) {
        String value = commentAssistant.addSystemData(sql);
        return super.getPreparedStatementCreator(value, paramSource, customizer);
    }

    @Override
    @NonNull
    protected ParsedSql getParsedSql(@NonNull String sql) {
        String value = commentAssistant.addSystemData(sql);
        return super.getParsedSql(value);
    }

    @Override
    @NonNull
    protected PreparedStatementCreatorFactory getPreparedStatementCreatorFactory(ParsedSql parsedSql,
                                                                                 @NonNull SqlParameterSource paramSource) {
        ParsedSql value = getParsedSql(parsedSql.toString());
        return super.getPreparedStatementCreatorFactory(value, paramSource);
    }
}