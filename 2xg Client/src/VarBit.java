public final class VarBit {

	public static VarBit cache[];

	public static void unpackConfig(StreamLoader streamLoader) {
		Stream stream = new Stream(streamLoader.getDataForName("varbit.dat"));
		int cacheSize = stream.readUnsignedWord();
		if (cache == null) {
			cache = new VarBit[cacheSize];
		}
		for (int j = 0; j < cacheSize; j++) {
			if (cache[j] == null) {
				cache[j] = new VarBit();
			}
			cache[j].readValues(stream);
			if (cache[j].aBoolean651) {
				Varp.cache[cache[j].anInt648].aBoolean713 = true;
			}
		}
		if (stream.currentOffset != stream.buffer.length) {
			System.out.println("varbit load mismatch");
		}
	}

	public int anInt648;

	public int anInt649;
	public int anInt650;
	private boolean aBoolean651;

	private VarBit() {
		aBoolean651 = false;
	}

	private void readValues(Stream stream) {
		do {
			int j = stream.readUnsignedByte();
			if (j == 0) {
				return;
			}
			if (j == 1) {
				anInt648 = stream.readUnsignedWord();
				anInt649 = stream.readUnsignedByte();
				anInt650 = stream.readUnsignedByte();
			} else if (j == 10) {
				stream.readString();
			} else if (j == 2) {
				aBoolean651 = true;
			} else if (j == 3) {
				stream.readDWord();
			} else if (j == 4) {
				stream.readDWord();
			} else {
				System.out.println((new StringBuilder())
						.append("Error unrecognised config code: ").append(j)
						.toString());
			}
		} while (true);
	}
}
