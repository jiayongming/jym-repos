package com.sax;

import com.model.Person;
import lombok.extern.log4j.Log4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class PersonHandler extends DefaultHandler{
	public static List<Person> list = null;
	private Person person;
	private String tagName;
	//专门处理文件节点
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		log.info(tagName+"------");
		String str = new String(ch,start,length);
		if("name".equals(tagName)){
			person.setName(str);
		}
		if("age".equals(tagName)){
			person.setAge(Integer.parseInt(str));
		}
		log.info("遇到文本节点"+str);
	}
	//当解析xml文件结束的时候触发
	@Override
	public void endDocument() throws SAXException {
		log.info("文件解析结束");
		
	}
	
	/**
	 * 	当解析到一个结束标签的时候触发
	 * 	uri: xml文件的唯一标示
	 * localName:不带前缀的标签名
	 * qName:带有前缀的标签名
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if("person".equals(qName)){
			list.add(person);
		}
		tagName="";
	}
	/**
	 *   文档开始被解析的时候执行,
	 *   一般执行一些初始化工作
	 */
	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<Person>();
	}
	/**当解析xml文件时遇到开始标签触发,一般拿到标签的属性，做出相应的处理
	 * attributes:封装了当前标签的所有属性
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName= qName;
		if("person".equals(qName)){
			person = new Person();
			String id = attributes.getValue("id");
			person.setId(Integer.parseInt(id));
		}
		
		for(int i = 0; i < attributes.getLength();i++){
			log.info("-------------"+attributes.getQName(i));
		}
	}
	
}
