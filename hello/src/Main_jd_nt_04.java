import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * �󼯺ϲ������������������ϣ�Ҫ��{A} + {B}�� ע��ͬһ�������в�����������ͬ��Ԫ�ء�
 *      ��������:
            ÿ���������ݷ�Ϊ����,��һ������������n,m(0 �� n,m �� 10000)���ֱ��ʾ����A�ͼ���B��Ԫ�ظ����������зֱ��ʾ����A�ͼ���B��ÿ��Ԫ��Ϊ������int��Χ������,ÿ��Ԫ��֮���и��ո������

        �������:
            ���ÿ���������һ�����ݣ���ʾ�ϲ���ļ��ϣ�Ҫ���С���������ÿ��Ԫ��֮����һ���ո����,��ĩ�޿ո�

        ��������1:
            3 3
            1 3 5
            2 4 6

        �������1:
            1 2 3 4 5 6
 * Created by seu on 2017/9/6.
 */
public class Main_jd_nt_04 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            n+=sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for(int i=0;i<n;i++){
                set.add(sc.nextInt());
            }

            Iterator<Integer> iter=set.iterator();
            while(iter.hasNext()){
                System.out.print(iter.next());
                if(iter.hasNext()){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
