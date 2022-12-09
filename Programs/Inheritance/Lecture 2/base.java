package base;

class base{
	public base(){
	System.out.println("in constructor of base()");
	}
	public void f(){
		System.out.println("In function f() of base");
	}
	public static void main(String[] ss){
	base p = new base();
	p.f();
	}
}