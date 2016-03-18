package chat.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import chat.controller.ChatController;
import chat.view.ChatPanel;

public class ChatSocialPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JLabel titleBar;
	private JButton analyzeTwitterButton;
	private JButton twitterButton;
	
	public ChatSocialPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		titleBar = new JLabel("ChatBot's Social Pages");
		analyzeTwitterButton = new JButton("Check Twitter");
		twitterButton = new JButton("Twitter");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(titleBar);
		this.add(analyzeTwitterButton);
		this.add(twitterButton);
	}
	
	private void setupLayout()
	{

	}
	
	private void setupListeners()
	{
		twitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//Assign to do something
				baseController.sendTweet("no text to send");
			}
		});
		analyzeTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//String user = typingField.getText();
				//String results = baseController.analyze(user);
				//inputField.setText(results);
			}
		});
	}
}
