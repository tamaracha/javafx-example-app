package sample

import de.saxsys.mvvmfx.ViewModel
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections

class BrowserColumnViewModel : ViewModel {
    public val variableList = SimpleListProperty(FXCollections.observableArrayList(variables))
    public val selectedVariable = SimpleStringProperty("Album")
    public val valueList = SimpleListProperty(FXCollections.observableArrayList(values))
    public val selectedValue = SimpleStringProperty("Haydn")
    companion object {
        val variables = listOf("Album", "Interpret", "Komponist")
        val values = listOf("Haydn", "Helge Schneider", "Frank Duval")
    }
}
