package com.mdt.ocp.chapter1.NestedClasses.MemberInner;

public class CaseOfThePrivateInterface {
    private interface Secret {
        public void shh();
    }
    class DontTell implements Secret {
        public void shh() { }
    }
}