package com.handy.demo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author longhairen
 * @create 2017/8/17 0017 上午 9:00
 */
public class JavaNIOTest {

    public static final String FILE_NAME_READ = "C:\\Users\\Administrator\\Desktop\\nio\\static.tar.gz";
    public static final String FILE_NAME_WRITTE = "C:\\Users\\Administrator\\Desktop\\nio\\static11.tar.gz";

    public static void main(String[] args) throws Exception{
        copyFileUseNIO(FILE_NAME_READ, FILE_NAME_WRITTE);
    }

    public static void copyFileUseNIO(String from, String dst) throws Exception{
        //声明源文件和目标文件
        FileInputStream fi=new FileInputStream(new File(from));
        FileOutputStream fo=new FileOutputStream(new File(dst));
        //获得传输通道channel
        FileChannel inChannel=fi.getChannel();
        FileChannel outChannel=fo.getChannel();
        //获得容器buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while(true){
            //判断是否读完文件
            int eof =inChannel.read(buffer);
            if(eof==-1){
                break;
            }
            //重设一下buffer的position=0，limit=position
            buffer.flip();
            //开始写
            outChannel.write(buffer);
            //写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();
    }

    public static void fileChannelRead() throws Exception{
        //第一步：获取通道
        FileInputStream fin = new FileInputStream(FILE_NAME_READ);
        FileChannel fc = fin.getChannel();
        //第二步：创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate( 1024 );
        //第三步：将数据从通道读到缓冲区
        fc.read(buffer);
    }

    public static void fileChannelWrite() throws Exception{
        //第一步：获取一个通道
        FileOutputStream fout = new FileOutputStream( FILE_NAME_WRITTE );
        FileChannel fc = fout.getChannel();
       // 第二步：创建缓冲区，将数据放入缓冲区
        ByteBuffer buffer = ByteBuffer.allocate( 1024 );
//        for (int i=0; i<message.length; ++i) {
//            buffer.put( message[i] );
//        }
        buffer.flip();
        //第三步：把缓冲区数据写入通道中
        fc.write( buffer );
    }
}
