import java.util.List;
public class Generic03 {
    public static void main(String[] args) {

        Person<String> person = new Person<String>("韩顺平教育");
        person.show(); 


        Person<Integer> person2 = new Person<Integer>(100);
        person2.show();

    }
}


class Person<E> {
    E s ;

    public Person(E s) {
        this.s = s;
    }

    public E f() {
        return s;
    }

    public void show() {
        System.out.println(s.getClass());
    }
}
