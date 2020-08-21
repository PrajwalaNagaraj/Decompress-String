/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
    private static String decompressStr(String str){
        Stack<String> ip = new Stack<String>();
        
        int cnt = 0; // variable used to see if we need to multiple str times
        for(int k = 0; k < str.length(); ) {
            char ch = str.charAt(k);
            if(ch == '(') {
                //do nothing, push in stack to pop when we encounter ")"
                ip.push("(");
                k++;
            }else if(Character.isDigit(ch)) {
                //logic to read a digit [1,12,1234,3456]
                StringBuilder num = new StringBuilder();
                num.append(ch);
                k++;
                while(k+1 < str.length() && Character.isDigit(str.charAt(k))) {
                    num.append(Character.toString(str.charAt(k)));
                    k++;
                }
                cnt = Integer.parseInt(num.toString());
            }else if(Character.isLetter(ch)) {
                ip.push(Character.toString(ch));
                k++;
            }else if(ch == ')') {
             StringBuilder sb = new StringBuilder();
                if(cnt == 0) {
                    //count is not set, pop all values upto "(",combine them and push them back
                    while(!ip.isEmpty() && ip.peek() != "(") {
                        sb.insert(0, ip.pop());
                    }
                    if (!ip.isEmpty())
                        ip.pop();// "(" - pop the opening bracket after compute is done
                    
                    ip.push(sb.toString());
                    k++;
                }else {
                    //count is set, pop  the latest value from stack, multiple by cnt times and push back to stack
                    ip.pop(); // pop - "(" of the digit that was added
                    String tmp = ip.pop();//str that needs multiplication
                 
                    for(int i = 0; i < cnt; i++) {
                        sb.append(tmp);
                    }
                    ip.push(sb.toString());
                    cnt = 0; // reset to 0 for reading consecutive values from left to right
                    k++;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while(!ip.isEmpty()) // To handle cases that has last letters after the string (ab(2)c)(2)d
            res.insert(0, ip.pop());
        return res.toString();
    }
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System. in);
        //String inputString = scanner. nextLine();
        System.out.println(decompressStr("(ab(2)c)(2)"));
	}
}
