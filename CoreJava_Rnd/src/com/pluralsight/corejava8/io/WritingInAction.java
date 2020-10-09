package com.pluralsight.corejava8.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WritingInAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeCharacters();
	}

	private static void writeCharacters() {
		// TODO Auto-generated method stub
		
		System.out.println("writeCharacters Start ---");
		//try-with-resources pattern
		
		Path path = Paths.get("ExtFiles/new-file.txt");
		
		try(BufferedWriter bufWriter = Files.newBufferedWriter(path,
					StandardOpenOption.CREATE,StandardOpenOption.APPEND);){
			
			PrintWriter pw = new PrintWriter(bufWriter);
			
			pw.println("Helo Amit, Keep Practicing for good results !!!");
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
		System.out.println("writeCharacters End ---");
		
	}

}
