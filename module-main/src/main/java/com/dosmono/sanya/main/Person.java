package com.dosmono.sanya.main;

import com.dosmono.sanya.architecture.app.WTF;

public class Person {
    private String name;
    private String age;

    private WTF wtf;

    public Person(WTF wtf) {
        this.wtf =wtf;
        this.name = wtf.getName();
        this.age = wtf.getAge();
    }


    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public WTF getWtf() {
        return wtf;
    }
}
