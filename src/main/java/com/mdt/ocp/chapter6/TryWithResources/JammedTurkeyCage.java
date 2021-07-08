package com.mdt.ocp.chapter6.TryWithResources;

public class JammedTurkeyCage implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }

    public static void main(String[] args) {
        //1
//        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
//            throw new IllegalStateException("turkeys ran off");
//        } catch (IllegalStateException e) {
//            System.out.println("caught: " + e.getMessage());
//            for (Throwable t : e.getSuppressed())
//                System.out.println(t.getMessage());
//        }
        //2
//        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
//            throw new RuntimeException("turkeys ran off");
//        } catch (IllegalStateException e) {
//            System.out.println("caught: " + e.getMessage());
//        }
        //3
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new IllegalStateException("turkeys ran off");
        } finally {
            throw new RuntimeException("and we couldn't find them");
        }
    }
}
