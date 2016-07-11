//
// Created by solar on 2016/7/11.
//
#include "com_jc_jnidemo_MainActivity.h"
JNIEXPORT jstring JNICALL Java_com_jc_jnidemo_MainActivity_getStringFromNative
  (JNIEnv * env, jobject obj){
   return (*env)->NewStringUTF(env,"这是c语言写的方法");
  }


