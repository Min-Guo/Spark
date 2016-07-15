name := "Spark"

version := "1.0"

scalaVersion := "2.11.8"
mainClass in Compile := Some("TrendingTopics")


libraryDependencies ++= Seq(
  "org.twitter4j" % "twitter4j-core" % "4.0.4")

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
   {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
   }
}
