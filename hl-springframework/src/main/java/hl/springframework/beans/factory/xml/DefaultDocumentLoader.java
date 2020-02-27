package hl.springframework.beans.factory.xml;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * 默认{@link DocumentLoader}接口的实现，用于加载文档流信息。
 *
 * @author Hailin
 * @date 2020/2/22
 */
public class DefaultDocumentLoader implements DocumentLoader {

    @Override
    public Document loadDocument(InputStream inputStream) {
        Document document = null;
        try {
            SAXReader reader = new SAXReader();
            document = reader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }
}
