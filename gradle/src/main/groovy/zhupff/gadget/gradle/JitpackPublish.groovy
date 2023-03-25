package zhupff.gadget.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication

class JitpackPublish implements Plugin< Project> {

    @Delegate Project project

    @Override
    void apply(Project project) {
        println("${project.name} apply ${getClass().simpleName}")
        this.project = project
    }

    private void publishToJitpack() {
        apply plugin: "maven-publish"

        if (System.getenv("JITPACK") == "true") {
            afterEvaluate {
                project.publishing {
                    repositories {
                        it.mavenLocal()
                    }
                    publications {
                        jitpack(MavenPublication) {
                            from plugins.hasPlugin("com.android.library") ? components.release : components.java
                            artifactId = project.name
                        }
                    }
                }
            }
        }
    }
}