package sample
import de.saxsys.mvvmfx.FxmlView
import de.saxsys.mvvmfx.InjectViewModel
import javafx.beans.property.Property
import javafx.fxml.FXML
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ListView
import javafx.scene.control.SelectionModel

public class BrowserColumnView : FxmlView<BrowserColumnViewModel> {
    @FXML public lateinit var variableSelect: ChoiceBox<String>
    @FXML public lateinit var valueList: ListView<String>
    @InjectViewModel private lateinit var viewModel: BrowserColumnViewModel
    public fun initialize() {
        variableSelect.itemsProperty().bind(viewModel.variableList)
        variableSelect.valueProperty().bindBidirectional(viewModel.selectedVariable)
        valueList.itemsProperty().bind(viewModel.valueList)
        bindSelectionModelBidirectional(valueList.getSelectionModel(), viewModel.selectedValue)
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
