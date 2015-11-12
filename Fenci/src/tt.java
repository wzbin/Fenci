import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class tt {
	
	public static void main(String[] args) throws IOException {  
		
		Map<String,String> data = new HashMap<String,String> ();
		
		//导入量词数据
		
		File file2 = new File("I:/workspace/Testfenci/src/量词.txt");
		
		ArrayList<String> shuliang = new ArrayList<String>();
		
		Scanner from2 = new Scanner(file2);
		
		while(from2.hasNext()){
			
			shuliang.add(from2.next());
			
			
		}
		Pattern pattern = Pattern.compile("[0-9]+.[0-9]*");
		  
		
		/*for(int i=0;i<shuliang.size();i++){
        	
        	System.out.print(shuliang.get(i));
        	System.out.println((shuliang.get(i).toString()).contains("五"));
        	
        }*/
		//导入量词数据
		
		
		//导入食物数据
		File file = new File("I:/workspace/Testfenci/src/食物种类.txt");
		
		System.out.println(file.exists());
		
		Scanner from = new Scanner(file);
		
		ArrayList<CharSequence>shiwu = new ArrayList<CharSequence>();
		
		while(from.hasNext()){
			
			shiwu.add(from.next().toString());
			
		}
		//导入食物数据
		
		//分词开始
        String text="我吃了2.55两担担面和6.666666666666666666666个鸡蛋还有三个妹子";  
        //创建分词对象  
        Analyzer anal=new IKAnalyzer(true);       
        StringReader reader=new StringReader(text);  
        //分词  
        TokenStream ts=anal.tokenStream("", reader);  
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class); 
        //遍历分词数据  
        ArrayList<String> result = new ArrayList<String>();
        while(ts.incrementToken()){  
            result.add(term.toString());  
        }  
        for(int i=0;i<result.size();i++){
        	
        	System.out.println(result.get(i));
        	
        }
        reader.close();  
        //分词结束
        
        
        //筛选食物
        for(int i=0;i<result.size();i++){
			
        	for(int j=0;j<shiwu.size();j++)
        		
        		if(result.get(i).contains(shiwu.get(j))){
        			
        			
        			
        			for(int k=0;k<shuliang.size();k++){
        				//System.out.println(result.get(i-1)+"test");
        				//System.out.println(shuliang.get(k));
        				Matcher matcher = pattern.matcher(result.get(i-1));
        				if(((result.get(i-1)).contains(shuliang.get(k))&&i-1>=0)||(matcher.find())){
        					System.out.print(result.get(i-1)+"------------------>");
        					break;
        				}
        			}
        			System.out.println(result.get(i));
        			break;
				
				
			}
        
        }

	}
	
}

