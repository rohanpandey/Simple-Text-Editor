//This converts the selected text to lowercase
public class Lowercase extends Editor 
{
	public Lowercase()
    {
        String S=Panel_To_Type.getSelectedText();
        String P = S.toLowerCase();
        Panel_To_Type.replaceSelection(P);
    }
}