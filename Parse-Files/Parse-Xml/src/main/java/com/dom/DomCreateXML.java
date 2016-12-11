package com.dom;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import lombok.SneakyThrows;

public class DomCreateXML {
	@Test @SneakyThrows
	public void createXML(){
		//  实例化一个xml创建工厂类
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//解析xml文件的解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		//获得document对象，等价于xml文件
		Document document = db.newDocument();

		Element persons = document.createElement("persons");

		Element person = document.createElement("person");
		person.setAttribute("id", "1");

		Element name = document.createElement("name");
		Element age = document.createElement("age");
		name.setTextContent("zhangsan");
		age.setTextContent("13");

		Element person1 = document.createElement("person");
		person1.setAttribute("id", "2");

		Element name1 = document.createElement("name");
		Element age1 = document.createElement("age");
		name1.setTextContent("lisi");
		age1.setTextContent("18");

		person1.appendChild(name1);
		person1.appendChild(age1);
		person.appendChild(name);
		person.appendChild(age);
		persons.appendChild(person);
		persons.appendChild(person1);
		document.appendChild(persons);
		//创建xml文件的工厂类
		TransformerFactory tfs = TransformerFactory.newInstance();
		//删除xml文件的transformer类
		Transformer ts = tfs.newTransformer();
		//设置xml文件的编码格式
		ts.setOutputProperty(OutputKeys.ENCODING,"utf-8");
		// 输出的时候换行
		ts.setOutputProperty(OutputKeys.INDENT,"yes");
		//xml文件的原始资源
		DOMSource ds = new DOMSource(document);
		//文件输出对象
		StreamResult sr = new StreamResult(new FileOutputStream("e:/persons.xml"));
		ts.transform(ds, sr);

	}
}
