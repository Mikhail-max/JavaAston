
package Immutab;


import java.util.ArrayList;
import java.util.List;


public class PracticeJava {


    public static void main(String[] args) {
        
        List<String> spisochek;
        spisochek = new ArrayList<String>();
        spisochek.add("apple");
        spisochek.add("banana");
        spisochek.add("cherry");
        Immutab listt = new Immutab(spisochek);
        
    
        System.out.println(listt.getSPISOK());
      
        
        
    }
    
}
