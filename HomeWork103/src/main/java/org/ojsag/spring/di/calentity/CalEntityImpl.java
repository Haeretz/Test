package org.ojsag.spring.di.calentity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ojsag.spring.di.connection.ConnectionUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalEntityImpl implements ICalEntity {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	@Autowired
	private ConnectionUtill cu;

	public void insertCal(CalVO vo) {
		try {
			System.out.println("엔티티");
			con = cu.getConnection();  //
			stmt = con.prepareStatement("insert into cal(op1,op,op2,result) values(?,?,?,?)");			
			stmt.setString(1,vo.getOp1());
			stmt.setString(2,vo.getOp());
			stmt.setString(3,vo.getOp2());
			stmt.setInt(4,vo.getResult());
			int i=stmt.executeUpdate();
			System.out.println(i+"행이 추가되었습니다.");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{			
				cu.close(stmt);
				cu.close(con);					
		}
	}
}
