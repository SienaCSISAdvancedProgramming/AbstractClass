import java.util.ArrayList;

/**
 * Demonstrating a simple abstract class
 *
 * Jim Teresco, Siena College, Computer Science 225, Spring 2017
 * Based heavily on example from Darren Lim
 *
 * @author Jim Teresco
 * @version Spring 2022
 */

/*
 * The class is declared as abstract to indicate that it will include
 * one or more abstract methods.
 */
abstract class Student {
    protected String name = "Fred";

    /* any class that extends Student will be required to implement this method */
    protected abstract void getName();

    /* and we'll provide a method everyone will inherit also */
    public void setName(String newName) {

        name = newName;
    }

}

class Undergraduate extends Student {
    @Override
    protected void getName() {
        System.out.println("Undergraduate : " + name);
    }
}

class Freshman extends Undergraduate {
}

class Graduate extends Student {
    @Override
    protected void getName() {
        System.out.println("Graduate : " + name);
    }

}

class Phd extends Graduate {
    @Override
    protected void getName() {
        System.out.println("Phd : " + name);
    }
}

public class AbstractClass {

    public static void main(String[] args) {
        // populate an ArrayList with Student objects and instances of derived classes
        ArrayList<Student> students = new ArrayList<>();
        // this will not be allowed, since we cannot instantiate an abstract class
        // students.add(new Student());
        students.add(new Undergraduate());
        students.add(new Freshman());
        students.add(new Graduate());
        students.add(new Phd());

        // any Student object can call setName
        students.get(0).setName("Mary");
        students.get(1).setName("Don");
        students.get(2).setName("Alice");

        // let's call each one's getName method, which each Student is
        // guaranteed to have, even though class Student doesn't provide one.
        for (Student s : students) {
            s.getName();
        }

    }
}
