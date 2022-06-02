package com.yedam.java.ch1101;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		// 논리적으로 동등한지

		// 1.동일한 타입인지
		if (obj instanceof Member) {
			// 2. 필드값이 같은지
			Member member = (Member) obj;
			if (id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
}
