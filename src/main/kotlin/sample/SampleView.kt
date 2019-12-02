package sample

import de.saxsys.mvvmfx.FxmlView
import de.saxsys.mvvmfx.InjectViewModel
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label

public class SampleView : FxmlView<SampleViewModel> {
    @FXML
    public lateinit var halloLabel: Label

    @FXML
    public lateinit var buhButton: Button

    @InjectViewModel
    private lateinit var viewModel: SampleViewModel

    public fun initialize() {
        halloLabel.textProperty().bind(viewModel.halloLabelText)
        buhButton.disableProperty().bind(viewModel.buhCommand.notExecutableProperty())
    }

    @FXML
    public fun buhButtonAction() {
        viewModel.buhCommand.execute()
    }
}
