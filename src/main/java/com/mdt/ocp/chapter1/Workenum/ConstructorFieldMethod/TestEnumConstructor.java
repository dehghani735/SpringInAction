package com.mdt.ocp.chapter1.Workenum.ConstructorFieldMethod;

public class TestEnumConstructor {
    public enum Season {
        WINTER("LOW"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
        private String expectedVisitors;

        private Season(String expectedVisitors) {
            System.out.println("Constructing...");
            this.expectedVisitors = expectedVisitors;
        }

        public void printExpectedVisitors() {
            System.out.println(expectedVisitors);
        }
    }

    public enum OnlyOne {
        ONCE(true);

        private OnlyOne(boolean b) {
            System.out.println("constructing");
        }
    }

    public enum Season2 {
        WINTER {
            public void printHours() { System. out .println("9am-3pm"); }
        }, SPRING {
            public void printHours() { System. out .println("9am-5pm"); }
        }, SUMMER {
            public void printHours() { System. out .println("9am-7pm"); }
        }, FALL {
            public void printHours() { System. out .println("9am-5pm"); }
        };
        public abstract void printHours();
    }

    public enum Season3 {
        WINTER {
            public void printHours() { System.out.println("short hours"); }
        }, SUMMER {
            public void printHours() { System.out.println("long hours"); }
        }, SPRING, FALL;
        public void printHours() { System.out.println("default hours"); }
    }

    public static void main(String[] args) {
        Season.SUMMER.printExpectedVisitors();
        Season.SUMMER.printExpectedVisitors();

        OnlyOne firstCall = OnlyOne.ONCE; // prints constructing
        OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything

        Season2.WINTER.printHours();
        Season3.FALL.printHours();
    }
}
