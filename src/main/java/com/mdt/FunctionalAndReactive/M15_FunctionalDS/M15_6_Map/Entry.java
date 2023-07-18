package com.mdt.FunctionalAndReactive.M15_FunctionalDS.M15_6_Map;

public class Entry {

    Object key;
    Object value;
    Entry next; // for collision resolution

    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public Entry() {
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Entry getNext() {
        return next;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}
