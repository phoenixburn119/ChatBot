package chat.view;

import javax.swing.*;
import java.awt.Event.*;
import chat.controller.ChatController;
import java.awt.Color;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton submitButton;
	private JTextField inputField;
	private JTextArea outputField;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatController baseController)
	{

		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("Submit");
		inputField = new JTextField("Answer me please!");
		outputField = new JTextArea("******");

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
	}
	
	private void setupLayout()
	{
		submitButton.setBackground(Color.WHITE);
		setBackground(Color.DARK_GRAY);
		inputField.setBackground(Color.LIGHT_GRAY);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, -1, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -6, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, outputField, -19, SpringLayout.NORTH, submitButton);
		outputField.setBackground(Color.LIGHT_GRAY);
		baseLayout.putConstraint(SpringLayout.NORTH, outputField, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, outputField, 0, SpringLayout.WEST, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, outputField, 0, SpringLayout.EAST, submitButton);
	}
	
	private void setupListeners()
	{
		
	}
}
