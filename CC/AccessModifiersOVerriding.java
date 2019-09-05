/**
 *
 * Java program to demonstrate that private method can not be overridden in Java.
 * This Java programs calls both private and non private method with child class
 * object on constructor of parent class.
 * Only non private method of Child class invoked while private method of
 * Parent class is invoked, Which confirms that private method can not be overridden in Java
 *  and only be hidden if we declare same message in Child class.
 * @author
 */
public class AccessModifiersOVerriding{
 
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
    private void name(){
        System.out.printf("private method inside Child class in Java %n");
    }
 
    @Override
    public void normal(){
        System.out.println("non private overridden method from Child class ");
    }
 
}