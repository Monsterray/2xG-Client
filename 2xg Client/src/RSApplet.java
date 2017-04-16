import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class RSApplet extends Applet implements Runnable, MouseListener,
		MouseMotionListener, KeyListener, FocusListener, WindowListener,
		MouseWheelListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515576602671576718L;

	public String titleText;

	public static int hotKey = 508;

	private int anInt4;

	private int delayTime;

	int minDelay;

	private final long timeArray[] = new long[10];

	int fps;

	boolean shouldDebug;

	int myWidth;

	int myHeight;

	Graphics graphics;

	RSImageProducer fullGameScreen;

	RSFrame gameFrame;

	private boolean shouldClearScreen;

	private boolean isApplet;

	boolean awtFocus;

	int idleTime;

	int clickMode2;

	public int mouseX;

	public int mouseY;

	private int clickMode1;

	private int clickX;

	private int clickY;

	private long clickTime;

	int clickMode3;

	int saveClickX;

	int saveClickY;

	long aLong29;

	final int keyArray[] = new int[128];

	private final int charQueue[] = new int[128];

	private int readIndex;

	private int writeIndex;

	public static int anInt34;

	public int resizeWidth;

	public int resizeHeight;

	RSApplet() {
		System.out.println("[DEBUG] Created an RSApplet");
		titleText = "";
		delayTime = 20;
		minDelay = 1;
		shouldDebug = false;
		shouldClearScreen = true;
		awtFocus = true;
	}

	void cleanUpForQuit() {
	}

	final void createClientFrame(int Height, int Width) {
		System.out.println("[DEBUG] Creating a Client Frame");
		isApplet = false;
		myWidth = Width;
		myHeight = Height;
		gameFrame = new RSFrame(this, myWidth, myHeight);
		graphics = getGameComponent().getGraphics();
		fullGameScreen = new RSImageProducer(myWidth, myHeight,
				getGameComponent());
		startRunnable(this, 1);
	}

	@Override
	public final void destroy() {
		anInt4 = -1;
		try {
			Thread.sleep(5000L);
		} catch (Exception exception) {
		}
		if (anInt4 == -1) {
			exit();
		}
	}

	void drawLoadingText(int percentage, String loadingText) {
		boolean createdByApplet = isApplet && myWidth == 765;
		while (graphics == null) {
			graphics = ((Component) (createdByApplet ? this : gameFrame))
					.getGraphics();
			try {
				getGameComponent().repaint();
			} catch (Exception exception) {
				System.out.println("[Failed] getGameComponent().repaint();");
			}
			try {
				Thread.sleep(1000L);
			} catch (Exception exception1) {
				System.out.println("[Failed] to sleep");
			}
		}
		Font font = new Font("Helvetica", 1, 13);
		FontMetrics fontmetrics = getGameComponent().getFontMetrics(font);
		Font font1 = new Font("Helvetica", 0, 13);
		FontMetrics fontmetrics1 = getGameComponent().getFontMetrics(font1);
		if (shouldClearScreen) {
			graphics.setColor(Color.black);
			graphics.fillRect(0, 0, myWidth, myHeight);
			shouldClearScreen = false;
		}
		Color color = new Color(140, 17, 17);
		int y = myHeight / 2 - 18;
		graphics.setColor(color);
		graphics.drawRect(myWidth / 2 - 152, y, 304, 34);
		graphics.fillRect(myWidth / 2 - 150, y + 2, percentage * 3, 30);
		graphics.setColor(Color.black);
		graphics.fillRect((myWidth / 2 - 150) + percentage * 3, y + 2,
				300 - percentage * 3, 30);
		graphics.setFont(font);
		graphics.setColor(Color.white);
		graphics.drawString(loadingText,
				(myWidth - fontmetrics.stringWidth(loadingText)) / 2, y + 22);
		graphics.drawString(titleText,
				(myWidth - fontmetrics1.stringWidth(titleText)) / 2, y - 8);
	}

	private void exit() {
		System.out.println("[EXIT] at RSApplet.exit()");
		anInt4 = -2;
		cleanUpForQuit();
		if (gameFrame != null) {
			try {
				Thread.sleep(1000L);
			} catch (Exception exception) {
				System.out.println("[Failed] to sleep");
			}
			try {
				System.exit(0);
			} catch (Throwable throwable) {

			}
		}
	}

	@Override
	public final void focusGained(FocusEvent focusevent) {
		awtFocus = true;
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	@Override
	public final void focusLost(FocusEvent focusevent) {
		awtFocus = false;
		for (int i = 0; i < 128; i++) {
			keyArray[i] = 0;
		}
	}

	Component getGameComponent() { // not called, the one in client is called
									// though
		if (gameFrame != null) {
			System.out.println("[INFO] Useing gameFrame");
			return gameFrame;
		} else {
			System.out.println("[INFO] Useing this");
			return this;
		}
	}

	final void initClientFrame(int Height, int Width) {
		System.out.println("[DEBUG] Initilizing Client Frame");
		isApplet = true;
		myWidth = Width;
		myHeight = Height;
		graphics = getGameComponent().getGraphics();
		fullGameScreen = new RSImageProducer(myWidth, myHeight,
				getGameComponent());
		startRunnable(this, 1);
	}

	@Override
	public final void keyPressed(KeyEvent keyevent) {
		idleTime = 0;
		int i = keyevent.getKeyCode();
		int j = keyevent.getKeyChar();
		if (i == 68) {
			if (KeyEvent.getKeyModifiersText(keyevent.getModifiers()).contains(
					"Ctrl")) {
				client.newDamage = !client.newDamage;
				if (client.newDamage) {
					JOptionPane
							.showMessageDialog(
									null,
									"You are now using the new damage system (Hits are multiplied by 10).",
									"Tyrena Client", 1);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"You are now using the old damage system (Hits are not multiplied by 10).",
									"Tyrena Client", 1);
				}
			}
		}
		if (hotKey == 508) {
			if (client.functionKeys) {
				if (i == 27) {
					client.setTab(3);
				} else if (i == 112) {
					client.setTab(0);
				} else if (i == 113) {
					client.setTab(1);
				} else if (i == 114) {
					client.setTab(2);
				} else if (i == 115) {
					client.setTab(3);
				} else if (i == 116) {
					client.setTab(4);
				} else if (i == 117) {
					client.setTab(5);
				} else if (i == 118) {
					client.setTab(6);
				} else if (i == 119) {
					client.setTab(7);
				} else if (i == 120) {
					client.setTab(8);
				} else if (i == 121) {
					client.setTab(9);
				} else if (i == 122) {
					client.setTab(10);
				} else if (i == 123) {
					client.setTab(11);
				}
			} else if (i == 27) {
				client.setTab(3);
			} else if (i == 112) {
				client.setTab(3);
			} else if (i == 113) {
				client.setTab(4);
			} else if (i == 114) {
				client.setTab(5);
			} else if (i == 115) {
				client.setTab(6);
			} else if (i == 116) {
				client.setTab(0);
			}
		} else if (i == 27) {
			client.setTab(0);
		} else if (i == 112) {
			client.setTab(3);
		} else if (i == 113) {
			client.setTab(1);
		} else if (i == 114) {
			client.setTab(2);
		} else if (i == 115) {
			client.setTab(3);
		} else if (i == 116) {
			client.setTab(4);
		} else if (i == 117) {
			client.setTab(5);
		} else if (i == 118) {
			client.setTab(6);
		} else if (i == 119) {
			client.setTab(7);
		} else if (i == 120) {
			client.setTab(8);
		} else if (i == 121) {
			client.setTab(9);
		} else if (i == 122) {
			client.setTab(10);
		} else if (i == 123) {
			client.setTab(11);
		}
		if (j < 30) {
			j = 0;
		}
		if (i == 37) {
			j = 1;
		}
		if (i == 39) {
			j = 2;
		}
		if (i == 38) {
			j = 3;
		}
		if (i == 40) {
			j = 4;
		}
		if (i == 17) {
			j = 5;
		}
		if (i == 8) {
			j = 8;
		}
		if (i == 127) {
			j = 8;
		}
		if (i == 9) {
			j = 9;
		}
		if (i == 10) {
			j = 10;
		}
		if (i >= 112 && i <= 123) {
			j = (1008 + i) - 112;
		}
		if (i == 36) {
			j = 1000;
		}
		if (i == 35) {
			j = 1001;
		}
		if (i == 33) {
			j = 1002;
		}
		if (i == 34) {
			j = 1003;
		}
		if (j > 0 && j < 128) {
			keyArray[j] = 1;
		}
		if (j > 4) {
			charQueue[writeIndex] = j;
			writeIndex = writeIndex + 1 & 0x7f;
		}
	}

	@Override
	public final void keyReleased(KeyEvent keyevent) {
		idleTime = 0;
		int i = keyevent.getKeyCode();
		char c = keyevent.getKeyChar();
		if (c < '\036') {
			c = '\0';
		}
		if (i == 37) {
			c = '\001';
		}
		if (i == 39) {
			c = '\002';
		}
		if (i == 38) {
			c = '\003';
		}
		if (i == 40) {
			c = '\004';
		}
		if (i == 17) {
			c = '\005';
		}
		if (i == 8) {
			c = '\b';
		}
		if (i == 127) {
			c = '\b';
		}
		if (i == 9) {
			c = '\t';
		}
		if (i == 10) {
			c = '\n';
		}
		if (c > 0 && c < '\200') {
			keyArray[c] = 0;
		}
	}

	@Override
	public final void keyTyped(KeyEvent keyevent1) {
	}

	final void method4(int i) {
		delayTime = 1000 / i;
	}

	@Override
	public final void mouseClicked(MouseEvent mouseevent1) {
	}

	@Override
	public final void mouseDragged(MouseEvent mouseevent) {
		int i = mouseevent.getX();
		int j = mouseevent.getY();
		if (gameFrame != null) {
			Insets insets = gameFrame.getInsets();
			i -= insets.left;
			j -= insets.top;
		}
		idleTime = 0;
		mouseX = i;
		mouseY = j;
	}

	@Override
	public final void mouseEntered(MouseEvent mouseevent1) {
	}

	@Override
	public final void mouseExited(MouseEvent mouseevent) {
		idleTime = 0;
		mouseX = -1;
		mouseY = -1;
	}

	@Override
	public final void mouseMoved(MouseEvent mouseevent) {
		int i = mouseevent.getX();
		int j = mouseevent.getY();
		if (gameFrame != null) {
			Insets insets = gameFrame.getInsets();
			i -= insets.left;
			j -= insets.top;
		}
		idleTime = 0;
		mouseX = i;
		mouseY = j;
	}

	@Override
	public final void mousePressed(MouseEvent mouseevent) {
		int i = mouseevent.getX();
		int j = mouseevent.getY();
		if (gameFrame != null) {
			Insets insets = gameFrame.getInsets();
			i -= insets.left;
			j -= insets.top;
		}
		idleTime = 0;
		clickX = i;
		clickY = j;
		clickTime = System.currentTimeMillis();
		if (mouseevent.isMetaDown()) {
			clickMode1 = 2;
			clickMode2 = 2;
		} else {
			clickMode1 = 1;
			clickMode2 = 1;
		}
	}

	@Override
	public final void mouseReleased(MouseEvent mouseevent) {
		idleTime = 0;
		clickMode2 = 0;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		int rotation = event.getWheelRotation();
		if (mouseX > 0 && mouseX < 512
				&& mouseY > 342 + client.getChatBackIncreaseY()) {
			int i = client.anInt1089;
			i -= rotation * 30;
			if (i < 0) {
				i = 0;
			}
			if (i > client.chatScrollTotalLength - 110) {
				i = client.chatScrollTotalLength - 110;
			}
			if (client.anInt1089 != i) {
				client.anInt1089 = i;
				client.inputTaken = true;
			}
		}
		if (mouseY > 210 && mouseY < 473 && mouseX > 514 && mouseX < 762
				|| mouseX > 0 && mouseX < 512 && mouseY > 0 && mouseY < 334) {
			if (client.tabInterfaceIDs[client.tabID] == 638) {
				RSInterface.interfaceCache[639].scrollPosition += rotation * 30;
			}
			if (client.openInterfaceID == 5292) {
				RSInterface.interfaceCache[5385].scrollPosition += rotation * 30;
			}
			if (client.openInterfaceID == 22760) {
				RSInterface.interfaceCache[22767].scrollPosition += rotation * 30;
			}
			if (client.openInterfaceID == 147) {
				RSInterface.interfaceCache[148].scrollPosition += rotation * 30;
			}
		}
	}

	@Override
	public final void paint(Graphics g) {
		if (graphics == null) {
			graphics = g;
		}
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	void processDrawing() {
		System.out.println("[INFO] Processed drawing");
	}

	void processGameLoop() {
		System.out.println("[INFO] Processed a game loop");
	}

	void raiseWelcomeScreen() {
		System.out.println("trololol welcome back");
	}

	final int readChar(int dummy) {
		while (dummy >= 0) {
			for (int j = 1; j > 0; j++) {
				;
			}
		}
		int k = -1;
		if (writeIndex != readIndex) {
			k = charQueue[readIndex];
			readIndex = readIndex + 1 & 0x7f;
		}
		return k;
	}

	final int readCharacter() {
		int k = -1;
		if (writeIndex != readIndex) {
			k = charQueue[readIndex];
			readIndex = readIndex + 1 & 0x7f;
		}
		return k;
	}

	public void recreateClientFrame(boolean decorative, int width, int height,
			boolean resizable) { // fourth hit is this for fullscreen
		System.out.println();
		System.out.println("[DEBUG] ~~~recreateClientFrame()~~~");
		boolean createdByApplet = isApplet && width == 765;
		System.out.println("[INFO] createdByApplet: " + createdByApplet);
		System.out.println("[INFO] width: " + width);
		System.out.println("[INFO] height: " + height);
		System.out.println();
		myWidth = width;
		myHeight = height;
		if (gameFrame != null) {
			System.out.println("[DEBUG] gameframe.dispose()");
			gameFrame.dispose();
		}
		if (!createdByApplet) {
			gameFrame = new RSFrame(this, width, height, decorative, resizable);
			gameFrame.addWindowListener(this);
		}
		graphics = ((Component) (createdByApplet ? this : gameFrame))
				.getGraphics();
		getGameComponent().addMouseWheelListener(this);
		getGameComponent().addMouseListener(this);
		getGameComponent().addMouseMotionListener(this);
		getGameComponent().addKeyListener(this);
		getGameComponent().addFocusListener(this);
	}

	/**
	 * this is called when the thread.start(); is called
	 */
	@Override
	public void run() { //
		System.out.println("[DEBUG] RS APPLET Running");
		getGameComponent().addMouseWheelListener(this);
		getGameComponent().addMouseListener(this);
		getGameComponent().addMouseMotionListener(this);
		getGameComponent().addKeyListener(this);
		getGameComponent().addFocusListener(this);
		if (gameFrame != null) {
			gameFrame.addWindowListener(this);
		}
		drawLoadingText(0, "Loading...");
		startUp();
		int i = 0;
		int j = 256;
		int k = 1;
		int l = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < 10; j1++) {
			timeArray[j1] = System.currentTimeMillis();
		}
		// long l1 = System.currentTimeMillis();
		do {
			if (anInt4 < 0) {
				break;
			}
			if (anInt4 > 0) {
				anInt4--;
				if (anInt4 == 0) {
					exit();
					return;
				}
			}
			int k1 = j;
			int i2 = k;
			j = 300;
			k = 1;
			long l2 = System.currentTimeMillis();
			if (timeArray[i] == 0L) {
				j = k1;
				k = i2;
			} else if (l2 > timeArray[i]) {
				j = (int) ((2560 * delayTime) / (l2 - timeArray[i]));
			}
			if (j < 25) {
				j = 25;
			}
			if (j > 256) {
				j = 256;
				k = (int) (delayTime - (l2 - timeArray[i]) / 10L);
			}
			if (k > delayTime) {
				k = delayTime;
			}
			timeArray[i] = l2;
			i = (i + 1) % 10;
			if (k > 1) {
				for (int j2 = 0; j2 < 10; j2++) {
					if (timeArray[j2] != 0L) {
						timeArray[j2] += k;
					}
				}
			}
			if (k < minDelay) {
				k = minDelay;
			}
			try {
				Thread.sleep(k);
			} catch (InterruptedException e) {
				i1++;
			}
			for (; l < 256; l += j) {
				clickMode3 = clickMode1;
				saveClickX = clickX;
				saveClickY = clickY;
				aLong29 = clickTime;
				clickMode1 = 0;
				processGameLoop();
				readIndex = writeIndex;
			}
			l &= 0xff;
			if (delayTime > 0) {
				fps = (1000 * j) / (delayTime * 256);
			}
			processDrawing();
			if (shouldDebug) {
				System.out.println((new StringBuilder()).append("ntime:")
						.append(l2).toString());
				for (int k2 = 0; k2 < 10; k2++) {
					int i3 = ((i - k2 - 1) + 20) % 10;
					System.out.println((new StringBuilder()).append("otim")
							.append(i3).append(":").append(timeArray[i3])
							.toString());
				}
				System.out.println((new StringBuilder()).append("fps:")
						.append(fps).append(" ratio:").append(j)
						.append(" count:").append(l).toString());
				System.out.println((new StringBuilder()).append("del:")
						.append(k).append(" deltime:").append(delayTime)
						.append(" mindel:").append(minDelay).toString());
				System.out.println((new StringBuilder()).append("intex:")
						.append(i1).append(" opos:").append(i).toString());
				shouldDebug = false;
				i1 = 0;
			}
		} while (true);
		if (anInt4 == -1) {
			exit();
		}
	}

	@Override
	public final void start() {
		System.out.println("[DEBUG] RS APPLET Started");
		if (anInt4 >= 0) {
			anInt4 = 0;
		}
	}

	public void startRunnable(Runnable runnable, int i) {
		System.out.println("[DEBUG] Starting Runnanble");
		Thread thread = new Thread(runnable);
		thread.start();
		thread.setPriority(i);
	}

	void startUp() {
		System.out.println("[INFO] Started Up");
	}

	@Override
	public final void stop() {
		System.out.println("[DEBUG] RS APPLET Stoped");
		if (anInt4 >= 0) {
			anInt4 = 4000 / delayTime;
		}
	}

	@Override
	public final void update(Graphics g) {
		if (graphics == null) {
			graphics = g;
		}
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	@Override
	public final void windowActivated(WindowEvent windowevent1) {
	}

	@Override
	public final void windowClosed(WindowEvent windowevent1) {
	}

	@Override
	public final void windowClosing(WindowEvent windowevent) {
		destroy();
	}

	@Override
	public final void windowDeactivated(WindowEvent windowevent1) {
	}

	@Override
	public final void windowDeiconified(WindowEvent windowevent1) {
	}

	@Override
	public final void windowIconified(WindowEvent windowevent1) {
	}

	@Override
	public final void windowOpened(WindowEvent windowevent1) {
	}
}
