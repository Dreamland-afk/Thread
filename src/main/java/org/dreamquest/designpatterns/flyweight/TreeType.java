package org.dreamquest.designpatterns.flyweight;
import java.awt.*;
/* Flyweight class that represents the intrinsic state of a tree. It contains properties that are shared among
multiple tree instances, such as name, color, and texture.
The draw method simulates the drawing of the tree on the screen, using the intrinsic state to determine how it should be rendered.

In the Flyweight pattern, the TreeType class is designed to be shared among multiple Tree instances, allowing for memory optimization by avoiding the duplication of common data. Each Tree instance can reference a TreeType, which contains the shared properties, while maintaining its own extrinsic state (like position) that is not shared.
 */
public class TreeType {

       private final String name;
       private final Color color;
       private final String texture;

    public TreeType(String name, Color color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }
}
