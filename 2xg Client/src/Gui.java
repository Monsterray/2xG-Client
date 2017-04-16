import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
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
import javax.swing.JLabel;
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
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import sign.signlink;
import theme.BlackTheme;

public class Gui extends client implements ActionListener, MouseListener,
		MouseMotionListener, KeyListener, FocusListener, WindowListener,
		MouseWheelListener {
	private static final long serialVersionUID = 7411442203970959046L;

	public static void main(String[] args) { // first thing called
		System.out.println("GUI.main called");
		System.out.println(System.getProperty("java.class.path"));
		if (args[0].equalsIgnoreCase("mid player")) {
			new Gui("debug");
		}
		theArgs = args;
		if (!args[1].equalsIgnoreCase("gui")) {
			new Gui(args);
//			theClient(theArgs, new Gui());
		} else {
			theClient(theArgs, new Gui());
		}
	}

	private boolean drawTabs;

	public Gui() {

	}

	private Gui(String s) {
		musicPlayer("play", signlink.findcachedir() + "Mp3/Music/", null);
	}

	public Gui(String args[]) { // second thing called
		System.out.println("GUI initilizer called");
		drawToolbar = theArgs[2].equalsIgnoreCase("ToolBar") || theArgs[2].equalsIgnoreCase("Both");
		drawTabs = theArgs[2].equalsIgnoreCase("Tabbed") || theArgs[2].equalsIgnoreCase("Both");
		
		musicPlayer("play", signlink.findcachedir() + "Mp3/Music/", "jingle1.mid");
		instance = this;
		MetalLookAndFeel.setCurrentTheme(new BlackTheme());
		try {
			tab = new JTabbedPane();
			frame = new JFrame(frameTitle);
			// UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceMagmaLookAndFeel");
			setCornerIcon("images/advisor 0.png");
			setCursor("images/Cursors/standard.png", "normal");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			try {
				sign.signlink.startpriv(InetAddress.getLocalHost()); // WAS:
																		// sign.signlink.startpriv(InetAddress.getByName(serverip));
			} catch (Exception e) {
				System.out.println("[Error] Address Error");
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
			frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
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
	// private ImageIcon info = createImageIcon("images/pfi.png");
	// private ImageIcon lice = createImageIcon("images/licence.png");
	private JMenuBar topMenuBar;
	private JPanel splashPanel;
	private JPanel gamePanel;
	// private JTextArea aboutArea = new JTextArea();
	// private JTextArea licenceArea = new JTextArea();
	private JTextArea textArea = new JTextArea();
	private MP3Player player;
	public int midiCount;
	public Sequencer sequencer;
	
	private static String[] theArgs;
	boolean drawToolbar;
	public String frameTitle = "2xG V3.4 || By Monsterray";
	public static String frameSTitle = "2xG V3.4 || By Monsterray";
	public String fileName = "splash.png";
	private int splashDuration = 5000;
	private Dimension appletDimensions = new Dimension(765, 503);
	public Dimension screenSize;
	public int screenWidth;
	public int screenHeight;
	private static boolean isApplet = false;
	// public int theme;
	protected JScrollPane scrollPane;

	// private JTabbedPane jTabbedPane1;
	public JFrame frame;
	public Toolkit toolkit;
	public Gui instance;
	public int myWidth;
	public int myHeight;
	// private Graphics graphics;
	// private BufferedImage frameImage;
	private BufferedImage tmp;

	private JFileChooser fileChooser;

	private JDialog fileDialog;

	private int dialogSelectionType;
	private Utilitys utils = new Utilitys();

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
	
//				case "Blue":
//					try {
//						UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel");
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					break;
//	
//				case "Black":
//					try {
//						UIManager.setLookAndFeel("theme.blackTheme");
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					break;
//	
//				case "Red":
//					try {
//						UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceMagmaLookAndFeel");
//						// UIManager.setLookAndFeel("theme.RedTheme");
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					break;
//	
//				case "Green":
//					initLookAndFeel();
////					try {
//////						UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel");
////						UIManager.setLookAndFeel("theme.GreenTheme");
////					} catch (Exception e) {
////						e.printStackTrace();
////					}
//					break;
//	
//				case "White":
//					try {
//						UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceCremeLookAndFeel");
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					break;
//	
//				case "Grey":
//					try {
//						UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel");
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					break;
//	
//				case "Dark Grey":
//					try {
//						UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel");
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					break;
				
				case "White":
				case "Grey":
				case "Dark Grey":
				case "Black":
				case "Red":
				case "Green":
				case "Blue":
					changeTheme(cmd);
					break;
	
				case "Object IDs":
					if (isApplet) {
						// checkIDs();
						new Xml$((new StringBuilder()).append("C:/2xGCache/").append("all_IDs/Objects.xml").toString());
					} else {
						new Xml$("all_IDs/Objects.xml");
					}
					break;
	
				case "Save Screenshot":
				case "Screenshot":
					createFileWindow(1, "../", "Save Screenshot");
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
	
				case "ApproveSelection":
					File file = fileChooser.getSelectedFile();
					if (dialogSelectionType == 1) {
						if (file != null && file.isFile()) {
							int i = JOptionPane.showConfirmDialog(
									frame,
									(new StringBuilder())
											.append(file.getAbsolutePath())
											.append(" already exists.\n"
													+ "Do you want to replace it?")
											.toString(), "Save Screenshot", 2);
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
	
				default:
					System.out.println("[ERROR] You clicked on: " + cmd + " which doesn't have a case!");
					break;
			}
		}
	}

	public void changeTheme(String theme){
		try {
		//	UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel");
			MetalLookAndFeel.setCurrentTheme(new BlackTheme());
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    for(Window window : JFrame.getWindows()) {
	        SwingUtilities.updateComponentTreeUI(window);
	    }
	}
	
	private void centerWindow() {
		toolkit = Toolkit.getDefaultToolkit();
		screenSize = toolkit.getScreenSize();
		screenWidth = (int) screenSize.getWidth();
		screenHeight = (int) screenSize.getHeight();
		frame.setLocation((screenWidth - (int) appletDimensions.getWidth()) / 2, (screenHeight - (int) appletDimensions.getHeight()) / 2);
	}

	private JMenuBar addMenuBar(JMenuBar menuBar) {
		menuBar.add(createButtonTab("File", new String[] { "Open File",
				"Save Screenshot", "-", "Vote", "Donate", "Forums", "-",
				"Item List", "World Map", "-", "Exit" }));
// 		menuBar.add(createButtonTab("Test", new String[] {"World Map"}));
//		menuBar.add(createButtonTab("Themes", utils.getLookandFeelNames(utils.listInstalledLaFs())));
		menuBar.add(createButtonTab("Themes", new String[] { "Blue", "Black/White", "Green", "Red", "White", "Grey", "Dark Grey" }));
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

	public JButton createButton(String buttonName, String buttonCommandName) {
		JButton button = new JButton(buttonName);
		button.setActionCommand(buttonCommandName);
		button.addActionListener(this);
		return button;
	}

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

	public JDialog createDialog(Component comp, String title, Container container) {
		JDialog jdialog = new JDialog(frame, title, true);
		jdialog.setDefaultCloseOperation(2);
		jdialog.add(comp);
		jdialog.pack();
		jdialog.setLocationRelativeTo(container);
		return jdialog;
	}

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

	public void createFileWindow(int saveing, String defaultPath, String title) {
		tmp = getFrameImage();
		// ImageFileFilter filter = new ImageFileFilter();
		fileChooser = createFileChooser(defaultPath, saveing);
		fileChooser.addActionListener(this);
		fileDialog = createDialog(fileChooser, title, this);
		fileDialog.setVisible(true);
	}

	public String getCacheDir() {
		return signlink.findcachedir();
	}

	public BufferedImage getFrameImage() {
		BufferedImage image;
		try {
			Robot robot = new Robot();
			Point point = getLocationOnScreen();
			Rectangle rectangle = new Rectangle(point.x, point.y, getWidth(),
					getHeight());
			image = robot.createScreenCapture(rectangle);
		} catch (Throwable throwable) {
			JOptionPane.showMessageDialog(frame,
					"An error occured while trying to create a screenshot!",
					"Screenshot Error", 0);
			return null;
		}
		return image;
	}

	@Override
	public void launchURL(String s) {
		String s1 = System.getProperty("os.name");
		try {
			if (s1.startsWith("Windows")) {
				Runtime.getRuntime()
						.exec((new StringBuilder())
								.append("rundll32 url.dll,FileProtocolHandler ")
								.append(s).toString());
			} else {
				String as[] = { "firefox", "opera", "konqueror", "epiphany",
						"mozilla", "netscape" };
				String s2 = null;
				for (int i = 0; i < as.length && s2 == null; i++) {
					if (Runtime.getRuntime()
							.exec(new String[] { "which", as[i] }).waitFor() == 0) {
						s2 = as[i];
					}
				}
				if (s2 == null) {
					throw new Exception("Could not find web browser");
				}
				Runtime.getRuntime().exec(new String[] { s2, s });
			}
		} catch (Exception exception) {
			System.out.println("An error occured while trying to open the web browser!\n");
		}
	}

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

	@SuppressWarnings("static-access")
	public void recreateGUIFrame(boolean undecorative, int width, int height,
			boolean resizable, int displayMode) {
		System.out.println("displayMode: " + displayMode);
		main3DAreaWidth = instance.getScreenWidth();
		main3DAreaHeight = instance.getScreenHeight();
		super.load3DArea();
		recreateClientFrame(undecorative, width, height, resizable);

		main3DArea = new RSImageProducer(main3DAreaWidth, main3DAreaHeight,
				getGameComponent());

		super.mouseX = super.mouseY = -1;
	}

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

	public void showSplash() {
		System.out.println("GUI.showSplash called");
		try {
			splashPanel = (JPanel) frame.getContentPane();

			Image img = new ImageIcon(fileName).getImage();

			int width = img.getWidth(null);
			int height = img.getHeight(null);
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (screen.width - width) / 2;
			int y = (screen.height - height) / 2;

			frame.setBounds(x, y, width, height);
			JLabel label = new JLabel(new ImageIcon(fileName));
			splashPanel.setOpaque(false);
			label.setOpaque(false);
			splashPanel.add(label, BorderLayout.CENTER);
			frame.setVisible(true);
			/**
			 * Sleep can be replaced with various loadings.
			 */
			try {
				Thread.sleep(splashDuration);
			} catch (Exception e) {

			}
			frame.setVisible(false);
		} catch (NullPointerException nE) {
			System.out.println("[FAILED] Couldn't find the splash image");
		} catch (Exception e) {

		}
	}

	public void takeScreenshot(String directory) {
		try {
			(new File(directory)).mkdir();
			Thread.sleep(1000L);
			Window window = KeyboardFocusManager
					.getCurrentKeyboardFocusManager().getFocusedWindow();
			Point point = window.getLocationOnScreen();
			int i = (int) point.getX();
			int j = (int) point.getY();
			int k = window.getWidth();
			int l = window.getHeight();
			Robot robot = new Robot(window.getGraphicsConfiguration()
					.getDevice());
			Rectangle rectangle = new Rectangle(i, j, k, l);
			java.awt.image.BufferedImage bufferedimage = robot
					.createScreenCapture(rectangle);
			int i1 = (int) (Math.random() * 100);
			File file = new File((new StringBuilder()).append(directory + "/")
					.append(i1).append(".png").toString());
			ImageIO.write(bufferedimage, "png", file);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
	
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

	public static String getNearestScreenshotFilename(String directory) throws IOException {
		File file = new File(directory);
		int i = 0;
		do {
			String s = " .png";
			if (i < 10) {
				s = s.replaceFirst(" ", " 000"+ i);
			} else if (i < 100) {
				s = s.replaceFirst(" "," 00"+ i);
			} else if (i < 1000) {
				s = s.replaceFirst(" ", " 0"+ i);
			} else if (i < 10000) {
				s = s.replaceFirst(" ", " "+ i);
			}
			if ((new File(file, s)).isFile()) {
				i++;
			} else {
				return s;
			}
		} while (i < 10000);
		return null;
	}

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