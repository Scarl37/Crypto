package aphineCypher;

public class Driver {
	

	public static void main(String[]args){
	
		//TODO  use args  
		String [] stuff = new String[3];
		stuff[0] = "res/test.txt";
		stuff[1] = "17";
		stuff[2] = "4";
		Encrypter encrypter = new Encrypter(stuff);
		encrypter.encrpyt();
	}
}
