package com.mdt.FunctionalAndReactive.M17_ReactiveProgramming.M17_6_Observer;

public interface SubjectLibrary {

    public void subscribeObserver(Observer ob);

    public void unsubscribeObserver(Observer ob);

    public void notifyObserver();
}
