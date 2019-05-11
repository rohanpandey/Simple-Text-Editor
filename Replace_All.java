import javax.swing.JOptionPane;

//This class uses JOptionPane to take the input from the user for the word that is to be replaced
//And the word with which it is to be replaced. It replaces all the instances of the word.

public class Replace_All extends Editor
{
	public Replace_All()
	{
        String text_in_editor=Panel_To_Type.getText();
        String Word_To_Replace=JOptionPane.showInputDialog(null,"Enter the word to replace:","REPLACE",JOptionPane.INFORMATION_MESSAGE);
		if(Word_To_Replace!=null)
                {
                    String Word_To_Replace_With=JOptionPane.showInputDialog(null,"Enter the word to replace with:","REPLACE",JOptionPane.INFORMATION_MESSAGE);
                    if(Word_To_Replace_With!=null)
                    {
                        String str=(text_in_editor.replaceAll(Word_To_Replace,Word_To_Replace_With));
                        Text_In_Editor=new StringBuilder(str);
                        Panel_To_Type.setText(str);
                        if(str.equals(text_in_editor)&&(Word_To_Replace.length()!=0))
                        	JOptionPane.showMessageDialog(null,"Word Not Found");
                    }
                }
    }
}