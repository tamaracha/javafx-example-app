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
    @InjectViewModel private lateinit var viewModel: SampleViewModel
    public fun initialize() {
    }
}
