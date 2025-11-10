public class Fraction {
    private int numerator;
    private int denominator;
//геттеры и сеттеры
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.denominator = denominator;
        simplify();
    }
//конструкторы
    public Fraction() {
        this.numerator = 1;
        this.denominator = 2;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // метод для упрощения дроби
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    //НОД
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraction sum(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction sum(int number) {
        return sum(new Fraction(number, 1));
    }

    public Fraction minus(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction minus(int number) {
        return minus(new Fraction(number, 1));
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(int number) {
        return multiply(new Fraction(number, 1));
    }

    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction div(int number) {
        return div(new Fraction(number, 1));
    }

    public void printInfo() {
        System.out.println("Числитель: " + numerator);
        System.out.println("Знаменатель: " + denominator);
        System.out.println("Дробь: " + toString());
        System.out.println("-----------------------------");
    }

    public void displayFraction() {
        System.out.println("Дробь " + toString() + " отображена!");
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}