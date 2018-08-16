package com.vincent.design.structural_pattern.adapter_pattern.entity;

import com.vincent.design.structural_pattern.adapter_pattern.AdvancedMediaPlayer;

public class Mp4Player implements AdvancedMediaPlayer {

	public Mp4Player() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub
		System.out.println("Mp4Player is playing " + fileName);

	}

}
