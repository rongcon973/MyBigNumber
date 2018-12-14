import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    public static void main(String[] args) {
        String s1,s2;

        BufferedReader reader;

        reader = new BufferedReader(new InputStreamReader(System.in));


        try { 
            System.out.print("s1 = ");
            s1 = reader.readLine();
            System.out.print("s2 = ");
            s2 = reader.readLine();
            
            ArrayList<String> result =  new MyBigNumber(s1,s2).sum();
            for(String x : result){
                System.out.println(x);
            }
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
