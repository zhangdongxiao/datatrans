package com.zlab.busi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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

    private static final Logger log = LoggerFactory.getLogger(ContentAnalysis.class);

    //00 2 * * * ksh /crmbob/crmrptb/rpt/bin/chkRpt.sh >>/crmbob/crmrptb/rpt/log/chkRpt_cron.log
    public Map<String, Object> analysis(String content) {
        Map<String, Object> out = new HashMap<>();

        String[] cmds = content.split("ksh");

        log.info("cmds = {}", Arrays.toString(cmds));

        //RegExp  Cmd  Freq
        out.put("RegExp", cmds[0].trim());
        out.put("Cmd", cmds[1].trim());

        //00 2 * * *  分 小时 日 月 星期
        String freq = "";

        String[] times = cmds[0].trim().split("\\s+");

        log.info("times length = {}", times.length);

        if (times.length > 0) {
            if (!times[0].equals("*")) {
                freq = "分";
            }
            if (!times[1].equals("*")) {
                freq = "时";
            }
            if (!times[2].equals("*")) {
                freq = "日";
            }
            if (!times[3].equals("*")) {
                freq = "月";
            }
            if (!times[4].equals("*")) {
                freq = "周";
            }
        }

        out.put("Freq", freq);

        log.info("out = {}", out);

        return out;
    }

    public static void main(String[] args) {
        ContentAnalysis contentAnalysis = new ContentAnalysis();
        contentAnalysis.analysis("50 8 1,23 * * ksh /crmbob/crmrptb/prodmng/bin/prcSendSMS/CRON_AUTOMODSENDSUM.sh");
    }

}
