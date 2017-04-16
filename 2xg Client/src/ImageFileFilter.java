import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ImageFileFilter extends FileFilter {

	ImageFileFilter() {

	}

	@Override
	public boolean accept(File file) {
		String s = file.getName();
		return file.isDirectory() || s.toLowerCase().endsWith(".png")
				&& s.indexOf("$") == -1;
	}

	@Override
	public String getDescription() {
		return "PNG (*.png)";
	}
}