package duke.spring.guestbook.service;

import duke.spring.guestbook.dao.MessageDao;

public class GuestBookWriteServiceImpl implements GuestBookWriteService {

	private MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public void write(Message message) {
		messageDao.insert(message);
	}

}
