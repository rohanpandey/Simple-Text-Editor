//This converts the selected text to uppercase
public class Uppercase extends Editor
{
	public Uppercase()
    {
        String S=Panel_To_Type.getSelectedText();
        String P = S.toUpperCase();
        Panel_To_Type.replaceSelection(P);
    }
}