import java.util.Arrays;
import java.util.Comparator;

// 定义一个学生类，实现 Comparable 接口
class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 重写 compareTo 方法，按照年龄进行比较
    @Override
    public int compareTo(Student other) {
        return this.age - other.age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

public class ArraySortingExamples {
    public static void main(String[] args) {
        // 整数数组降序排序
        Integer[] intArray = {5, 3, 8, 1, 2};
        Arrays.sort(intArray, Comparator.reverseOrder());
        System.out.println("降序排序后的整数数组: " + Arrays.toString(intArray));

        // 双精度数组降序排序
        Double[] doubleArray = {3.2, 1.5, 2.7, 0.9};
        Arrays.sort(doubleArray, Comparator.reverseOrder());
        System.out.println("降序排序后的双精度数组: " + Arrays.toString(doubleArray));

        // 字符数组降序排序
        Character[] charArray = {'c', 'a', 'b'};
        Arrays.sort(charArray, Comparator.reverseOrder());
        System.out.println("降序排序后的字符数组: " + Arrays.toString(charArray));

        // 对象数组排序
        Student[] students = {
            new Student("Alice", 20),
            new Student("Bob", 18),
            new Student("Charlie", 22)
        };

        // 使用实现 Comparable 接口的方式排序
        Arrays.sort(students);
        System.out.println("按年龄排序后的学生数组（实现 Comparable 接口）: " + Arrays.toString(students));

        // 使用 Comparator 进行排序，按照姓名降序排序
        Arrays.sort(students, Comparator.comparing(Student::getName).reversed());
        System.out.println("按姓名降序排序后的学生数组（使用 Comparator）: " + Arrays.toString(students));

        // 并行排序
        Integer[] largeArray = new Integer[100];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int) (Math.random() * 100);
        }

        // 并行降序排序
        Arrays.parallelSort(largeArray, Comparator.reverseOrder());
        System.out.println("并行降序排序后的数组: " + Arrays.toString(largeArray));
    }
}    