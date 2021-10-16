import java.util.*;

class PhoneNumberCombination{
    private static final Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList<>();
        return createCombination(digits,"");
    }

    public List<String> createCombination(String digits,String tempString){
        /*
        if the length of the digits is 0, return the tempString as a singleton item.
         */
        if(digits.length()==0){
            return Collections.singletonList(tempString);
        }// base case

        List<String> resultList=new ArrayList<>();
        /*
        Pick the first digit from the digits.
        Get the value mapped at the same digit.
        Iterate the values, and add the value one by one in the string.
        Call the recursive function from the next value of "digits" variable
         */
        String valuesAtDigit=phoneMap.get(digits.charAt(0));
        for(int i=0;i<valuesAtDigit.length();i++){
            String newTemp=tempString+valuesAtDigit.charAt(i);
            //call the function and add them in list
            resultList.addAll(createCombination(digits.substring(1),newTemp));
        }
        return resultList;
    }

    public static void main(String[] args) {
        PhoneNumberCombination phoneNumberCombination=new PhoneNumberCombination();
        Scanner input=new Scanner(System.in);
        System.out.println("enter the digits: ");
        String digits=input.next();
        /*
        Checking the entered digits.
        if 0 or 1 is entered, throw error.
        If non digit String is entered, throw error.
         */
        if(digits.contains("0") || digits.contains("1") || !digits.chars().allMatch(Character::isDigit))
            System.out.println("Please enter valid number between 2 and 9");
        else
            System.out.println(phoneNumberCombination.letterCombinations(digits));
    }
}