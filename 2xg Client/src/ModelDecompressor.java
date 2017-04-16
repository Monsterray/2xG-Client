import java.io.DataInputStream;
import java.io.FileInputStream;

public class ModelDecompressor {

	public static void loadModels() {
		try {
			DataInputStream indexFile = new DataInputStream(
					new FileInputStream(
							"C:/1InsanityX/Data/474ObjectModels.idx"));
			DataInputStream dataFile = new DataInputStream(new FileInputStream(
					"C:/1InsanityX/Data/474ObjectModels.dat"));
			int length = indexFile.readInt();// shudnt it be like that
			for (int i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte[] data = new byte[invlength];
				dataFile.readFully(data);
				System.out.println("ID: " + id + " Length: " + invlength
						+ " Data: " + data);
				Model.method460(data, id);
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}