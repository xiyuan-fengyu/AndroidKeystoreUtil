package com.xiyuan.keystore

import java.io.{BufferedReader, InputStreamReader, PrintWriter}

/**
  * Created by xiyuan_fengyu on 2016/8/26.
  */
object KeystoreUtil {

  def keystoreInfo(keystore: String, password: String): KeystoreInfo = {
    val strBld = new StringBuilder()
    var alias: String = null
    var md5: String = null
    var sha1: String = null
    var sha256: String = null
    try {
      val process: Process = Runtime.getRuntime.exec("cmd")
      val writer: PrintWriter = new PrintWriter(process.getOutputStream)
      writer.println(s"keytool -list -v -keystore $keystore")
      writer.flush()
      writer.println(password)
      writer.flush()

      val reader = new BufferedReader(new InputStreamReader(process.getInputStream, "GBK"))
      var line = reader.readLine()
      while (line != null) {
        if (line.startsWith("别名: ")) {
          alias = line.substring(4)
        }
        else if (line.startsWith("\t MD5: ")) {
          md5 = line.substring(7)
        }
        else if (line.startsWith("\t SHA1: ")) {
          sha1 = line.substring(8)
        }
        else if (line.startsWith("\t SHA256: ")) {
          sha256 = line.substring(10)
        }

        strBld.append(line).append('\n')
        line = reader.readLine()
        if (line.matches("[*]+")) {
          line = null
        }

      }

      reader.close()
      writer.close()
    }
    catch {
      case e: Exception =>
        e.printStackTrace()
    }

    new KeystoreInfo(strBld.toString(), alias, md5, sha1, sha256)
  }

}
