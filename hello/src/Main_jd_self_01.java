import java.util.Scanner;

/**
 * Created by seu on 2017/9/9.
 */
public class Main_jd_self_01 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();//���еĸ���
        for(int i=0;i<N;i++){
            int n=sc.nextInt();//Ԫ�ظ���
            int nums4=0;//�ܱ�4������Ԫ�ظ���
            int numsx=0;//�Ȳ��ܱ�2Ҳ���ܱ�4������Ԫ�ظ���
            for(int j=0;j<n;j++){
                int cur=sc.nextInt();
                if(cur%4==0){
                    nums4++;
                }else if(cur%2!=0){
                    numsx++;
                }
            }
            //����ܱ�4�����ĸ������ڵ��ڼȲ��ܱ�4Ҳ���ܱ�2������Ԫ�ظ��������
            if(nums4>=numsx){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
