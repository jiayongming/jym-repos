package com.commons.util.ftp;

import com.commons.model.FTPVo;
import com.commons.util.DefaultConfig;

import java.io.IOException;

/**
 * FTP工具类
 */
public class FTPFactory {


    //获取一个实例
    public static FTPUtil getInstance(String Name) throws IOException {

        String host = DefaultConfig.get(Name + ".host");
        if (host != null) {
            int port = Integer.parseInt(DefaultConfig.get(Name + ".port"));
            String username = DefaultConfig.get(Name + ".username");
            String password = DefaultConfig.get(Name + ".password");
            String remoteDir = DefaultConfig.get(Name + ".remoteDir");
            String localDir = DefaultConfig.get(Name + ".localDir");
            String Encoding = DefaultConfig.get(Name + ".Encoding");
            boolean passiveMode = new Boolean(DefaultConfig.get(Name + ".passiveMode")).booleanValue();
            FTPVo vo = new FTPVo(host, port, username, password, remoteDir, localDir, Encoding, passiveMode);
            return new FTPUtilImpl(vo);
        } else {
            throw new IOException("config error");
        }
    }
}
