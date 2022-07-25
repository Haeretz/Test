package duke.spring.guestbook.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import duke.spring.guestbook.service.Message;

public class MemberRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("GUESTBOOK_MESSAGE_ID"));
		message.setGuestName(rs.getString("GUEST_NAME"));
		message.setContent(rs.getString("CONTENT"));
		return message;
	}

}
