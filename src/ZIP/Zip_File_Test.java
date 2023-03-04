//https://www.chillyfacts.com/zip-unzip-files-folder-using-java/

package ZIP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip_File_Test {
    public static void main(String[] args) {
        Zip_File_Test.zip_one_file();
    }
    public static void zip_one_file() {
        byte[] buffer = new byte[1024];
        try{
            FileOutputStream fos = new FileOutputStream("E:\\java\\testing.zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze= new ZipEntry("testing1.txt");
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream("E:\\java\\testing.txt");
            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();
            zos.closeEntry();
            //remember close it
            zos.close();
            System.out.println("Done");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}