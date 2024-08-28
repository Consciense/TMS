package task3;

public class Document implements Cloneable{
    String documentName;
    String documentData;

    public Document(String documentName, String documentData){
        this.documentName = documentName;
        this.documentData = documentData;
    }

    @Override
    public String toString(){
        return "This is a document named " + this.documentName + ". " +
                "\nIt's data is " + this.documentData + ".\n";
    }

    @Override
    public Document clone() {  // wanted create simple return super.clone; but compiler build this and im ok with it...
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
