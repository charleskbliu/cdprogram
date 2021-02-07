package test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import cdprogram.Mycd;

public class unitTest {
	public static void main(String[] args) throws IOException {
		File testFile = new File("test.txt");
	    Scanner myReader = new Scanner(testFile);
	    int pass = 0;
	    int fail = 0;
	    int caseNum = 1;
	      
	    while (myReader.hasNextLine()) {
	    	String out;
	    	StringTokenizer st = new StringTokenizer(myReader.nextLine());
	    	out = Mycd.processMycd(st);
	    	String modelAnswer = myReader.nextLine();
	    	if (out.contentEquals(modelAnswer)) {
	    		pass++;
	    	}
	    	else {
	    		fail++;
	    		System.out.print("case " + caseNum + " fail " + "wrong answer is " + out + "\n");
	    	}
	    	caseNum++;
	    }
	    System.out.println();
	    System.out.print("pass cases " + pass + "; fail cases " + fail);
	    myReader.close();
		
	}

}
