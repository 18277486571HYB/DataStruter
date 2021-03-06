package com.hyb.ds.排序;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;
public class Student implements Comparable<Student> {
    private String name;		// 姓名
    private int age;			// 年龄

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age; // 比较年龄(年龄的升序)
    }

}



class Test01 {

    public static void main(String[] args) throws Exception {
//        Set<Student> set = new TreeSet<>();		// Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
//        set.add(new Student("Hao LUO", 33));
//        set.add(new Student("XJ WANG", 32));
//        set.add(new Student("Bruce LEE", 60));
//        set.add(new Student("Bob YANG", 22));
//
//        for(Student stu : set) {
//            System.out.println(stu);
//        }
//		输出结果:
//		Student [name=Bob YANG, age=22]
//		Student [name=XJ WANG, age=32]
//		Student [name=Hao LUO, age=33]
//		Student [name=Bruce LEE, age=60]
        Student student = new Student();
        Field[] declaredFields = student.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            if (declaredFields[i].getName().equals("name")){
                declaredFields[i].set(student,"hyb");
            }else {
                declaredFields[i].set(student,21);
            }
        }
        Method[] methods = student.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals("toString")) {
                System.out.println(method.invoke(student));
            }
        }
    }
}

