public class Name {
    private String lastName;
    private String firstName;
    private String middleName;
    // геттеры и сеттеры
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    //конструкторы
    public Name() {
        this.lastName = "Иванов";
        this.firstName = "Иван";
        this.middleName = "Иванович";
    }

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public void printInfo() {
        System.out.println("Фамилия: " + lastName);
        System.out.println("Имя: " + firstName);
        System.out.println("Отчество: " + middleName);
        System.out.println("-----------------------------");
    }

    public void displayFullName() {
        System.out.println("Полное имя: " + toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (lastName != null && !lastName.isEmpty()) {
            sb.append(lastName);
        }

        if (firstName != null && !firstName.isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(firstName);
        }

        if (middleName != null && !middleName.isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(middleName);
        }

        return sb.toString();
    }
}