import java.util.*;

/**
 * ľ��ƴͼ��
 * ��һ���ɺܶ�ľ�����ɵļ��ϣ�ÿ��ľ���ж�Ӧ�ĳ��ȣ������ܷ��ü����е���Щľ����ĳ��˳����β��������һ��������� 0 �ļ򵥶����������ľ����Ҫ���ϣ�
 * �򵥶���μ������Խ��Ķ���Ρ���ʼ�����ǿյģ������ֲ�����Ҫô���������һ������Ϊ L ��ľ����Ҫôɾȥ�������Ѿ��е�ĳ��ľ����ÿ�β�����������
 * ����Ҫ��֪�Ƿ����ü����е���Щľ������һ���򵥶���Ρ�

    ��������:
        ÿ���������������һ�����ݣ�ÿ�����ݵ�һ��Ϊһ�������� n ��ʾ����������(1 �� n �� 50000) �� ��������n�У�ÿ�е�һ������Ϊ�������� i (i �� {1,2})���ڶ�������Ϊһ������ L(1 �� L �� 1,000,000,000)����� i=1 �����ڼ����ڲ���һ������Ϊ L ��ľ������� i=2 ����ɾȥ�ڼ����ڵ�һ������Ϊ L ��ľ�����������ݱ�֤ɾ��ʱ�����бض����ڳ���Ϊ L ��ľ��������������󼯺϶��Ƿǿյġ�
    �������:
        ����ÿһ�β���������һ���������������ڵ�ľ�����Թ��ɼ򵥶���Σ���� "Yes" ��������� "No"��

    ��������1:
         5
         1 1
         1 1
         1 1
         2 1
         1 2

    �������1:
         No
         No
         Yes
         No
         No

    ����˼·�� �����бߣ���ľ�����ܳ���Ϊ Tlen����ǰ���һ���߳���Ϊmax_len������� Tlen - max_len > max_len ʱ��
    ��������������0 �ļ򵥶����

 * Created by seu on 2017/9/6.
 */
public class Main_toutiao_nt_02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            long[][] data=new long[n][2];
            for(int i=0;i<n;i++){
                data[i][0]=sc.nextLong();
                data[i][1]=sc.nextLong();
            }
                dealWith(data);
        }
    }
     
    public static void dealWith(long[][] data){
        List<Long> sticks=new ArrayList<Long>();
        for(int i=0;i<data.length;i++){
            if(data[i][0]==1)
                sticks.add(data[i][1]);
            else
                sticks.remove(data[i][1]);
            judge(sticks);
        }
    }
     
    public static void judge(List<Long> sticks){
        if(sticks.size()<3)
            System.out.println("No");
        else{
            Collections.sort(sticks);
            long sum=0;
            int i=0;
            for(i=0;i<sticks.size()-1;i++){
                sum+=sticks.get(i);
            }
            if(sum>sticks.get(i))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}