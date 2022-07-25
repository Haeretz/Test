package org.ojsag.spring.di.calentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalEntity {
	@Autowired
	ICalEntity ice;
	
	public void insertCal(CalVO vo){
		ice.insertCal(vo);
	}
	
}
