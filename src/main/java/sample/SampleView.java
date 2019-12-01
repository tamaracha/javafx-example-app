package sample;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleView implements FxmlView<SampleViewModel> {
    @FXML
    public Label halloLabel;

    @FXML
    public Button buhButton;

    @InjectViewModel
    private SampleViewModel viewModel;

    public void initialize() {
        halloLabel.textProperty().bind(viewModel.halloLabelTextProperty());
        buhButton.disableProperty().bind(viewModel.getBuhCommand().notExecutableProperty());
    }

    @FXML
    public void buhButtonAction() {
        viewModel.getBuhCommand().execute();
    }
}
