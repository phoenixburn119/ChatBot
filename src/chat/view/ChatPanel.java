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

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton submitButton;
	private JScrollPane textPane;
	private JTextField inputField;
	private JTextArea outputField;
	private SpringLayout baseLayout;
	private JLabel titleLabel;
	
	public ChatPanel(ChatController baseController)
	{

		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("Submit");
		inputField = new JTextField();
		titleLabel = new JLabel("Hello i' Chatbot! Talk to me.");
		baseLayout.putConstraint(SpringLayout.SOUTH, titleLabel, -339, SpringLayout.NORTH, inputField);

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
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 25, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, -30, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -10, SpringLayout.EAST, this);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	/*
	 * Adds components onto the panel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(inputField);
		//this.add(outputField);
		this.add(textPane);
		outputField = new JTextArea();
		baseLayout.putConstraint(SpringLayout.NORTH, outputField, 6, SpringLayout.SOUTH, titleLabel);
		baseLayout.putConstraint(SpringLayout.WEST, outputField, 0, SpringLayout.WEST, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, outputField, -197, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, outputField, -267, SpringLayout.EAST, submitButton);
		add(outputField);
		outputField.setEnabled(false);
		this.add(titleLabel);
		inputField.setToolTipText("Type here for the chatbot");
	}
	
	/*
	 * Stores the layout code for all the panel components. 
	 */
	private void setupLayout()
	{
		titleLabel.setForeground(Color.WHITE);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 0, SpringLayout.WEST, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, titleLabel, 0, SpringLayout.EAST, submitButton);
		setBackground(Color.DARK_GRAY);
		inputField.setBackground(Color.LIGHT_GRAY);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, -1, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -6, SpringLayout.WEST, submitButton);
		outputField.setBackground(Color.LIGHT_GRAY);
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
