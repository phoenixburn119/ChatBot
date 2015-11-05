package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatView
{
	
	private String windowMessage;
	private ImageIcon SpookyIcon;
	private ImageIcon blackIcon;
	private ImageIcon eveeIcon;
	private ImageIcon umbereonIcon;
	private ImageIcon smileIcon;
	
	public ChatView()
	{
		windowMessage = "Hello I'm Chatbot.";
		SpookyIcon = new ImageIcon(getClass().getResource("images/SpookyScarySkelly.png"));
		blackIcon = new ImageIcon(getClass().getResource("images/black.png"));
		eveeIcon = new ImageIcon(getClass().getResource("images/EveeEvo.png"));
		umbereonIcon = new ImageIcon(getClass().getResource("images/Umberion.png"));
		smileIcon = new ImageIcon(getClass().getResource("images/Smile.png"));
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
		answer = JOptionPane.showInputDialog(null, displayMessage, windowMessage, JOptionPane.INFORMATION_MESSAGE, RandomIcon(), null, "Type here please.").toString();
		return answer;
	}
	
	/**
	 * Displays a String to the user with a standard popup.
	 * @param displayMessage
	 */
	public void displayResponse(String displayMessage)
	{
		JOptionPane.showMessageDialog(null, displayMessage, windowMessage, JOptionPane.PLAIN_MESSAGE, RandomIcon());
	}
	
	private ImageIcon RandomIcon()
	{
		int randomIcon = (int) (Math.random() * 5);
		
		switch (randomIcon)
		{
		case 0:
			return SpookyIcon;
		case 1:
			return blackIcon;
		case 2:
			return eveeIcon;
		case 3:
			return umbereonIcon;
		case 4:
			return smileIcon;
		default:
			return SpookyIcon;
		}
	}
}
