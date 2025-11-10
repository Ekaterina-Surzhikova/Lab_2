import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Point> points = new ArrayList<>();
    private static List<Name> names = new ArrayList<>();
    private static List<Line> lines = new ArrayList<>();
    private static List<Fraction> fractions = new ArrayList<>();

    // Добавляем CityManager вместо списка городов
    private static CityManager cityManager = new CityManager();

    // Добавляем статические переменные для демонстрационных линий
    private static Line demoLine1;
    private static Line demoLine2;
    private static Line demoLine3;

    public static void main(String[] args) {
        // Добавляем начальные данные для демонстрации
        initializeDemoData();

        System.out.println("=== ПРОГРАММА ДЛЯ ДЕМОНСТРАЦИИ КЛАССОВ ===");

        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = Validator.getIntInput(scanner, "Выберите пункт меню: ");

            switch (choice) {
                case 1:
                    pointMenu();
                    break;
                case 2:
                    nameMenu();
                    break;
                case 3:
                    lineMenu();
                    break;
                case 4:
                    cityMenu();
                    break;
                case 5:
                    fractionMenu();
                    break;
                case 6:
                    demonstrateAll();
                    break;
                case 0:
                    running = false;
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
        scanner.close();
    }

    private static void initializeDemoData() {
        // Инициализация точек
        points.add(new Point(2, 3));
        points.add(new Point(-1, 4));
        points.add(new Point(0, -5));

        // Инициализация имен
        names.add(new Name(null, "Клеопатра", null));
        names.add(new Name("Пушкин", "Александр", "Сергеевич"));
        names.add(new Name("Маяковский", "Владимир", null));

        // Инициализация демонстрационных линий согласно заданию
        initializeDemoLines();

        // Инициализация линий для основного списка (отдельные объекты)
        Point start1 = new Point(1, 3);
        Point end1 = new Point(23, 8);
        lines.add(new Line(start1, end1));

        Point start2 = new Point(5, 10);
        Point end2 = new Point(25, 10);
        lines.add(new Line(start2, end2));

        // Инициализация городов через CityManager
        // Создаем города разными способами согласно новым требованиям

        // 1. Город только с названием
        cityManager.createCity("Москва");

        // 2. Город с названием и связями
        Map<String, Integer> spbRoutes = new HashMap<>();
        spbRoutes.put("Москва", 500);
        City stPetersburg = cityManager.createCity("Санкт-Петербург", spbRoutes);

        // 3. Создаем двусторонние связи для демонстрации
        cityManager.createBidirectionalRoute("Москва", "Казань", 800);
        cityManager.createBidirectionalRoute("Москва", "Нижний Новгород", 400);

        // Инициализация дробей
        fractions.add(new Fraction(1, 3));
        fractions.add(new Fraction(2, 3));
        fractions.add(new Fraction(1, 2));
    }

    private static void initializeDemoLines() {
        // 1. Линия 1 с началом в т. {1;3} и концом в т.{23;8}
        Point start1 = new Point(1, 3);
        Point end1 = new Point(23, 8);
        demoLine1 = new Line(start1, end1);

        // 2. Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25
        Point start2 = new Point(5, 10);
        Point end2 = new Point(25, 10);
        demoLine2 = new Line(start2, end2);

        // 3. Линия 3, которая начинается там же, где начинается линия 1,
        // и заканчивается там же, где заканчивается линия 2
        // Для этого используем ССЫЛКИ на те же объекты точек
        demoLine3 = new Line(demoLine1.getStart(), demoLine2.getEnd());
    }

    private static void showMainMenu() {
        System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
        System.out.println("1. Работа с Точками");
        System.out.println("2. Работа с Именами");
        System.out.println("3. Работа с Линиями");
        System.out.println("4. Работа с Городами");
        System.out.println("5. Работа с Дробями");
        System.out.println("6. Демонстрация всех классов");
        System.out.println("0. Выход");
        System.out.println("====================");
    }

    private static void pointMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== РАБОТА С ТОЧКАМИ ===");
            System.out.println("1. Показать все точки");
            System.out.println("2. Добавить новую точку");
            System.out.println("3. Демонстрация работы класса");
            System.out.println("0. Назад в главное меню");

            int choice = Validator.getIntInput(scanner, "Выберите действие: ");

            switch (choice) {
                case 1:
                    showAllPoints();
                    break;
                case 2:
                    addNewPoint();
                    break;
                case 3:
                    demonstratePoint();
                    break;
                case 0:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private static void nameMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== РАБОТА С ИМЕНАМИ ===");
            System.out.println("1. Показать все имена");
            System.out.println("2. Добавить новое имя");
            System.out.println("3. Демонстрация работы класса");
            System.out.println("0. Назад в главное меню");

            int choice = Validator.getIntInput(scanner, "Выберите действие: ");

            switch (choice) {
                case 1:
                    showAllNames();
                    break;
                case 2:
                    addNewName();
                    break;
                case 3:
                    demonstrateName();
                    break;
                case 0:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private static void lineMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== РАБОТА С ЛИНИЯМИ ===");
            System.out.println("1. Показать все линии");
            System.out.println("2. Добавить новую линию");
            System.out.println("3. Демонстрация работы класса");
            System.out.println("0. Назад в главное меню");

            int choice = Validator.getIntInput(scanner, "Выберите действие: ");

            switch (choice) {
                case 1:
                    showAllLines();
                    break;
                case 2:
                    addNewLine();
                    break;
                case 3:
                    demonstrateLine();
                    break;
                case 0:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private static void cityMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== РАБОТА С ГОРОДАМИ ===");
            System.out.println("1. Показать все города");
            System.out.println("2. Добавить новый город (только название)");
            System.out.println("3. Добавить город с маршрутами");
            System.out.println("4. Добавить маршрут между городами");
            System.out.println("5. Построить демонстрационную сеть");
            System.out.println("6. Демонстрация работы класса");
            System.out.println("0. Назад в главное меню");

            int choice = Validator.getIntInput(scanner, "Выберите действие: ");

            switch (choice) {
                case 1:
                    showAllCities();
                    break;
                case 2:
                    addNewCity();
                    break;
                case 3:
                    addNewCityWithRoutes();
                    break;
                case 4:
                    addCityRoute();
                    break;
                case 5:
                    buildSampleNetwork();
                    break;
                case 6:
                    demonstrateCity();
                    break;
                case 0:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private static void fractionMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== РАБОТА С ДРОБЯМИ ===");
            System.out.println("1. Показать все дроби");
            System.out.println("2. Добавить новую дробь");
            System.out.println("3. Выполнить операции с дробями");
            System.out.println("4. Демонстрация работы класса");
            System.out.println("0. Назад в главное меню");

            int choice = Validator.getIntInput(scanner, "Выберите действие: ");

            switch (choice) {
                case 1:
                    showAllFractions();
                    break;
                case 2:
                    addNewFraction();
                    break;
                case 3:
                    performFractionOperations();
                    break;
                case 4:
                    demonstrateFraction();
                    break;
                case 0:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    // Методы для работы с точками
    private static void showAllPoints() {
        System.out.println("\n--- ВСЕ ТОЧКИ ---");
        if (points.isEmpty()) {
            System.out.println("Точки отсутствуют");
        } else {
            for (int i = 0; i < points.size(); i++) {
                System.out.println((i + 1) + ". " + points.get(i));
            }
        }
    }

    private static void addNewPoint() {
        System.out.println("\n--- ДОБАВЛЕНИЕ НОВОЙ ТОЧКИ ---");
        int x = Validator.getIntInput(scanner, "Введите координату X: ");
        int y = Validator.getIntInput(scanner, "Введите координату Y: ");

        Point newPoint = new Point(x, y);
        points.add(newPoint);
        System.out.println("Точка " + newPoint + " успешно добавлена!");
    }

    // Методы для работы с именами
    private static void showAllNames() {
        System.out.println("\n--- ВСЕ ИМЕНА ---");
        if (names.isEmpty()) {
            System.out.println("Имена отсутствуют");
        } else {
            for (int i = 0; i < names.size(); i++) {
                System.out.println((i + 1) + ". " + names.get(i));
            }
        }
    }

    private static void addNewName() {
        System.out.println("\n--- ДОБАВЛЕНИЕ НОВОГО ИМЕНИ ---");
        System.out.println("Введите данные (можно оставить пустым):");

        System.out.print("Фамилия: ");
        String lastName = scanner.nextLine().trim();
        if (lastName.isEmpty()) lastName = null;

        System.out.print("Имя: ");
        String firstName = scanner.nextLine().trim();
        if (firstName.isEmpty()) firstName = null;

        System.out.print("Отчество: ");
        String middleName = scanner.nextLine().trim();
        if (middleName.isEmpty()) middleName = null;

        Name newName = new Name(lastName, firstName, middleName);
        names.add(newName);
        System.out.println("Имя '" + newName + "' успешно добавлено!");
    }

    // Методы для работы с линиями
    private static void showAllLines() {
        System.out.println("\n--- ВСЕ ЛИНИИ ---");
        if (lines.isEmpty()) {
            System.out.println("Линии отсутствуют");
        } else {
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ". " + lines.get(i));
            }
        }
    }

    private static void addNewLine() {
        System.out.println("\n--- ДОБАВЛЕНИЕ НОВОЙ ЛИНИИ ---");

        if (points.size() < 2) {
            System.out.println("Недостаточно точек для создания линии. Сначала создайте точки.");
            return;
        }

        showAllPoints();
        int startIndex = Validator.getIntInput(scanner, "Выберите номер точки начала: ") - 1;
        int endIndex = Validator.getIntInput(scanner, "Выберите номер точки конца: ") - 1;

        if (!Validator.isValidIndex(startIndex, points.size()) ||
                !Validator.isValidIndex(endIndex, points.size())) {
            System.out.println("Неверный номер точки!");
            return;
        }

        Line newLine = new Line(points.get(startIndex), points.get(endIndex));
        lines.add(newLine);
        System.out.println("Линия " + newLine + " успешно добавлена!");
    }

    // Методы для работы с городами (обновленные)
    private static void showAllCities() {
        System.out.println("\n--- ВСЕ ГОРОДА ---");
        Collection<City> allCities = cityManager.getAllCities();
        if (allCities.isEmpty()) {
            System.out.println("Города отсутствуют");
        } else {
            int i = 1;
            for (City city : allCities) {
                System.out.println((i++) + ". " + city);
            }
        }
    }

    private static void addNewCity() {
        System.out.println("\n--- ДОБАВЛЕНИЕ НОВОГО ГОРОДА (ТОЛЬКО НАЗВАНИЕ) ---");
        System.out.print("Введите название города: ");
        String cityName = scanner.nextLine().trim();

        City newCity = cityManager.createCity(cityName);
        System.out.println("Город '" + cityName + "' успешно добавлен!");
    }

    private static void addNewCityWithRoutes() {
        System.out.println("\n--- ДОБАВЛЕНИЕ ГОРОДА С МАРШРУТАМИ ---");
        System.out.print("Введите название города: ");
        String cityName = scanner.nextLine().trim();

        Map<String, Integer> routes = new HashMap<>();
        boolean addingRoutes = true;

        while (addingRoutes) {
            System.out.print("Введите название связанного города (или 'стоп' для завершения): ");
            String connectedCity = scanner.nextLine().trim();

            if (connectedCity.equalsIgnoreCase("стоп")) {
                addingRoutes = false;
                continue;
            }

            int cost = Validator.getIntInput(scanner, "Введите стоимость пути: ");
            routes.put(connectedCity, cost);
        }

        City newCity = cityManager.createCity(cityName, routes);
        System.out.println("Город '" + cityName + "' с маршрутами успешно добавлен!");
    }

    private static void addCityRoute() {
        System.out.println("\n--- ДОБАВЛЕНИЕ МАРШРУТА МЕЖДУ ГОРОДАМИ ---");

        Collection<City> allCities = cityManager.getAllCities();
        if (allCities.size() < 2) {
            System.out.println("Недостаточно городов для создания маршрута.");
            return;
        }

        showAllCities();

        System.out.print("Введите название города отправления: ");
        String fromCityName = scanner.nextLine().trim();

        System.out.print("Введите название города назначения: ");
        String toCityName = scanner.nextLine().trim();

        int cost = Validator.getIntInput(scanner, "Введите стоимость поездки: ");

        cityManager.createBidirectionalRoute(fromCityName, toCityName, cost);
        System.out.println("Двусторонний маршрут между '" + fromCityName + "' и '" + toCityName + "' успешно добавлен!");
    }

    private static void buildSampleNetwork() {
        System.out.println("\n--- ПОСТРОЕНИЕ ДЕМОНСТРАЦИОННОЙ СЕТИ ГОРОДОВ ---");
        cityManager.buildSampleNetwork();
        System.out.println("Демонстрационная сеть городов успешно построена!");
    }

    // Методы для работы с дробями
    private static void showAllFractions() {
        System.out.println("\n--- ВСЕ ДРОБИ ---");
        if (fractions.isEmpty()) {
            System.out.println("Дроби отсутствуют");
        } else {
            for (int i = 0; i < fractions.size(); i++) {
                System.out.println((i + 1) + ". " + fractions.get(i));
            }
        }
    }

    private static void addNewFraction() {
        System.out.println("\n--- ДОБАВЛЕНИЕ НОВОЙ ДРОБИ ---");
        int numerator = Validator.getIntInput(scanner, "Введите числитель: ");
        int denominator = Validator.getIntInput(scanner, "Введите знаменатель: ");

        try {
            Fraction newFraction = new Fraction(numerator, denominator);
            fractions.add(newFraction);
            System.out.println("Дробь " + newFraction + " успешно добавлена!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void performFractionOperations() {
        System.out.println("\n--- ОПЕРАЦИИ С ДРОБЯМИ ---");

        if (fractions.size() < 2) {
            System.out.println("Недостаточно дробей для операций.");
            return;
        }

        showAllFractions();
        int f1Index = Validator.getIntInput(scanner, "Выберите номер первой дроби: ") - 1;
        int f2Index = Validator.getIntInput(scanner, "Выберите номер второй дроби: ") - 1;

        if (!Validator.isValidIndex(f1Index, fractions.size()) ||
                !Validator.isValidIndex(f2Index, fractions.size())) {
            System.out.println("Неверный номер дроби!");
            return;
        }

        Fraction f1 = fractions.get(f1Index);
        Fraction f2 = fractions.get(f2Index);

        System.out.println("\nРезультаты операций:");
        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));

        try {
            System.out.println(f1 + " / " + f2 + " = " + f1.div(f2));
        } catch (IllegalArgumentException e) {
            System.out.println(f1 + " / " + f2 + " = Ошибка: " + e.getMessage());
        }
    }

    // Демонстрационные методы
    private static void demonstratePoint() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ КЛАССА ТОЧКА ===");
        if (points.size() >= 2) {
            System.out.println("Пример работы:");
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            System.out.println("Точка 1: " + p1);
            System.out.println("Точка 2: " + p2);

            // Демонстрация изменения координат
            System.out.println("\nИзменяем координаты точки 1:");
            p1.setX(10);
            p1.setY(20);
            System.out.println("После изменения - Точка 1: " + p1);
        } else {
            System.out.println("Недостаточно точек для демонстрации.");
        }
    }

    private static void demonstrateName() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ КЛАССА ИМЯ ===");
        if (!names.isEmpty()) {
            System.out.println("Примеры имен:");
            for (Name name : names) {
                System.out.println("Имя: '" + name + "'");
                System.out.println("  Фамилия: " + (name.getLastName() != null ? name.getLastName() : "не указана"));
                System.out.println("  Имя: " + (name.getFirstName() != null ? name.getFirstName() : "не указано"));
                System.out.println("  Отчество: " + (name.getMiddleName() != null ? name.getMiddleName() : "не указано"));
            }
        }
    }

    private static void demonstrateLine() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ КЛАССА ЛИНИЯ ===");

        // Инициализируем демонстрационные линии ПЕРЕД каждой демонстрацией
        initializeDemoLines();

        System.out.println("=== ИСХОДНЫЕ ЛИНИИ ===");
        System.out.println("Линия 1: " + demoLine1.getTextRepresentation());
        System.out.println("Линия 2: " + demoLine2.getTextRepresentation());
        System.out.println("Линия 3: " + demoLine3.getTextRepresentation());

        // 4. Изменяем координаты первой и второй линий
        System.out.println("\n=== ИЗМЕНЕНИЕ КООРДИНАТ ПЕРВОЙ И ВТОРОЙ ЛИНИЙ ===");

        System.out.println("Меняем начало первой линии с {1;3} на {10;15}");
        demoLine1.getStart().setX(10);
        demoLine1.getStart().setY(15);

        System.out.println("Меняем конец второй линии с {25;10} на {30;20}");
        demoLine2.getEnd().setX(30);
        demoLine2.getEnd().setY(20);

        System.out.println("\nПосле изменения:");
        System.out.println("Линия 1: " + demoLine1.getTextRepresentation());
        System.out.println("Линия 2: " + demoLine2.getTextRepresentation());
        System.out.println("Линия 3: " + demoLine3.getTextRepresentation()); // Должна автоматически измениться!

        // Проверяем, что третья линия действительно использует те же объекты
        System.out.println("\nПроверка ссылок:");
        System.out.println("line1.start == line3.start: " + (demoLine1.getStart() == demoLine3.getStart()));
        System.out.println("line2.end == line3.end: " + (demoLine2.getEnd() == demoLine3.getEnd()));
    }

    private static void demonstrateCity() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ КЛАССА ГОРОД ===");
        System.out.println("Демонстрация работы CityManager с разными способами создания городов:");

        // Показываем все города
        cityManager.displayAllCities();
    }

    private static void demonstrateFraction() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ КЛАССА ДРОБЬ ===");
        if (fractions.size() >= 3) {
            Fraction f1 = fractions.get(0);
            Fraction f2 = fractions.get(1);
            Fraction f3 = fractions.get(2);

            System.out.println("Исходные дроби:");
            System.out.println("f1 = " + f1);
            System.out.println("f2 = " + f2);
            System.out.println("f3 = " + f3);

            System.out.println("\nПример цепочки операций: ((1/3 + 2/3) ÷ 1/2) - 5");
            try {
                Fraction result = f1.sum(f2).div(f3).minus(5);
                System.out.println("Результат: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка при вычислении: " + e.getMessage());
            }
        } else {
            System.out.println("Недостаточно дробей для демонстрации.");
        }
    }

    private static void demonstrateAll() {
        System.out.println("\n=== ПОЛНАЯ ДЕМОНСТРАЦИЯ ВСЕХ КЛАССОВ ===");
        demonstratePoint();
        demonstrateName();
        demonstrateLine();
        demonstrateCity();
        demonstrateFraction();
    }
}