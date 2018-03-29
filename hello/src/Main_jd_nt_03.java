import java.util.Scanner;

/**
 * ��������
 *
 * ���壺�����Ʊ�ʾ��λ֮�͵���ʮ���Ʊ�ʾ����λ֮��
 *      ��������:
            ÿ����������һ����n(n<=100000)

        �������:
            ÿ���������һ�У�С�ڵ���n��������������

        ��������1:
            21

        �������1:
            3
 * Created by seu on 2017/9/6.
 */
public class Main_jd_nt_03{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            System.out.println(helper(n));
        }
    }
    public static int helper(int n){
        int res=0;
        for(int i=1;i<=n;i++){
            if(getSumDigits(i,10)==getSumDigits(i,2)){
                res++;
            }
        }
        return res;
    }
    public static int getSumDigits(int num,int base){
        int res=0;
        while(num!=0){
            res+=(num%base);
            num/=base;
        }
        return res;
    }
}
