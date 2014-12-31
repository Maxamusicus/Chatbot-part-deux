package chatbot.view;

// Chatbot 1.00
// Max Geiger


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import chatbot.controller.ChatbotAppController;

public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;
	private JButton sampleButton;
	private JTextField sampleField;
	private JScrollPane chatPane;
	private JTextArea chatArea;

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;
		sampleButton = new JButton("Send");
		chatArea = new JTextArea(10, 30);
		chatArea.setBackground(Color.LIGHT_GRAY);
		chatPane = new JScrollPane(chatArea);

		sampleField = new JTextField(25);
		sampleField.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 11));
		sampleField.setBackground(Color.LIGHT_GRAY);

		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	public void displayTextToUser(String input)
	{
		chatArea.append(input);
	}

	private void setupLayout()
	{
		JLabel lblWelcomeToChatbot = new JLabel("Max ChatBot");
		lblWelcomeToChatbot.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToChatbot.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblWelcomeToChatbot.setForeground(Color.BLACK);
		lblWelcomeToChatbot.setBackground(Color.BLACK);
		add(lblWelcomeToChatbot);

	}

	private void setupListeners()
	{
		sampleButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				String userTypedText = sampleField.getText();
				if (userTypedText.isEmpty() || userTypedText == null)
				{
					String chatbotResponse = baseController.sendTextToChatBot("EmptyResponse");
					displayTextToUser("\n[ You ]: ...");
					displayTextToUser("\n[ ChatBot ]: " + chatbotResponse);
				}
				else
				{
					String chatbotResponse = baseController.sendTextToChatBot(userTypedText);
					displayTextToUser("\n[ You ]: " + userTypedText);
					displayTextToUser("\n[ ChatBot ]: " + chatbotResponse);
				}
				sampleField.setText("");

			}
		});
	}

	private void setupPanel()
	{
		this.setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.add(sampleButton);
		this.add(sampleField);
		this.add(chatPane);
	}

	private void setupScrollPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
}