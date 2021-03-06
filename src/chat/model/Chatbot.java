package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Adam Kinzer
 * @version 1.6 10/28/15 Made a MemesList and built it. Also edited the reply system. along with adding .content. 
 * Repaired the getContent method. Completed the contentChecker method.
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private ArrayList<String> keyboardMashChecker;
	private String [] quitList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.keyboardMashChecker = new ArrayList<String>();
		this.quitList = new String [6];
		this.userName = userName;
		this.content = "CSGO";
		this.content = "Shiloh Jr";
		
		buildMemesList();
		buildPoliticalTopicsList();
		buildKeyboardMashChecker();
		quitList();
	}
	
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("Thomas's Face");
		this.memesList.add("Trevor's Face");
		this.memesList.add("Pepe");
		this.memesList.add("Weeknd pepe");
		this.memesList.add("Shiloh Jr");
		this.memesList.add("Shiloh lll");
		this.memesList.add("Deez Nuts");
		this.memesList.add("Illuminati");
	}
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("Election");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("Liberal");
		this.politicalTopicList.add("Conservative");
		this.politicalTopicList.add("Trump");
		this.politicalTopicList.add("Clinton");
		this.politicalTopicList.add("Biden");
		this.politicalTopicList.add("Carson");
		this.politicalTopicList.add("Rubio");
		this.politicalTopicList.add("Fiorina");
		this.politicalTopicList.add("Sanders");
		this.politicalTopicList.add("Vote");
		this.politicalTopicList.add("11/4/16");
	}
	
	private void buildKeyboardMashChecker()
	{
		this.keyboardMashChecker.add("sdf");
		this.keyboardMashChecker.add("dfg");
		this.keyboardMashChecker.add("cvb");
		this.keyboardMashChecker.add(",./");
	}
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if(currentInput != null)
		{
			if(currentInput.length() > 0)
			{
				hasLength = true;
			}
		}
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitical = false;
		for(String politicalTopicList : politicalTopicList)
		{
			if(currentInput.toLowerCase().contains(politicalTopicList.toLowerCase()))
			{
				hasPolitical = true;
			}
		}
		return hasPolitical;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		for(String memesList : memesList)
		{
			if(currentInput.toLowerCase().contains(memesList.toLowerCase()))
			{
				hasMeme = true;
			}
		}
		return hasMeme;
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		for(int pos = 0; pos < quitList.length; pos++)
		{
			if(quitList[pos].equals(currentInput))
			{
				hasQuit = true;
			}
		}
		
//		if(currentInput.toLowerCase())
//		{
//			hasQuit = true;
//		}
		return hasQuit;
	}
	
	private void quitList()
	{
		this.quitList[0] = "quit";
		this.quitList[1] = "exit";
		this.quitList[2] = "end";
		this.quitList[3] = "leave";
		this.quitList[4] = "close";
		this.quitList[5] = "bye";
	}
	
	public String processConversation(String currentInput)
	{
		String nextConversation = "oh, what else would you like to talk about?";
		int randomTopic = (int) (Math.random() * 5); //Generates a random number between 0 and 4.
		
		if(keyboardMashChecker(currentInput))
		{
			return "Stop mashing the keyboard good sir.";
		}
		switch (randomTopic)
		{
		case 0:
			if(contentChecker(currentInput))
			{
				nextConversation = "Hey you talked about my special topic, that is cool you pleb. What else you got to say?";
			}
			break;
		case 1:
			if(memeChecker(currentInput))
			{
				nextConversation = "This is a popular meme! What's your favorite food?";
			}
			break;
		case 2:
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "Thats cool! Whats your favorite food?";
			}
			break;
		case 3:
			//Choose your own test here
			if(currentInput.length() > 23)
			{
				nextConversation = "Cool. Whats that?";
			}
			break;
		case 4:
			//Random topic for chat here
			nextConversation = "Awesome. Say more?";
			break;
		default:
			//Never will happen.
			nextConversation = "Thats awesome. What's your favoite meme?";
			break;
		}
		
		return nextConversation;
	}
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean ismash = false;
		for(String s : keyboardMashChecker)
		{
			if(s.equals(currentInput))
			{
				ismash = true;
			}
		}
		
		return ismash;
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}