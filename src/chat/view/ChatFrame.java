package chat.view;

import javax.swing.*;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	
	/*
	 * Will setup the frame for the panel.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setTitle("Chatbot");
		this.setSize(800,400);
		this.setVisible(true);
	}
	
	public ChatController getBaseController()
	{
		return baseController;
	}
}
