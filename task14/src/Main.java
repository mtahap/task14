interface Run {
    void run();
}

interface Speak {
    void speak();
}

class Animal {
    private String type;

    public Animal(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Animal implements Run, Speak {
    public Dog() {
        super("Dog");
    }

    @Override
    public void run() {
        System.out.println("The dog is running");
    }

    @Override
    public void speak() {
        System.out.println("The dog is barking");
    }
}

class Cat extends Animal implements Run, Speak {
    public Cat() {
        super("Cat");
    }

    @Override
    public void run() {
        System.out.println("The cat is running");
    }

    @Override
    public void speak() {
        System.out.println("The cat is meowing");
    }
}

class Shark extends Animal {
    public Shark() {
        super("Shark");
    }
}

class HomeAnimal<T extends Animal & Run & Speak> {
    private T animal;

    public HomeAnimal(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void showType() {
        System.out.println("This is a " + animal.getType());
    }

    public void sleepOnTheCouch() {
        System.out.println(animal.getType() + " is sleeping on the couch");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        HomeAnimal<Dog> dogHome = new HomeAnimal<>(dog);
        dogHome.getAnimal().run();
        dogHome.getAnimal().speak();
        dogHome.showType();
        dogHome.sleepOnTheCouch();

        HomeAnimal<Cat> catHome = new HomeAnimal<>(cat);
        catHome.getAnimal().run();
        catHome.getAnimal().speak();
        catHome.showType();
        catHome.sleepOnTheCouch();
    }
}