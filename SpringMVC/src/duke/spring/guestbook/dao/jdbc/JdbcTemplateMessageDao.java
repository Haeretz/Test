package duke.spring.guestbook.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import duke.spring.guestbook.dao.MessageDao;
import duke.spring.guestbook.service.Message;

public class JdbcTemplateMessageDao implements MessageDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String SELECT_COUNT_SQL = "select count(*) from GUESTBOOK_MESSAGE";

	@Override
	public int selectCount() {
		return jdbcTemplate.queryForInt(SELECT_COUNT_SQL);
	}

	private static final String SELECT_LIST_SQL = "select * from (select rownum numrow, A.* from(select * from GUESTBOOK_MESSAGE)A) where numrow >= ? and numrow <= ? order by GUESTBOOK_MESSAGE_ID desc";

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> selectList(int page, int pageSize) {
		int startRow = (page - 1) * pageSize;
		List<Message> list = jdbcTemplate.query(SELECT_LIST_SQL, 
			new Object[] { startRow, pageSize }, 
			new RowMapper() {
				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					Message message = new Message();
					message.setId(rs.getInt("GUESTBOOK_MESSAGE_ID"));
					message.setGuestName(rs.getString("GUEST_NAME"));
					message.setContent(rs.getString("CONTENT"));
					return message;
				}
			}
		);
		return list;
	}

	private static final String INSERT_SQL = "insert into GUESTBOOK_MESSAGE (GUESTBOOK_MESSAGE_ID, GUEST_NAME, CONTENT) values (seq_log.nextval, ?, ?)";

	@Override
	public void insert(Message message) {
		jdbcTemplate.update(INSERT_SQL, new Object[] { message.getGuestName(),
				message.getContent() });
	}

}
