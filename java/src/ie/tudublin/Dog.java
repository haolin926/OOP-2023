package ie.tudublin;

public class Dog
{
	String name;
	int numLives=9;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Dog()
	{
	}
	
	public Dog(String name)
	{
	}
	
	public void speak()
	{
		System.out.println("Woof");
	}
	// public void kill()
	// {
	// 	if (numLives > 0)
	// 	{
	// 		System.out.println("Ouch!");
	// 		numLives = numLives - 1;
	// 	}
	// 	else if (numLives == 0 )
	// 	{
	// 		System.out.println("Dead.");
	// 	}
	// }
}