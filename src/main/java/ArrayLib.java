public class ArrayLib {
    private ArrayLib(){}

    public static int[] nextFourArray(int[] inputArray){
        int fourPos=-1;
        for (int i = inputArray.length-1; i >=0 ; i--) {
            if (inputArray[i]==4){
                fourPos=i;
                break;
            }
        }
        if (fourPos==-1) throw new RuntimeException();

        int length = inputArray.length-fourPos-1;
        int[] result = new int[length];

        for (int i = fourPos+1; i <inputArray.length ; i++) {
            result[i-fourPos-1]=inputArray[i];
        }
        return result;
    }

    public static boolean checkForOneAndFour(int[] inputArray)
    {
        boolean haveOne = false;
        boolean haveFour = false;

        for (int number:inputArray)
        {
            if (number==4)haveFour=true;
            if (number==1)haveOne=true;
        }
        return haveOne || haveFour;
    }

}
