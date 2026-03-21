package org.dreamquest.designpatterns.proxy;

/*
Build an Image viewer module where loading an image from disk is expensive. The UI must show a gallery of 1,000 image placeholders instantly, but must not load any actual image bytes until the user clicks a thumbnail.

Design requirements:

Define an Image interface with display() (and optionally getSize()).
Implement RealImage that loads the image file from disk in its constructor (simulate with a delay) and then renders in display().
Implement ImageProxy that implements Image, stores the filename, and creates the RealImage only on the first call to display() (lazy loading).
Subsequent display() calls must reuse the same RealImage instance (no re-loading).
Add logging so it’s visible when the real image is actually loaded vs when only the proxy is used.
 */
public class Executor {
    public static void main(String[] args) {
        Image image1 = new ImageProxy("photo1.jpg");
        Image image2 = new ImageProxy("photo2.jpg");

        // Displaying images (only loads when display is called)
        System.out.println("Displaying image 1:");
        image1.display(); // Loads and displays photo1.jpg

        System.out.println("\nDisplaying image 2:");
        image2.display(); // Loads and displays photo2.jpg

        System.out.println("\nDisplaying image 1 again:");
        image1.display();
        System.out.println("\nDisplaying image 2 again:");
        image2.display(); // Reuses loaded photo1.jpg, no loading delay
    }
}
