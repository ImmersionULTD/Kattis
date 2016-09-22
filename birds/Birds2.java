import java.util.*;

public class Birds2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int length = input.nextInt();
        int distance = input.nextInt();
        int n = input.nextInt();

        Integer[] wire = new Integer[n+2];

        if (length >= 6) {
            wire[0] = 6;
            wire[1]= length-6;
        }

        for (int i = 0; i < n; i ++)
        {
            wire[i+2] = input.nextInt();
        }
        Arrays.sort(wire, Collections.reverseOrder());

        int count = 0;

        for (int i = 0; i < wire.length-1; i++)
        {
            int space =(wire[i] - wire[i+1])/distance-1; 
            if (i == 0) space++;
            if (i+1 == wire.length-1) space++;
            count += space;
       }
       
        System.out.println(count);  
    }
} 
