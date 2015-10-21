package chat.view;

import javax.swing.JOptionPane;

public class ChatView
{
	/**
	 * Displays a GUI popup for collecting user text with a supplied String.
	 * Usually in the form of a question for further use in the program.
	 * @param input
	 * @return
	 */
	public String getAnswer(String displayMessage)
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, displayMessage);
		return answer;
	}
	
	/**
	 * Displays a String to the user with a standard popup.
	 * @param displayMessage
	 */
	public void displayResponse(String displayMessage)
	{
		JOptionPane.showMessageDialog(null, displayMessage);
	}
}
