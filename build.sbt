mainClass := Some("editorLauncher.editor.launcher.Launcher")

lazy val root = (project in file(".")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4",
    mainClass := Some("editorLauncher.editor.launcher.Launcher")
  ) aggregate(standardResource, standardModel, standardView,
  standardController,
  editorResource, editorModel, editorController, editorView, editorLauncher,
  warriorResource, warriorModel, warriorController, warriorView, warriorLauncher)

lazy val standardResource = (project in file("standardResource")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  )

lazy val standardModel = (project in file("standardModel")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn (standardResource)

lazy val standardController = (project in file("standardController")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn (standardModel)

lazy val standardView = (project in file("standardView")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, standardController)


lazy val editorResource = (project in file("editorResource")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn (standardResource)

lazy val editorModel = (project in file("editorModel")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, editorResource)

lazy val editorController = (project in file("editorController")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, standardController, editorResource, editorModel)

lazy val editorView = (project in file("editorView")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, standardController, standardView, editorResource, editorModel, editorController)

lazy val editorLauncher = (project in file("editorLauncher")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, standardController, standardView, editorResource, editorModel, editorController, editorView)

lazy val warriorResource = (project in file("warriorResource")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn (standardResource)

lazy val warriorModel = (project in file("warriorModel")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, warriorResource, standardModel)

lazy val warriorController = (project in file("warriorController")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, warriorResource, standardModel, warriorModel, standardController)

lazy val warriorView = (project in file("warriorView")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4",
    libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
  ) dependsOn(standardResource, warriorResource, standardModel, standardController, standardView, warriorResource, warriorModel, warriorController)

lazy val warriorLauncher = (project in file("warriorLauncher")).
  settings(
    version := "0.1.0",
    scalaVersion := "2.11.4"
  ) dependsOn(standardResource, standardModel, standardController, standardView, warriorResource, warriorModel, warriorController, warriorView)