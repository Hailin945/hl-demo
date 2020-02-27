package hl.springframework.beans.factory.xml;

import hl.springframework.beans.definition.BeanDefintion;
import hl.springframework.beans.factory.BeanFactory;
import hl.springframework.core.io.ClassPathResource;
import hl.springframework.core.io.Resource;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Hailin
 * @date 2020/2/22
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    @Override
    public BeanDefintion loadBeanDefinition(String path, BeanFactory beanFactory) throws IOException {
        Resource resource = new ClassPathResource(path);
        InputStream inputStream = resource.getInputStream();

        DocumentLoader documentLoader = new DefaultDocumentLoader();
        Document document = documentLoader.loadDocument(inputStream);
        Element rootElement = document.getRootElement();

        BeanDefinitionParser parser = new BeanDefinitionParser(beanFactory);
        BeanDefintion beanDefintion = parser.parseRootElement(rootElement);
        return beanDefintion;
    }
}
