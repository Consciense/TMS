public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.startWorkingDayAtClinic();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Apple apple = new Apple("green", "not ripe");
        apple.showAppleInfo();
        apple.ripeUp();
        apple.showAppleInfo();
        apple.ripeUp();
        apple.showAppleInfo();
    }
}
