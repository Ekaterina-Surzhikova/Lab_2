import java.util.*;

public class City {
    private String name;
    private Map<City, Integer> routes;

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<City, Integer> getRoutes() {
        return new HashMap<>(routes);
    }

    public void setRoutes(Map<City, Integer> routes) {
        this.routes = new HashMap<>(routes);
    }

    // конструкторы
    public City() {
        this.name = "Москва";
        this.routes = new HashMap<>();
    }

    public City(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    public City(String name, Map<City, Integer> routes) {
        this.name = name;
        this.routes = new HashMap<>(routes);
    }

    // добавление маршрута в указанный город с указанной стоимостью
    public void addRoute(City city, int cost) {
        routes.put(city, cost);
    }

    // удаление маршрута
    public void removeRoute(City city) {
        routes.remove(city);
    }

    // проверка наличия маршрута к городу
    public boolean hasRouteTo(City city) {
        return routes.containsKey(city);
    }

    // получение стоимости маршрута к городу
    public Integer getRouteCost(City city) {
        return routes.get(city);
    }

    public void printInfo() {
        System.out.println("Город: " + name);

        if (!routes.isEmpty()) {
            System.out.println("Связанные города:");
            for (Map.Entry<City, Integer> entry : routes.entrySet()) {
                System.out.println("  - " + entry.getKey().getName() + ": " + entry.getValue());
            }
        } else {
            System.out.println("Нет связанных городов");
        }
        System.out.println("-----------------------------");
    }

    public void displayRoutes() {
        System.out.println("Маршруты из города " + name + " показаны!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Город: ").append(name);

        if (!routes.isEmpty()) {
            sb.append("\n  Связанные города:");
            for (Map.Entry<City, Integer> entry : routes.entrySet()) {
                sb.append("\n    - ").append(entry.getKey().getName())
                        .append(": ").append(entry.getValue());
            }
        } else {
            sb.append(" (нет связей)");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}