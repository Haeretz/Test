package duke.spring.guestbook.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import duke.spring.guestbook.dao.MessageDao;
import duke.spring.guestbook.service.Message;

public class IBatisMessageDao extends SqlMapClientDaoSupport implements
		MessageDao {

	@Override
	public void insert(Message message) {
		getSqlMapClientTemplate().insert("insert", message);
	}

	@Override
	public int selectCount() {
		return (Integer) getSqlMapClientTemplate()
				.queryForObject("selectCount");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> selectList(int page, int pageSize) {
		int startRow = (page - 1) * pageSize;
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("startRow", startRow);
		params.put("fetchSize", pageSize);
		return getSqlMapClientTemplate().queryForList("selectList", params);
	}

}
