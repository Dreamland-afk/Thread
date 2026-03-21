package org.dreamquest.executors;

import java.util.concurrent.ThreadFactory;

class CustomThreadName implements ThreadFactory {


    private String tname = null;

    private int ordinal = 1;

    public CustomThreadName(String tname) {
        this.tname = tname;

    }
    public CustomThreadName() {

    }
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);

        String name = tname;

        if (name == null) {

            System.out.println("Ordinal: " + ordinal);

            name = ThreadColor.values()[ordinal].name();

            name = name.substring(5);
            ++ordinal;
            if (ordinal > 5) {
                ordinal = 1;
            }

            System.out.println("Thread Name: "+name);

        }

        thread.setName(name);
        return thread;
    }
}
