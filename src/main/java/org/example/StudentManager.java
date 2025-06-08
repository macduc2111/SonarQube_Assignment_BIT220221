package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentManager {
    private static final Logger logger = Logger.getLogger(StudentManager.class.getName());
    private final String[] students = new String[100];
    private int count = 0;

    public void addStudent(String name) {
        if (name == null || name.trim().isEmpty()) {
            logger.warning("Name cannot be null or empty");
            return;
        }
        if (count >= students.length) {
            logger.warning("Student list is full");
            return;
        }
        students[count++] = name;
    }

    public String findStudent(String name) {
        if (name == null) {
            return null;
        }
        for (int i = 0; i < count; i++) {
            if (name.equals(students[i])) {
                return students[i];
            }
        }
        return null;
    }

    public void removeStudent(String name) {
        if (name == null) return;
        for (int i = 0; i < count; i++) {
            if (name.equals(students[i])) {
                students[i] = students[count - 1];
                students[count - 1] = null;
                count--;
                if (logger.isLoggable(Level.INFO)) {
                    logger.info(String.format("Removed student: %s", name));
                }
                break;
            }
        }
    }
}
