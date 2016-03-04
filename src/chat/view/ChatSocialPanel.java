package chat.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import chat.controller.ChatController;

public class ChatSocialPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JLabel titleBar;
	private JButton faceBookButton;
	private JButton twitterButton;
	
	public ChatSocialPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		titleBar = new JLabel("ChatBot's Social Pages");
		faceBookButton = new JButton("Facebook");
		twitterButton = new JButton("Twitter");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(titleBar);
		this.add(faceBookButton);
		this.add(twitterButton);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
