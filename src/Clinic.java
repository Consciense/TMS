public class Clinic {
    public void startWorkingDayAtClinic() {
        MedicalStaff surgeon = createSurgeon();
        MedicalStaff dentist = createDentist();
        Therapist therapist = createTherapist();
        Patient[] list = createPatientList();

        System.out.println("Therapist starts his job.");
        System.out.println("----------------------------------------------------------------");
        for (Patient patient : list) {
            therapist.scheduleDoctor(patient);
            System.out.println("----------------------------------------------------------------");
        }
        startTreatment(list, dentist, surgeon);

    }

    MedicalStaff createSurgeon() {
        MedicalStaff clinicSurgeon = new Surgeon();
        clinicSurgeon.setProfession("Surgeon");
        System.out.println(clinicSurgeon.getProfession() + " has entered the clinic.");
        System.out.println("----------------------------------------------------------------");
        return clinicSurgeon;
    }

    Therapist createTherapist() {
        Therapist clinicTherapist = new Therapist();
        clinicTherapist.setProfession("Therapist");
        System.out.println(clinicTherapist.getProfession() + " has entered the clinic.");
        System.out.println("----------------------------------------------------------------");
        return clinicTherapist;
    }

    MedicalStaff createDentist() {
        MedicalStaff clinicDentist = new Dentist();
        clinicDentist.setProfession("Dentist");
        System.out.println(clinicDentist.getProfession() + " has entered the clinic.");
        System.out.println("----------------------------------------------------------------");
        return clinicDentist;
    }

    Patient[] createPatientList() {
        return new Patient[]{
                new Patient("Ivan", 1, "Doctor"),
                new Patient("DefinitelyNotIvan", 2, "Doctor"),
                new Patient("Viktor", 33, "Doctor")
        };
    }

    public void startTreatment(Patient[] patients, MedicalStaff dentist, MedicalStaff surgeon) {
        for (Patient patient : patients) {
            if (patient.getTreatingDoctor().equals("Dentist")) {
                dentist.treatPatient(patient);
            } else if (patient.getTreatingDoctor().equals("Surgeon")) {
                surgeon.treatPatient(patient);
            } else {
                System.out.println("Therapist already done his treatment.");
            }
        }
    }
}