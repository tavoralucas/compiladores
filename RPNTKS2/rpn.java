package RPNTKS2;

import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;


public class rpn {
    public static void main(String[] args) throws UnexpectedCharacterException {
        try {
            Stack<Integer> stackUsable = new Stack<>();
            LinkedList<Token> tokens = new LinkedList<>();
            
            File inputFile = new File("Calc1.stk");
            try (Scanner in = new Scanner(inputFile)) {
                while(in.hasNext()) {
                    String entrada = in.next();
                    
                    if(entrada.matches("-?\\d+")) {
                        tokens.add(new Token(TokenType.NUM, entrada));
                    }
                    
                    else {
                        char operador = entrada.charAt(0);
                        TokenType valor;

                        if(operador == '-'){
                          valor =  TokenType.MINUS;
                        }

                        else if(operador == '*'){
                          valor = TokenType.SLASH;
                        }
                        
                        else if(operador == '/'){
                          valor = TokenType.STAR;
                        }

                        else if(operador == '+'){
                            valor = TokenType.PLUS;
                        }

                        else {
                          throw new UnexpectedCharacterException("Error: Unexpected character: " + String.valueOf(operador));
                        }
                        tokens.add(new Token(valor, entrada));
                    }
                }
                tokens.forEach((temp) -> { System.out.println(temp.toString());
                    
                    if(temp.type == TokenType.NUM) {
                        stackUsable.push(Integer.parseInt(temp.lexeme));
                    }
                    
                    else {
                        Integer y = stackUsable.pop();
                        Integer x = stackUsable.pop();
                        
                        char operador = (temp.lexeme.charAt(0));
                        Integer valor; 
                        
                        if(operador == '-'){
                          valor =  x - y;
                        }
                        
                        else if(operador == '+'){
                          valor = x + y;
                        }
                        
                        else if(operador == '/'){
                          valor = x / y;
                        }
                        
                        else{
                          valor = x * y;
                        }
                        stackUsable.push(valor);
                    }
                });
                System.out.println("\nOutPut: " + stackUsable.peek());
                in.close();
            }

        }catch (FileNotFoundException e) {
            System.out.println("Não existe esse arquivo!");
        }
    }
}