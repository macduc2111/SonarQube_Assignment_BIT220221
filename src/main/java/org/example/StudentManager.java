package org.example;

public class StudentManager {
    private String[] students = new String[100];
    private int count = 0;

    public void addStudent(String name) {
        if (name == null) {
            System.out.println("Name is null");
        } else {
            students[count] = name;
            count++;
        }
    }

    public String findStudent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return students[i];
            }
        }
        return null;
    }

    public void removeStudent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                students[i] = students[count - 1];
                count--;
            }
        }
    }
}