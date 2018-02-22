package tw.acelan;

import java.io.File;

public class Test {
	public static void main(String[] args){
		/*
		 * 1.�Q��File���O�إ߸�Ƨ��B�ɮשΧR���ɮ�
		 * 2.�P�_File����ҫ��V����H�O�_����Ƨ�
		 * 3.�C�X��Ƨ����Ҧ��ɮפ��e
		 * 4.�R����Ƨ�
		 */
		
		
		String folderPath = "D:/testFolder";//�إ�testFolder��Ƨ��ɮ׸��|
		String filePath1 = "D:/testFolder/test1.txt";//�إ�test1.txt�ɮ׸��|
		String filePath2 = "D:/testFolder/test2.txt";//�إ�test2.txt�ɮ׸��|
		
		File folder = new File(folderPath);
		File file1 = new File(filePath1);
		File file2 = new File(filePath2);
		
		try{
			/*
			 * �ھڪ�����w�n�����|�إ�testFolder��Ƨ�
			 * �p�G�إ߸�Ƨ����\�Amkdir�|�^��true
			 */
			boolean createFolderSuccess = folder.mkdir();
			System.out.println("�إ�testFolder��Ƨ����\?"+createFolderSuccess);
			
			
			/*
			 * �ھڪ�����w�n�����|�إ߷s�ɮ�test1.txt��test2.txt
			 * �p�G�ɮפw�g�s�b�A�hcreateNewFile��k�|�^��false��ܷs�W�ɮץ���
			 */
			boolean createFileSuccess1 = file1.createNewFile();
			boolean createFileSuccess2 = file2.createNewFile();
			System.out.println("�إ��ɮ�test1.txt���\?"+createFileSuccess1);
			System.out.println("�إ��ɮ�test2.txt���\?"+createFileSuccess2);
			
			
			/*
			 * �R��test2.txt�ɮ�
			 * �p�G�ɮפ��s�b�A�hdelete��k�|�^��false��ܧR������
			 */
			boolean deleteFileSuccess = file2.delete();
			System.out.println("�R���ɮ�test2.txt���\?"+deleteFileSuccess);
			
			/*
			 * �ϥ�isDirectory��k�P�_File������V����H�O�_����Ƨ�
			 * ���Ƨ������ɮצs�b�ɡA��Ƨ��|�R������
			 * �ҥH���� �v�@�R���ɮ׫�A�̫�A�R����Ƨ�
			 */
			if(folder.isDirectory()){
				System.out.println("====================");
				System.out.println("���|:"+folderPath+" �O��Ƨ��A�ǳƶi��R��");
				
				File[] files = folder.listFiles();
				System.out.println("��Ƨ����e�G");
				System.out.println("��Ƨ����ɮ׼ƶq�G"+files.length);
				
				if(files.length > 0){
					for(int i=0;i<files.length;i++){
						boolean isDelete=files[i].delete();
						if(isDelete){
							System.out.println(files[i].getPath()+"�R�����\");
						}else{
							System.out.println(files[i].getPath()+"�R������");
						}
					}
				}
				
				boolean deleteFolder = folder.delete();
				System.out.println("��Ƨ��R�����\?"+deleteFolder);
				System.out.println("====================");	
			}else{
				System.out.println("���|:"+folderPath+" �ëD��Ƨ�");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("�{�����槹��");
	}
}
