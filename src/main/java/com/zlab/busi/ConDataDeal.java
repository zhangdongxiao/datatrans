package com.zlab.busi;

import com.zlab.pojo.Data;
import com.zlab.util.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/11/12 2:49 下午
 * @Describe 文件内容处理
 */
@Service
public class ConDataDeal {

    private static final Logger log = LoggerFactory.getLogger(ConDataDeal.class);

    @Autowired
    private FileContentDeal fileContentDeal;

    public void deal(Data data) throws Exception {

        if (fileContentDeal == null) {
            fileContentDeal = new FileContentDeal();//兼容单独的main启动
        }

        Data out = fileContentDeal.fileContentDeal(data);

        if (out.getFileContent() != null && out.getFileContent().size() > 0) {

            log.info(" export excel ");
            ExcelUtil.exportInfo(out.getFileContent(), data.getOutPut() + data.getOutPutFileName());
        } else {
            log.info(" No data deal ");
        }

    }

    public static void main(String[] args) throws Exception {

        List<Data> datas = new ArrayList<>();

        Data in = new Data();

        in.setFilePath("/Users/dxz/Public/ProgramCodes/file/");
        in.setOutPut("/Users/dxz/Public/ProgramCodes/file/");
        in.setFileName("crontab_206");
        in.setOutPutFileName(in.getFileName() + ".xls");

        datas.add(in);

        Data in1 = new Data();

        in1.setFilePath("/Users/dxz/Public/ProgramCodes/file/");
        in1.setOutPut("/Users/dxz/Public/ProgramCodes/file/");
        in1.setFileName("crontab_205");
        in1.setOutPutFileName(in1.getFileName() + ".xls");

        datas.add(in1);

        Data in2 = new Data();

        in2.setFilePath("/Users/dxz/Public/ProgramCodes/file/");
        in2.setOutPut("/Users/dxz/Public/ProgramCodes/file/");
        in2.setFileName("crontab_245");
        in2.setOutPutFileName(in2.getFileName() + ".xls");

        datas.add(in2);

        Data in3 = new Data();

        in3.setFilePath("/Users/dxz/Public/ProgramCodes/file/");
        in3.setOutPut("/Users/dxz/Public/ProgramCodes/file/");
        in3.setFileName("crontab_235");
        in3.setOutPutFileName(in3.getFileName() + ".xls");

        datas.add(in3);

        ConDataDeal conDataDeal = new ConDataDeal();

        datas.forEach(data -> {
            try {
                conDataDeal.deal(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

}
