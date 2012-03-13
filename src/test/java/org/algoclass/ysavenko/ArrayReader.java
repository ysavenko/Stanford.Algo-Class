package org.algoclass.ysavenko;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class ArrayReader {

    @SuppressWarnings("deprecation")
    public static final Integer[] read() throws Exception {
	final Integer[] array = new Integer[100000];
	int i = 0;
	final File file = new File("IntegerArray.txt");
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	DataInputStream dis = null;
	try {
	    fis = new FileInputStream(file);
	    bis = new BufferedInputStream(fis);
	    dis = new DataInputStream(bis);
	    while (dis.available() != 0) {
		array[i++] = Integer.valueOf(dis.readLine());
	    }
	} finally {
	    fis.close();
	    bis.close();
	    dis.close();
	}

	return array;
    }
}
