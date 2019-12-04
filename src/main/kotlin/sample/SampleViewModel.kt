package sample

import de.saxsys.mvvmfx.ViewModel
import de.saxsys.mvvmfx.utils.commands.Action
import de.saxsys.mvvmfx.utils.commands.Command
import de.saxsys.mvvmfx.utils.commands.DelegateCommand
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.collections.FXCollections

public class SampleViewModel : ViewModel {
    private val initialBoohooText = "Buhu"
    private val initialItems = listOf("Schnipp", "Schnapp", "Schnupp")

    public val selectedBoohoo: StringProperty = SimpleStringProperty()
    public val newBoohooText: StringProperty = SimpleStringProperty(initialBoohooText)
    public val boohooList = SimpleListProperty(FXCollections.observableArrayList(initialItems))
    public val addBoohooCommand: Command = DelegateCommand({ object : Action() {
        override fun action() {
            val value: String = newBoohooText.getValue()
            boohooList.add(value)
            newBoohooText.set("")
            selectedBoohoo.set(value)
        }
    } }, newBoohooText.isNotEmpty())
}
