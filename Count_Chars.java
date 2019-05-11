import java.util.Scanner;
import javax.swing.JOptionPane;

//This class counts the number of characters that have been selected in the editor

public class Count_Chars extends Editor{
    int CountChars=0;
    public Count_Chars()
    {
        
        Scanner input=new Scanner(Panel_To_Type.getSelectedText());
        if(input==null)
            CountChars=0;
        while(input.hasNext())
        {
            String s=(input.nextLine());
            for (int i=0;i<s.length();i++)
            {
                if(s.charAt(i)==' ')
                    ;
                else
                    this.CountChars++;
            }
        }
    }
    public int getSelectedChars()
    {
        return this.CountChars;
    }
    
}