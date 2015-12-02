package chat.view;

import javax.swing.*;
import java.awt.event.*;
import chat.controller.ChatController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton submitButton;
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
		outputField = new JTextArea();
		titleLabel = new JLabel("Hello i' Chatbot! Talk to me.");

		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(inputField);
		this.add(outputField);
		this.add(titleLabel);
		inputField.setToolTipText("Type here for the chatbot");
		outputField.setEnabled(false);
	}
	
	private void setupLayout()
	{
		titleLabel.setForeground(Color.WHITE);
		baseLayout.putConstraint(SpringLayout.NORTH, outputField, 27, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 0, SpringLayout.WEST, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, titleLabel, -6, SpringLayout.NORTH, outputField);
		baseLayout.putConstraint(SpringLayout.EAST, titleLabel, 0, SpringLayout.EAST, submitButton);
		setBackground(Color.DARK_GRAY);
		inputField.setBackground(Color.LIGHT_GRAY);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, -1, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -6, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, outputField, -19, SpringLayout.NORTH, submitButton);
		outputField.setBackground(Color.LIGHT_GRAY);
		baseLayout.putConstraint(SpringLayout.WEST, outputField, 0, SpringLayout.WEST, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, outputField, 0, SpringLayout.EAST, submitButton);
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();		//Grab user text		X
				String response = baseController.fromUserToChatbot(userText);	//send the text to the controller	X	//give text to chatbot to process	X
				outputField.append("\nUser: " + userText);		//display users text	X
				outputField.append("\nChatbot: " + response);	//display answers	X
				inputField.setText("");		//clear user field		X
			}
		});
	}
	
	public JTextField getTextField()
	{
		return inputField;
	}
}