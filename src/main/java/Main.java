import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <=3; i++) {
            String name;
            while (true) {
                System.out.println("Введите название автомобиля №" + i + ": ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Вы забыли ввести название автомобиля, попробуйте еще!");
                    continue;
                }
                break;
            }
            int speed;
            while (true) {
                System.out.println("Введите скорость автомобиля №" + i + ": ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Вы забыли ввести скорость, попробуйте еще!");
                    continue;
                }
                if (!input.matches("\\d+")) {
                    System.out.println("Скоростью может быть только целое число, попробуйте еще!");
                    continue;
                }

                speed = Integer.parseInt(input);
                if (speed > 0 && speed <= 250) {
                    break;
                } else {
                    System.out.println("Скорость должна быть от 1 до 250. Попробуйте снова.");
                }
            }
            Car car = new Car(name, speed);
            race.updateLeader(car);
        }
        System.out.println("Самая быстрая машина: " + race.getWinnerName());


    }
}

class Car {
    String name;
    int speed;

    public Car(String carName, int carSpeed) {
        this.name = carName;
        this.speed = carSpeed;
    }
}


class Race {
    String leaderName = "";
    int leaderDistance = 0;

    public void updateLeader(Car newCar) {
        int newDistance = 24 * newCar.speed;
        if (newDistance > this.leaderDistance) {
            leaderName = newCar.name;
            leaderDistance = newDistance;
        }
    }
        public String getWinnerName() {
            return leaderName;
        }
}