import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_jd_self_02 {
    static String s="";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s=sc.next();
        int res=-1;
        int sum=0;
        List<String> resList = generateParentheses(s.length()/2);
        for(String t:resList){
            //t��s�������
            if(t.equals(s)){
                continue;
            }
            res=Math.max(longestCommonSubsequence(s,t).length(),res);

        }
        for(int i=0;i<resList.size();i++){
            if(resList.get(i).equals(s)){
                continue;
            }
            if(longestCommonSubsequence(s,resList.get(i)).length()==res){
                sum++;
            }
        }
        System.out.println(sum);
    }

    public static String longestCommonSubsequence(String s1,String s2){
        int size1=s1.length();
        int size2=s2.length();
        int chess[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=size1;i++){//���������ᵽ�Ĺ�ʽ�������
            for(int j=1;j<=size2;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    chess[i][j]=chess[i-1][j-1]+1;
                }else {
                    chess[i][j]=Math.max(chess[i][j-1],chess[i-1][j]);
                }
            }
        }
        int i=size1;
        int j=size2;
        StringBuffer sb=new StringBuffer();
        while((i!=0)&&(j!=0)){//��������õ��ľ�����������У��������½���������
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));//��ͬʱ��Ϊ��ͬ���Ӵ�
                i--;
                j--;
            }else {
                if (chess[i][j-1]>chess[i-1][j]) {
                    j--;
                }else {
                    i--;
                }
            }
        }
        //      System.out.println((double)sb.length()/s2.length()+","+(double)sb.length()/s1.length());
        return sb.reverse().toString();//�ǵ÷�ת
    }


    public static List<String>generateParentheses(int pairs) {
        List<String> result = new ArrayList<String>();
        generate(pairs, pairs, "", result);
        return result;
    }

    public static void generate(int leftNum, int rightNum, String s,
                                List<String> result) {
        if (leftNum == 0 && rightNum == 0) {
            result.add(s);
        }
        if (leftNum > 0) {
            generate(leftNum - 1, rightNum, s + '(', result);
        }
        if (rightNum > 0 && leftNum < rightNum) {
            generate(leftNum, rightNum - 1, s + ')', result);
        }
    }


}
