class Sum {
    public static int sumOfAreas(Shape[] array) {
        int sumOfArea = 0;

        for(Shape shape: array){
            if(Square.class.isInstance(shape) ){
                Square newShape = (Square) shape;
                sumOfArea += newShape.getArea();
                continue;
            }

            if(Rectangle.class.isInstance(shape) ){
                Rectangle newShape = (Rectangle) shape;
                sumOfArea += newShape.getArea();
                continue;
            }
        }

        return sumOfArea;
    }
}

//Don't change the code below
class Shape {
}

class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getArea(){
        return side * side;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(){
        return height * width;
    }
}