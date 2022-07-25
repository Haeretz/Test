package org.ojsag.spring.di.calentity;

import org.springframework.stereotype.Component;

@Component
public class CalVO {
	private String op1;
	private String op;
	private String op2;
	private int result;

	public CalVO() {}
	
	public CalVO(String op1,String op,String op2) {
		this.op1=op1;
		this.op=op;
		this.op2=op2;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int resutl) {
		this.result = resutl;
	}

	public void setOps(String op1,String op,String op2){
		setOp1(op1);
		setOp(op);
		setOp2(op2);
	}

}
