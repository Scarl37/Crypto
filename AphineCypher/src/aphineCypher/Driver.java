package aphineCypher;

/**
 * Driver class for aphine cypher encryption and decryption
 * 
 * @author Martin Wallace
 * <p>marty.wallace@ymail.com
 *
 */
public class Driver {
	

	public static void main(String[]args){
	
		//TODO  use args  
		
		
		/////arbitrary testing value ///////////
		String [] stuff = new String[3];
		stuff[0] = "res/test.txt";
		stuff[1] = "17";
		stuff[2] = "4";
		Encrypter encrypter = new Encrypter(stuff);
		encrypter.encrpyt();
		
		
	}
}
