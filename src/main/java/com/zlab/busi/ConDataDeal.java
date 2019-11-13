package com.zlab.busi;

import com.zlab.pojo.Data;
import com.zlab.util.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

        if(fileContentDeal == null){
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

        Data in = new Data();

        ConDataDeal conDataDeal = new ConDataDeal();

        conDataDeal.deal(in);

    }

}
