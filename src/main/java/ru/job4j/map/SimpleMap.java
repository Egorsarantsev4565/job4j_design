package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int h = key.hashCode();
        int hash = hash(h);
        int index = indexFor(hash);
        if (table[index] == null || table[index].equals(key)) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        return hashCode % table.length;
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] tmp = table;
        table = new MapEntry[capacity];
        for (int i = 0; i < capacity / 2; i++) {
            if (tmp[i] != null) {
                table[indexFor(hash(tmp[i].key.hashCode()))] = tmp[i];
            }
        }

    }

    @Override
    public V get(K key) {
        int h = key.hashCode();
        int hash = hash(h);
        int index = indexFor(hash);
        return table[index] != null && table[index].key.equals(key) ? table[index].value : null;
    }

    @Override
    public boolean remove(K key) {
        int h = key.hashCode();
        int hash = hash(h);
        int index = indexFor(hash);
            if (table[index] != null && table[index].equals(key)) {
            table[index] = null;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int itPoint = 0;
            private int itCapacity = capacity;
            private int itModCount = modCount;

            @Override
            public boolean hasNext() {
                if (itModCount != modCount) {
                    throw new ConcurrentModificationException("Map was changed!");
                }
                while (itPoint < itCapacity) {
                    if (table[itPoint] != null) {
                        return true;
                    }
                    itPoint++;
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No Items");
                }
                return table[itPoint++].getKey();
            }
        };
    }

    private class MapEntry<K, V> {

       private K key;

       private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }
}



