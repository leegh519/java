package com.yedam.app.members;

import java.sql.SQLException;

import com.yedam.app.common.DAO;

public class MembersDAO extends DAO {

	private static MembersDAO mDAO;

	private MembersDAO() {
	}

	public static MembersDAO getInstance() {
		if (mDAO == null) {
			mDAO = new MembersDAO();
		}
		return mDAO;
	}

	// CRUD
	public Member selectOne(Member member) {
		Member loginInfo = null;
		try {
			connect();
			String sql = "SELECT * FROM members WHERE member_id = '" + member.getMemberId() + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			// id 존재
			if (rs.next()) {
				// password 일치
				if (rs.getString("member_password").equals(member.getMemberPassword())) {
					loginInfo = new Member();
					loginInfo.setMemberRole(rs.getInt("member_role"));
					loginInfo.setMemberId(member.getMemberId());
					loginInfo.setMemberPassword(member.getMemberPassword());
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				System.out.println("ID가 존재하지 않습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return loginInfo;
	}

	//

}
