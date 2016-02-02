public class Vigenere{

    public static void main(String[]args){

        String keyword = "marty";
        String message = "honest abe never told a lie";
        char[] k = keyword.toCharArray();
        char[] nM = message.toCharArray();
        int spaces =0;
        for(int i = 0; i < nM.length; i++){
            if(nM[i] == ' '){
                spaces++;
                continue;
            }
            int num = nM[i] - 'a';
            int key = (i-spaces)%keyword.length();
            num += (k[key] -'a');
            num %= 26;
            nM[i] = (char)(num + 'a');
        }
        System.out.println(nM);
    }
}