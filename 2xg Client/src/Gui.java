

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import sign.signlink;

public class Gui extends Client implements ActionListener, MouseListener,
		MouseMotionListener, KeyListener, FocusListener, WindowListener,
		MouseWheelListener {
	private static final long serialVersionUID = 7411442203970959046L;

	public static void main(String[] args) { // first thing called
		System.out.println("GUI.main called");
//		System.out.println(System.getProperty("java.class.path"));
		if (args[0].equalsIgnoreCase("mid player")) {
			new Gui("debug");
		}
		if (!args[1].equalsIgnoreCase("gui")) {
			new Gui(args);
//			theClient(theArgs, new Gui());
		} else {
			theClient(args);
		}
	}

	private boolean drawTabs;

	public Gui() {

	}

	private Gui(String s) {
		musicPlayer("play", signlink.findcachedir() + "Mp3/Music/", null);
	}

	public Gui(String args[]) { // second thing called
		List<String> argList = Arrays.asList(args);
		System.out.println("GUI initilizer called");
		drawToolbar = argList.contains("-toolbar") || argList.contains("-both");
		drawTabs = argList.contains("-tabbed") || argList.contains("-both");
		if(!argList.contains("-musicoff"))
			musicPlayer("play", signlink.findcachedir() + "Mp3/Music/", "jingle1.mid");
		instance = this;
		try {
			UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		try {
			tab = new JTabbedPane();
			frame = new JFrame(frameTitle);
			setCornerIcon("images/advisor 0.png");
			setCursor("images/Cursors/standard.png", "normal");
			try {
				sign.signlink.startpriv(InetAddress.getLocalHost()); // WAS:
																		// sign.signlink.startpriv(InetAddress.getByName(serverip));
			} catch (Exception e) {
				System.out.println("[Error] SignLink Address Error");
				e.printStackTrace();
			}
			initUI();
		} catch (Exception e) {
			System.out.println("FAIL: " + e.toString());
			e.printStackTrace();
		}
	}

	private void initUI() {
		System.out.println("GUI.initUI called");
		try {
			// signlink.mainapp
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);

			frame.setLayout(new BorderLayout());
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//showSplash();
			frame.getContentPane().removeAll();

			gamePanel = new JPanel();
			gamePanel.setLayout(new BorderLayout());
			gamePanel.add(this);
			gamePanel.setPreferredSize(appletDimensions);
			centerWindow();

			/*
			 * try{ editorPane = new
			 * JEditorPane("http://www.liberty.issaquah.wednet.edu/");
			 * }catch(Exception e){
			 * 
			 * }
			 */
			textArea.setBackground(new Color(166, 166, 166));
			textArea = readTabInfo("../Version.txt", textArea);
			// aboutArea = readTabInfo("./cba.txt", aboutArea);
			// licenceArea = readTabInfo("./asd.txt", licenceArea);

			JScrollPane scrollText = new JScrollPane(textArea);
			// JScrollPane webscroll = new JScrollPane(editorPane);
			// JScrollPane Aboutscroll = new JScrollPane(aboutArea);
			// JScrollPane Licencescroll = new JScrollPane(licenceArea);
			textArea = new JTextArea();
			// aboutArea = new JTextArea();
			// licenceArea = new JTextArea();

			tab = new JTabbedPane();
			tab.putClientProperty("substancelaf.tabbedpanehasclosebuttons", true);

			if (drawToolbar) {
				topMenuBar = new JMenuBar();
				topMenuBar = addMenuBar(topMenuBar);
				frame.getContentPane().add(topMenuBar, BorderLayout.NORTH);
			}
			
			if (drawTabs) {
				frame.getContentPane().add(tab, BorderLayout.CENTER);
				tab.addTab("Game", gameIcon, gamePanel, "Your Game Panel");
				tab.setMnemonicAt(0, 49);
				tab.addTab("Version info", aboutIcon, scrollText,
						"Version Info");
				// tab.addTab("About Us", about2, aboutArea, "About us");
				// tab.addTab("License agreement", lice, licenceArea,
				// "License");
				// tab.addTab("webscroll", lice, webscroll, "webscroll");
				// tab.addTab("Aboutscroll", lice, Aboutscroll, "Aboutscroll");
				// tab.addTab("Licencescroll", lice, Licencescroll,
				// "Licencescroll");
			}else{
				frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
			}

			frame.setVisible(true);
			frame.setResizable(false);
			frame.pack();
			frame.getContentPane().addContainerListener(
					new ContainerListener() {
						@Override
						public void componentAdded(ContainerEvent e) {
							frame.pack();
						}

						@Override
						public void componentRemoved(ContainerEvent e) {
							frame.pack();
						}
					});

			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JTabbedPane tab;
	// private JEditorPane editorPane;
	private ImageIcon gameIcon = createImageIcon("images/command.gif");

	private ImageIcon aboutIcon = createImageIcon("images/about.png");
	private JMenuBar topMenuBar;
	private JPanel gamePanel;
	private JTextArea textArea = new JTextArea();
	private MP3Player player;
	public int midiCount;
	public Sequencer sequencer;
	
	boolean drawToolbar;
	public String frameTitle = "2xG V3.4 || By Monsterray";
	public static String frameSTitle = "2xG V3.4 || By Monsterray";
	private Dimension appletDimensions = new Dimension(765, 503);
	public Dimension screenSize;
	public int screenWidth;
	public int screenHeight;
	private static boolean isApplet = false;
	protected JScrollPane scrollPane;

	public JFrame frame;
	public Toolkit toolkit;
	public Gui instance;
	public int myWidth;
	public int myHeight;

	private JFileChooser fileChooser;

	private JDialog fileDialog;

	private int dialogSelectionType;
	private Utilitys utils = new Utilitys();
	private BufferedImage tmp;

	@Override
	public void actionPerformed(ActionEvent evt) {
		String cmd = evt.getActionCommand();
		if (cmd != null) {
			int index = tab.indexOfTabComponent(Gui.this);
			if (index != -1) {
				tab.remove(index);
			}
			System.out.println("You clicked on: " + cmd);
			switch (cmd) {
				case "Forums":
					launchURL("www.2xgng.iftopic.com/forum");
					break;
	
				case "Vote":
					launchURL("www.2xgng.iftopic.com");
					break;
	
				case "Donate":
					launchURL("www.2xgng.iftopic.com/donate");
					break;
	
				case "Exit":
					@SuppressWarnings("unused")
					int i1;
					if ((i1 = JOptionPane.showConfirmDialog(this,
							"Do you really want to exit the client?")) == 0) {
						System.exit(0);
					}
					break;
	
				case "Item List":
					new ItemListLoader();
					System.out.println("Item List is Loading...");
					break;
	
				case "World Map":
					Runtime runtime = Runtime.getRuntime();
					try {
						Process p1 = runtime.exec("cmd /c start C:/2xGCache/MiniDeps/WorldMap/WM.bat");
						InputStream is = p1.getInputStream();
						int i = 0;
						while ((i = is.read()) != -1) {
							System.out.print((char) i);
						}
					} catch (IOException ioException) {
						System.out.println(ioException.getMessage());
					}
					System.out.println("World Map is loading...");
					break;
	
				case "Object IDs":
					if (isApplet) {
						// checkIDs();
						new Xml$((new StringBuilder()).append("C:/2xGCache/").append("all_IDs/Objects.xml").toString());
					} else {
						new Xml$("all_IDs/Objects.xml");
					}
					break;
	
				case "Debug":
					createFileWindow(0, "../", "Load testing");
					break;
	
				case "fullScreen":
					toolkit = Toolkit.getDefaultToolkit();
					screenSize = toolkit.getScreenSize();
					screenWidth = (int) screenSize.getWidth();
					screenHeight = (int) screenSize.getHeight();
					recreateGUIFrame(true, screenWidth, screenHeight, false, 1);
					break;
	
				case "Change Port":
					String port = JOptionPane.showInputDialog(this, "Server Port:",
							"");
					if (port == null) {
						JOptionPane.showMessageDialog(this,
								"You must specify a port.", "No port specified.",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
					int portInt = Integer.parseInt(port);
					super.port = portInt;
					break;
	
				case "change server":
					WorldSelect();
					break;

				case "Save Screenshot":
				case "Screenshot":
					tmp = getFrameImage(frame);
					createFileWindow(1, "../", "Save Screenshot");
					break;
	
				case "ApproveSelection":
					File file = fileChooser.getSelectedFile();
					if (dialogSelectionType == 1) {
						if (file != null && file.isFile()) {
							int i = JOptionPane.showConfirmDialog(
									frame, file.getAbsolutePath() + " already exists.\n" + "Do you want to replace it?", 
									"Save Screenshot", 2);
							if (i != 0) {
								return;
							}
						}
						try {
							ImageIO.write(tmp, "png", file);
						} catch (IOException ioexception2) {
							JOptionPane.showMessageDialog(frame, 
									"An error occured while trying to save the screenshot!\n" + 
									"Please make sure you have\n" + 
									" write access to the screenshot directory.",
									"Screenshot Error", 0);
						}
					} else {
						try {
							Desktop.getDesktop().open(file);
						} catch (IOException e) {
	
						}
					}
					fileDialog.dispose();
					break;
	
				case "CancelSelection":
					fileDialog.dispose();
					break;
	
				case "Original":
					setCursor("images/Cursors/standard.png", "normal");
					break;
				case "Scimitar":
				case "Longsword":
				case "Twohander":
				case "Halberd":
				case "Warspear":
				case "Godsword":
				case "Granite Maul":
				case "Sword":
				case "Guitar":
				case "Kenny":
				case "Pikachu":
				case "Normal Pointer":
				case "Wand":
					setCursor("images/Cursors/" + cmd + ".png", cmd);
					break;
					
				case "pause":
					musicPlayer("Stop", null, null);
					break;
					
				case "Display Classes":
					List<String> classes = null;
					try {
						classes = utils.getClassInJar("./theme/Theme.jar", "org.jvnet.substance.skin");
					} catch (IOException e) {
						e.printStackTrace();
					}
					for(String s : classes){
						if(s.contains("LookAndFeel")){
							String cleanedLAF = s.substring(s.lastIndexOf(".") + 1, s.length()).replace("Substance", "").replace("LookAndFeel", "").replaceAll("(.)([A-Z])", "$1 $2");
							System.out.println(cleanedLAF);
						}
					}
					break;
	
				default:
					testForThemeButtons(cmd);
					System.out.println("[ERROR] You clicked on: " + cmd);
					break;
			}
		}
	}

	public String getCacheDir() {
		return signlink.findcachedir();
	}

	public void changeTheme(String theme){
		try {
			UIManager.setLookAndFeel(theme);
//			MetalLookAndFeel.setCurrentTheme(new BlackTheme());
//			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    for(Window window : JFrame.getWindows()) {
	        SwingUtilities.updateComponentTreeUI(window);
	    }
	}

	/**
	 * This method gets all of the themes in the jar file at path and in the package packagePre.
	 * 
	 * @param path This is the path to the jar file to be searched
	 * @param packagePre This is the package you want class files to be listed from
	 * @return <strong>classNames</strong> Contains all the class files in the package chosen
	 * @throws IOException
	 */
	private String[] getThemes(String path, String packagePre){
		List<String> classes = null;
		try {
			classes = utils.getClassInJar(path, packagePre);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ListIterator<String> classIter = classes.listIterator();
		while(classIter.hasNext()){
			String currentS = classIter.next();
			if(currentS.contains("LookAndFeel")){
				String cleanedLAF = currentS
						.substring(currentS.lastIndexOf(".") + 1, currentS.length())
						.replace("Substance", "").replace("LookAndFeel", "").replaceAll("(.)([A-Z])", "$1 $2");
				classIter.set(cleanedLAF);
//				System.out.println(cleanedLAF);
			}else{
				classIter.remove();
			}
		}
		
		String[] result = new String[classes.size()];
		int i = 0;
		for(String s : classes){
			result[i] = s;
			i++;
		}
		return result;
	}
	
	private void testForThemeButtons(String button){
		String themeLocation = "org.jvnet.substance.skin";
		String[] themes = getThemes("./theme/Theme.jar", themeLocation);
		for(int i = 0; i < themes.length; i++){
			if(themes[i].equals(button)){
				changeTheme(themeLocation + ".Substance" + button.replace(" ", "") + "LookAndFeel");
				return;
			}
		}
	}
	
	/**
	 * Centers the applet in the center of the center
	 */
	private void centerWindow() {
		toolkit = Toolkit.getDefaultToolkit();
		screenSize = toolkit.getScreenSize();
		screenWidth = (int) screenSize.getWidth();
		screenHeight = (int) screenSize.getHeight();
		frame.setLocation((screenWidth - (int) appletDimensions.getWidth()) / 2, (screenHeight - (int) appletDimensions.getHeight()) / 2);
	}

	/**
	 * @param menuBar
	 * @return
	 */
	private JMenuBar addMenuBar(JMenuBar menuBar) {
		menuBar.add(createButtonTab("File", new String[] { "Open File",
				"Save Screenshot", "-", "Vote", "Donate", "Forums", "-",
				"Item List", "World Map", "Object IDs", "-", "Exit" }));
 		menuBar.add(createButtonTab("Test", new String[] {"Display Classes"}));
//		menuBar.add(createButtonTab("Themes", new String[] { "Blue", "Black/White", "Green", "Red", "White", "Grey", "Dark Grey" }));
		menuBar.add(createButtonTab("Themes", getThemes("./theme/Theme.jar", "org.jvnet.substance.skin")));
		menuBar.add(createButtonTab("Cursor", new String[] { "Scimitar",
				"Longsword", "Twohander", "Halberd", "Warspear", "Godsword",
				"Granite Maul", "Sword", "Original", "Guitar", "Kenny",
				"Pikachu", "Normal Pointer", "Wand" }));
		menuBar.add(createButton("Screenshot", "Screenshot"));
		menuBar.add(createButton("Full Screen", "fullScreen"));
		menuBar.add(createButton("Test Function", "Debug"));
		menuBar.add(createButton("||>", "pause"));
		return menuBar;
	}

	/**
	 * @param buttonName
	 * @param buttonCommandName
	 * @return
	 */
	public JButton createButton(String buttonName, String buttonCommandName) {
		JButton button = new JButton(buttonName);
		button.setActionCommand(buttonCommandName);
		button.addActionListener(this);
		return button;
	}

	/**
	 * @param tabName
	 * @param subTabNames
	 * @return
	 */
	public JMenu createButtonTab(String tabName, String[] subTabNames) {
		JMenu Menu;
		try {
			Menu = new JMenu(tabName);
			for (String name : subTabNames) {
				JMenuItem menuItem = new JMenuItem(name);
				if (name.equalsIgnoreCase("-")) {
					Menu.addSeparator();
				} else {
					menuItem.addActionListener(this);
					Menu.add(menuItem);
				}
			}
			return Menu;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param comp
	 * @param title
	 * @param container
	 * @return
	 */
	public JDialog createDialog(Component comp, String title, Container container) {
		JDialog jdialog = new JDialog(frame, title, true);
		jdialog.setDefaultCloseOperation(2);
		jdialog.add(comp);
		jdialog.pack();
		jdialog.setLocationRelativeTo(container);
		return jdialog;
	}

	/**
	 * @param cmd
	 * @param fileDir
	 * @param songName
	 */
	public void musicPlayer(String cmd, String fileDir, String songName) {
		// String fileDir = FileDIR;// signlink.findcachedir() +"Mp3/Music/";
		if (player != null && player.isRunning()) {
			player.close();
		}
		if (sequencer != null && sequencer.isRunning()) {
			sequencer.stop();
			sequencer.close();
		}
		if (cmd.equals("Next")) {
			midiCount++;
		} else if (cmd.equals("Previous")) {
			midiCount--;
		} else if (!cmd.equals("Stop")) {
			File file;
			try{
				file = new File(fileDir);
			}catch(Exception e){
				file = null;
			}
			String songList[] = file.list();
			if (songName != null) {
				for (int i = 0; i <= songList.length - 1; i++) {
					if (songList[i].equals(songName)) {
						midiCount = i;
						break;
					}
				}
			}
			if (songList.length > 0) {
				if (midiCount > songList.length - 1) {
					midiCount = 0;
				}
				if (midiCount < 0) {
					midiCount = songList.length - 1;
				}
				if (songList[midiCount].endsWith(".mp3")) {
					System.err.println("Playing " + songList[midiCount]);
					player = new MP3Player(fileDir + songList[midiCount], true);
				} else if (songList[midiCount].endsWith(".mid")) {
					System.err.println("Playing " + songList[midiCount]);
					try {
						File file1 = new File(fileDir + songList[midiCount]);
						sequencer = MidiSystem.getSequencer();
						sequencer.setSequence(MidiSystem.getSequence(file1));
						if (sequencer.getMicrosecondLength() <= 5000000) {
							midiCount++;
							file1 = new File(fileDir + songList[midiCount]);
							sequencer = MidiSystem.getSequencer();
							sequencer.setSequence(MidiSystem.getSequence(file1));
						}
						sequencer.setLoopCount(1);
						sequencer.open();
						sequencer.start();
					} catch (MidiUnavailableException midiunavailableexception) {
						System.err.println("[WARNING] Midi device unavailable!");
					} catch (InvalidMidiDataException invalidmididataexception) {
						System.err.println("[WARNING] Invalid Midi data!");
					} catch (IOException ioexception) {
						System.err.println("[WARNING] I/O Error!");
					}
				} else if (songList[midiCount].endsWith(".wma")) {
					System.err.println("[INFO] Sorry .wma files are not suported");
				} else {
					System.err.println();
					System.err.println("[DEBUG] ~~~Failed to play item~~~");
					System.err.println("[DEBUG] midiCount: " + midiCount);
					System.err.println("[DEBUG] fileDir: " + fileDir);
					System.err.println("[DEBUG] cmd: " + cmd);
					System.err.println("[DEBUG] songList.length: "+ songList.length);
					System.err.println("[DEBUG] song name: "+ songList[midiCount]);
					System.err.println("[DEBUG] ~~~~~~~~~~~~~~~~~~~~~~~~~");
				}
			} else {
				System.err.println("[WARNING] No midi or mp3 files in folder");
			}
		}
	}

	/**
	 * @param path
	 * @param jta
	 * @return
	 */
	public JTextArea readTabInfo(String path, JTextArea jta) {
		BufferedReader objectFile = null;
		try {
			objectFile = new BufferedReader(new FileReader(path));
			jta.read(objectFile, null);
			return jta;
		} catch (FileNotFoundException fileex) {
			fileex.printStackTrace();
			System.out.println(path + ": not found.");
			return null;
		} catch (NullPointerException nullE) {
			nullE.printStackTrace();
			System.out.println(path + ": is null");
			return null;
		} catch (IOException ioe) {
			System.out.println("IO Error: " + path);
			return null;
		}
	}

	/**
	 * @param undecorative
	 * @param width
	 * @param height
	 * @param resizable
	 * @param displayMode
	 */
	@SuppressWarnings("static-access")
	public void recreateGUIFrame(boolean undecorative, int width, int height, boolean resizable, int displayMode) {
		System.out.println("displayMode: " + displayMode);
		main3DAreaWidth = instance.getScreenWidth();
		main3DAreaHeight = instance.getScreenHeight();
		super.load3DArea();
		recreateClientFrame(undecorative, width, height, resizable);

		main3DArea = new RSImageProducer(main3DAreaWidth, main3DAreaHeight,
				getGameComponent());

		super.mouseX = super.mouseY = -1;
	}

	/**
	 * @param path
	 */
	public void setCornerIcon(String path) {
		try {
			if ((new File(path)).isFile()) {
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(path));
			} else {
				System.out.println("Can't Find the icon at: " + path);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't Find the icon at: " + path);
		}
	}

	/**
	 * @param path
	 * @param name
	 */
	public void setCursor(String path, String name) {
		try {
			toolkit = Toolkit.getDefaultToolkit();
			Point point = new Point(0, 0);
			URL url = getClass().getResource(path);
			Image image = toolkit.getImage(url);
			Cursor cursor = toolkit.createCustomCursor(image, point, name);
			frame.setCursor(cursor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param path
	 * @return
	 */
	protected static ImageIcon createImageIcon(String path) {
		try {
			// URL imgURL = Gui.class.getResource(path);
			if (path != null) {
				return new ImageIcon(path);
			} else {
				System.err.println("Couldn't find file: " + path);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't find file: " + path);
		}
		return null;
	}

	/**
	 * @param defaultPath
	 * @param dialogType
	 * @return
	 */
	public JFileChooser createFileChooser(String defaultPath, int dialogType) {
		JFileChooser fChooser;
		try {
			fChooser = new JFileChooser(); // creates a JFileChooser
			fChooser.setFileSelectionMode(0); // either files(0) or folders(1)
			fChooser.addChoosableFileFilter(new ImageFileFilter()); // sets the filter in the drop down menu bar for extension types
			fChooser.setCurrentDirectory(new File(defaultPath)); // sets the directory the chooser begins in
			String title = ((int) (Math.random() * 100)) + ".png"; // gets a random name for the file, will change this later
			fChooser.setSelectedFile(new File(title)); // sets the
			fChooser.setDialogType(dialogType); // either opening(0) or saveing(1)
			dialogSelectionType = dialogType; // sets my variable to tell if the user is loading or saveing
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[Failed] to create FileChooser");
			return null;
		}
		return fChooser;
	}

	/**
	 * @param saveing
	 * @param defaultPath
	 * @param title
	 * @return
	 */
	public void createFileWindow(int saveing, String defaultPath, String title) {
		// ImageFileFilter filter = new ImageFileFilter();
		fileChooser = createFileChooser(defaultPath, saveing);
		fileChooser.addActionListener(this);
		fileDialog = createDialog(fileChooser, title, this);
		fileDialog.setVisible(true);
	}


	/**
	 * @param screenToCapture
	 * @return
	 */
	public BufferedImage getFrameImage(Component screenToCapture) {
		BufferedImage image;
		try {
			Robot robot = new Robot();
			Point point = screenToCapture.getLocationOnScreen();
			Rectangle rectangle = new Rectangle(point.x, point.y, screenToCapture.getWidth(), screenToCapture.getHeight());
			image = robot.createScreenCapture(rectangle);
		} catch (Throwable throwable) {
			JOptionPane.showMessageDialog(frame,
					"An error occured while trying to create a screenshot!",
					"Screenshot Error", 0);
			return null;
		}
		return image;
	}

	/**
	 * 
	 */
	public void WorldSelect() {
		try {
			String s1 = JOptionPane.showInputDialog(this,
					(new StringBuilder()).append("Current server:"),
					"Enter Server", 3);
			if (s1 == null) {
				System.out.println("Canceled");
			} else if (s1.equalsIgnoreCase("")) {
				System.out.println("Sorry, have to have some input");
			} else {
				System.out.println((new StringBuilder())
						.append("Set world to: ").append(s1).toString());
			}
		} catch (Exception e) {
			System.out.println((new StringBuilder())
					.append("You must enter a numeric value!: ").append(e)
					.toString());
		}
	}

//	/**
//	 * @param directory
//	 * @return
//	 * @throws IOException
//	 */
//	public static String getNearestScreenshotFilename(String directory) throws IOException {
//		File file = new File(directory);
//		int i = 0;
//		do {
//			String s = " .png";
//			if (i < 10) {
//				s = s.replaceFirst(" ", " 000"+ i);
//			} else if (i < 100) {
//				s = s.replaceFirst(" "," 00"+ i);
//			} else if (i < 1000) {
//				s = s.replaceFirst(" ", " 0"+ i);
//			} else if (i < 10000) {
//				s = s.replaceFirst(" ", " "+ i);
//			}
//			if ((new File(file, s)).isFile()) {
//				i++;
//			} else {
//				return s;
//			}
//		} while (i < 10000);
//		return null;
//	}
//
//	public void takeScreenshot(String directory) {	//Wasn't even used anymore 4/17/17
//		try {
//			(new File(directory)).mkdir();
//			Thread.sleep(1000L);
//			Window window = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusedWindow();
//			Point point = window.getLocationOnScreen();
//			int i = (int) point.getX();
//			int j = (int) point.getY();
//			int k = window.getWidth();
//			int l = window.getHeight();
//			Robot robot = new Robot(window.getGraphicsConfiguration().getDevice());
//			Rectangle rectangle = new Rectangle(i, j, k, l);
//			java.awt.image.BufferedImage bufferedimage = robot.createScreenCapture(rectangle);
//			int i1 = (int) (Math.random() * 100);
//			File file = new File(directory + "/" + i1 + ".png");
//			ImageIO.write(bufferedimage, "png", file);
//		} catch (Exception exception) {
//			System.out.println(exception.getMessage());
//		}
//	}
//	
//	@Override
//	public void launchURL(String s) {	//Not sure if this is even needed there is the same thing in Client Class 4/17/17
//		String s1 = System.getProperty("os.name");
//		try {
//			if (s1.startsWith("Windows")) {
//				Runtime.getRuntime()
//						.exec((new StringBuilder())
//								.append("rundll32 url.dll,FileProtocolHandler ")
//								.append(s).toString());
//			} else {
//				String as[] = { "firefox", "opera", "konqueror", "epiphany",
//						"mozilla", "netscape" };
//				String s2 = null;
//				for (int i = 0; i < as.length && s2 == null; i++) {
//					if (Runtime.getRuntime()
//							.exec(new String[] { "which", as[i] }).waitFor() == 0) {
//						s2 = as[i];
//					}
//				}
//				if (s2 == null) {
//					throw new Exception("Could not find web browser");
//				}
//				Runtime.getRuntime().exec(new String[] { s2, s });
//			}
//		} catch (Exception exception) {
//			System.out.println("An error occured while trying to open the web browser!\n");
//		}
//	}

//	public void showSplash() {	//Not used just using the built in java splash display 4/17/17
//		System.out.println("GUI.showSplash called");
//		try {
//			splashPanel = (JPanel) frame.getContentPane();
//
//			Image img = new ImageIcon(fileName).getImage();
//
//			int width = img.getWidth(null);
//			int height = img.getHeight(null);
//			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//			int x = (screen.width - width) / 2;
//			int y = (screen.height - height) / 2;
//
//			frame.setBounds(x, y, width, height);
//			JLabel label = new JLabel(new ImageIcon(fileName));
//			splashPanel.setOpaque(false);
//			label.setOpaque(false);
//			splashPanel.add(label, BorderLayout.CENTER);
//			frame.setVisible(true);
//			/**
//			 * Sleep can be replaced with various loadings.
//			 */
//			try {
//				Thread.sleep(splashDuration);
//			} catch (Exception e) {
//
//			}
//			frame.setVisible(false);
//		} catch (NullPointerException nE) {
//			System.out.println("[FAILED] Couldn't find the splash image");
//		} catch (Exception e) {
//
//		}
//	}

	/*
	 * public void recreateGUIFrame(boolean undecorative, int width, int height,
	 * boolean resizable, int displayMode) { main3DAreaWidth = (displayMode ==
	 * 1) ? 512 : instance.getScreenWidth(); main3DAreaHeight = (displayMode ==
	 * 1) ? 334 : instance.getScreenHeight(); super.load3DArea();
	 * instance.recreateClientFrame(undecorative,width,height,resizable);
	 * System.out.println("displayMode: " + displayMode);
	 * 
	 * main3DArea = new RSImageProducer(main3DAreaWidth, main3DAreaHeight,
	 * getGameComponent());
	 * 
	 * super.mouseX = super.mouseY = -1; }
	 */

	/*
	 * public void recreateClientFrame(boolean decorative, int width, int
	 * height, boolean resizable){ boolean createdByApplet = isApplet && width
	 * == 765; myWidth = width; myHeight = height; if(gameFrame != null)
	 * gameFrame.dispose(); if(!createdByApplet){ gameFrame = new RSFrame(this,
	 * width, height, decorative, resizable); gameFrame.addWindowListener(this);
	 * } graphics = ((Component) (createdByApplet ? this :
	 * gameFrame)).getGraphics();
	 * getGUIGameComponent().addMouseWheelListener(this);
	 * getGUIGameComponent().addMouseListener(this);
	 * getGUIGameComponent().addMouseMotionListener(this);
	 * getGUIGameComponent().addKeyListener(this);
	 * getGUIGameComponent().addFocusListener(this); }
	 * 
	 * private Component getGUIGameComponent(){ if(gameFrame != null) return
	 * gameFrame; else return this; }
	 */
}