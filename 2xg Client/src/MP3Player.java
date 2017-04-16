import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3Player extends Thread {
	private String filename;
	private Player mp3Player;
	private boolean started;
	private boolean loop;

	public MP3Player(String paramString, boolean paramBoolean) {
		this.filename = paramString;
		setLoop(paramBoolean);
		start();
	}

	public void close() {
		setLoop(false);
		this.mp3Player.close();
	}

	public boolean isRunning() {
		return this.started;
	}

	@Override
	public void run() {
		try {
			this.started = true;
			while (this.loop) {
				this.mp3Player = new Player(new FileInputStream(new File(
						this.filename)));
				this.mp3Player.play();
			}
		} catch (Exception localException) {
			System.out.println("MP3 player error!");
		}
		this.started = false;
	}

	public void setLoop(boolean paramBoolean) {
		this.loop = paramBoolean;
	}
}