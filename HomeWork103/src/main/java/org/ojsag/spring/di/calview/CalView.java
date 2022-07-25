package org.ojsag.spring.di.calview;

import org.ojsag.spring.di.calentity.CalVO;
import org.springframework.stereotype.Component;

@Component
public class CalView {
	public void doPrint(CalVO vo) {
		String check = vo.getOp();
		switch (check) {
		case "add":
			System.out.println(vo.getOp1() + "+" + vo.getOp2() + "=" + vo.getResult());
			break;
		case "sub":
			System.out.println(vo.getOp1() + "-" + vo.getOp2() + "=" + vo.getResult());
			break;
		case "mul":
			System.out.println(vo.getOp1() + "*" + vo.getOp2() + "=" + vo.getResult());
			break;
		case "div":
			System.out.println(vo.getOp1() + "/" + vo.getOp2() + "=" + vo.getResult());
			break;
		default:
			System.out.println("123");
		}		
	}
}
