package com.mdt.ocp.chapter1.Workenum;

public class TestEnum {

    public enum Season {
        WINTER, SPRING, SUMMER, FALL
    }

    public static void main(String[] args) {
        Season s = Season.SUMMER;
        System.out.println(Season.SUMMER);
        System.out.println(s == Season.SUMMER);

        for (Season season : Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }
//        if (Season.SUMMER == 2) {}  does not compile
        Season s1 = Season.valueOf("SUMMER");
//        Season s2 = Season.valueOf("summer"); // Exception

        Season summer = Season.SUMMER;
        switch (summer) {
            case WINTER:
                System.out.println("Get out the sled!");
                break;
            case SUMMER:
                System.out.println("Time for the pool");
                break;
//            case 0:   // it does not compile, enum is not int
//                System.out.println("sss");
            default:
                System.out.println("Is it summer yet?");
        }
    }
}

//public enum ExtendedSeason extends TestEnum.Season { }  // Compile error; can not extend enum
