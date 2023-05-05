
package mavenPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Properties {

	public static void main(String[] args) throws IOException {
		java.util.Properties prop=new java.util.Properties();
		FileInputStream ips=new FileInputStream("D:\\rajesh-workspace\\FirstMavenProject\\src\\test\\resources\\Properties\\testdata.properties");
		prop.load(ips);
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
		FileOutputStream ops=new FileOutputStream("D:\\rajesh-workspace\\FirstMavenProject\\src\\test\\resources\\Properties\\testdata.properties");		
		prop.setProperty("testdata1", "hi");
		prop.setProperty("testdata2", "welcome");
		prop.store(ops, "Added test data");
		
		System.out.println(prop.getProperty("testdata1"));
	}
}
