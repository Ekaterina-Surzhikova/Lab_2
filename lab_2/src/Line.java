public class Line {
    private Point start;
    private Point end;

    // Геттеры и сеттеры
    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    // Конструкторы
    public Line() {
        this.start = new Point(0, 0);
        this.end = new Point(1, 1);
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Метод для получения текстового представления согласно заданию
    public String getTextRepresentation() {
        return "Линия от {" + start.getX() + ";" + start.getY() + "} до {" + end.getX() + ";" + end.getY() + "}";
    }

    public void printInfo() {
        System.out.println("Начальная точка: " + start);
        System.out.println("Конечная точка: " + end);
        System.out.println("Текстовое представление: " + getTextRepresentation());
        System.out.println("-----------------------------");
    }

    public void draw() {
        System.out.println("Линия от " + start + " до " + end + " нарисована!");
    }

    @Override
    public String toString() {
        return getTextRepresentation();
    }
}