import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class SoundProvider {

	public static SoundProvider getSingleton() {
		return instance = instance != null ? instance : new SoundProvider();
	}

	public Sequencer midiSequencer;

	private Sequence midiSequence;

	private static SoundProvider instance = null;

	protected SoundProvider() {
		try {
			midiSequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playMIDI(byte data[]) {
		if (!midiSequencer.isOpen()) {
			try {
				midiSequencer.open();
			} catch (MidiUnavailableException e1) {
			}
		}
		if (midiSequencer.isRunning()) {
			midiSequencer.stop();
		}
		try {
			midiSequence = MidiSystem.getSequence(new BufferedInputStream(
					new ByteArrayInputStream(data)));
			midiSequencer.setLoopCount(-1);
			midiSequencer.setSequence(midiSequence);
		} catch (InvalidMidiDataException e) {
		} catch (IOException e) {
		}
		midiSequencer.start();
	}

	public void stopMIDI() {
		midiSequencer.stop();
	}
}
