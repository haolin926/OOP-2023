package ie.tudublin;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Hello world");
		
		Dog penny = new Dog();
		penny.setName("Penny");
		penny.speak();

		cat ginger = new cat();
		int numLives = ginger.getNumlives();
		for (int i = 0; i < (numLives+1); i++)
		{
			ginger.kill();
		}
	}
	
}