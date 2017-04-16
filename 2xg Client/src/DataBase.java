import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;

import sign.signlink;

public final class DataBase {

	public static byte allFrames[][] = new byte[7000][];

	public static byte allSkinlist[][] = new byte[7000][];

	private static String getDir() {
		return signlink.findcachedir();
	}

	public static void loadAnimations() {
		int i = 0;
		try {
			GZIPInputStream gzipDataFile = new GZIPInputStream(
					new FileInputStream((new StringBuilder()).append(getDir())
							.append("/frames.dat").toString()));
			DataInputStream dataFile = new DataInputStream(gzipDataFile);
			GZIPInputStream gzipIndexFile = new GZIPInputStream(
					new FileInputStream((new StringBuilder()).append(getDir())
							.append("/frames.idx").toString()));
			DataInputStream indexFile = new DataInputStream(gzipIndexFile);
			int length = indexFile.readInt();
			for (i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte data[] = new byte[invlength];
				dataFile.readFully(data);
				allFrames[id] = data;
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			GZIPInputStream gzipDataFile = new GZIPInputStream(
					new FileInputStream((new StringBuilder()).append(getDir())
							.append("/skinlist.dat").toString()));
			DataInputStream dataFile = new DataInputStream(gzipDataFile);
			GZIPInputStream gzipIndexFile = new GZIPInputStream(
					new FileInputStream((new StringBuilder()).append(getDir())
							.append("/skinlist.idx").toString()));
			DataInputStream indexFile = new DataInputStream(gzipIndexFile);
			int length = indexFile.readInt();
			for (i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte data[] = new byte[invlength];
				dataFile.readFully(data);
				allSkinlist[id] = data;
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadModels() {
		int i = 0;
		try {
			GZIPInputStream gzipDataFile = new GZIPInputStream(
					new FileInputStream((new StringBuilder()).append(getDir())
							.append("/models.dat").toString()));
			DataInputStream dataFile = new DataInputStream(gzipDataFile);
			GZIPInputStream gzipIndexFile = new GZIPInputStream(
					new FileInputStream((new StringBuilder()).append(getDir())
							.append("/models.idx").toString()));
			DataInputStream indexFile = new DataInputStream(gzipIndexFile);
			int length = indexFile.readInt();
			for (i = 0; i < length; i++) {
				int invlength = indexFile.readInt();
				byte data[] = new byte[invlength];
				dataFile.readFully(data);
			}
			indexFile.close();
			dataFile.close();
			System.gc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadObjects() {
		try {
			DataInputStream indexFile = new DataInputStream(
					new FileInputStream((new StringBuilder()).append(getDir())
							.append("/Data/object.idx").toString()));
			DataInputStream dataFile = new DataInputStream(new FileInputStream(
					(new StringBuilder()).append(getDir())
							.append("/Data/object.dat").toString()));
			int length = indexFile.readInt();
			for (int i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte[] data = new byte[invlength];
				dataFile.readFully(data);
				// System.out.println("ID: "+ id +" Length: "+ invlength
				// +" Data: "+ data);
				FileOperations.WriteFile("C:/2xGCache/modelz/" + id + ".dat",
						data);
				Model.method460(data, id);
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DataBase() {
		System.out.println("DataBase Loaded");
	}
}
