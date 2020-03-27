package testing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import adt.ADT;
import adt.BinarySearchTree;
import adt.DoublyLinkedList;



	public class EmpiricalStudies {

		public int[] arr;
		public String fileName;
		public ADT<Integer> adt;
		public int[] randomNumber;
		
		
		public EmpiricalStudies(String fileName, ADT<Integer> adt) {
			super();
			this.adt = adt;
			
			try {
				this.readArray(fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.randomNumber = this.GenerateValues(this.adt);
		}

		public void readArray(String longName) throws IOException {
			
			Path path = Paths.get(longName);
			int lineCount = (int) Files.lines(path).count();
			
			int[] arr = new int[lineCount];
			int i = 0;
			
			File file = new File(longName);
			Scanner fileScanner = new Scanner(file);
			
			while(i<lineCount) {
				arr[i] = fileScanner.nextInt();
				i++;
			}
			
			fileScanner.close();
			this.arr = arr;
			
		}
		
		public void IsElementTest() {
			// Quick 3 way Sort
			
			System.out.print("\nTesting is Element Method: ");
			List<Long> averages = new ArrayList<Long>();
			for (int x=0; x < randomNumber.length; x++) {
				long time1=System.currentTimeMillis();
				adt.IsElement(arr[x]);
				long time2=System.currentTimeMillis();
				long timeTaken=time2-time1;
				averages.add(timeTaken);
				
			}
			
			long averageTime = 0;
			for (Long time : averages) {
				
				averageTime += time;
			}
			
			
			System.out.print(averageTime/100 + " milliseconds\n");
			System.out.print(adt.setSize);
		}
		
		public int[] GenerateValues(ADT<Integer> adt) {
			// Quick 3 way Sort
			System.out.print("\nAdding Intgers from file: ");
			long time1=System.currentTimeMillis();
			for (int x=0; x < arr.length-1; x++) {
				adt.Add(arr[x]);
			}
			long time2=System.currentTimeMillis();
			long timeTaken=time2-time1;
			System.out.print(timeTaken + " milliseconds\n");

			System.out.print("\nGenerating random numbers: ");
			time1=System.currentTimeMillis();
			
			int[] randomNumber = new int[100];
			Random r = new Random();
			int max = 49999;
			int min = 0;
			for (int x = 0; x < randomNumber.length; x++) {
				randomNumber[x] = r.nextInt((max - min) + 1) + min;
				
			}
			time2=System.currentTimeMillis();
			timeTaken=time2-time1;
			System.out.print(timeTaken + " milliseconds\n");
			System.out.print("Good to go... \n");
			
			
			return randomNumber;
		}
		
		
		
		public static void main(String args[]) {
			
			
			DoublyLinkedList<Integer> dbl = new DoublyLinkedList<Integer>();
			BinarySearchTree bst = new BinarySearchTree();
			
			EmpiricalStudies testDBL = new EmpiricalStudies("src/lab-tests/int20k.txt", dbl);
			EmpiricalStudies testBST = new EmpiricalStudies("src/lab-tests/int20k.txt", bst);
			
			testDBL.IsElementTest();
			testBST.IsElementTest();
			System.out.println("\n"+bst.height(bst.root));
			
			
		}
}
