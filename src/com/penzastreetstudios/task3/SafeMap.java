package com.penzastreetstudios.task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SafeMap<K, V> implements Map<K, V> {

    private final Map<K, V> map = new HashMap<>();

    @Override
    public int size() {
        synchronized (map) {
            return map.size();
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (map) {
            return map.isEmpty();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        synchronized (map) {
            return map.containsKey(key);
        }
    }

    @Override
    public boolean containsValue(Object value) {
        synchronized (map) {
            return map.containsValue(value);
        }
    }

    @Override
    public V get(Object key) {
        synchronized (map) {
            return map.get(key);
        }
    }

    @Override
    public V put(K key, V value) {
        synchronized (map) {
            return map.put(key, value);
        }
    }

    @Override
    public V remove(Object key) {
        synchronized (map) {
            return map.remove(key);
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        synchronized (map) {
            map.putAll(m);
        }
    }

    @Override
    public void clear() {
        synchronized (map) {
            map.clear();
        }
    }

    @Override
    public Set<K> keySet() {
        synchronized (map) {
            return map.keySet();
        }
    }

    @Override
    public Collection<V> values() {
        synchronized (map) {
            return map.values();
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        synchronized (map) {
            return map.entrySet();
        }
    }
}
