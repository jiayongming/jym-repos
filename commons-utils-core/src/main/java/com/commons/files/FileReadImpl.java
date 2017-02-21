package com.commons.files;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 封装了集中常用的文件读的方法
 */
@Log4j2
public class FileReadImpl {

    /**
     * 利用FileChannel直接实现文件的对拷,对于大文件速度特别明显
     *
     * @param source
     * @param target
     */
    public static void copyFileWithChannel(File source, File target) {
        try (
                FileInputStream inStream = new FileInputStream(source);
                FileOutputStream outStream = new FileOutputStream(target);
                FileChannel in = inStream.getChannel();
                FileChannel out = outStream.getChannel();
        ) {
            in.transferTo(0, in.size(), out);
        } catch (IOException e) {
            log.error("copyFileWithChannel error:",e);
        }
    }

    /**
     * 使用FileChannel+Buffer实现文件的读取拷贝是一种极佳的方案
     *
     * @param source
     * @param target
     */
    public static void copyFileWithBuffer(File source, File target) {
        try (
                FileInputStream inStream = new FileInputStream(source);
                FileOutputStream outStream = new FileOutputStream(target);
                FileChannel in = inStream.getChannel();
                FileChannel out = outStream.getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            while (in.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            log.error("copyFileWithBuffer error:",e);
        }
    }

    /**
     * 利用Buffer实现文件的读取拷贝
     *
     * @param source
     * @param target
     */
    public static void customBufferBufferedStreamCopy(File source, File target) {
        try (
                InputStream fis = new BufferedInputStream(new FileInputStream(source));
                OutputStream fos = new BufferedOutputStream(new FileOutputStream(target))
        ) {
            byte[] buf = new byte[4096];
            int i;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        } catch (IOException e) {
            log.error("customBufferBufferedStreamCopy error:",e);
        }
    }

    /**
     * 利用Buffer实现文件的读取拷贝
     *
     * @param source
     * @param target
     */
    public static void customBufferStreamCopy(File source, File target) {
        try (
                InputStream fis = new FileInputStream(source);
                OutputStream fos = new FileOutputStream(target);
        ) {
            byte[] buf = new byte[4096];
            int i;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        } catch (IOException e) {
            log.error("customBufferStreamCopy error:",e);
        }
    }

}
