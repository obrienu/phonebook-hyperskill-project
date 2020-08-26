import java.util.List;

class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
        for(Shape shape: array){

            if(Square.class.isInstance(shape) ){
                squares.add((Square) shape);
                continue;
            }
            if(Circle.class.isInstance(shape) ){
                circles.add((Circle) shape);
                continue;
            }
            if(Polygon.class.isInstance(shape) ){
                polygons.add((Polygon) shape);
                continue;
            }
            if(Shape.class.isInstance(shape) ){
                shapes.add(shape);
                continue;
            }

        }
    }
}

//Don't change classes below
class Shape { }
class Polygon extends Shape { }
class Square extends Polygon { }
class Circle extends Shape { }