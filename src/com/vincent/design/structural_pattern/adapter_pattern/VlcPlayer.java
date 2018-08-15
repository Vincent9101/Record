package com.vincent.design.structural_pattern.adapter_pattern;

public class VlcPlayer implements AdvancedMediaPlayer{

	public VlcPlayer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub
		System.out.println("VlcPlayer is playing "+fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub
		
	}

}
