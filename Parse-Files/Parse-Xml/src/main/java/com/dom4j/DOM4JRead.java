package com.dom4j;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.tree.DefaultAttribute;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;


@Log4j
public class DOM4JRead {
	@Test @SneakyThrows
	public void test() {
//		SAXReader
		DOMReader dr = new DOMReader();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//解析xml文件的解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		FileInputStream fis = new FileInputStream("e:/persons.xml");
		Document d = db.parse(fis);
		org.dom4j.Document document = dr.read(d);
		Element root = document.getRootElement();
		List<Element> children = root.elements();

		for(Element e:children){
			Iterator<DefaultAttribute> iterator = e.attributeIterator();
			while(iterator.hasNext()){
				DefaultAttribute attribute = iterator.next();
				log.info(attribute.getName()+"-->"+attribute.getValue());
			}
		}
	}
}
