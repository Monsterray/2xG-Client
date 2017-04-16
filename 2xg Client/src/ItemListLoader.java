import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import sign.signlink;

/**
 * @Author Monsterray
 */
public class ItemListLoader implements ActionListener, KeyListener {
	private String[] itemName;
	private String[] itemID;
	private JTextArea namePanel;
	private JTextArea idPanel;
	private JTextArea searchPanel;
	public String listFolder = signlink.findcachedir() + "/";
	public String listLocation = signlink.findcachedir() + "/ItemList.dat";
	private boolean first = true;

	public String[] keyStringStuff;

	public ItemListLoader() {
		do {
			if (new File(listLocation).exists()) {
				new ItemListLoader(listLocation);
				first = false;
			} else {
				System.out.println("Please wait, the list is being written.");
				File localFile = new File(listFolder);
				localFile.mkdir();
				getList();
				System.out.println("Successfully downloaded item list");
			}
		} while (first);
	}

	public ItemListLoader(String paramString) {
		this.itemName = new String[30000];
		this.itemID = new String[30000];
		File localFile = new File(paramString);
		localFile.getName();
		try {
			DataInputStream localDataInputStream = new DataInputStream(
					new FileInputStream(localFile));
			readStream(localDataInputStream);
		} catch (IOException e) {
			e.printStackTrace();
			System.out
					.println("Failed to load file! Report this problem on the forum");
			System.exit(-1);
		}
		initUI();
	}

	@Override
	public void actionPerformed(ActionEvent paramActionEvent) {
		search();
	}

	public void getList() {
		try {
			URL localURL = new URL(
					"https://dl.dropbox.com/s/zxzfv20zhgjo4tt/ItemList.dat");
			File localFile = new File(listLocation);
			InputStream localInputStream = localURL.openStream();
			FileOutputStream localFileOutputStream = new FileOutputStream(
					localFile);
			byte[] arrayOfByte = new byte[500];
			int i = 0;
			while ((i = localInputStream.read(arrayOfByte)) != -1) {
				localFileOutputStream.write(arrayOfByte, 0, i);
			}
			localFileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame localJFrame = new JFrame("525 Item list - By: Monsterray");
		localJFrame.setDefaultCloseOperation(2);
		localJFrame.getContentPane().setLayout(new BorderLayout());
		this.namePanel = new JTextArea();
		this.namePanel.setEditable(false);
		this.idPanel = new JTextArea();
		this.idPanel.setEditable(false);
		localJFrame.setResizable(false);
		JPanel localJPanel1 = new JPanel(new FlowLayout());
		localJPanel1.add(this.namePanel);
		localJPanel1.add(this.idPanel);
		JScrollPane localJScrollPane = new JScrollPane(localJPanel1, 22, 31);
		localJScrollPane.setPreferredSize(new Dimension(280, 503));
		int i = 0;
		String str = "\n";
		for (int j = 0; (j < this.itemName.length)
				&& (this.itemName[j] != null); j++) {
			if (i != 0) {
				this.namePanel.append(str + this.itemName[j]);
				this.idPanel.append(str + this.itemID[j]);
			} else {
				i = 1;
				this.namePanel.append(this.itemName[j]);
				this.idPanel.append(this.itemID[j]);
			}
		}
		JButton localJButton = new JButton("Search");
		localJButton.addActionListener(this);
		this.searchPanel = new JTextArea();
		this.searchPanel.addKeyListener(this);
		this.searchPanel.setLineWrap(false);
		this.searchPanel.setRows(1);
		this.searchPanel.setColumns(9);
		JPanel localJPanel2 = new JPanel(new FlowLayout());
		localJPanel2.add(this.searchPanel);
		localJPanel2.add(localJButton);
		localJFrame.getContentPane().add(localJScrollPane, "Center");
		localJFrame.getContentPane().add(localJPanel2, "South");
		localJFrame.pack();
		localJFrame.setVisible(true);
		this.searchPanel.requestFocus();
	}

	@Override
	public void keyPressed(KeyEvent paramKeyEvent) { // actualy receaves the key
														// presses
		if (paramKeyEvent.getKeyCode() == 10) {
			search();
		}
	}

	@Override
	public void keyReleased(KeyEvent paramKeyEvent) { // actualy receaves the
														// key releases
		if (paramKeyEvent.getKeyCode() == 10) {
			this.searchPanel.setText(this.searchPanel.getText().replace("\n",
					""));
		}
	}

	@Override
	public void keyTyped(KeyEvent paramKeyEvent) { // actualy receaves the key
													// strocks
		keyStringStuff = paramKeyEvent.paramString().split(",");
		System.out.println("You pressed the " + paramKeyEvent.getKeyChar());
	}

	private void readStream(DataInputStream paramDataInputStream)
			throws IOException {
		DataInputStream localDataInputStream = paramDataInputStream;
		int i = 0;
		while (true) {
			int j = localDataInputStream.readShort();
			if (j == -1) {
				break;
			}
			this.itemID[i] = String.valueOf(j);
			this.itemName[i] = localDataInputStream.readUTF();
			i++;
		}
	}

	private void search() {
		String str1 = this.searchPanel.getText();
		this.namePanel.setText("");
		this.idPanel.setText("");
		int i = 0;
		String str2 = "\n";
		for (int j = 0; (j < this.itemName.length)
				&& (this.itemName[j] != null); j++) {
			if (this.itemName[j].toLowerCase().contains(str1.toLowerCase())) {
				if (i != 0) {
					this.namePanel.append(str2 + this.itemName[j]);
					this.idPanel.append(str2 + this.itemID[j]);
				} else {
					i = 1;
					this.namePanel.append(this.itemName[j]);
					this.idPanel.append(this.itemID[j]);
				}
			}
		}
		if (this.namePanel.getText().equals("")) {
			this.namePanel.setText("No Results Found");
		}
	}
}