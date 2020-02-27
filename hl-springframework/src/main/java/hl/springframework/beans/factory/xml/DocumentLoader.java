package hl.springframework.beans.factory.xml;


import org.dom4j.Document;

import java.io.InputStream;

/**
 * @author Hailin
 * @date 2020/2/22
 */
public interface DocumentLoader {

    /**
     * 使用Sax解析XML文件，创建Document对象
     *
     * @param inputStream 输入流信息
     * @return Document对象
     */
    Document loadDocument(InputStream inputStream);
}
