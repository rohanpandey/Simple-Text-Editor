import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.*;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextPane;
//This is the main class that contains all variables that have to be used in all of the classes
public class Editor extends JFrame
{	
	static String Path_Of_File="";
	boolean Selected_Text_Stored=false;
	static JEditorPane Panel_To_Type=new JEditorPane();
	static String Selected_Text="";
	static String Name_Of_File="";
	static String T_I_E="";
	static StringBuilder Text_In_Editor=new StringBuilder(T_I_E);
	static int a=10;
	static String Name_Of_Font="";
	static String Font_Size="";
	JFrame Mainframe=new JFrame();
	public static void main(String arg[])
	{
		Layout layout=new Layout();
	}
}