package duke.spring.guestbook.service;

public interface GuestBookListService {

	ListResult getMessages(int page, int pageSize);
	
}
