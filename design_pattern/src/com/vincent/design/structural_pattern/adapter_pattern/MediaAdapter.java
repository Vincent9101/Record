package com.vincent.design.structural_pattern.adapter_pattern;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author Vincent
 *         <p>
 *         这是还适配器类
 *         </p>
 * 
 */

public class MediaAdapter implements MediaPlayer {

	private static Properties mediaTypeProperites;
	static {

		mediaTypeProperites = new Properties();
		InputStream inputStream = MediaAdapter.class.getClassLoader().getResourceAsStream("media_type.properties");

		try {
			mediaTypeProperites.load(inputStream);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private AdvancedMediaPlayer advancedMediaPlayer;

	public MediaAdapter(String audioType) {

		try {

			advancedMediaPlayer = (AdvancedMediaPlayer) Class.forName(mediaTypeProperites.getProperty(audioType))
					.newInstance();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		String playerName = null;
		if (advancedMediaPlayer != null) {
			playerName = advancedMediaPlayer.getClass().toString();

			if (audioType.equals(playerName.substring(playerName.lastIndexOf(".") + 1, playerName.length() - 6))
					&& audioType.equals("Vlc")) {
				advancedMediaPlayer.playVlc(fileName);
			} else
				advancedMediaPlayer.playMp4(fileName);
		}
	}

}
