import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * @author Monsterray
 *
 */
public class Utilitys {

	/**
	 * This method searches a jar file in the chosen package location for class file to be added to a List.
	 * 
	 * @param path This is the path to the jar file to be searched
	 * @param packagePre This is the package you want class files to be listed from
	 * @return <strong>classNames</strong> Contains all the class files in the package chosen
	 * @throws IOException
	 */
	public List<String> getClassInJar(String path, String packagePre) throws IOException{
		List<String> classNames = new ArrayList<String>();
		ZipInputStream zip = new ZipInputStream(new FileInputStream(path));
		for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
		    if (!entry.isDirectory() && entry.getName().endsWith(".class") && !entry.getName().contains("$") && entry.getName().replace('/', '.').startsWith(packagePre)) {
		        // This ZipEntry represents a class. Now, what class does it represent?
		        String className = entry.getName().replace('/', '.'); // including ".class"
		        classNames.add(className.substring(0, className.length() - ".class".length()));
//		        System.out.println(className.substring(0, className.length() - ".class".length()));
		    }
		}
		zip.close();
		return classNames;
	}
	
	/**
	 * @param laf
	 * @return
	 */
	public String[] getLookandFeelNames(LookAndFeelInfo[] laf){
		String[] results = new String[laf.length];
		for(int i = 0; i < laf.length; i++){
			results[i] = laf[i].getName();
		}
		return results;
	}

	/**
	 * Returns the class name of the installed LookAndFeel with a name
	 * containing the name snippet or null if none found.
	 * 
	 * @param nameSnippet a snippet contained in the Laf's name
	 * @return the class name if installed, or null
	 */
	public String getLookAndFeelClassName(String nameSnippet) {
		LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo info : plafs) {
			if (info.getName().contains(nameSnippet)) {
				return info.getClassName();
			}
		}
		return null;
	}

	/**
	 * Prints out all the currently installed LookAndFeel's on the computer
	 */
	public LookAndFeelInfo[] listInstalledLaFs() {
		LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo info : lafs) {
			System.out.println(info.getName());
			System.out.println("   " + info.getClassName());
		}
		return lafs;
	}
	
	public static void printArray(String[] toPrint){
		for(int i = 0; i < toPrint.length; i++){
			System.out.println(toPrint[i]);
		}
	}

	public static String[] arrayShortener(String[] startArray, int shorter,
			boolean append) {
		String[] output;
		if (append) {
			output = new String[startArray.length - (shorter)];
			for (int i = 0; i <= startArray.length - (1 + shorter); i++) {
				output[i] = startArray[i];
			}
		} else {
			output = new String[startArray.length - (shorter)];
			for (int i = shorter; i <= startArray.length - 1; i++) {
				String temp = startArray[i];
				output[i - shorter] = temp;
			}
		}
		return output;
	}
	
	/**
	 * Prints out the methods that called the method this method is called in.
	 */
	public static void findCaller(){
		Throwable t = new Throwable(); 
		StackTraceElement[] elements = t.getStackTrace();
		String[] arrayS = Utilitys.exceptionToString(elements);
		arrayS[0] = elements[1].getMethodName();
		System.out.println("~~~~~~~~Finding Caller~~~~~~~~");
		Utilitys.printArray(arrayS);
//		Utilitys.saveStack(arrayS, "debug");
	} 
	

	public static String[] exceptionToString(StackTraceElement[] stack) {
		String[] output = new String[stack.length];
		for (int i = 0; i <= stack.length - 1; i++) {
			output[i] = stack[i].toString();
		}
		return output;
	}

	public static void saveStack(String[] stack, String type) {
		File debugFolder = new File("./" + type + "/");
		if(!debugFolder.exists()){
			debugFolder.mkdirs();
		}
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss.SSSS");
		Date cachedDate = new Date();
		String date = dateFormat.format(cachedDate);
		BufferedWriter stackError = null;
		try {
			if (stack[0].equals("<init>")) {
				stack[0] = "Initilizer";
			}
			FileWriter fW = new FileWriter("./" + type + "/" + stack[0] + ".err", true);
			stackError = new BufferedWriter(fW);
			for (int i = 1; i <= stack.length - 1; i++) {
				if (i == 1) {
					try {
						// stackError.write(e1.getMessage());
						stackError.write(date);
					} catch (Exception e) {
						stackError.write("Unknown Reason For Failure!");
					}
				}
				stackError.newLine();
				stackError.write("\t" + stack[i]);
			}
			stackError.write("\n");
			stackError.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[ERROR] Problem in saveing a stack trace!");
		} finally {
			// stackError.close();
		}
	}

	public Utilitys() {

	}
}