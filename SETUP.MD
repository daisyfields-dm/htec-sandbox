# Steps for initializing project with gradle and importing it into eclipse

## Setup gradle project
1. download gradle https://downloads.gradle.org/distributions/gradle-4.10.2-bin.zip
1. unzip it in `D:\Java\tools\gradle-4.10.2`
1. add following location to PATH environment variable `D:\Java\tools\gradle-4.10.2\bin`
1. create new folder `D:\Java\projects\htec-sandbox`
1. open command prompt in `htec-sandbox`
1. execute: `gradle wrapper --gradle-version 4.10.2` this will add some gradle files in `htec-sandbox` folder
1. create `build.gradle` and set `buildscript` and `subproject` elements
1. create `settings.gradle` file
1. declare `rootProject.name` in `settings.gradle`
1. include subproject `selenium-tests` that we are going to create in next steps also in `settings.gradle`
1. create `gradle.properties` and declare name, group and version
1. create folder `selenium-tests` and enter into it
1. execute following command to create folder structure: `mkdir src\main\java src\main\resources src\test\java src\test\resources`
1. create `build.gradle` and add dependencies
1. go back to `htec-sandbox` folder
1. execute `gradlew clean build cleanEclipse eclipse`

## Import project into eclipse
1. open eclipse
1. open File -> Import
1. choose Gradle -> Existing Gradle Project
1. Enter `D:\Java\projects\htec-sandbox` into Project root directory field
1. click Finish button

