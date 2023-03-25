package zhupff.gadget.gradle

import org.gradle.api.Project

abstract class ClosureDelegate {

    abstract String name()

    final void delegate(Closure closure) {
        if (closure != null) {
            closure.delegate = this
            closure()
        }
    }

    abstract void delegate(Project project, Closure closure)
}