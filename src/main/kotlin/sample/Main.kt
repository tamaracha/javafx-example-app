package sample

import de.saxsys.mvvmfx.FluentViewLoader
import de.saxsys.mvvmfx.ViewTuple
import javafx.application.Application
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

public class Main : Application() {
    public override fun start(stage: Stage) {
        val viewTuple: ViewTuple<SampleView, SampleViewModel> = FluentViewLoader.fxmlView(
            SampleView:: class.java
        ).load()
        val root: Parent = viewTuple.getView()
        val scene = Scene(root)
        stage.setScene(scene)
        stage.show()
    }
    companion object {
        @JvmStatic
    public fun main(args: Array<String>) {
        launch(Main::class.java, * args)
    }
    }
}
