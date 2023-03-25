package zhupff.gadget.gradle

final class GadgetGradle {

    private GadgetGradle() {}

    static void compose(Closure closure) {
        try {
            def sb = new StringBuilder()
                .append("class GadgetGradleDelegate {").append("\n")
                .append("    @Delegate org.gradle.api.Project project").append("\n")
                .append("    HashMap<String, zhupff.gadget.gradle.ClosureDelegate> map").append("\n")
                .append("    GadgetGradleDelegate(map, script) {").append("\n")
                .append("        this.map = map").append("\n")
                .append("        this.project = script.project").append("\n")
                .append("        println(\"GadgetGradle compose in \" + this.project.name)").append("\n")
                .append("    }").append("\n")

            def iterator = ServiceLoader.load(ClosureDelegate.class).iterator()
            def map = new HashMap<String, ClosureDelegate>()
            while (iterator.hasNext()) {
                def next = iterator.next()
                map.put(next.name(), next)
                sb
                .append("    def ${next.name()}(Closure c) {").append("\n")
                .append("        map.get(\"${next.name()}\").delegate(this.project, c)").append("\n")
                .append("    }").append("\n")
            }

            sb
                .append("}").append("\n")


            def cls = new GroovyClassLoader().parseClass(sb.toString())
            closure.delegate = cls.newInstance(map, closure.owner)
            closure()
        } catch(Exception e) {
            e.printStackTrace()
        }
    }
}