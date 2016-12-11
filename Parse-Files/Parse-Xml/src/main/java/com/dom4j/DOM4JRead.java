package com.dom4j;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.tree.DefaultAttribute;
import org.junit.Test;
import org.w3c.dom.Document;

import lombok.SneakyThrows;


public class DOM4JRead {
	@SuppressWarnings({ "unused", "unchecked" })
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
		
		/*Iterator iterator = root.attributeIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}*/
		
		
		for(Element e:children){
			List<Attribute> attributes = e.attributes();
			Iterator<DefaultAttribute> iterator = e.attributeIterator();
			while(iterator.hasNext()){
				DefaultAttribute attribute = iterator.next();
				System.out.println(attribute.getName()+"-->"+attribute.getValue());
			}
			/*Attribute attribute = e.attribute("id");
			System.out.println(attribute.getName()+"---"+ attribute.getValue());
			for(Attribute a: attributes){
				System.out.println(a.getName()+"------------"+ a.getValue());
			}*/
		/*	List<Element> elements = e.elements();
			for(Element ele: elements){
				System.out.println(ele.getName()+"----"+ ele.getText());
			}*/
		}
	}
}
