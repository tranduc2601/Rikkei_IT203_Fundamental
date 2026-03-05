package SS9;

class AnimalBT4 {
    public void sound() {
        System.out.println("Động vật đang phát ra tiếng kêu...");
    }
}

class DogBT4 extends AnimalBT4 {
    @Override
    public void sound() {
        System.out.println("Chó sủa: Gâu gâu!");
    }

    public void fetch() {
        System.out.println("Chó đang chạy đi nhặt bóng!");
    }
}

public class BT4 {
    public static void main(String[] args) {
        AnimalBT4 animal = new DogBT4();
        animal.sound();

        if (animal instanceof DogBT4) {
            DogBT4 realDog = (DogBT4) animal;
            realDog.fetch();
        }
    }
}