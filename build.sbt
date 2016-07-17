name := "Spark"

version := "1.0"

scalaVersion := "2.10.4"
mainClass in Compile := Some("TrendingTopics")


libraryDependencies ++= Seq(
  "org.twitter4j" % "twitter4j-core" % "4.0.4")





