package com.mdt.tacobar;

public class Demo {

    public enum Week {
        SATURDAY, SUNDAY
    }

    public void traverse(){
        for (Week week : Week.values()){
            System.out.println(week.name() + " , " + week.ordinal());
        }
    }
}
