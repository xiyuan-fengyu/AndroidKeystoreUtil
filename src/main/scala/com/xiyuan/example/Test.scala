package com.xiyuan.example

import com.xiyuan.keystore.KeystoreUtil
import com.xiyuan.template.log.XYLog
import com.xiyuan.template.util.ClassUtil

/**
  * Created by xiyuan_fengyu on 2016/8/26 14:32.
  */
object Test {

  def main(args: Array[String]) {
    val path = ClassUtil.classRoot + "/test.jks"
    val password = "123456"
    val keystoreInfo = KeystoreUtil.keystoreInfo(path, password)
    XYLog.d("md5\t", keystoreInfo.md5LowercaseNoDivider)
    XYLog.d("sha1\t", keystoreInfo.sha1LowercaseNoDivider)
    XYLog.d("sha256\t", keystoreInfo.sha256LowercaseNoDivider)
  }

}