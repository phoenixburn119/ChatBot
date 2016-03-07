package chat.model;

import java.util.*;
import twitter4j.*;
import chat.controller.ChatController;

public class CTECTwitter
{
	private ArrayList <Status> statusList;
	private ArrayList <String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter()
	{
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		
	}
	
	public void sendTweet(String message)
	{
		CTECTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
	}
	
}
