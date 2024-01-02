package Section14;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class JavaStreams {
    
    /**
     * 
     */
    public void regular() {
        
        // Java Streams
        //@Test
        
        ArrayList<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Jane");
        names.add("Jim");
        names.add("Sofia");
        names.add("Cristina");
        int count = 0;

        for(int i = 0; i < names.size(); i++){

            String actual=names.get(i);
            if(actual.startsWith("J"))
            {
                count++;
            }
        }
        System.out.println(count);
        
    }

    @Test
    public void streamFilter() {
       
        ArrayList<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Jane");
        names.add("Jim");
        names.add("Sofia");
        names.add("Cristina");
        

        Long c=names.stream().filter(s -> s.startsWith("J")).count();
        System.out.println(c);
        
    }
}