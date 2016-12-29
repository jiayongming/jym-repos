package com.sax;

import com.model.Person;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.util.List;

@Log4j
public class SaxRead {
	@Test @SneakyThrows
	public void test() {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();
		FileInputStream fis = new FileInputStream("e:/persons.xml");
		PersonHandler handler = new PersonHandler();
		parser.parse(fis, handler);
		List<Person> list = PersonHandler.list;
		for(Person p :list){
			log.info(p);
		}
	}
}
