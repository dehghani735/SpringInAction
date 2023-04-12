package com.mdt.FunctionalAndReactive.M9_2_Iterator;

import java.util.function.Consumer;

public class MyArrayList {

    Object[] elements = new Object[5];

    public MyArrayList(Object[] elements) {
        this.elements = elements;
    }

    public void forEach(Consumer<Object> action) {
        for (Object element : elements) {
            action.accept(element);
        }
    }
}
