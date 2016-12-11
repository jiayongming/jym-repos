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
		//  ʵ����һ��xml����������
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//����xml�ļ��Ľ�����
		DocumentBuilder db = dbf.newDocumentBuilder();
		//���document���󣬵ȼ���xml�ļ�
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
		//����xml�ļ��Ĺ�����
		TransformerFactory tfs = TransformerFactory.newInstance();
		//ɾ��xml�ļ���transformer��
		Transformer ts = tfs.newTransformer();
		//����xml�ļ��ı����ʽ
		ts.setOutputProperty(OutputKeys.ENCODING,"utf-8");
		// �����ʱ����
		ts.setOutputProperty(OutputKeys.INDENT,"yes");
		//xml�ļ���ԭʼ��Դ
		DOMSource ds = new DOMSource(document);
		//�ļ��������
		StreamResult sr = new StreamResult(new FileOutputStream("e:/persons.xml"));
		ts.transform(ds, sr);

	}
}
