import java.rmi.UnexpectedException;
import java.util.HashMap;
import java.util.Map;

class RomeNumbersParser {
    public static void main(String[] args) throws UnexpectedException {
        if(args.length > 1){
            throw new UnexpectedException("Incorrect data was input. More than one string applied!");
        }

        else if(args[0].length() < 1){
            throw new UnexpectedException("Empty rome value could not be converted to a greek number!");
        }

        else{
            String romeStr = args[0];
            int greekTotalNumber = 0;

            for(Map.Entry<String, Integer> entry: getExceptionsMap().entrySet()){
                if(romeStr.contains(entry.getKey())){
                    greekTotalNumber =+ entry.getValue();
                    romeStr = romeStr.replace(entry.getKey(), "");
                }
            }
            for (char ch: romeStr.toCharArray()) {
                Integer greekFract = getNumbersMap().get(Character.toUpperCase(ch));
                if(greekFract == null){
                    throw new UnexpectedException("Unable to parse char:" + ch);
                }
                greekTotalNumber = greekTotalNumber + greekFract;
            }

            System.out.println("Greek value:" + greekTotalNumber);
        }
    }

    private static Map<String, Integer> getExceptionsMap(){
        HashMap<String, Integer> numbersMap = new HashMap<>();
        numbersMap.put("IV", 4);
        numbersMap.put("XL", 40);
        numbersMap.put("XC", 90);
        numbersMap.put("CD", 90);
        numbersMap.put("CM", 900);
        return numbersMap;
    }

    private static Map<Character, Integer> getNumbersMap(){
        HashMap<Character, Integer> numbersMap = new HashMap<>();
        numbersMap.put('I', 1);
        numbersMap.put('V', 5);
        numbersMap.put('X', 10);
        numbersMap.put('L', 50);
        numbersMap.put('M', 100);
        return numbersMap;
    }
}
