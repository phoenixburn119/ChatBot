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
		display.displayResponse("Hello " + simpleBot.getUserName() + " I'm ChatBot!");
		chat();
	}
	
	private void chat()
	{
		String textFromUser = display.getAnswer("What would you like to talk about today?");
		while(simpleBot.lengthChecker(textFromUser))
		{
			if(simpleBot.contentChecker(textFromUser))
			{
				display.displayResponse("Wow, I had no idea you loved " + simpleBot.getContent());
			}
			if(simpleBot.memeChecker(textFromUser))
			{
				display.displayResponse("");
			}
			textFromUser = display.getAnswer("What does " + textFromUser + " mean?");
		}
	}
}
