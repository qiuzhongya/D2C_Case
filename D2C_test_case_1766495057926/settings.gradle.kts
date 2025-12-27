pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://maven.byted.org/repository/android_public")
        maven(url = "https://maven.byted.org/repository/bytedance_android/")
        maven(url = "https://maven.byted.org/nexus/content/repositories/bytedance_android/")
        maven(url = "https://maven.byted.org/nexus/content/repositories/ss_app_android/")
        maven(url = "https://maven.byted.org/repository/bytedance_android/")
        maven {
            url = uri("https://central.sonatype.com/repository/maven-snapshots/")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://maven.byted.org/repository/android_public")
        maven(url = "https://maven.byted.org/repository/bytedance_android/")
        maven(url = "https://maven.byted.org/nexus/content/repositories/bytedance_android/")
        maven(url = "https://maven.byted.org/nexus/content/repositories/ss_app_android/")
        maven(url = "https://maven.byted.org/repository/bytedance_android/")
        maven {
            url = uri("https://central.sonatype.com/repository/maven-snapshots/")
        }
    }
}

rootProject.name = "kmp_d2c_evaluate"
include(":app")
include(":benchmark")
