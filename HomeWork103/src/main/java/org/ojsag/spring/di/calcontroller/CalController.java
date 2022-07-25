package org.ojsag.spring.di.calcontroller;

import org.ojsag.spring.di.calentity.CalVO;
import org.ojsag.spring.di.calservice.CalService;
import org.ojsag.spring.di.calview.CalView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalController {
	@Autowired
	CalService cs;
	@Autowired
	CalView cv;
	
	public void doService(CalVO vo){
		cs.doService(vo);
		cv.doPrint(vo);
	}

}
