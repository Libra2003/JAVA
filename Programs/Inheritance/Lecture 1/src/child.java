/*public class child extends Base{
	public child(){
	System.out.println("Constructor of child()");
	}*/

	public void childF(){
	System.out.println("Function of the child itself.i.e.,child()");
	
	}
	public static void main(String args[]){
	child obj = new child();
	obj.f();
	obj.childF();
	/*protected void finalize(){
		System.out.println("This is the child class destructor in base class");

		};*/
	}
}