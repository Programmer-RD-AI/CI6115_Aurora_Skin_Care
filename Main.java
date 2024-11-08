import exception.InvalidTreatmentIDException;
import view.CLI.GeneralView;

public class Main {
    public static void main(String[] args) throws InvalidTreatmentIDException {
        // MainGUI.main(args);
        GeneralView generalView = new GeneralView();
        generalView.start();
    }
}
