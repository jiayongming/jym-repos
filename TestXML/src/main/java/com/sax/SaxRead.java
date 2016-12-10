package com.sax;

import java.io.FileInputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;

import com.model.Person;

import lombok.SneakyThrows;

public class SaxRead {
	@Test @SneakyThrows
	public void test() {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();
		FileInputStream fis = new FileInputStream("e:/persons.xml");
		PersonHandler handler = new PersonHandler();
		parser.parse(fis, handler);
//		handler.print();
		List<Person> list = PersonHandler.list;
//		System.out.println("----------------------");
//		System.out.println(list.size());
		for(Person p :list){
			System.out.println(p);
		}
	}
}
