import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy selectPrizeToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        double randomWeight = Math.random() * totalWeight;
        double currentWeight = 0;

        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (currentWeight >= randomWeight) {
                return toy;
            }
        }

        return null; // Return null if no toy is selected
    }

    public void playGame() {
        Toy prizeToy = selectPrizeToy();
        if (prizeToy != null) {
            toys.remove(prizeToy);
            prizeToy.decreaseQuantity();

            // Write the prize toy to a text file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toy.txt", true))) {
                writer.write(prizeToy.getName());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}