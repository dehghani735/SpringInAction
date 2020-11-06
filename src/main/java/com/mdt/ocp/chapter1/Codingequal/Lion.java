package com.mdt.ocp.chapter1.Codingequal;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Lion {
    private int idNumber;
    private int age;
    private String name;

    public Lion(int idNumber, int age, String name) {
        this.idNumber = idNumber;
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // way #1
        if ( !(obj instanceof Lion)) return false;
        Lion otherLion = (Lion) obj;
        return otherLion.idNumber == this.idNumber;

        // way #2
        // Apache Commons Lang facility using Reflection
        // for checking all of the fields
//        return EqualsBuilder.reflectionEquals(this, obj);

        // way #3
        // for checking special fields
//        if ( !(obj instanceof Lion)) return false;
//        Lion otherLion = (Lion) obj;
//        return new EqualsBuilder().appendSuper(super.equals(obj))
//                .append(idNumber, otherLion.idNumber)
//                .append(name, otherLion.name)
//                .isEquals();
    }
}