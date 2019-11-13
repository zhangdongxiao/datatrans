package com.zlab.busi;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/11/13 9:00 上午
 * @Describe
 */
@Component
public class ContentAnalysis {

    //00 2 * * * ksh /crmbob/crmrptb/rpt/bin/chkRpt.sh >>/crmbob/crmrptb/rpt/log/chkRpt_cron.log
    public Map<String, Object> analysis(String content) {
        Map<String, Object> out = new HashMap<>();

        return out;
    }

}
