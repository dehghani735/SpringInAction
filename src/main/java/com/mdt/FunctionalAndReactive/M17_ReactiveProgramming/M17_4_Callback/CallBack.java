package com.mdt.FunctionalAndReactive.M17_ReactiveProgramming.M17_4_Callback;

public interface CallBack {

    void pushData(String data);

    /**
     * we will use to signal the completion of any process running on a separate thread than the main thread.
     */
    void pushComplete();

    void pushError(Exception ex);
}
