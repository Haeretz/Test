package dao;

public class PageVO {
	private int pageSize = 10;
	private int pageNum = 0;
	private int startRow = 0;
	private int count = 0;
	private int number = 0;
	
	public PageVO() {
	}
	public PageVO(int pageNum, int count) {
		this.setPageNum(pageNum);
		this.setCount(count);
		doPaging();
	}
	private void doPaging() {
		this.setStartRow((this.getPageNum() - 1) * this.getPageSize() + 1);
		this.setNumber(this.getCount()-(this.getPageNum()-1)*this.getPageSize());
	    
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
}
