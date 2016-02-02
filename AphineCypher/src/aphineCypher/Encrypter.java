package aphineCypher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Aphine Cypher encrypter that uses the formula alpha*plaintextValue + beta (% m) to encrypt where alpha must be relatively prime to the modulus. 
 * Here the default modulus is taken from driver. 
 * 
 * @author Martin
 *
 */
public class Encrypter {

	private	Encrypter encrypter;
	private int alpha, beta;
	private String plaintextFileName, cyphertextFileName;
	private Scanner in;
	private PrintWriter pw;
	private final int MODULUS = 26; //this will need to be changed if you are encrypting more than a-z
	/**
	 *  Constructor for encrypter
	 *  Takes args and intializes The printwriter and scanner for reading writing to the files
	 *  Creates file with the same filename as the file to be encrypted but adds "APH" right before the "."
	 *  
	 * @param args
	 * {@code String[]} first arg is FileName second arg is String representation of number to use for Alpha value
	 *  third arg is number to use for Beta Value
	 */
	public Encrypter (String[] args){
		
		try{
			this.alpha = Integer.parseInt(args[1]);
			this.beta = Integer.parseInt(args[2]);
			System.out.println(alpha + " " + beta);
			
			this.plaintextFileName = args[0];
			this.cyphertextFileName = plaintextFileName.substring(0, plaintextFileName.indexOf("."));
			this.cyphertextFileName += "APH";
			this.cyphertextFileName += plaintextFileName.substring(plaintextFileName.indexOf("."));
			File plaintextFile = new File(plaintextFileName);
			File cyphertextFile = new File(cyphertextFileName);
			in = new Scanner(plaintextFile);
			pw = new PrintWriter(cyphertextFile);
		}catch(FileNotFoundException f){
			System.out.println("File not found: " + f.getMessage());
		}catch(Exception e){
			System.out.println("Error!");
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Where the magic happens. Switch plaintext to a char array and iterate over each character 
	 * changing each character into an integer where a/A == 0 and z/Z == 25 then 
	 * using the alpha and beta values to produce our ciphertext and swapping back to a char value.
	 * Finally it writes the ciphertext to a file. 
	 */
	public void encrpyt(){
		String plaintext = "";
		while(in.hasNext()){
			plaintext += in.nextLine().toUpperCase();
		}
		char[]plaintextArray = plaintext.toCharArray();
		char[]cyphertextArray = new char[plaintext.length()];
		for(int index = 0; index < plaintextArray.length; index++){
			char plain = plaintextArray[index];
			if(plain < 'A' || plain > 'Z'){
				cyphertextArray[index] = plain;
				continue;
			}
			int value = plain -'A';
			value = ((value*alpha)+beta) % MODULUS;
			char cypher = (char)(value + 'A');
			cyphertextArray[index] = cypher;
		}
		in.close();
		String cyphertext = new String(cyphertextArray);
		pw.println(cyphertext);
		pw.flush();
		pw.close();
	}
}