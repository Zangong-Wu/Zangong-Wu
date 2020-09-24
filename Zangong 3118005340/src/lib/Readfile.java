package lib;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Readfile {
	public static double readTxtFile(String filePath1,String filePath2) {
		 File file1=new File(filePath1);
		 File file2=new File(filePath2);
		 String str1=new String();
		 String str2=new String();
		try {
			
			 if(file1.isFile() && file1.exists()
					 &&file2.isFile() && file2.exists()){ //�ж��ļ��Ƿ����
				 InputStreamReader read1 = new InputStreamReader(new FileInputStream(file1));
				 InputStreamReader read2 = new InputStreamReader(new FileInputStream(file2));
				 //���ǵ������ʽ
				 BufferedReader bufferedReader1 = new BufferedReader(read1);
				 BufferedReader bufferedReader2 = new BufferedReader(read2);
				 String lineTxt1= null;
				 String lineTxt2= null;
				
				 while((lineTxt1 = bufferedReader1.readLine()) != null){
					 str1+=lineTxt1;
					
				 }
				 while((lineTxt2 = bufferedReader2.readLine()) != null){
					 
					 str2+=lineTxt2;
				 }
				 read1.close();
				 read2.close();
			 }
			 else{
				 System.out.println("�Ҳ���ָ�����ļ�");
			 }
		}catch (Exception e) {
			 System.out.println("��ȡ�ļ����ݳ���");
			 e.printStackTrace();
		}

		return SimilarityUtil.getSimilarity(str1,str2);
		
	}
	public static void main(String argv[]){
		//String filePath1 = "C:\\Users\\715019816\\Desktop\\test\\orig.txt";
		//String filePath2 = "C:\\Users\\715019816\\Desktop\\test\\orig_0.8_add.txt";
		System.out.println("������ԭ��·��");
		
		
		System.out.println("������Ƚ��ļ�·��");
		//Scanner path2= new Scanner(System.in);
		String P1=argv[0];
		String P2=argv[1];
		String P3=argv[2];
		double rate =readTxtFile(P1,P2);
		System.out.println("���ƶ�"+rate);
		File f3 = new File(P3);
		if (!f3.exists())
			try {
				f3.createNewFile();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		try {
			FileWriter fileWriter = new FileWriter(f3.getAbsoluteFile(), true);
			fileWriter.write(String.format("%.2f", rate));
			fileWriter.write('\n');
			fileWriter.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
