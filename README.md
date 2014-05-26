UiAutomatorExample
==================

An example using UI Automator for testing Android applications. I used the Api Demos application as subject to testing. This application is packaged within any distributed image from Genymotion. I created this sample application to demonstrate UiAutomator to a colleague. My personal findings and notes are attached below.

##Running project with attached jar
> adb push /Users/path/to/git/folder/UiAutomatorExample.jar /data/local/tmp

> adb shell uiautomator runtest UiAutomatorExample.jar -c com.tobrun.android.test.uiautomator.ApiDemosTest


##Build the project from source
###Dependencies
First add the following dependencies to the project:
> JUnit 3

> uiautomator.jar

> android.jar

###Build project
Generate an Ant build file, and compile it with ant
> ./android create uitest-project -n UiAutomatorExample -t 1 -p /Users/path/to/workspace/project

>  ant build

###Running project
Copy the jar to the SD-card and run the test
> adb push bin/UiAutomatorExample.jar /data/local/tmp

> adb shell uiautomator runtest UiAutomatorExample.jar -c com.tobrun.android.test.uiautomator.ApiDemosTest




