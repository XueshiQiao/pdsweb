/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.codeGen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

/**
 * @author qiaoxueshi
 *
 */
public class CodeGenerator {
	private Map<String, String> replacePairs = new HashMap<String,String>(); //替换对，key是要替换的，value是要替换为什么
	private List<String> files = new LinkedList<String>();//模板文件名列表
	private List<String> entityNames = new LinkedList<String>(); //实体类的名
	
	public CodeGenerator(){
	}
	
	public void work(){
		files.add("Action.tmp");
		files.add("Dao.tmp");
		files.add("DaoImpl.tmp");
		files.add("Service.tmp");
		files.add("ServiceImpl.tmp");
		
//		entityNames.add("BackgroundUser");
		
		
		
		entityNames.add("Reply");
//		entityNames.add("Criticism");
//		entityNames.add("Departments");
//		entityNames.add("FileUD");
//		entityNames.add("HotArticle");
//		entityNames.add("Link");
//		entityNames.add("Message");
//		entityNames.add("News");
//		entityNames.add("Role");
//		entityNames.add("Rules");
//		entityNames.add("UnionShow");
		
		replacePairs.put("{Entity}", "");
		String folderName = "src/com/pds/codeGen/terget/";
		for(String fileName:files){
			for(String entityName:entityNames){
				replacePairs.put("{Entity}", entityName);
				gen(fileName, folderName+entityName+fileName.substring(0, fileName.lastIndexOf("."))+".java");
			}
		}
		
		System.out.println("OK");
		
	}
	public void gen(String sourceFileName, String targetPathAndFileName){
		StringBuffer buffer = readFileToBuffer(sourceFileName);
		buffer = replace(buffer,this.replacePairs);
		writeBufferToFile(buffer,targetPathAndFileName);
	}
	
	public StringBuffer replace(StringBuffer buffer,Map<String,String> pairs){
		String s = buffer.toString();
		for(Entry<String,String> entry:pairs.entrySet()){
			s = StringUtils.replace(s,entry.getKey().trim(),entry.getValue().trim());
		}
		return new StringBuffer(s);
	}


	public StringBuffer readFileToBuffer(String fileName){
		//读文件到buffer中
		StringBuffer buffer = new StringBuffer();
		
		File file = new File(getPath(fileName));
		try {
			FileInputStream fis = new FileInputStream(file);
			this.readToBuffer(buffer, fis);
			//System.out.println(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}
	
	public void writeBufferToFile(StringBuffer buffer,String targetPathAndFileName){
		File file = new File(targetPathAndFileName);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(fos));
			writer.write(buffer.toString());
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getPath(String fileName){
		return this.getClass().getResource(fileName).getPath();	
	}
	
	   /**
     * 将流中的文本读入一个 StringBuffer 中
     * @throws IOException
     */
    public void readToBuffer(StringBuffer buffer, InputStream is)
        throws IOException {
        String line;        // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine();       // 读取第一行
        while (line != null) {          // 如果 line 为空说明读完了
            buffer.append(line);        // 将读到的内容添加到 buffer 中
            buffer.append("\n");        // 添加换行符
            line = reader.readLine();   // 读取下一行
        }
    }

	public Map getReplacePairs() {
		return replacePairs;
	}

	public void setReplacePairs(Map replacePairs) {
		this.replacePairs = replacePairs;
	}

	public List getFiles() {
		return files;
	}

	public void setFiles(List files) {
		this.files = files;
	}

	public static void main(String[] args) {
//		System.out.println(CodeGenerator.class.getResource("Text").getPath());
		new CodeGenerator().work();
	}
}
