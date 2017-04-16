import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;

final class RSFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8419229512160408612L;

	private final RSApplet rsApplet;

	public Toolkit toolkit;

	public Dimension screenSize;

	public int screenWidth;

	public int screenHeight;

	public RSFrame(RSApplet rsapplet) {
		toolkit = Toolkit.getDefaultToolkit(); // creates a toolkit
		screenSize = toolkit.getScreenSize(); // gets a Dimension of the screen
		screenWidth = (int) screenSize.getWidth(); // gets screen width
		screenHeight = (int) screenSize.getHeight(); // gets screen height
		rsApplet = rsapplet;
	}

	public RSFrame(RSApplet rsapplet, int width, int height) {
		this(rsapplet, width, height, false, false);
	}

	public RSFrame(RSApplet rsapplet, int width, int height,
			boolean undecorative, boolean resizable) {
		toolkit = Toolkit.getDefaultToolkit(); // creates a toolkit
		screenSize = toolkit.getScreenSize(); // gets a Dimension of the screen
		screenWidth = (int) screenSize.getWidth(); // gets screen width
		screenHeight = (int) screenSize.getHeight(); // gets screen height

		rsApplet = rsapplet;
		setTitle(Gui.frameSTitle);

		setUndecorated(undecorative);
		setResizable(resizable);
		setVisible(true);

		Insets insets = getInsets();
		setSize(width + insets.left + insets.right, height + insets.top
				+ insets.bottom); // changes the size of the window

		setLocation((screenWidth - width) / 2, (screenHeight - height) / 2); // centers
																				// the
																				// window

		requestFocus(); // these to things bring the thing to the front
		toFront(); //
	}

	public int getFrameHeight() {
		Insets insets = getInsets();
		return getHeight() - (insets.top + insets.bottom);
	}

	public int getFrameWidth() {
		Insets insets = getInsets();
		return getWidth() - (insets.left + insets.right);
	}

	@Override
	public Graphics getGraphics() {
		Graphics g = super.getGraphics();
		Insets insets = getInsets();
		g.translate(insets.left, insets.top);
		return g;
	}

	@Override
	public void paint(Graphics g) {
		rsApplet.paint(g);
	}

	@Override
	public void update(Graphics g) {
		rsApplet.update(g);
	}
}
