package RPNTKS1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class rpn {

	public static void main (String[] args) throws FileNotFoundException {
		Stack<Integer> stackUsable = new Stack<>();		
		Scanner input = new Scanner (new FileReader("Calc1.stk"));
		
          while (input.hasNext()) {
			if (input.hasNextInt()) {
				stackUsable.push(input.nextInt());
			} else {
				char symbol = input.next().charAt(0);
				
                    int FirstValue = stackUsable.pop().intValue();
				int OtherValue = stackUsable.pop().intValue();
				
                    switch (symbol) {
                         case '+':
                              stackUsable.push(FirstValue+OtherValue);
                              break;
                         case '-':
                              stackUsable.push(FirstValue-OtherValue);
                              break;
                         case '*':
                              stackUsable.push(FirstValue*OtherValue);
                              break;
                         case '/':
                              stackUsable.push(FirstValue/OtherValue);
                              break;
				}
			}
		}
		System.out.println(stackUsable.get(0));
	}
     
}
