package chat.controller;

/**
 * Starts the Chatbot program.
 * @author akin8529
 *
 */
public class ChatRunner
{
	public static void main (String [] args)
	{
		ChatController myChatController = new ChatController();
		myChatController.start();
	}
}