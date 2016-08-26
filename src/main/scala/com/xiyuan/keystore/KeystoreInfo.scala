package com.xiyuan.keystore

/**
  * Created by xiyuan_fengyu on 2016/8/26.
  */
class KeystoreInfo(val all: String, val alias: String, val md5: String, val sha1: String, val sha256: String) {

  val md5Lowercase = md5.toLowerCase

  val md5NoDivider = md5.replaceAll(":", "")

  val md5LowercaseNoDivider = md5NoDivider.toLowerCase

  val sha1Lowercase = sha1.toLowerCase

  val sha1NoDivider = sha1.replaceAll(":", "")

  val sha1LowercaseNoDivider = sha1NoDivider.toLowerCase

  val sha256Lowercase = sha256.toLowerCase

  val sha256NoDivider = sha256.replaceAll(":", "")

  val sha256LowercaseNoDivider = sha256NoDivider.toLowerCase

}
