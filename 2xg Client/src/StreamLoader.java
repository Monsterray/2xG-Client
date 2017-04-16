// Decompiler options: packimports(3) 
// Source File Name:   StreamLoader.java

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

final class StreamLoader {

	private final byte aByteArray726[];

	/*
	 * public byte[] getDataForName(String s) { byte abyte0[] = null; int i = 0;
	 * s = s.toUpperCase(); for(int j = 0; j < s.length(); j++) i = (i * 61 +
	 * s.charAt(j)) - 32;
	 * 
	 * if(s.equalsIgnoreCase("NPC.DAT") || s.equalsIgnoreCase("NPC.IDX"))
	 * System.out.println((new
	 * StringBuilder()).append(s).append(" : ").append(i).toString()); for(int k
	 * = 0; k < dataSize; k++) if(anIntArray728[k] == i) { if(abyte0 == null)
	 * abyte0 = new byte[anIntArray729[k]]; if(!aBoolean732)
	 * Class13.method225(abyte0, anIntArray729[k], aByteArray726,
	 * anIntArray730[k], anIntArray731[k]); else System.arraycopy(aByteArray726,
	 * anIntArray731[k], abyte0, 0, anIntArray729[k]); return abyte0; }
	 * 
	 * return null; }
	 */// comment this method out, we'll try mine.ok

	private final int dataSize;

	private final int anIntArray728[];

	private final int anIntArray729[];
	private final int anIntArray730[];
	private final int anIntArray731[];
	private final boolean aBoolean732;

	public StreamLoader(byte abyte0[]) {
		Stream stream = new Stream(abyte0);
		int i = stream.read3Bytes();
		int j = stream.read3Bytes();
		if (j != i) {
			byte abyte1[] = new byte[i];
			Class13.method225(abyte1, i, abyte0, j, 6);
			aByteArray726 = abyte1;
			stream = new Stream(aByteArray726);
			aBoolean732 = true;
		} else {
			aByteArray726 = abyte0;
			aBoolean732 = false;
		}
		dataSize = stream.readUnsignedWord();
		anIntArray728 = new int[dataSize];
		anIntArray729 = new int[dataSize];
		anIntArray730 = new int[dataSize];
		anIntArray731 = new int[dataSize];
		int k = stream.currentOffset + dataSize * 10;
		for (int l = 0; l < dataSize; l++) {
			anIntArray728[l] = stream.readDWord();
			anIntArray729[l] = stream.read3Bytes();
			anIntArray730[l] = stream.read3Bytes();
			anIntArray731[l] = k;
			k += anIntArray730[l];
		}

	}

	public byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		if (length <= 0x7fffffffL) {
			;
		}
		byte bytes[] = new byte[(int) length];
		int offset = 0;
		for (int numRead = 0; offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0; offset += numRead) {
			;
		}
		if (offset < bytes.length) {
			is.close();
			throw new IOException((new StringBuilder()).append("Could not completely read file ").append(file.getName()).toString());
		} else {
			is.close();
			return bytes;
		}
	}

	public byte[] getDataForName(String s) {
		byte abyte0[] = null; // was a parameter
		int i = 0;
		s = s.toUpperCase();
		for (int j = 0; j < s.length(); j++) {
			i = (i * 61 + s.charAt(j)) - 32;
		}

		for (int k = 0; k < dataSize; k++) {
			if (anIntArray728[k] == i) {
				if (abyte0 == null) {
					abyte0 = new byte[anIntArray729[k]];
				}
				if (!aBoolean732) {
					Class13.method225(abyte0, anIntArray729[k], aByteArray726,
							anIntArray730[k], anIntArray731[k]);
				} else {
					System.arraycopy(aByteArray726, anIntArray731[k], abyte0,
							0, anIntArray729[k]);

				}
				return abyte0;
			}
		}

		return null;
	}
}
