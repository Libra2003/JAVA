class Animal
{
	public void getName(String name)
	{
	System.out.println("Name of Animal is:"+name);
	System.out.println("Base Class");
	}
}
class Dog extends Animal
{
	public void getName(String name)
	{
		super.getName(name);
		System.out.println("Name of breed is:"+name);
		System.out.println("Derived Class");
	}
}
class overriding
{
	public static void main(String args[])
	{
	Dog d=new Dog();
	d.getName("dog");
	d.getName("puppy");
	}
}