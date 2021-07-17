package com.bytedance.practice5.socket;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocketThread extends Thread {
    public ClientSocketThread(SocketActivity.SocketCallback callback) {
        this.callback = callback;
    }

    private SocketActivity.SocketCallback callback;

    //head请求内容
    private static String content = "HEAD / HTTP/1.1\r\nHost:www.zju.edu.cn\r\n\r\n";
    private boolean stopFlag = false;

    @Override
    public void run() {
        // TODO 6 用socket实现简单的HEAD请求（发送content）
        //  将返回结果用callback.onresponse(result)进行展示
        try{
            Socket socket = new Socket("www.zju.edu.cn",80);
            BufferedOutputStream os = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream is = new BufferedInputStream(socket.getInputStream());
            double n = 1;
            byte[] data = new byte[1024*5];
            int len = -1;
            while(!stopFlag&&socket.isConnected()){
                os.write(content.getBytes());
                os.flush();
                int reciveLen = is.read(data);
                String receive = new String(data,0,reciveLen);
                Log.d("socket","收到"+receive);
                callback.onResponse(receive);
                stopFlag=true;
            }
            os.flush();
            os.close();
            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}