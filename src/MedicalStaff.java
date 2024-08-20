public class MedicalStaff {
    private String profession;

    MedicalStaff(){
        this.profession = "Doctor";
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfession(){
        return this.profession;
    }
    public void treatPatient(Patient patient){
        System.out.println(this.profession + "start's treatment of" + patient.getName() + "...");
        System.out.println("Asks how " + patient.getName() + " feeling himself.");
    }
}
