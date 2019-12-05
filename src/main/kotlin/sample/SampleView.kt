package sample

import de.saxsys.mvvmfx.FxmlView
import de.saxsys.mvvmfx.InjectViewModel
import javafx.beans.property.Property
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.control.SelectionModel
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
        bindSelectionModelBidirectional(schnippSelect.getSelectionModel(), viewModel.selectedBoohoo)
        buhButton.disableProperty().bind(viewModel.addBoohooCommand.notExecutableProperty())
    }

    @FXML
    public fun buhButtonAction() {
        viewModel.addBoohooCommand.execute()
    }
    private fun <T> bindSelectionModelBidirectional(sm: SelectionModel<T>, p: Property<T>) {
        sm.select(p.getValue())
        sm.selectedItemProperty().addListener({ _, oldValue, newValue ->
            if (oldValue != newValue && newValue != p.getValue()) {
                p.setValue(newValue)
            }
        })
        p.addListener({ _, oldValue, newValue ->
            if (oldValue != newValue && newValue != sm.getSelectedItem()) {
                sm.select(newValue)
            }
        })
    }
}
