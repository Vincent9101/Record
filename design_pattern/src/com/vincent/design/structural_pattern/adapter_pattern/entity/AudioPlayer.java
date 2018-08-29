package com.vincent.design.structural_pattern.adapter_pattern.entity;

import com.vincent.design.structural_pattern.adapter_pattern.MediaAdapter;
import com.vincent.design.structural_pattern.adapter_pattern.MediaPlayer;

/**
 * 
 * @author Vincent
 * 
 *
 */
public class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdapter;

	public AudioPlayer(MediaAdapter mediaAdapterParam) {
		// TODO Auto-generated constructor stub
		mediaAdapter = mediaAdapterParam;
	}

	public AudioPlayer() {
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		
	
		if (audioType.equals("mp3")) {
			System.out.println("MP3 我觉得还OKAY");
		} else if (audioType.equals("Vlc") || audioType.equals("Mp4")) {
			mediaAdapter=new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}
		else {
			System.out.println("我觉得不行");
		}

	}

}
