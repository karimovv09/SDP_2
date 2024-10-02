import java.util.HashMap;
import java.util.Map;

public class Prototype {
    static abstract class Shape implements Cloneable { // Make it static
        private String id;
        protected String type;

        abstract void draw();

        public String getType() {
            return type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class Circle extends Shape { // Also make Circle static
        public Circle() {
            type = "Circle";
        }

        @Override
        void draw() {
            System.out.println("Drawing a Circle.");
        }
    }

    static class Rectangle extends Shape { // Also make Rectangle static
        public Rectangle() {
            type = "Rectangle";
        }

        @Override
        void draw() {
            System.out.println("Drawing a Rectangle.");
        }
    }

    static class ShapeCache { // Ensure ShapeCache is also static
        private static Map<String, Shape> shapeMap = new HashMap<>();

        public static Shape getShape(String shapeId) {
            Shape cachedShape = shapeMap.get(shapeId);
            try {
                return (Shape) cachedShape.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static void loadCache() {
            Circle circle = new Circle();
            circle.setId("1");
            shapeMap.put(circle.getId(), circle);

            Rectangle rectangle = new Rectangle();
            rectangle.setId("2");
            shapeMap.put(rectangle.getId(), rectangle);
        }
    }
}
