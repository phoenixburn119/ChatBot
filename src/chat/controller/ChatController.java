package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;
import chat.view.ChatFrame;

public class ChatController
{
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame baseFrame;

	public ChatController()
	{
		display = new ChatView();
		String user = display.getAnswer("What is your name?");
		simpleBot = new Chatbot(user);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		display.displayResponse("Hello " + simpleBot.getUserName() + " I'm ChatBot!");
		//chat();
	}
	
	private void chat()
	{
		String conversation = display.getAnswer("What would you like to talke about today?");
		while(simpleBot.lengthChecker(conversation))
		{
			conversation = simpleBot.processConversation(conversation);
			conversation = display.getAnswer(conversation);
		}
	}
	
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		botResponse = simpleBot.processConversation(conversation);
		
		return botResponse;
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	
	public ChatView getChatView()
	{
		return display;
	}
	
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
}
