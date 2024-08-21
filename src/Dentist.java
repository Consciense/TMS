public class Dentist extends MedicalStaff{

    @Override
    public void treatPatient(Patient patient) {
        System.out.println(getProfession() + " starts treatment of " + patient.getName() + "...");
        System.out.println("Making some terrible stuff with teeth...");
        System.out.println("----------------------------------------------------------------");
    }
}
