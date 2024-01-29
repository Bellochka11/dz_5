public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Добавление новых игрушек
        Toy toy1 = new Toy(1, "Кукла Барби", 5, 25);
        Toy toy2 = new Toy(2, "Мяч", 10, 50);
        Toy toy3 = new Toy(3, "Автомобиль", 8, 15);

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);

        // Изменение веса (частоты выпадения игрушки)
        toyStore.updateWeight(1, 40);

        // Розыгрыш игрушек
        toyStore.playGame();
    }
}
