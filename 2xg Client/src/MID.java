import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MID {
	// test client
	public static void main(String[] args) {
		String filename = args[0];
		MID mid = new MID(filename);
		mid.play();
		// do whatever computation you like, while music plays
		int N = 4000;
		double sum = 0.0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += Math.sin(i + j);
			}
		}
		System.out.println(sum);
		// when the computation is done, stop playing it
		mid.close();
		// play from the beginning
		mid = new MID(filename);
		mid.play();
	}

	private String filename;

	private Player player;

	/**
	 * constructor that takes the name of an MID file
	 */
	public MID(String filename) {
		this.filename = filename;
	}

	public void close() {
		if (player != null) {
			player.close();
		}
	}

	public void close2() {

	}

	/**
	 * Plays the MID file to the sound card
	 */
	public void play() {
		try {
			FileInputStream fis = new FileInputStream(filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println("Problem playing file " + filename);
			System.out.println(e);
		}
		// run in new thread to play in background
		new Thread() {
			@Override
			public void run() {
				try {
					player.play();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}.start();
	}

}