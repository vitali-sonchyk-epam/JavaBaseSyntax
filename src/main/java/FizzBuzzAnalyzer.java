import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FizzBazzAnalyzer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the limit integer for program:");
        int limit = Integer.parseInt(br.readLine());
        for(int i = 1; i <= limit;  i++){
            if(i % 3 == 0 && i % 5 ==0){
                System.out.println(i + "FizzBuzz");
            }
            else if(i % 3 == 0){
                System.out.println(i + "Fizz");
            }
            else if(i % 5 ==0){
                System.out.println(i + "Buzz");
            }
            else{
                System.out.println(i);
            }
        }
    }
}

