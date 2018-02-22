package tw.acelan;

import java.io.File;

public class Test {
	public static void main(String[] args){
		/*
		 * 1.利用File類別建立資料夾、檔案或刪除檔案
		 * 2.判斷File物件所指向的對象是否為資料夾
		 * 3.列出資料夾中所有檔案內容
		 * 4.刪除資料夾
		 */
		
		
		String folderPath = "D:/testFolder";//建立testFolder資料夾檔案路徑
		String filePath1 = "D:/testFolder/test1.txt";//建立test1.txt檔案路徑
		String filePath2 = "D:/testFolder/test2.txt";//建立test2.txt檔案路徑
		
		File folder = new File(folderPath);
		File file1 = new File(filePath1);
		File file2 = new File(filePath2);
		
		try{
			/*
			 * 根據物件指定好的路徑建立testFolder資料夾
			 * 如果建立資料夾成功，mkdir會回傳true
			 */
			boolean createFolderSuccess = folder.mkdir();
			System.out.println("建立testFolder資料夾成功?"+createFolderSuccess);
			
			
			/*
			 * 根據物件指定好的路徑建立新檔案test1.txt及test2.txt
			 * 如果檔案已經存在，則createNewFile方法會回傳false表示新增檔案失敗
			 */
			boolean createFileSuccess1 = file1.createNewFile();
			boolean createFileSuccess2 = file2.createNewFile();
			System.out.println("建立檔案test1.txt成功?"+createFileSuccess1);
			System.out.println("建立檔案test2.txt成功?"+createFileSuccess2);
			
			
			/*
			 * 刪除test2.txt檔案
			 * 如果檔案不存在，則delete方法會回傳false表示刪除失敗
			 */
			boolean deleteFileSuccess = file2.delete();
			System.out.println("刪除檔案test2.txt成功?"+deleteFileSuccess);
			
			/*
			 * 使用isDirectory方法判斷File物件指向的對象是否為資料夾
			 * 當資料夾中有檔案存在時，資料夾會刪除失敗
			 * 所以必須 逐一刪除檔案後，最後再刪除資料夾
			 */
			if(folder.isDirectory()){
				System.out.println("====================");
				System.out.println("路徑:"+folderPath+" 是資料夾，準備進行刪除");
				
				File[] files = folder.listFiles();
				System.out.println("資料夾內容：");
				System.out.println("資料夾內檔案數量："+files.length);
				
				if(files.length > 0){
					for(int i=0;i<files.length;i++){
						boolean isDelete=files[i].delete();
						if(isDelete){
							System.out.println(files[i].getPath()+"刪除成功");
						}else{
							System.out.println(files[i].getPath()+"刪除失敗");
						}
					}
				}
				
				boolean deleteFolder = folder.delete();
				System.out.println("資料夾刪除成功?"+deleteFolder);
				System.out.println("====================");	
			}else{
				System.out.println("路徑:"+folderPath+" 並非資料夾");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("程式執行完畢");
	}
}
