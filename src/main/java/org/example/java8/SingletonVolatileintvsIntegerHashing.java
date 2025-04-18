package org.example.java8;

import java.util.Objects;

public class SingletonVolatileintvsIntegerHashing {
    /**
✅ Java Interview Notes: Singleton, Volatile, int vs Integer, Hashing
🔁 Singleton Design Pattern
Eager Initialization

public class Singleton {
private static final Singleton instance = new Singleton();
private Singleton() {}
public static Singleton getInstance() {
return instance;
}
}

Lazy Initialization (Non-thread-safe)

public class Singleton {
private static Singleton instance;
private Singleton() {}
public static Singleton getInstance() {
if (instance == null)
instance = new Singleton();
return instance;
}
}

Double-Checked Locking (Thread-safe)

public class Singleton {
private static volatile Singleton instance;
private Singleton() {}
public static Singleton getInstance() {
if (instance == null) {
synchronized(Singleton.class) {
if (instance == null) {
instance = new Singleton();
}
}
}
return instance;
}
}

🆚 Lazy Loading vs Double-Checked Locking

Feature	Lazy Loading	Double-Checked Locking
Thread-safe	No	Yes
Performance	Poor in concurrency	Efficient
Uses synchronized	Yes	Yes (but minimal)
Needs volatile	No	Yes
🌀 Volatile Keyword in Java
Ensures visibility across threads.

Prevents instruction reordering.

Required for safe publishing in multithreaded patterns.

⚠️ Without volatile in DCL
Threads may see partially constructed object.

Can break the Singleton guarantee.

🧾 equals() and hashCode()
❌ Only equals()
class A {
int id;
@Override
public boolean equals(Object o) { ... }
// hashCode not overridden
}

✅ Correct usage:
@Override
public boolean equals(Object o) { ... }

@Override
public int hashCode() {
return Objects.hash(id);
}

🔢 int vs Integer

Feature	int (Primitive)	Integer (Wrapper)
Nullable	No	Yes
Default Value	0	null
Memory	4 bytes	More (Object)
Collections	No	Yes
Use in streams	No	Yes
🧮 Integer Cache Range
Cached range: -128 to 127

Beyond this: new object created

Integer a = 100;
Integer b = 100;
System.out.println(a == b); // true (cached)

Integer x = 200;
Integer y = 200;
System.out.println(x == y); // false (not cached)

✅ Use equals():
System.out.println(x.equals(y)); // true

🔍 Comparing int and Integer
int == int
int a = 5, b = 5;
System.out.println(a == b); // true

Integer == Integer
Integer a = 100, b = 100;
System.out.println(a == b); // true (cached)

Integer x = 200, y = 200;
System.out.println(x == y); // false (outside cache)

Integer.equals(Integer)
Integer a = 200, b = 200;
System.out.println(a.equals(b)); // true

int == Integer
Integer a = 200;
int b = 200;
System.out.println(a == b); // true (auto-unboxed)

Integer is null
Integer a = null;
int b = 5;
System.out.println(a == b); // NullPointerException

✅ Safe comparison:
Objects.equals(a, b); // handles null

🧠 Best Practices
Use == for primitives

Use equals() for objects

Avoid == for Integer outside cache range

Use Objects.equals(a, b) for safe null handling

====================================================================
*/
    public static void main(String[] args) {


        // ===== Integer Cache Comparison =====
        Integer a = 100;
        Integer b = 100;
        System.out.println("a == b (100): " + (a == b)); // true (cached)

        Integer x = 200;
        Integer y = 200;
        System.out.println("x == y (200): " + (x == y)); // false (not cached)
        System.out.println("x.equals(y): " + x.equals(y)); // true

        // ===== int and Integer comparison =====
        int p = 100;
        Integer q = 100;
        System.out.println("p == q (100): " + (p == q)); // true (unboxed)

        Integer r = null;
        try {
            System.out.println("r == p (null check): " + (r == p)); // NPE
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught in Integer == int comparison");
        }

        // Safe null check
        System.out.println("Objects.equals(r, p): " + Objects.equals(r, p)); // false

        // ===== Singleton Demo =====
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("Singleton instances same: " + (instance1 == instance2)); // true

        // ===== equals() and hashCode() demo =====
        Person person1 = new Person(1, "Ayush");
        Person person2 = new Person(1, "Ayush");

        System.out.println("person1.equals(person2): " + person1.equals(person2)); // true
        System.out.println("person1.hashCode() == person2.hashCode(): " +
                (person1.hashCode() == person2.hashCode())); // true
    }
}

// ================= Singleton Class =================
class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

// ================= Person Class with equals & hashCode =================
class Person {
    int id;
    String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return id == p.id && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

