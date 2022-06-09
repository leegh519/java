package com.yedam.java.ch1501;

public class MainTest {

	public static void main(String[] args) {
		
		// object를 이용해서 모든타입을 담을수 있음
		// 꺼내올때 마다 형변환 필요
		// 형변환시 오류발생할 가능성 높음
		Bag bag = new Bag();
		
		bag.set(new Note());
		Note note = (Note) bag.get();
		
		bag.set("신운하");
		String name = (String) bag.get();
		
		
		// 제네릭 사용
		Box<Note, String, Integer> box = new Box<>();
		
		box.setT(new Note());
		box.setV("홍길동");
		box.setK(500);
		
		Note memo = box.getT();
		int num = box.getK();
		String str = box.getV();
		
		Box<Car, Bus, Taxi> vehicle = new Box<>();
		vehicle.setT(new Car());
		vehicle.setK(new Taxi());
		vehicle.setV(new Bus());
		
		Car car = vehicle.getT();
		Bus bus = vehicle.getV();
		Taxi taxi = vehicle.getK();
				
		
		
	}

}



class Car{}
class Bus{}
class Taxi{}
