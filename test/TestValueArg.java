package test;
public class TestValueArg {
    public void changeValueInFunction(int[] arr){
        int[] newArr = {0,0,0,0,0};
        arr = newArr;
    }

    public void changeValueInFunction(Person old){
        Person newPerson = new Person();
        newPerson.name = "new";
        newPerson.age = 18;
        old = newPerson;
    }

    class Person{
        public String name;
        public Integer age;

        @Override
        public String toString() {
            return "Person:name = "+this.name + " Person:age = " + this.age;
        }
    }
    
    public static void main(String[] args) {
        Object obj = new Object();
        System.err.println(obj);
        System.out.println(obj.hashCode());



        int[] arr = {1,2,3,4,5};

        TestValueArg t = new TestValueArg();

        t.changeValueInFunction(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        Person p = t.new Person();
        p.name = "test";
        p.age = 1;
        System.out.println(p);
        t.changeValueInFunction(p);
        System.out.println(p);
    }
}
