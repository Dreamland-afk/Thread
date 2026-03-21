package org.dreamquest.designpatterns.factory;

public class Factory {

    private static Factory factory = null;
    private Factory() {
        // Private constructor to prevent instantiation
    }

    static Factory getFactory() {
        if (factory == null) {
            factory = new Factory();
        }
        return factory;
    }

    UICreate getUI(String type){
        if(type.equalsIgnoreCase("Windows")){
            return new WindowsUI();
        } else if(type.equalsIgnoreCase("Mac")){
            return new MacUI();
        } else {
            throw new IllegalArgumentException("Invalid UI type: " + type);
        }
    }
}
