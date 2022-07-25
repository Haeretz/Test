package duke.spring.guestbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import duke.spring.guestbook.service.GuestBookWriteService;
import duke.spring.guestbook.service.Message;

public class WriteController extends AbstractCommandController {

	private GuestBookWriteService guestBookWriteService;

	public void setGuestBookWriteService(
			GuestBookWriteService guestBookWriteService) {
		this.guestBookWriteService = guestBookWriteService;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Message message = (Message) command;
		guestBookWriteService.write(message);
		return new ModelAndView(getRedirectUrl(request));
	}

	private String getRedirectUrl(HttpServletRequest request) {
		return "redirect:" + request.getServletPath() + "/list";
	}

}
