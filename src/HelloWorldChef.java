import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class HelloWorldChef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World of Chef");
		System.out.println("This is version 2.4");
		String current = new File( "." ).getAbsolutePath();
		System.out.println(current);
		current = current.subSequence(0,current.length()-1).toString();
		String path = current + "helloworld.conf";
		String[] attr = readFile(path).split(":");
		System.out.println(attr[1]);
		
		
	}
	public static final String readFile(String filePath) {
        File f = new File(filePath);
        if(!f.exists()) {
            System.err.println("File " + f.getName() + " not found");
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        byte[] bytes = new byte[1024];
        int readBytesCount = 0;
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(f));
            while( (readBytesCount = in.read(bytes)) != -1) {
                buffer.append(new String(bytes, 0, readBytesCount));
            }
        } catch(Exception exc) {
            exc.printStackTrace();
            return null;
        }
        return buffer.toString();
    }
}
