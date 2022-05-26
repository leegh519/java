package com.yedam.java.ex1;

// 고객정보를 저장하는 저장소
public class Repo {

	// 필드
	private Customer[] dataList;
	private int listIndex;

	// 생성자
	public Repo() {
		dataList = new Customer[100];
		listIndex = -1;
	}

	// 메소드

	// 등록
	public void insert(Customer customer) {
		dataList[++listIndex] = customer;
	}

	// 수정
	public void update(Customer customer) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getId() == customer.getId()) {
				dataList[i] = customer;
			}
		}
	}

	// 삭제
	public void delete(int id) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getId() == id) {
				dataList[i] = null;
			}
		}
		cleanDataList();
	}

	// 배열에 비어있는 공간 한칸씩 땡김
	private void cleanDataList() {

		// 기존 데이터, 임시 변수에 복사
		Customer[] temp = dataList;
		int tempIndex = listIndex;

		// 기존 데이터 초기화
		this.dataList = new Customer[100];
		this.listIndex = -1;
		for (int i = 0; i <= tempIndex; i++) {
			if (temp[i] == null) {
				continue;
			}
			dataList[++listIndex] = temp[i];
		}

	}

	// 조회
	public Customer[] selectAll() {
		return dataList;
	}

	public Customer selectOne(int id) {
		Customer selected = null;
		for (int i = 0; i <= listIndex; i++) {
			if(dataList[i].getId() == id) {
				selected = dataList[i];
				break;
			}
		}
		return selected;
	}

}
