package org.ojsag.spring.di.calservice;

import org.ojsag.spring.di.calentity.CalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CalService {
    private ICalService ics;
    @Autowired
	public CalService(ICalService ics) {
		// TODO Auto-generated constructor stub
		this.ics=ics;
	}
	public void setIcs(ICalService ics){
		this.ics=ics;
	}
	public void doService(CalVO vo){
		ics.doService(vo);
	}
	

}
