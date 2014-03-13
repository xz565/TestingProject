package testtest;

import java.util.HashMap;
import java.util.Map;

public class Test {

  public static void main(String[] args) {

    long l = 5;
    int i = 5;

    System.out.println(":" + (l == i));

    MyClass myClass1 = new MyClass(0, "Jack");
    MyClass myClass2 = new MyClass(0, "Jack");

    Map<MyClass, String> map = new HashMap<MyClass, String>();

    map.put(myClass1, "I'm Jack");
    map.put(myClass2, "I'm Cale");

    System.out.println(myClass1.hashCode());
    System.out.println(myClass2.hashCode());
    System.out.println(map.get(myClass1));
    System.out.println(map.get(myClass2));

    myClass1.id = 1;
    myClass2.id = 2;

    System.out.println(myClass1.hashCode());
    System.out.println(myClass2.hashCode());
    System.out.println(map.get(myClass1));
    System.out.println(map.get(myClass2));

    //
    System.out.println(1.03 - 0.42);
    System.out.println(1 - 9 * 0.1);

    double d = 8 * 1.0 / 3;
    System.out.println(d);
  }
}


class MyClass {

  int id;
  String name;


  public MyClass() {

  }


  public MyClass(int i, String s) {

    id = i;
    name = s;
  }


  @Override
  public String toString() {

    return id + " " + name;
  }


  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    MyClass other = (MyClass) obj;
    if (id != other.id) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

}
