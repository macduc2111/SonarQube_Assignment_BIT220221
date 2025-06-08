package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentManagerTest {

    @Test
    void testAddAndFindStudent() {
        StudentManager sm = new StudentManager();
        sm.addStudent("Alice");
        assertEquals("Alice", sm.findStudent("Alice"));
    }

    @Test
    void testRemoveStudent() {
        StudentManager sm = new StudentManager();
        sm.addStudent("Bob");
        sm.removeStudent("Bob");
        assertNull(sm.findStudent("Bob"));
    }

    @Test
    void testNullInput() {
        StudentManager sm = new StudentManager();
        sm.addStudent(null);
        assertNull(sm.findStudent(null));
    }

    @Test
    void testAddStudentWhenFull() {
        StudentManager sm = new StudentManager();
        for (int i = 0; i < 100; i++) {
            sm.addStudent("S" + i);
        }
        sm.addStudent("Overflow");
        assertNull(sm.findStudent("Overflow"));
    }

    @Test
    void testRemoveNonexistentStudent() {
        StudentManager sm = new StudentManager();
        sm.addStudent("Alice");
        sm.removeStudent("Bob");
        assertEquals("Alice", sm.findStudent("Alice"));
    }
}
