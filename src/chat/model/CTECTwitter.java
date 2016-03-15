package chat.model;

import java.util.ArrayList;
import java.util.List;
import twitter4j.*;
import chat.controller.ChatController;

public class CTECTwitter
{
	private Twitter chatbotTwitter;
	private ArrayList <Status> statusList;
	private ArrayList <String> wordsList;
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
			chatbotTwitter.updateStatus("IT'S YA BOY ADAM @AdamGKinzer");
			//if boolean method set variable to true here.
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}

	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while(page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for(Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for(String word : tweetText)
			{
				wordsList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordsList);
		removeEmptyText();
	}
	
	public List removeCommonEnglishWords(List<String> wordList)
	{
		return null;
	}
	private void removeEmptyText()
	{
		
	}
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?\"(){}^[]<>-"; //Add what I need
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
}
