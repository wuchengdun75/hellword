import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({"all"})
public class GenericDetail {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(); 

        Pig<A> aPig = new Pig<A>(new A());
        aPig.f();
        Pig<A> aPig2 = new Pig<A>(new B());
        aPig2.f();

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        ArrayList<Pig> pigs = new ArrayList<>();

        ArrayList arrayList = new ArrayList();
        Tiger tiger = new Tiger();

    }
}
class Tiger<E> {
    E e;

    public Tiger() {}

    public Tiger(E e) {
        this.e = e;
    }
}

class A {}
class B extends A {}

class Pig<E> {
    E e;

    public Pig(E e) {
        this.e = e;
    }

    public void f() {
        System.out.println(e.getClass()); 
    }
}