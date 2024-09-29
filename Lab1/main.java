import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Abiturient {
    int id;
    String lastName;
    String firstName;
    String middleName;
    String address;
    String phone;
    List<Integer> marks;

    public Abiturient(int id, String lastName, String firstName, String middleName, String address, String phone, List<Integer> marks) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.marks = marks;
    }

    public int getSumOfMarks() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }

    public boolean hasUnsatisfactoryMarks() {
        for (int mark : marks) {
            if (mark < 3) {
                return true;
            }
        }
        return false;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName, address, phone, marks);
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", marks=" + marks +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
        List<Abiturient> abiturients = new ArrayList<>();
        abiturients.add(new Abiturient(1, "Ivanov", "Ivan", "Ivanovich", "ul. Lenina, 1", "89123456789", List.of(4, 5, 3, 4, 5)));
        abiturients.add(new Abiturient(2, "Petrov", "Petr", "Petrovich", "ul. Pushkina, 2", "89123456780", List.of(5, 4, 3, 2, 5)));
        abiturients.add(new Abiturient(3, "Sidorov", "Sidor", "Sidorovich", "ul. Tolstogo, 3", "89123456781", List.of(3, 4, 4, 5, 4)));
        abiturients.add(new Abiturient(4, "Kozlov", "Kozla", "Kozlovich", "ul. Gorkogo, 4", "89123456782", List.of(2, 3, 4, 3, 4)));
        abiturients.add(new Abiturient(5, "Mikhailov", "Mikhail", "Mikhailovich", "ul. Chehova, 5", "89123456783", List.of(4, 5, 5, 5, 5)));

        // a) Список абитуриентов с неудовлетворительными оценками
        System.out.println("Список абитуриентов с неудовлетворительными оценками:");
        for (Abiturient abiturient : abiturients) {
            if (abiturient.hasUnsatisfactoryMarks()) {
                System.out.println(abiturient);
            }
        }

        // b) Список абитуриентов с суммой баллов выше указанной
        int specifiedSum = 18;
        System.out.println("\nСписок абитуриентов с суммой баллов выше указанной" + specifiedSum + ":");
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getSumOfMarks() > specifiedSum) {
                System.out.println(abiturient);
            }
        }

        // c) Выбор определенного количества абитуриентов с наибольшей суммой баллов
        int n = 2;
        System.out.println("\n" + n + " абитуриенты с самой высокой суммой баллов:");
        Collections.sort(abiturients, Comparator.comparingInt(Abiturient::getSumOfMarks).reversed());
        for (int i = 0; i < n; i++) {
            System.out.println(abiturients.get(i));
        }

        // Вывод списка абитуриентов с проходным баллом
        int passingScore = abiturients.get(n - 1).getSumOfMarks();
        System.out.println("\nСписок абитуриентов с проходным баллом " + passingScore + ":");
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getSumOfMarks() >= passingScore) {
                System.out.println(abiturient);
            }
        }
    }
}