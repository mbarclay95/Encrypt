package ecrypt;

public class LetterBreaker {
	private char letters[];
	
	public LetterBreaker()
	{
		letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZa!b@c#d$e%f^g&h*i(j)klmnopqr stuvwxyz.,?:;/-+=_~".toCharArray();
	}
	
	public String breakString(String string)
	{
		String message = "";
		for(int k = 0 ; k < letters.length ; k++)
		{
			char enc[] = string.toCharArray();
			for(int i = 0 ; i < enc.length ; i++)
			{
				loop:
				for(int j = 0 ; j < letters.length ; j++)
				{
					if(enc[i] == letters[j])
					{
						int m = (j+k)%letters.length;
						message += letters[m];
						break loop;
					}
					if(j == letters.length - 1)
						message += enc[i];
				}
			}
			System.out.println(message);
			message = "";
		}
		return message;
	}
}
