package animal;

public class Dog extends Animal {


    Dog(String name, String animalType) {
        super("Dog");
    }

    @Override
    public void voice(boolean isHappy) {
        super.voice(isHappy);
        System.out.println("Dog barks (this means that dog is glad to see you)" +
                (isHappy ? "":"\n Not your terrible food"));
    }

    @Override
    public void eat(String food) {
        super.eat(food);
        System.out.println("Your food looks back...");
        if (food.equals("Meat")) {
            System.out.println("Dog starts to eat.");
            voice(true);
        } else {
            System.out.println("Dog keeps staring at you wagging his tail.");
            voice(false);
        }
    }
}
