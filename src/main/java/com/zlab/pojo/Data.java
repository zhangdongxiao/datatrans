package com.zlab.pojo;

import java.util.List;
import java.util.Map;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/11/12 2:54 下午
 * @Describe 数据对象
 */
public class Data {

    private String lineContent;
    private String fileName;
    private String filePath;
    private String outPut;
    private String outPutFileName;
    private List<Map<String, Object>> fileContent;

    public String getOutPut() {
        return outPut;
    }

    public void setOutPut(String outPut) {
        this.outPut = outPut;
    }

    public String getOutPutFileName() {
        return outPutFileName;
    }

    public void setOutPutFileName(String outPutFileName) {
        this.outPutFileName = outPutFileName;
    }

    public List<Map<String, Object>> getFileContent() {
        return fileContent;
    }

    public void setFileContent(List<Map<String, Object>> fileContent) {
        this.fileContent = fileContent;
    }

    public String getLineContent() {
        return lineContent;
    }

    public void setLineContent(String lineContent) {
        this.lineContent = lineContent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
