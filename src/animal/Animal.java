package animal;

public class Animal {
    String animalType;

    Animal(String animalType) {
        this.animalType = animalType;
    }

    public void voice(boolean isHappy) {
        System.out.println(this.animalType + " try's to make" + (isHappy ? " happy " : " unhappy ") + "noise:");
    }

    public void eat(String food) {
        System.out.println(this.animalType + "looks at your food...");
    }
}
