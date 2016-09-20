

import java.util.Scanner;

/**
 * Created by ykjt on 9/19/16.
 */
public class Birds {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int d = sc.nextInt();
        int n = sc.nextInt();

        int birds[] = new int[n];

        int additionalBirds = 0;

        for (int i = 0; i < n; i++){
            birds[i] = sc.nextInt();
        }

        //quick solution if there are no birds on the wire
        if(n == 0){
            //adjust to take away edges
            int lAdjust = l - 10;
            //round up, because even lAdjust= 31 d=10 we can fit 4 (1, 11, 21, 31)
            double result = Math.ceil((double) lAdjust / (double) d);

            System.out.println((int)result);
            return;
        }

        boolean allClear;
        for (int i = 6; i < l-6; i++) {
            allClear = true;

            for (int j = 0; j < birds.length; j++) {
                if(i <= birds[j] && i+d > birds[j]){
                    allClear = false;
                    //System.out.println("No bird added. Bird already at " + bird);

                    i= birds[j] + d - 1;
                    //System.out.println("jumped to " + (i+1));
                    break;
                }
            }
            /*
            for (int bird : birds){
                if(i <= bird && i+d > bird){
                    allClear = false;
                    //System.out.println("No bird added. Bird already at " + bird);

                    i= bird + d - 1;
                    //System.out.println("jumped to " + (i+1));
                    break;
                }
            }*/

            if (allClear){
                additionalBirds++;
                //System.out.println("bird "+additionalBirds+ " added at " + i);

                i += d - 1;
                //System.out.println("jumped to: " + (i+1));
            }
        }
        //results

        System.out.println(additionalBirds);
    }
}
