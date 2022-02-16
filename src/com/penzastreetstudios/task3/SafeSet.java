package com.penzastreetstudios.task3;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeSet<E> implements Set<E> {

    private final Set<E> set = new HashSet<E>();
    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        try {
            semaphore.acquire();
            int res = set.size();
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            boolean res = set.isEmpty();
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire();
            boolean res = set.contains(o);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        try {
            semaphore.acquire();
            Iterator<E> res = set.iterator();
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Collections.emptyIterator();
        }
    }

    @Override
    public Object[] toArray() {
        try {
            semaphore.acquire();
            Object[] res = set.toArray();
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new Object[0];
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        try {
            semaphore.acquire();
            T[] res = set.toArray(a);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return a;
        }
    }

    @Override
    public boolean add(E e) {
        try {
            semaphore.acquire();
            boolean res = set.add(e);
            semaphore.release();
            return res;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            boolean res = set.remove(o);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean res = set.containsAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            semaphore.acquire();
            boolean res = set.addAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean res = set.retainAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean res = set.removeAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            set.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
