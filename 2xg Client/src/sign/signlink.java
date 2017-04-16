package sign;

import java.applet.Applet;
import java.io.*;
import java.net.*;

public final class signlink implements Runnable{

	private signlink(){
		
	}

	public static void startpriv(InetAddress inetaddress){ //fourth thing called
		threadliveid = (int)(Math.random() * 99999999D);
		if(active){
			try{
				Thread.sleep(500L);
			}catch(Exception _ex) {
				System.out.println("Failed to sleep");
			}
			active = false;
		}
		socketreq = 0;
		threadreq = null;
		dnsreq = null;
		savereq = null;
		urlreq = null;
		socketip = inetaddress;
		Thread thread = new Thread(new signlink());
		thread.setDaemon(true);
		thread.start();
		while(!active)
			try{
				Thread.sleep(50L);
			}catch(Exception _ex) {
				System.out.println("Failed to sleep");
			}
	}

	public static void setuid() {
		uid = 26342;
	}
	/**
	* this is called when the thread.start(); is called
	*/
	public void run(){
		active = true;
		String s = findcachedir();
		uid = getuid(s);
		System.out.println("UID: "+ uid);
		uid = 26342;
		try {
			cache_dat = new RandomAccessFile(s + "main_file_cache.dat", "rw");
			for(int j = 0; j < 5; j++) {
				cache_idx[j] = new RandomAccessFile(s + "main_file_cache.idx" + j, "rw");
			}
		} catch(Exception exception) {
			exception.printStackTrace();
			System.out.println("Failed at Sign.sighnlink.run()");
		}
		for(int i = threadliveid; threadliveid == i;){
			if(socketreq != 0){
				try{
					socket = new Socket(socketip, socketreq);
				}catch(Exception _ex){
					socket = null;
					System.out.println("[Failed] socket is now null");
				}
				socketreq = 0;
			} else if(threadreq != null){
				Thread thread = new Thread(threadreq);
				thread.setDaemon(true);
				thread.start();
				thread.setPriority(threadreqpri);
				threadreq = null;
			} else if(dnsreq != null){
				try{
					dns = InetAddress.getByName(dnsreq).getHostName();
				}catch(Exception _ex){
					dns = "unknown";
					System.out.println("[Failed] dns is unknown");
				}
				dnsreq = null;
			} else if(savereq != null){
				if(savebuf != null)
					try{
						FileOutputStream fileoutputstream = new FileOutputStream(s + savereq);
						fileoutputstream.write(savebuf, 0, savelen);
						fileoutputstream.close();
					}catch(Exception _ex) {
						System.out.println("[Failed] with fileoutputstream stuff");
					}
				if(waveplay){
					@SuppressWarnings("unused")
					String wave = s + savereq;
					waveplay = false;
				}
				if(midiplay){
					midi = s + savereq;
					midiplay = false;
				}
				savereq = null;
			} else if(urlreq != null){
				try{
					System.out.println("urlstream");
					urlstream = new DataInputStream((new URL(mainapp.getCodeBase(), urlreq)).openStream());
				}catch(Exception _ex){
					urlstream = null;
					System.out.println("[Failed] urlstream is now null");
				}
				urlreq = null;
			}
			try{
				Thread.sleep(50L);
			}catch(Exception _ex) {
				System.out.println("[Failed] to sleep");
			}
		}
	}

	public static String findcachedir(){ //fifth thing called
		String as[] = {"C:/"};
		if(storeid < 32 || storeid > 34)
			storeid = 32;
		String s = "2xGCache";
		for(int i = 0; i < as.length; i++)
			try {
				String s1 = as[i];
				if(s1.length() > 0) {
					File file = new File(s1);
					if(!file.exists())
						continue;
				}
				File file1 = new File(s1 + s);
				if(file1.exists() || file1.mkdir())
					return s1 + s + "/";
			}catch(Exception e) {
				System.out.println("[Failed] at sign.signlink.findCacheDir()");
			}
		return null;
	}

	public static int getuid() {
		return 26342;
	}
	
	private static int getuid(String s){
		try{
			File file = new File(s + "uid.dat");
			if(!file.exists() || file.length() < 4L){
				DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(s + "uid.dat"));
				dataoutputstream.writeInt((int)(Math.random() * 99999999D));
				dataoutputstream.close();
			}
		}catch(Exception e) {

		}
		try{
			DataInputStream datainputstream = new DataInputStream(new FileInputStream(s + "uid.dat"));
			int i = datainputstream.readInt();
			datainputstream.close();
			return i + 1;
		}catch(Exception e){
			return 0;
		}
	}

	public static synchronized Socket opensocket(int i) throws IOException{
		for(socketreq = i; socketreq != 0;)
			try{
				Thread.sleep(50L);
			}catch(Exception _ex) {
				System.out.println("[Failed] to sleep");
			}
		if(socket == null)
			throw new IOException("could not open socket");
		else
			return socket;
	}

	public static synchronized DataInputStream openurl(String s) throws IOException{
		for(urlreq = s; urlreq != null;)
			try{
				Thread.sleep(50L);
			}catch(Exception _ex) {
				System.out.println("[Failed] to sleep");
			}
		if(urlstream == null)
			throw new IOException("could not open: " + s);
		else
			return urlstream;
	}

	public static synchronized void dnslookup(String s){
		dns = s;
		dnsreq = s;
	}

	public static synchronized void startthread(Runnable runnable, int i){
		threadreqpri = i;
		threadreq = runnable;
	}

	public static synchronized boolean wavesave(byte abyte0[], int i){
		if(i > 0x1e8480)
			return false;
		if(savereq != null){
			return false;
		} else {
			wavepos = (wavepos + 1) % 5;
			savelen = i;
			savebuf = abyte0;
			waveplay = true;
			savereq = "sound" + wavepos + ".wav";
			return true;
		}
		//return false;
	}

	public static synchronized boolean wavereplay(){
		if(savereq != null){
			return false;
		} else{
			savebuf = null;
			waveplay = true;
			savereq = "sound" + wavepos + ".wav";
			return true;
		}
	}

	public static synchronized void midisave(byte abyte0[], int i){
		if(i > 0x1e8480)
			return;
		if(savereq != null){
		
		} else{
			midipos = (midipos + 1) % 5;
			savelen = i;
			savebuf = abyte0;
			midiplay = true;
			savereq = "jingle" + midipos + ".mid";
		}
	}

	public static void reporterror(String s){
		System.out.println("Error: " + s);
	}

	public static int midipos;
	public static final int clientversion = 317;
	public static int uid;
	public static int storeid = 32;
	public static RandomAccessFile cache_dat = null;
	public static final RandomAccessFile[] cache_idx = new RandomAccessFile[5];
	public static boolean sunjava;
	public static Applet mainapp = null;
	private static boolean active;
	private static int threadliveid;
	private static InetAddress socketip;
	private static int socketreq;
	private static Socket socket = null;
	private static int threadreqpri = 1;
	private static Runnable threadreq = null;
	private static String dnsreq = null;
	public static String dns = null;
	private static String urlreq = null;
	private static DataInputStream urlstream = null;
	private static int savelen;
	private static String savereq = null;
	private static byte[] savebuf = null;
	private static boolean midiplay;
	public static String midi = null;
	public static int midivol;
	public static int midifade;
	private static boolean waveplay;
	private static int wavepos;
	public static int wavevol;
	public static boolean reporterror = true;
	public static String errorname = "";
}
