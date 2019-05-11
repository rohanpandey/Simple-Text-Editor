import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

//This class uses JFileChooser to open the file which is to displayed on the editor screen.

public class Open extends Editor
{
    public Open() throws FileNotFoundException
    {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
        {
        	java.io.File file = fileChooser.getSelectedFile();
        	Path_Of_File=file.getAbsolutePath();
        	Scanner input = new Scanner(file);
        	StringBuilder String_To_Put=new StringBuilder("");boolean flag=true;
        	while(input.hasNext())
        	{
        		String s=input.nextLine();
        		if(flag)
        			String_To_Put.append(s);
        		else
        			String_To_Put.append('\n'+s);
        	}
        	input.close();
        	Panel_To_Type.setText(String_To_Put.toString());
        	Text_In_Editor.append(String_To_Put.toString());
        }
        else 
        {
        	;
        }
    } 
}