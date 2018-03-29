import java.util.Scanner;

/**
 * ����ƾ�ֵ���Բ��ɻ���ķ�����ʾ
 * ��������:
        �������ж���������ݣ�ÿ���������Ϊһ������A(1 �� A �� 5000).

        �������:
            ��ÿ��������ݣ��ڵ�����������X/Y����ʽ��������

        ��������1:
            5
            3

        �������1:
            7/3
            2/1

    ˼·�����ӵ���2-A-1������λ֮�ͣ���ĸ����n-2
 * Created by seu on 2017/9/6.
 */
public class Main_jd_nt_02 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            System.out.println(helper(n));
        }
    }
    public static String helper(int n){
        int res=0;
        for(int i=2;i<n;i++){
            res+=getSumDigits(n,i);
        }
        int comm=gcd(res,n-2);
        return res/comm+"/"+(n-2)/comm;
    }
    public static int gcd(int a,int b){
        while(a%b!=0){
            int c=a%b;
            a=b;
            b=c;
        }
        return b;
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
