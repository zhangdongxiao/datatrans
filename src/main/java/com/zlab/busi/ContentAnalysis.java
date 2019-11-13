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

        String[] cmds = new String[2];

        if (content.contains("ksh") && !content.contains("/ksh")) {
            cmds = content.split("ksh");
        } else {
            String b = content.substring(0, content.lastIndexOf("*") + 1);
            String c = content.substring(content.lastIndexOf("*") + 1);
            cmds[0] = b;
            cmds[1] = c;
        }

        log.info("cmds = {}", Arrays.toString(cmds));

        //RegExp  Cmd  Freq
        out.put("RegExp", cmds[0].trim());
        out.put("Cmd", cmds[1].trim());

        //00 2 * * *  分 小时 日 月 星期
        String freq = "";
        String remark = "";

        String[] times = cmds[0].trim().split("\\s+");

        log.info("times length = {}", times.length);

        if (times.length > 0) {

            boolean isMin = false, isH = false, isDay = false, isMth = false;

            if (!times[0].equals("*")) {
                freq = times[0] + "分";
                isMin = true;
            }
            if (!times[1].equals("*")) {
                freq = times[1] + "时";

                isH = true;

                if (isMin) {
                    freq = "固定" + times[0] + "分" + times[1] + "时";
                }

            }
            if (!times[2].equals("*")) {
                freq = times[2] + "日";

                isDay = true;

                if (isH) {
                    freq = "固定" + times[0] + "分" + times[1] + "时" + times[2] + "日";
                    remark = "指定日执行";
                }

            }
            if (!times[3].equals("*")) {
                freq = times[3] + "月";

                isMth = true;

                if (isDay) {
                    freq = "固定" + times[0] + "分" + times[1] + "时" + times[2] + "日" + times[3] + "月";
                    remark = "指定日期执行";
                }

            }
            if (!times[4].equals("*")) {
                freq = times[4] + "周";

                if (isMth) {
                    freq = "固定" + times[0] + "分" + times[1] + "时" + times[2] + "日" + times[3] + "月" + times[4] + "周";
                    remark = "指定星期执行";
                }

            }
        }

        out.put("Freq", freq);
        out.put("Remark", remark);

        log.info("out = {}", out);

        return out;
    }

    public static void main(String[] args) {
        ContentAnalysis contentAnalysis = new ContentAnalysis();
        contentAnalysis.analysis("02,12,22,32,42,52 * * * *  /usr/bin/ksh /crmbob/crmrptb/interface/ifCRMDataInDBCen/bin/ifDIstart.sh");

    }

}
