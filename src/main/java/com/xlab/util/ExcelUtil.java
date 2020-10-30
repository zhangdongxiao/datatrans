package com.xlab.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/11/13 10:50 上午
 * @Describe
 */
public class ExcelUtil {

    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    public static void exportInfo(List<Map<String, Object>> contents, String output) throws Exception {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计表");

        Map<String, Object> tmp = contents.get(0);

        Set<String> keyTmps = tmp.keySet();

        TreeSet<String> keys = new TreeSet();

        keyTmps.forEach(keyTmp -> {
            keys.add(keyTmp);
        });

        createTitle(workbook, sheet, keys);

        final int[] rowNum = {1};
        contents.forEach(content -> {

            HSSFRow row = sheet.createRow(rowNum[0]);

            int idx = 0;

            for (String key : keys) {
                row.createCell(idx).setCellValue(content.get(key).toString().trim());
                idx++;
            }

            rowNum[0]++;
        });

        buildExcelFile(output, workbook);

    }

    //创建表头
    private static void createTitle(HSSFWorkbook workbook, HSSFSheet sheet, TreeSet<String> keys) {
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(3, 17 * 256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);

        HSSFCell cell;

        int idx = 0;

        for (String key : keys) {

            cell = row.createCell(idx);
            cell.setCellValue(key);
            cell.setCellStyle(style);

            idx++;
        }

    }

    private static void buildExcelFile(String filename, HSSFWorkbook workbook) throws Exception {
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }

}
