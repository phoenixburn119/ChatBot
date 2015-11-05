package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatView
{
	
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "Thisi message brought to you by Chatbot.";
		chatIcon = new ImageIcon(getClass().getResource("images/SpookyScarySkelly.png"));
		
	}
	/**
	 * Displays a GUI popup for collecting user text with a supplied String.
	 * Usually in the form of a question for further use in the program.
	 * @param input
	 * @return
	 */
	public String getAnswer(String displayMessage)
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, displayMessage, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type here please.").toString();
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
