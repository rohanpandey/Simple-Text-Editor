import java.util.Scanner;
import javax.swing.JOptionPane;

//This class counts the number of words that have been selected in the editor

public class Count_words extends Editor {
    int CountWords=0;
    public Count_words()
    {
        Scanner input=new Scanner(Panel_To_Type.getSelectedText());
        if(input==null)
            CountWords=0;
        while(input.hasNext())
        {
            String s=(input.nextLine());
            for (String word : s.split(" "))
            {
                this.CountWords++;  
            }
        }
    }
    
    public int getSelectedWords()
    {
        return this.CountWords;
    }    
}