import Util.CommentAssistant;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;

public class MySuperMonNamedParameterJdbcTemplate extends NamedParameterJdbcTemplate {
    public MySuperMonNamedParameterJdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    public static void main(String[] args) {
        String query = "Select * from difar";

        System.out.println(CommentAssistant.addSystemData(query));
    }

    @Nullable
    @Override
    public <T> T query(String sql, SqlParameterSource paramSource, ResultSetExtractor<T> rse) throws DataAccessException {
        String value = CommentAssistant.addSystemData(sql);
        return super.query(value, paramSource, rse);
    }
}