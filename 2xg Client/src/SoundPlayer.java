import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

public class SoundPlayer implements Runnable {

	private AudioInputStream stream;
	private DataLine.Info info;
	private Clip soundeffect;

	private InputStream musicfile;
	private Thread player;

	private int volumeType;

	public SoundPlayer(InputStream musicfile, int volume) {
		this.musicfile = musicfile;
		this.volumeType = volume;
		player = new Thread(this);
		player.start();
	}

	@Override
	public void run() {
		try {
			stream = AudioSystem.getAudioInputStream(musicfile); // Creates the
																	// stream
																	// from the
																	// stored
																	// sound
																	// file in
																	// the
																	// client
			info = new DataLine.Info(Clip.class, stream.getFormat());

			soundeffect = (Clip) AudioSystem.getLine(info);
			soundeffect.open(stream); // Reads the stream
			if (soundeffect.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
				double[] volumes = { 0.0, 0.25, 0.5, 0.75, 1.0 };
				float dB = (float) (Math.log(volumes[volumeType])
						/ Math.log(10.0) * 20.0);
				FloatControl pan = (FloatControl) soundeffect
						.getControl(FloatControl.Type.MASTER_GAIN);
				pan.setValue(dB);
			}
			soundeffect.start(); // Starts playing sound

			while (soundeffect.isActive()) {
				Thread.sleep(250);
			}
			Thread.sleep(10000); // allow sound to fully finsh

			soundeffect.close(); // Closes SoundPlayer
			stream.close(); // Closes Stream
			player.interrupt(); // Interrupts this thread to exit.

		} catch (Exception e) {
			player.interrupt();
			System.out.println("Error player sounds");
		}
	}
}