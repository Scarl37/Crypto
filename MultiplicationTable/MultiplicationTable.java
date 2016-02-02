
import java.util.*;
public class MultiplicationTable {
    
    
    public static void main(String[]args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Hello enter modulus number");
        
        int mod = sc.nextInt();
        int[][] table = new int[mod][mod];
        for(int i = 0; i < mod; i++){
            for(int j =0 ; j  < mod; j++){
                table[i][j] = (i*j)%mod;
                System.out.printf("10d%", table[i][j]);
            }
            System.out.println();
        }
    }
}
    