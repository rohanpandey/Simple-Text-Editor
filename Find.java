import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

//This class is used to find the word that is entered by the user. This file uses a JOptionPane
//for taking the word which is to be found. It highlights the first instance of the word
//present in the editor

public class Find extends Editor
{
	public Find() throws FileNotFoundException
	{
		String Word_To_Find= JOptionPane.showInputDialog(null,"Enter the word to find:","FIND",JOptionPane.INFORMATION_MESSAGE);
		Scanner input=new Scanner(Panel_To_Type.getText());
		int position=0;
		boolean found=false;
		while(input.hasNext())
		{
			String s=(input.nextLine());
			for (String word : s.split(" ")){
				if(word.equalsIgnoreCase(Word_To_Find))
				{
					Panel_To_Type.setSelectionStart(position);
					Panel_To_Type.setSelectionEnd(position+word.length());
					found=true;
					break;
				}
				else
				{
					position+=word.length()+1;
				}
			}
		}
		if(found==false)
        {
            JOptionPane.showMessageDialog(null,"Word Not Found");
        }
	}
}