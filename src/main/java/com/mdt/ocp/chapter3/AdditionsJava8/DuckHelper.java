package com.mdt.ocp.chapter3.AdditionsJava8;

import com.mdt.ocp.chapter3.ComparableAndComparator.Duck;

// this class is used in duck in package com.mdt.ocp.chapter3.ComparableAndComparator;
public class DuckHelper {
    public static int compareByWeight(Duck d1, Duck d2) {
        return d1.getWeight() - d2.getWeight();
    }

    public static int compareByName(Duck d1, Duck d2) {
        return d1.getName().compareTo(d2.getName());
    }
}
