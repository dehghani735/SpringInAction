package com.mdt.ocp.chapter1;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class ListHelper {

    public List<String> copyAndSortList(List<String> original) {
        List<String> list = new ArrayList<String>(original);
        sort(list); // sort() is a static method on Collections => you definitely need a static import
        return list;
    }
}
