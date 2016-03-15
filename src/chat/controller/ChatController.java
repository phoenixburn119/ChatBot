package chat.controller;

import chat.model.Chatbot;
import chat.model.CTECTwitter;
import chat.view.ChatView;
import chat.view.ChatFrame;

public class ChatController
{
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame baseFrame;
	private CTECTwitter myTwitter;

	public ChatController()
	{
		myTwitter = new CTECTwitter(this);
		display = new ChatView();
		String user = display.getAnswer("What is your name?");
		simpleBot = new Chatbot(user);
		baseFrame = new ChatFrame(this);
		
	}
	
	/*
	 * Starts the program to collect your username.
	 */
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
	
	/*
	 * This method is used to see if the user types in a phrase and shuts the program down.
	 */
	private void shutDown()
	{
		display.displayResponse("Goodbye, " + simpleBot.getUserName() + " it has been a pleasure talking with you.");
		System.exit(0);
	}
	
	public void tweetText(String tweetText)
	{
		myTwitter.sendTweet(tweetText);
	}
	
	public String analyze(String userName)
	{
		//String userAnalysis = "The Twitter user " + 
	}
	
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		if(simpleBot.quitChecker(conversation))
		{
			shutDown();
		}
		
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
	
	public void sendTweet(String tweet)
	{
		myTwitter.sendTweet(tweet);
	}
	
	public void handleErrors(String error)
	{
		display.displayResponse(error);
	}
}
