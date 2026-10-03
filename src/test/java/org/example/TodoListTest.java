package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest {

    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().get(0));
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add(" ");
        assertEquals(0, t.size());
    }
    @Test
    void clear() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        t.clear();
        assertEquals(0, t.size());
    }
    @Test
    void markDone() {
        TodoList t = new TodoList();
        t.add("task");
        assertTrue(t.markDone(0));
        assertTrue(t.getAll().get(0).startsWith("[done]"));
        assertFalse(t.markDone(5));
    }

    @Test
    void search() {
        TodoList t = new TodoList();
        t.add("buy milk");
        t.add("buy bread");
        t.add("call mom");
        assertEquals(2, t.search("buy").size());
        assertEquals(1, t.search("mom").size());
        assertEquals(0, t.search("xyz").size());
    }
}