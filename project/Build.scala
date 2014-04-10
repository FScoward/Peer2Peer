import sbt._
import Keys._

object Peer2PeerBuild extends Build {
  lazy val root = Project(id = "peer2peer",
    base = file(".")) aggregate(client, server)

  lazy val client = Project(id = "client",
    base = file("client"))

  lazy val server = Project(id = "server",
    base = file("server"))
}