package problemset3;
/*
2^5=2*2*2*2*2*1

4

 */
public class XToThePowerN {


    public  int improvedApproach(int baseNumber,int power){

        if(power==0){
            return 1;
        }

        int result=improvedApproach( baseNumber, power/2);

        if(power%2==0){
            return result*result;
        }
        return baseNumber*result*result;
    }
    public int findPowerOfN(int baseNumber,int power){
        if(power==0){
            return 1;
        }
       return baseNumber* findPowerOfN(baseNumber,power-1);
    }


    public static void main(String[] args) {
       // System.out.println("Result:"+new XToThePowerN().findPowerOfN(2,10));
        System.out.println("Result:"+new XToThePowerN().improvedApproach(2,4));
    }
}
