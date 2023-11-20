package com.example.project4.DAO;

import com.example.project4.VO.MemberVO;
import com.example.project4.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String MEMBER_INSERT = "insert into MEMBER (userid, username, content) values (?,?,?)";
	private final String MEMBER_UPDATE = "update MEMBER set userid=?, username=?, content=? where sid=?";
	private final String MEMBER_DELETE = "delete from MEMBER  where sid=?";
	private final String MEMBER_GET = "select * from MEMBER  where sid=?";
	private final String MEMBER_LIST = "select * from MEMBER order by sid desc";

	public int insertMember(MemberVO vo) {
		System.out.println("===> JDBC로 insertMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_INSERT);
			stmt.setString(1, vo.getUserid());
			stmt.setString(2, vo.getUsername());
			stmt.setString(3, vo.getEmail());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteMember(MemberVO vo) {
		System.out.println("===> JDBC로 deleteMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_DELETE);
			stmt.setInt(1, vo.getSid());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateMember(MemberVO vo) {
		System.out.println("===> JDBC로 updateMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_UPDATE);
			stmt.setString(1, vo.getUserid());
			stmt.setString(2, vo.getUsername());
			stmt.setString(3, vo.getEmail());
			stmt.setInt(4, vo.getSid());
			
			
			System.out.println(vo.getUserid() + "-" + vo.getUsername() + "-" + vo.getEmail() + "-" + vo.getSid());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public MemberVO getMember(int sid) {
		MemberVO one = new MemberVO();
		System.out.println("===> JDBC로 getMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_GET);
			stmt.setInt(1, sid);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSid(rs.getInt("sid"));
				one.setUserid(rs.getString("userid"));
				one.setUsername(rs.getString("username"));
				one.setEmail(rs.getString("email"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<MemberVO> getMemberList(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		System.out.println("===> JDBC로 getMemberList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				MemberVO one = new MemberVO();
				one.setSid(rs.getInt("sid"));
				one.setUserid(rs.getString("userid"));
				one.setUsername(rs.getString("username"));
				one.setEmail(rs.getString("email"));
				one.setRegdate(rs.getDate("regdate"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
}
