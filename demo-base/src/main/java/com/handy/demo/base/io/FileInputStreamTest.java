package com.handy.demo.base.io;

import java.io.*;

/**
 * @author longhairen
 * @create 2017/8/16 0016 下午 5:07
 */
public class FileInputStreamTest {

    public void testInputSteam() throws Exception{
        FileInputStream fis = new FileInputStream("FileInputStreamTest.java");
        byte[] bytes = new byte[1024];
        int hasRead = 0;
        while ((hasRead = fis.read(bytes)) > 0) {
            System.out.println(new String(bytes,0,hasRead));
        }
        BufferedInputStream in = new BufferedInputStream(fis);
        in.read();
        fis.close();
    }

    public void testOutPustStream(){
        /*try (FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
             FileInputStream fileInputStream = new FileInputStream("FileInputStreamTest.java")) {
            byte[] bytes = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fileInputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes,0,hasRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void testReader(){
        /*try (FileReader fileReader = new FileReader("FileInputStreamTest.java")) {
            char[] chars = new char[1024];
            int hasRead = 0;
            while ((hasRead = fileReader.read(chars)) > 0) {
                System.out.println(new String(chars,0,hasRead));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void testWriter(){
      /*  try (FileWriter fileWriter = new FileWriter("poem.txt")){
            fileWriter.write("锦瑟 -李商隐\r\n");// \r\n时windows平台的换行符
            fileWriter.write("锦瑟无端五十弦，一弦一柱思华年\r\n");
            fileWriter.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃\r\n");
            fileWriter.write("沧海月明珠有泪，蓝田日暖玉生烟\r\n");
            fileWriter.write("此情可待成追忆，只是当时已惘然\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
