package com.yedam.java.ch0801;

public class TvControl implements RemoteControl, SmartControl {

	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}

	@Override
	public void searchInternet(String url) {
		System.out.println(url + "을 검색합니다.");
	}

	@Override
	public void executeApp(String app) {
		System.out.println(app + "을 실행합니다.");
	}

}
