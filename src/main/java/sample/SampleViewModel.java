package sample;

import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.commands.Action;
import de.saxsys.mvvmfx.utils.commands.Command;
import de.saxsys.mvvmfx.utils.commands.DelegateCommand;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SampleViewModel implements ViewModel {
    private final String halloLabelInitialText = "hallo1";

    private final StringProperty halloLabelText = new SimpleStringProperty(halloLabelInitialText);
    private final Command buhCommand;

    public SampleViewModel() {
        buhCommand = new DelegateCommand(() -> new Action() {
            @Override
            protected void action() {
                halloLabelText.set("hallo buh");
            }
        }, halloLabelText.isEqualTo(halloLabelInitialText));
    }

    public ReadOnlyStringProperty halloLabelTextProperty() {
        return halloLabelText;
    }

    public Command getBuhCommand() {
        return buhCommand;
    }
}
