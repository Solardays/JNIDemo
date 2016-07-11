package com.jc.jnidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void j2c(View view){
        Toast.makeText(this,getStringFromNative(),Toast.LENGTH_SHORT).show();
    }

    public native String getStringFromNative();
    //使用javah生成头文件时，可能会出现找不到v7包，这是因为没有把v7包设置在classpath中，完整的javah命令如下
    //javah -d jni -classpath H:\localdata\sdkndk\SDK\platforms\android-23\android.jar;H:\localdata\sdkndk\SDK\extras\android\support\v4\android-support-v4.jar;H:\localdata\sdkndk\SDK\extras\android\support\v7\appcompat\libs\android-support-v7-appcompat.jar;..\..\build\intermediates\classes\debug com.jc.jnidemo.MainActivity

    //生成so文件需要设置ndk的路径，用到ndk-build命令

    //运行时可能会出现Execution failed for task ':app:compileDebugNdk'. Error Code:2
    //这是NDK的一个bug,解决方法就是再再往jni文件夹加入一个空util.c文件即可。

    static {
        System.loadLibrary("MyJni");
    }

}
