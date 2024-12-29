
package employeemanagement;

import java.util.ArrayList;

public class sabtAhval {
    
    public int test(String codeMeli){
        ArrayList<Integer>AC=new ArrayList();
        String code1 = codeMeli;
        String CODE[] = code1.split("");
        for(String code:CODE){
        int e = Integer.parseInt(code);
        AC.add(e);
        }
        int sum = 0;
        int sum2 = 10;
        for (int i = 0; i < 9; i++) {
        sum = sum + AC.get(i)*sum2;
        sum2--;
        }
        int sum3 = sum%11;
        int sum33 = 11-sum3;
        int getAC = AC.get(AC.size()-1);
        if (sum3==getAC || sum33==getAC){
            return 1;
        }else{
            return 0;
        }
    }
    
    
}
