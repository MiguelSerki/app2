package PruebaWorkbook.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

	
	// Copy the source file to target file.
	  // In case the dst file does not exist, it is created
	  void copy(File source, File target) throws IOException {
	 
	      InputStream in = new FileInputStream(source);
	      OutputStream out = new FileOutputStream(target);
	   
	      // Copy the bits from instream to outstream
	      byte[] buf = new byte[1024];
	      int len;
	 
	      while ((len = in.read(buf)) > 0) {
	          out.write(buf, 0, len);
	      }
	 
	      in.close();
	      out.close();
	  }

}
