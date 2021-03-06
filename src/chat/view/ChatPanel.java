package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

import chat.controller.ChatController;
import chat.controller.IOController;

import javax.swing.JTree;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton submitButton;
	private JScrollPane textPane;
	private JTextField inputField;
	private JTextArea outputField;
	private SpringLayout baseLayout;
	private JLabel titleLabel;
	private JButton analyzeTwitterButton;
	private JButton twitterButton;
	private JButton clearOutput;
	private JButton sampleInvest;
	private JButton save;
	private JButton load;
	
	public ChatPanel(ChatController baseController)
	{

		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("Submit");
		save = new JButton("Save");
		baseLayout.putConstraint(SpringLayout.EAST, save, -1, SpringLayout.EAST, this);
		load = new JButton("Load");
		baseLayout.putConstraint(SpringLayout.NORTH, load, 6, SpringLayout.SOUTH, save);
		baseLayout.putConstraint(SpringLayout.EAST, load, -1, SpringLayout.EAST, this);
		inputField = new JTextField();
		outputField = new JTextArea();
		analyzeTwitterButton = new JButton("Check Twitter");
		twitterButton = new JButton("Twitter");
		clearOutput = new JButton("Clear Conversation");
		sampleInvest = new JButton("PastaTrack");
		baseLayout.putConstraint(SpringLayout.WEST, load, 0, SpringLayout.WEST, sampleInvest);
		baseLayout.putConstraint(SpringLayout.NORTH, save, 6, SpringLayout.SOUTH, sampleInvest);
		baseLayout.putConstraint(SpringLayout.WEST, sampleInvest, 0, SpringLayout.WEST, save);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleInvest, 33, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleInvest, -1, SpringLayout.EAST, this);
		titleLabel = new JLabel("Hello i'm Chatbot!");
		baseLayout.putConstraint(SpringLayout.EAST, titleLabel, -450, SpringLayout.EAST, submitButton);
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatPane()
	{
		outputField.setLineWrap(true);
		outputField.setWrapStyleWord(true);
		outputField.setEnabled(false);
		outputField.setEditable(false);
		textPane = new JScrollPane(outputField);
		baseLayout.putConstraint(SpringLayout.WEST, save, 4, SpringLayout.EAST, textPane);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -110, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 0, SpringLayout.WEST, textPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, titleLabel, 5, SpringLayout.NORTH, textPane);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	/*
	 * Adds components onto the panel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(sampleInvest);
		this.add(save);
		this.add(load);
		this.add(clearOutput);
		this.add(analyzeTwitterButton);
		this.add(twitterButton);
		this.add(submitButton);
		this.add(inputField);
		//this.add(outputField); //No longer adding outputField since textPane is the outputfield now.
		this.add(textPane);
		//add(outputField);
		this.add(titleLabel);
		outputField.setEnabled(false);
		inputField.setToolTipText("Type here for the chatbot");
	}
	
	/*
	 * Stores the layout code for all the panel components. 
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, twitterButton, -131, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, analyzeTwitterButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 35, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, -30, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, clearOutput, -209, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, outputField, 6, SpringLayout.SOUTH, titleLabel);
		baseLayout.putConstraint(SpringLayout.WEST, outputField, 0, SpringLayout.WEST, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, outputField, -197, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, outputField, -267, SpringLayout.EAST, submitButton);
		outputField.setForeground(Color.BLACK);
		titleLabel.setForeground(Color.WHITE);
		setBackground(Color.DARK_GRAY);
		inputField.setBackground(Color.LIGHT_GRAY);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, -1, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -6, SpringLayout.WEST, submitButton);
		outputField.setBackground(Color.LIGHT_GRAY);
		baseLayout.putConstraint(SpringLayout.NORTH, titleLabel, 6, SpringLayout.NORTH, this);

	}
	
	/*
	 * Is a listener that grabs user text, displays answer, and clears input field.
	 */
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				submitted();
			}
		});
		
		inputField.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent typed)
			{
				
			}
			public void keyPressed(KeyEvent pressed)
			{
				if(pressed.getKeyCode() == KeyEvent.VK_ENTER)
				{
					submitted();
				}
			}
			public void keyReleased(KeyEvent released)
			{
				
			}
		});
		twitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//Assign to do something
				baseController.sendTweet("no text to send");
			}
		});
		analyzeTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = inputField.getText();
				String results = baseController.analyze(user);
				outputField.setText(results);
			}
		});
		clearOutput.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				outputField.setText("");
			}
		});
		sampleInvest.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String results = baseController.sampleInvest();
				outputField.setText(results);
			}
		});
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String file = IOController.saveFile(outputField.getText());
				inputField.setText(file);
			}
		});
		load.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String loadedText = IOController.readTextFromFile(inputField.getText());
				outputField.setText(loadedText);
			}
		});
	}
	
	private void submitted()
	{
		String userText = inputField.getText();		//Grab user text		X
		String response = baseController.fromUserToChatbot(userText);	//send the text to the controller	X	//give text to chatbot to process	X
		outputField.append("\nUser: " + userText);		//display users text	X
		outputField.append("\nChatbot: " + response);	//display answers	X
		inputField.setText("");		//clear user field		X
	}
	
	public JTextField getTextField()
	{
		return inputField;
	}
}
