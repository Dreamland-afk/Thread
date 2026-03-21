package org.dreamquest.designpatterns.proxy;

import java.util.LinkedHashMap;
import java.util.Map;

public class ImageProxy implements Image{
    private final String fileName;
    private static final Map<String,RealImage> imageCache = new LinkedHashMap<>();// Simulate a cache for loaded images
    ImageProxy(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void display() {
        if(!imageCache.containsKey(fileName)){
            imageCache.put(fileName,new RealImage(fileName));
        }
        RealImage realImage = imageCache.get(fileName);
        realImage.display();
    }
}
