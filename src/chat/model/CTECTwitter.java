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
	
	public CTECTwitter(ChatController baseController)
	{
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		
	}
	
	public void sendTweet(String message)
	{
		try
		{
			CTECTwitter.updateStatus("IT'S YA BOY ADAM @AdamGKinzer");
			//if boolean method set variable to true here.
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
	
}
