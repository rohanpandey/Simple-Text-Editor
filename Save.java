import javax.swing.*;
import java.io.*;
import java.util.jar.Attributes.Name;
public class Save extends Editor
{
    public Save() throws FileNotFoundException
    {
    	if(Path_Of_File=="")
    	{
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setDialogTitle("Specify a file to save");    
    	 
    	int userSelection = fileChooser.showSaveDialog(Mainframe);
    	if (userSelection == JFileChooser.APPROVE_OPTION) {
    		
    	    File fileToSave = fileChooser.getSelectedFile();
    	    Path_Of_File=fileToSave.getAbsolutePath();
    	    File Save_Object = new File(Path_Of_File);
            PrintWriter output;boolean exist=false;
            if(!Save_Object.exists())
                {output = new PrintWriter(Save_Object);}
            else
                {JOptionPane.showMessageDialog(null,"This file already exists.");exist=true;}
            if(exist==false)
            {
            	try
            	{
            		output=new PrintWriter(Save_Object);
            		output.print(Panel_To_Type.getText());
            		output.close();
            	}
            	catch(NullPointerException e)
            	{
            		Path_Of_File="";
            	}     
            }
    	    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
    		}
    	 }
    	 else if(Path_Of_File!=null)
    	 {
    		 PrintWriter output;
    		 File Save_Object = new File(Path_Of_File);
    		 output=new PrintWriter(Save_Object);
     		output.print(Panel_To_Type.getText());
     		output.close();
    	 }
    }
}