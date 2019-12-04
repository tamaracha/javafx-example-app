package sample

import de.saxsys.mvvmfx.FxmlView
import de.saxsys.mvvmfx.InjectViewModel
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.control.TextArea

public class SampleView : FxmlView<SampleViewModel> {
    @FXML
    public lateinit var schnippLabel: Label

    @FXML
    public lateinit var schnippSelect: ListView<String>

    @FXML
    public lateinit var newBoohooField: TextArea

    @FXML
    public lateinit var buhButton: Button

    @InjectViewModel
    private lateinit var viewModel: SampleViewModel

    public fun initialize() {
        schnippLabel.textProperty().bind(viewModel.selectedBoohoo)
        newBoohooField.textProperty().bindBidirectional(viewModel.newBoohooText)
        schnippSelect.setPlaceholder(Label("alles"))
        schnippSelect.itemsProperty().bind(viewModel.boohooList)
        schnippSelect.getSelectionModel().selectedItemProperty().addListener({ obs, oldValue, newValue ->
            if (oldValue != newValue && newValue != viewModel.selectedBoohoo.getValue()) {
                viewModel.selectedBoohoo.set(newValue)
            }
        })
        viewModel.selectedBoohoo.addListener({ obs, oldValue, newValue ->
            if (oldValue != newValue && newValue != schnippSelect.getSelectionModel().getSelectedItem()) {
                schnippSelect.getSelectionModel().select(newValue)
            }
        })
        // viewModel.selectedBoohoo.bind(schnippSelect.getSelectionModel().selectedItemProperty())
        buhButton.disableProperty().bind(viewModel.addBoohooCommand.notExecutableProperty())
    }

    @FXML
    public fun buhButtonAction() {
        viewModel.addBoohooCommand.execute()
    }
}
