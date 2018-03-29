import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *  ����ӣ�
 *  �и��� x, k �������� x + y = x | y �ĵ� k С�������� y �� | �Ƕ����ƵĻ�(or)���㣬���� 3 | 5 = 7��
    ���統 x=5��k=1ʱ���� 2����Ϊ5+1=6 ������ 5|1=5���� 5+2=7 ���� 5 | 2 = 7��

        ��������:
            ÿ���������������һ�����ݣ�ÿ������Ϊ���������� x , k�� ���� 0 < x , k �� 2,000,000,000��

        �������:
            ���һ����y��

        ��������1:
            5 1

        �������1:
            2

    ����˼·�����Ҫʹ��x+y=x|y�������Ҫ��֤x��Ϊ1��λ����y��Ϊ1��Ȼ��k�Ķ����Ʊ�ʾӳ���x�м���

 * Created by seu on 2017/9/6.
 */
public class Main_toutiao_nt_04 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int x=sc.nextInt();
            int k=sc.nextInt();
            StringBuilder res=new StringBuilder();
            String k_bin=Integer.toString(k, 2);//ת�ɶ������ַ���
            int index=k_bin.length()-1;
            while(k!=0){
                if((x&1)==0){
                    res.append(k_bin.charAt(index--));
                    k/=2;
                }else{
                    res.append("0");
                }
                x>>>=1;
            }
            BigInteger num=new BigInteger(res.reverse().toString(), 2);
            System.out.println(num);
        }
    }
}