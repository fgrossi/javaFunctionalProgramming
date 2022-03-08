package org.francesco.test;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal(2, "Mario", KIND.MAN);
        Dog dog1 = new Dog(4, "Fido", KIND.DOG);
        animal.talk();
        dog1.talk();
        System.out.println(animal.join("ciao", " sono io"));
        System.out.println(dog1.join("ciao", " sono io"));
        System.out.println(animal.join("ciao", 25));
        System.out.println(dog1.join("ciao", 25));
    }
}
