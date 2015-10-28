package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;

public class ChatController
{
	private Chatbot simpleBot;
	private ChatView display;
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.getAnswer("What is your name?");
		simpleBot = new Chatbot(user);
		
	}
	
	public void start()
	{
		display.displayResponse("Hello " + simpleBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String textFromUser = display.getAnswer("Talk to the chabot.");
		while(simpleBot.lengthChecker(textFromUser))
		{
			textFromUser = display.getAnswer("wowow " + textFromUser);
		}
	}
}
