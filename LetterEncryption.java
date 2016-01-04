package ecrypt;

public class LetterEncryption {
	private char[] letters;
	
	public LetterEncryption()
	{
		letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZa!b@c#d$e%f^g&h*i(j)klmnopqr stuvwxyz.,?:;/-+=_~".toCharArray();
	}
	
	public String Encrypt(String message, int key)
	{
		char[] changedMessage;
		changedMessage = message.toCharArray();
		message = "";
		for(int i = 0 ; i < changedMessage.length ; i++)
		{
			loop:
			for(int j = 0 ; j < letters.length ; j++)
			{
				if(changedMessage[i] == letters[j])
				{
					message += letters[(j+key)%letters.length];
					break loop;
				}
				if(j == letters.length -1)
					message += changedMessage[i];
			}
		}
		return message;
	}
	
	public String Decrypt(String message, int key)
	{
		char[] changedMessage;
		changedMessage = message.toCharArray();
		message = "";
		int y = 0;
		for(int i = 0 ; i < changedMessage.length ; i++)
		{
			loop:
			for(int j = 0 ; j < letters.length ; j++)
			{
				if(changedMessage[i] == letters[j])
				{
					y = j-key;
					if(y < 0)
						y += letters.length;
					message += letters[y];
					break loop;
				}
			}
		}
		return message;
	}
}
