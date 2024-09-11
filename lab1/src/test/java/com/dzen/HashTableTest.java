package com.dzen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashTableTest {
    private HashTable hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new HashTable(10);
    }

    @Test
    public void testPutAndGet() {
        hashTable.put(1, 10);
        assertEquals(10, hashTable.get(1));
        hashTable.put(1, 20);
        assertEquals(20, hashTable.get(1));
    }

    @Test
    public void testGetNonExistent() {
        assertNull(hashTable.get(100));
    }

    @Test
    public void testRemove() {
        hashTable.put(1, 10);
        assertTrue(hashTable.remove(1));
        assertNull(hashTable.get(1));
        assertFalse(hashTable.remove(1));
    }

    @Test
    public void testCollisionHandling() {
        hashTable.put(1, 10);
        hashTable.put(11, 20);
        assertEquals(10, hashTable.get(1));
        assertEquals(20, hashTable.get(11));
    }
}
