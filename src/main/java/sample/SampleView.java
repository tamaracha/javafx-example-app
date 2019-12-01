package sample;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class SampleView implements FxmlView<SampleViewModel>, Initializable {
    @FXML
    public Label halloLabel;

    @FXML
    public Button buhButton;

    @InjectViewModel
    private SampleViewModel viewModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        halloLabel.textProperty().bind(viewModel.halloLabelTextProperty());
        halloLabel.disableProperty().bind(viewModel.getBuhCommand().notExecutableProperty());
    }

    @FXML
    public void buhButtonAction() {
        viewModel.getBuhCommand().execute();
    }
}
