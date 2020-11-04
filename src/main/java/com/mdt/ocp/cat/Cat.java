package com.mdt.ocp.cat;

abstract class Cat {
//    one way let it blank
//    one way
    abstract void Clean();
//    default implementation
//    void Clean() {}
}

class Lion extends Cat {
    void Clean() {}
}
