import java.util.*;

public class CityManager {
    private Map<String, City> cities;

    public CityManager() {
        this.cities = new HashMap<>();
    }

    // Создать город только с названием
    public City createCity(String name) {
        City city = new City(name);
        cities.put(name, city);
        return city;
    }

    // Создать город с названием и набором связанных городов
    public City createCity(String name, Map<String, Integer> connectedCitiesWithCosts) {
        City city = new City(name);
        cities.put(name, city);

        // Добавляем маршруты к связанным городам
        for (Map.Entry<String, Integer> entry : connectedCitiesWithCosts.entrySet()) {
            String connectedCityName = entry.getKey();
            int cost = entry.getValue();

            // Если город уже существует, используем его, иначе создаем новый
            City connectedCity = cities.get(connectedCityName);
            if (connectedCity == null) {
                connectedCity = new City(connectedCityName);
                cities.put(connectedCityName, connectedCity);
            }

            city.addRoute(connectedCity, cost);
        }

        return city;
    }

    // Создать двустороннюю связь между городами
    public void createBidirectionalRoute(String city1Name, String city2Name, int cost) {
        City city1 = getOrCreateCity(city1Name);
        City city2 = getOrCreateCity(city2Name);

        city1.addRoute(city2, cost);
        city2.addRoute(city1, cost);
    }

    // Получить город по имени (если не существует - создать)
    private City getOrCreateCity(String name) {
        City city = cities.get(name);
        if (city == null) {
            city = new City(name);
            cities.put(name, city);
        }
        return city;
    }

    // Получить все города
    public Collection<City> getAllCities() {
        return cities.values();
    }

    // Получить город по имени
    public City getCity(String name) {
        return cities.get(name);
    }

    // Показать информацию о всех городах
    public void displayAllCities() {
        System.out.println("\n=== ВСЕ ГОРОДА В СЕТИ ===");
        for (City city : cities.values()) {
            city.printInfo();
        }
    }

    // Построить схему согласно рисунку 2
    public void buildSampleNetwork() {
        // Создаем города согласно схеме
        Map<String, Integer> moscowRoutes = new HashMap<>();
        moscowRoutes.put("Санкт-Петербург", 500);
        moscowRoutes.put("Казань", 800);
        moscowRoutes.put("Нижний Новгород", 400);

        createCity("Москва", moscowRoutes);

        Map<String, Integer> spbRoutes = new HashMap<>();
        spbRoutes.put("Москва", 500);
        spbRoutes.put("Псков", 300);

        createCity("Санкт-Петербург", spbRoutes);

        // Создаем остальные города с двусторонними связями
        createBidirectionalRoute("Казань", "Самара", 350);
        createBidirectionalRoute("Казань", "Уфа", 450);
        createBidirectionalRoute("Нижний Новгород", "Казань", 400);
        createBidirectionalRoute("Псков", "Смоленск", 350);
        createBidirectionalRoute("Смоленск", "Москва", 400);
        createBidirectionalRoute("Самара", "Волгоград", 500);
        createBidirectionalRoute("Уфа", "Челябинск", 550);
    }
}