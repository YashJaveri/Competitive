public class AccessModifiersOverriding{
    public static void main(String args[]) {
        //shows that private method can not be overridden in Java    
        Parent parent = new Child();
    }
}

class Parent{
 
    public Parent(){
        name();
        normal();
    }
 
    private void name(){
        System.out.printf("private method inside Parent class in Java %n");
    }
 
    public void normal(){
        System.out.println("non private method from Parent class can be overridden");
    }
 
}

class Child extends Parent{ 

    public Child(){
        name();
        normal();
    }
    private double x= 6.022e23;
    private void name(){
        System.out.println(x);
    }
 
    @Override
    public void normal(){
        System.out.println("non private overridden method from Child class ");
    }
 
}