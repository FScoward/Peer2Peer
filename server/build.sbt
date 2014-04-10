name := "Peer2Peer"

version := "1.0"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"
)

libraryDependencies ++= Seq(
  "log4j" % "log4j" % "1.2.17",
  "com.typesafe.akka" %% "akka-actor" % "2.4-SNAPSHOT"
)