package acwing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AcWing_429 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1[] = reader.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        Person person[] = new Person[n + 1];
        for (int i = 1; i <= n; i++) {
            String str2[] = reader.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);
            person[i] = new Person();
            person[i].set(i, a + b + c, a, b, c);
        }
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - 1; j++) {
                if (cmp(person[j], person[j + 1])) {
                    person[0] = new Person();
                    person[0].set(person[j].id, person[j].sum, person[j].a, person[j].b, person[j].c);
                    person[j].set(person[j + 1].id, person[j + 1].sum, person[j + 1].a, person[j + 1].b, person[j + 1].c);
                    person[j + 1].set(person[0].id, person[0].sum, person[0].a, person[0].b, person[0].c);
                }
            }
        }
        for (int i = n; i > n - 5; i--) {
            System.out.println(person[i].id + " " + person[i].sum);
        }
    }

    private static boolean cmp(Person person, Person person1) {
        if (person.sum != person1.sum) return person.sum > person1.sum;
        if (person.a != person1.a) return person.a > person1.a;
        return person.id < person1.id;
    }
}

class Person implements Comparable<Person> {
    public int id, sum, a, b, c;

    public void set(int id, int sum, int a, int b, int c) {
        this.id = id;
        this.sum = sum;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Person o) {
        if (this.sum != o.sum) {
            if (this.sum > o.sum) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.a != o.a) {
            if (this.a > o.a) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.id < o.id) {
            return 1;
        } else {
            return -1;
        }
    }

    public int getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
