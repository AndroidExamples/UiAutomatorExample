UiAutomatorExample
==================

An example using UI Automator for testing Android applications. I used the Api Demos application as subject to be tested. This application is packaged within any image distributed from Genymotion. I created this sample application to demonstrate UiAutomator to a colleague. My personal findings and notes are attached below.

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


##Personal findings
###Test engineer
UiAutomator is the perfect tool to test Android applications if you are a test engineer. It requires a small amount of java and Android knowledge to program. The syntax/funcionalities are limited, but it we be enough to perform the typical "bussiness-as-usual" tests. 

###Developer
In comparison to other testing frameworks, tests are harder to write and don't allow the developer doing TDD. In UiAutomator you use UiSelectors to search for UiObjets. The search is based on text and content descriptions of Views, but the problem their is that you can't reference the Views directly. You can only invoke a simplified set of methods on UIObject. 

But their are some upsides to this framework. You can leave your app sandbox and do all kind of stuff. For example: toggle on/off wifi, open other apps, test your activity for result etc. 

Another upside to UiAutomator is the usage of UiWatcher, this watcher listens to conditional events (primarely being ui changes, e.g. dialog showing up). You can easily incoperate different scenario's within your testcases.


