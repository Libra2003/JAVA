class MyClass {
    int a;
    int b;

    public MyClass() {
        a = 10;
        b = 20;
    }
    public MyClass(int t, int t2) {
        a = t;
        b = t2;
    }

    void add(MyClass o){
        a = this.a +o.a;
        b = this.b +o.b;
        System.out.println(a);
        System.out.println(b);
    }
    public static void main(String[] args) {
        MyClass o1 = new MyClass();
        MyClass o2 = new MyClass();
        o1.add(o2);

        //Class Object Refrence Example
        MyClass me;
        MyClass Me[]=new MyClass[10];

        //Making 10 objects
        for (int j = 0;j<5;j++){
            Me[j]=new MyClass();
        }
        for (int i = 5;i<10;i++){
            Me[i]=new MyClass(200,300);
        }
    }
}
