import java.util.*;

public class Birds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int length = input.nextInt();
        int distance = input.nextInt();
        int buffer = distance - 1;
        int n = input.nextInt();

        
        int[] wire = new int[length+1];

        if (wire.length <= 12){
        	for (int i :wire ) i = 1;
        }
        else{
            for (int i = 0; i< 6 ; i++) {
                wire[i] = 1;
                wire[length-i] = 1;
            }
        }

        
        for (int i =0; i < n; i++)
        {
            
            int position = input.nextInt();     
            for(int j = position - buffer; j <= position + buffer; j++) {
                wire[j] = 1;
            }
        }
        
    
        int count = 0;
        for (int i =6; i < wire.length-6; i++)
        {

            if (wire[i] == 0) {
                count++;

                for (int j = i; j < i+distance && j < wire.length; j++){

                    wire[j] = 1;

                }
            }
            
        }   
        System.out.println(count);  
    }
} 
