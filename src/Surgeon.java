public class Surgeon extends MedicalStaff {


    @Override
    public void treatPatient(Patient patient) {
        System.out.println(getProfession() + " starts treatment of" + patient.getName() + "...");
        System.out.println("Making some surgical practice...");
    }

}
