package tool;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

@SuppressWarnings("unused")
public class WriteExcel {
	
	private static String path = "D:\\Program Files\\jym-github\\excelPoi\\src\\main\\resources\\source.sql"; 
	private static File filename = new File(path); 
	@Test
	public void main() {
		try {
			Map<String, String> SQLMap = Maps.newLinkedHashMapWithExpectedSize(256);
			
			InputStream inp = new FileInputStream("D:\\Program Files\\jym-github\\excelPoi\\src\\main\\resources\\guiyang_batchOpen_501.xlsx");
			Workbook wb = WorkbookFactory.create(inp);
			int numberOfSheets = wb.getNumberOfSheets();
			System.out.println("工作表个数为：" + numberOfSheets);
			Sheet sheet = wb.getSheetAt(0); // 第一个工作表
			// 获得总列数
			int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("获得总列数" + coloumNum);
			// 获得总行数
			int rowNum = sheet.getLastRowNum();
			System.out.println("获得总行数14572:" + rowNum);

			/*writeTxtFile("USE wealth ;") ;*/
			Map<String, String> bankEncrypt = Maps.newLinkedHashMapWithExpectedSize(600);
			for (int i = 1; i <= rowNum; i++) {
				double bank8 = sheet.getRow(i).getCell(7).getNumericCellValue(); // 第八列单元格的值
				long bank_int8 = (long)bank8 ;
				double bank9 = sheet.getRow(i).getCell(8).getNumericCellValue(); // 第八列单元格的值
				long bank_int9 = (long)bank9 ;
				String str8 = String.valueOf(bank_int8);
				String str9 = String.valueOf(bank_int9);
				String str = str8+str9;
				String encrypt = DESUtil.encrypt(str.getBytes());
				bankEncrypt.put(str, encrypt) ;
			}

/*			HashSet<Integer> newHashSet = Sets.newHashSet(fs);
			fs = Lists.newArrayList(newHashSet);*/
			Set<Entry<String, String>> entrySet = bankEncrypt.entrySet();
			for (Entry<String, String> entry : entrySet) {
				
				writeTxtFile(entry.getKey()+","+entry.getValue()) ;
				
			}
			
			

/*			String str = "INSERT into user_medal values ({-1},{0},{1},{2},{3},{4},{5},{6},{7},{8},{9} ) ;";
			sb.append(str) ;

			
			for (Long integer : fs1) {
				
				sb.append(integer) ;
				String replaceEach = StringUtils.replaceEach(
											str,
											new String[]{"{-1}","{0}","{1}","{2}","{3}","{4}","{5}","{6}","{7}","{8}","{9}"}, 
											new String[]{
														String.valueOf(count) ,
														integer.toString(),
														"'理财达人'",
														"1",
														"'http://news.jinhui365.com/cms/medal.html?ut=1200001'",
														"0",
														"0",
														"1477929600000",
														"1478793600000",
														"1477887142000",
														"1477887142000"
														});
				count++ ;
				
				writeTxtFile(replaceEach) ;
			}*/
			
/*			for (Map.Entry<String, String> entry : SQLMap.entrySet()) {
				System.out.println(entry.getKey()+"============="+entry.getValue());
			}
			
			for (Map.Entry<String, String> entry : SQLMap.entrySet()) {
				String filein = "UPDATE user_address SET RESOURCE = '"+entry.getValue().trim()+"' WHERE NAME = '"+entry.getKey().trim()+"' ;" ;
				
				writeTxtFile(filein) ;
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/*	public static void writeSQL(Map<String, String> SQLMap) throws Exception {
        if (!filename.exists()) { 
            filename.createNewFile(); 
            System.err.println(filename + "已创建！ "); 
        }
        
        
        UPDATE resources SET resource = 'test' WHERE NAME = 'indexHotUpdate-wealth-application-service-rmi' ;
        
        
        RandomAccessFile mm = null; 
        try {
        	for (Map.Entry<String, String> entry : SQLMap.entrySet()) {
        		String filein = "UPDATE resources SET resource = '"+entry.getValue()+"' WHERE id = '"+entry.getKey()+"' ;" ;
        		mm = new RandomAccessFile(filename, "rw"); 
        		mm.writeBytes(filein); 
        	}
			
		} catch (Exception e) {
			e.printStackTrace() ;
		}  finally { 
            if (mm != null) { 
                try { 
                    mm.close(); 
                } catch (IOException e2) { 
                    e2.printStackTrace(); 
                } 
            } 
        }

	}*/
	
	/**
	 * 写文件
	 * 
	 * @param newStr
	 *            新内容
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	public static boolean writeTxtFile(String newStr) throws IOException {
		// 先读取原有文件内容，然后进行写入操作
		boolean flag = false;
		String filein = newStr + "\r\n";
		String temp = "";

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
			// 文件路径
			File file = new File(path);
			// 将文件读入输入流
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buf = new StringBuffer();

			// 保存该文件原有的内容
			for (int j = 1; (temp = br.readLine()) != null; j++) {
				buf = buf.append(temp);
				// System.getProperty("line.separator")
				// 行与行之间的分隔符 相当于“\n”
				buf = buf.append(System.getProperty("line.separator"));
			}
			buf.append(filein);

			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buf.toString().toCharArray());
			pw.flush();
			flag = true;
		} catch (IOException e1) {
			// TODO 自动生成 catch 块
			throw e1;
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return flag;
	}
}