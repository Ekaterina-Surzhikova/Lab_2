public class Point {
    //поля
    private int x;
    private int y;

//свойства
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

//конструкторы
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void printInfo() {
        System.out.println("Координата X: " + x);
        System.out.println("Координата Y: " + y);
        System.out.println("-----------------------------");
    }

    public void display() {
        System.out.println("Точка с координатами {" + x + ";" + y + "} отображена!");
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}