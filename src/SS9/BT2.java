package SS9;

class Animal{
    public void sound(){
        System.out.println("Animal sound");
    }
}

class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal{
    @Override
    public void sound() {
        System.out.println("Meow!");
    }
}

public class BT2{
    public static void main(String[] args) {
        System.out.println("Animal sound: ");

        Animal animal = new Animal();
        animal.sound();

        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();
    }
}

