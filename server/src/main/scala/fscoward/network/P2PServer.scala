package fscoward.network

import java.net.ServerSocket
import org.apache.log4j.Logger
import akka.actor.{Props, ActorSystem}

/**
 * Created by FScoward on 2014/04/06.
 */
class P2PServer {
  /** 接続待ちを開始する */
  def run = {
    println("wait for connect...")
//    val logger = Logger.getLogger(this.getClass.getName)

    val serverSocket = new ServerSocket(1025)
    println(serverSocket.getLocalPort + "で接続を待機します")
    while(true){

      val socket = serverSocket.accept()

      val actorSystem = ActorSystem("MySystem")
      val s = actorSystem.actorOf(Props[P2PServerActor], name="p2p")
//      s ! serverSocket
      s ! socket

    }
//    actorSystem.stop(s)

//    logger.debug("connected...")
//    val socket = serverSocket.accept()
//    println("connected...: " + socket.getRemoteSocketAddress)

//    logger.debug("close")
//    socket.close()

  }
}
