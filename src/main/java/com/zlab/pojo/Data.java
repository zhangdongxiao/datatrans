package com.zlab.pojo;

import java.util.List;

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
    private List<String> fileContent;

    public List<String> getFileContent() {
        return fileContent;
    }

    public void setFileContent(List<String> fileContent) {
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
