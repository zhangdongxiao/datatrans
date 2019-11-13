package com.zlab.busi;

import com.zlab.pojo.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/11/12 3:08 下午
 * @Describe
 */
@Component
public class FileContentDeal {

    private static final Logger log = LoggerFactory.getLogger(FileContentDeal.class);

    @Autowired
    private ContentAnalysis contentAnalysis;

    public Data fileContentDeal(Data data) {

        String filePath = data.getFilePath() + data.getFileName();

        Data outdata = new Data();

        BufferedWriter writer = null;

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            String content;

            List<Map<String, Object>> contentlist = new ArrayList<>();

            while ((content = in.readLine()) != null) {

                log.info("@@@@@@@  file content = " + content);

                contentlist.add(contentAnalysis.analysis(content));

            }
            writer.flush();
            in.close();
            writer.close();

            if (contentlist.size() > 0) {
                outdata.setFileContent(contentlist);
            }

        } catch (IOException e) {
            log.error("@@@@@@@@@@@@@  文件打开异常  @@@@@@@@@@@@");
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return outdata;

    }

}
