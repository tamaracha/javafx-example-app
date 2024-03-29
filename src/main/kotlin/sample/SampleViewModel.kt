package sample

import de.saxsys.mvvmfx.ViewModel
import de.saxsys.mvvmfx.utils.commands.Action
import de.saxsys.mvvmfx.utils.commands.Command
import de.saxsys.mvvmfx.utils.commands.DelegateCommand
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

public class SampleViewModel : ViewModel {
    private val halloLabelInitialText = "hallo1"

    public val halloLabelText: StringProperty = SimpleStringProperty(halloLabelInitialText)
    public val buhCommand: Command = DelegateCommand({ object : Action() {
        override fun action() {
            halloLabelText.set("hallo buh")
        }
    } }, halloLabelText.isEqualTo(halloLabelInitialText))
}
