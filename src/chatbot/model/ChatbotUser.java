// Chatbot 1.00
// Max Geiger 2014

package chatbot.model;

public class ChatbotUser
{
	private String userName;

	private int age;

	private boolean lovesMusic;

	private Boolean playsPiano;
	private double weight;

	public ChatbotUser()
	{
		this.userName = "John Doe";
		this.age = 0;
		this.lovesMusic = false;
		this.playsPiano = false;
		this.weight = 0;
	}

	public int getAge()
	{
		return age;
	}

	public Boolean getPlaysPiano()
	{
		return playsPiano;
	}

	/**
	 * Gets the username
	 * 
	 * @return
	 */
	public String getUserName()
	{
		return userName;
	}

	public double getWeight()
	{
		return weight;
	}

	public boolean isLovesMusic()
	{
		return lovesMusic;
	}

	public void setAge(int userAge)
	{
		this.age = userAge;
	}

	public void setLovesMusic(boolean lovesMusic)
	{
		this.lovesMusic = lovesMusic;
	}

	public void setPlaysPiano(Boolean playsPiano)

	{
		this.playsPiano = playsPiano;

	}

	public void setUserName(String userName)
	{

		this.userName = userName;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

}
