package org.ojsag.spring.di.calservice;

import org.ojsag.spring.di.calentity.CalEntity;
import org.ojsag.spring.di.calentity.CalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CalServiceImpl implements ICalService {
	@Autowired
	CalEntity ce;

	public CalServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public void doService(CalVO vo) {
		String check = vo.getOp();
		switch(check){
		case "add":
			vo.setResult(Integer.parseInt(vo.getOp1()) + Integer.parseInt(vo.getOp2()));
			break;
		case "sub":
			vo.setResult(Integer.parseInt(vo.getOp1()) - Integer.parseInt(vo.getOp2()));
			break;
		case "mul":
			vo.setResult(Integer.parseInt(vo.getOp1()) * Integer.parseInt(vo.getOp2()));
			break;
		case "div":
			vo.setResult(Integer.parseInt(vo.getOp1()) / Integer.parseInt(vo.getOp2()));
			break;
		default:
				break;			
		}
	}
}
