package com.pluralsight.corejava8.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WritingBytes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to core java...");
		
		//testWriteIntOutputStream();
		testReadInputStream();
		//testWriteUTFChars();
		//testWriteIntStreams();
		
		
	}

	private static void testWriteIntStreams() {
		// TODO Auto-generated method stub
		System.out.println("Writing Integer Stream Start -----");
		
		String pathname = "ExtFiles/ints.bin";

		File file = new File(pathname);

		try (OutputStream os = new FileOutputStream(file);) {

			// Make a DataOutputStream as we have to write integer
			DataOutputStream dos = new DataOutputStream(os);

			IntStream.range(1000, 2000)
					 .forEach(I -> {
						 try {
							dos.writeInt(I);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 });
			
			//dos.writeInt(10);
			// dos.writeDouble(10d);

			
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Lets verify size of the file after we have writtem integer to the file
		Path path = Paths.get(pathname);
		try {
			long sizeOfFile = Files.size(path);
			System.out.println("Size of file : " + sizeOfFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Writing Integer Stream End -----");
		
	}

	private static void testWriteUTFChars() {
		// TODO Auto-generated method stub
		String pathname = "ExtFiles/ints.bin";

		File file = new File(pathname);

		try (OutputStream os = new FileOutputStream(file);) {

			// Make a DataOutputStream as we have to write integer
			DataOutputStream dos = new DataOutputStream(os);

			dos.writeUTF("Hello");
			// dos.writeDouble(10d);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Lets verify size of the file after we have writtem integer to the file
		Path path = Paths.get(pathname);
		try {
			long sizeOfFile = Files.size(path);
			System.out.println("Size of file after writing UTF Chars : " + sizeOfFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void testReadInputStream() {
		// TODO Auto-generated method stub
		
		System.out.println("testReadInputStream Start ---");

		String pathname = "ExtFiles/ints.bin";

		File file = new File(pathname);

		List<Integer> integerList = new ArrayList<>();

		try (InputStream is = new FileInputStream(file); DataInputStream dis = new DataInputStream(is);) {

			int readValue = -1;
			try {
				while (true) {
					integerList.add(dis.readInt());
				}
			} catch (EOFException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception block 1 ...");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception block 2 ...");
			e.printStackTrace();
		}
		
		System.out.println("Size of integerList : " + integerList.size());
		System.out.println("testReadInputStream End ---");

	}

	private static void testWriteIntOutputStream() {
		// TODO Auto-generated method stub
		
		String pathname = "ExtFiles/ints.bin";
		
		File file = new File(pathname);
		
		try(OutputStream os = new FileOutputStream(file);){
			
			//Make a DataOutputStream as we have to write integer
			DataOutputStream dos = new DataOutputStream(os);
			
			dos.writeInt(10);
			//dos.writeDouble(10d);
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//Lets verify size of the file after we have writtem integer to the file
		Path path = Paths.get(pathname);
		try {
			long sizeOfFile = Files.size(path);
			System.out.println("Size of file : " + sizeOfFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
