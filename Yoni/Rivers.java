import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by ykjt on 9/21/16.
 */
public class Rivers {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        River[] rivers = new River[n];
        Confluence[] confluences = new Confluence[sc.nextInt()+1];
        int currConfluence;


        //store rivers and confluences
        for (int i = 0; i < n; i++)
            rivers[i] = new River(sc.next(), sc.nextInt(),sc.nextInt());

        //confluences offset for more readable code
        for (int i = 1; i < confluences.length; i++) {
            confluences[i] = new Confluence(i, sc.nextInt(), sc.nextInt());
        }

        //for each river, go down the river and calculate using all confluences
        for (int i = 0; i < n; i++) {

            currConfluence = rivers[i].getConfluence();
            while(currConfluence != 0){
                //set the max length to the current max + the length of the next leg
                rivers[i].setMaxLength(rivers[i].getMaxLength() + confluences[currConfluence].getLength());
                currConfluence = confluences[currConfluence].confluence;
            }
        }

        //score the lengths
        //used an Arraylist so I could remove duplicates and check the index later
        ArrayList<Integer> sort = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!sort.contains(rivers[i].getMaxLength()))
            sort.add(rivers[i].getMaxLength());
        }
        Collections.sort(sort, Collections.reverseOrder());

        for (int i = 0; i < n; i++)
            System.out.println(rivers[i].getName() + " " + (sort.indexOf(rivers[i].getMaxLength())+1));





    }



}

class River implements Comparable<River>{
    String name;
    private int confluence;
    private int length;
    private int maxLength;

     public River(String name, int confluence, int length){
        this.name = name;
         this.confluence = confluence;
         maxLength = this.length = length;

    }

    public String getName() {
        return name;
    }

    public int getConfluence() {
        return confluence;
    }
    /*
    public int getLength() {
        return length;
    }*/

    public void setMaxLength(int maxLength) {
        if(maxLength > this.maxLength)
            this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int compareTo(River river) {

        int compareLength = river.getMaxLength();

        //ascending order
        //return this.maxLength - compareLength;

        //descending order
        return compareLength - this.maxLength;

    }

}

class Confluence{
    int n;
    int confluence;
    int length;


    public Confluence(int n, int confluence, int length){
        this.n = n;
        this.confluence = confluence;
        this.length = length;
    }

    public int getLength() {
        return length;
    }
    /*
    public int getConfluence() {
        return confluence;
    }

    public int getN() {
        return n;
    }*/
}
