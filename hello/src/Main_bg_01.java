import java.util.Scanner;
import java.util.Stack;

/**
 * Created by seu on 2017/9/4.
 */
public class Main_bg_01 {
/*
����ʾ����
2
A 2 2 100.5
B 4 3 180.5
3 2 1
���е�һ�б�ʾһ���м��ַ��ͣ���Ϊ����n��
��������n���������ֱ��ʾÿ�ַ����ܹ����ɵĳ��������ܹ����ɵĶ�ͯ��������
���һ�е��������ֱ��ʾ�ͻ��еĳ���������ͯ����ס����
*/
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();//������
            int[] adults = new int[N];//���Ϳ�ס������
            int[] children = new int[N];//���Ϳ�ס��ͯ��
            double[] prices = new double[N];//���͵���
            for(int i=0;i<N;i++){
                adults[i]=sc.nextInt();
                children[i]=sc.nextInt();
                prices[i]=sc.nextDouble();
            }
            int X=sc.nextInt();//�ͻ����м����ǳ���
            int Y=sc.nextInt();//�ͻ����м����Ƕ�ͯ
            int num=sc.nextInt();//�ͻ�һ��ס����
            int[] res=new int[N];//�м����飬���ڽ��������������ʱʹ��
            int[] destChoices=new int[N];//Ŀ�귿��ѡ����Ŀ���飬��destChoices[i]=t����ʾ��Ҫ��i�ͷ�t��
            double[] minPrice=new double[1];//���ڴ���ͼۣ�ע���������ͼ۱�ʾnum���ܵ���ͼ�
            minPrice[0]=Integer.MAX_VALUE;//��ʼ����ͼ�Ϊ�������ֵ

            //�����ѡ��
            getMinPriceChoiceWithNum(adults,children,prices,res,minPrice,destChoices,X,Y,num,0,0,0.0);

            //���������ѡ�������
            for(int r:destChoices){
                System.out.print(r+"\t");
            }

            //���num���ܵķ���
            System.out.println(minPrice[0]);
        }
    }

    /**
     * ��num������ѡ��
     * @param adults :ÿ�ַ��Ϳ�����ס�ĳ�����
     * @param children :ÿ�ַ��Ϳ�����ס�Ķ�ͯ��
     * @param prices :ÿ�ַ��͵���
     * @param res :�м����飬���ڽ��������������ʱʹ��
     * @param minPrice :���ڴ���ͼۣ�ע���������ͼ۱�ʾnum���ܵ���ͼ�
     * @param destChoices :Ŀ�귿��ѡ����Ŀ���飬��destChoices[i]=t����ʾ��Ҫ��i�ͷ�t��
     * @param x :�ͻ��еĳ�����
     * @param y :�ͻ��еĶ�ͯ��
     * @param num :�ͻ�ס����
     * @param xn :Ŀǰ����ѡ��������ɶ��ٳ���
     * @param yn :Ŀǰ����ѡ��������ɶ��ٶ�ͯ
     * @param cur :Ŀǰ����ѡ���ܽ��
     */
    private static void getMinPriceChoiceWithNum(int[] adults, int[] children, double[] prices, int[] res,double[] minPrice,int[] destChoices,int x, int y,int num,int xn,int yn,double cur) {
        getMinPriceChoice(adults,children,prices,res,minPrice,destChoices,x,y,xn,yn,cur);
        minPrice[0]*=num;
    }


    /**
     * ��1������ѡ��
     * @param adults :ÿ�ַ��Ϳ�����ס�ĳ�����
     * @param children :ÿ�ַ��Ϳ�����ס�Ķ�ͯ��
     * @param prices :ÿ�ַ��͵���
     * @param res :�м����飬���ڽ��������������ʱʹ��
     * @param minPrice :���ڴ���ͼۣ�ע���������ͼ۱�ʾnum���ܵ���ͼ�
     * @param destChoices :Ŀ�귿��ѡ����Ŀ���飬��destChoices[i]=t����ʾ��Ҫ��i�ͷ�t��
     * @param x :�ͻ��еĳ�����
     * @param y :�ͻ��еĶ�ͯ��
     * @param xn :Ŀǰ����ѡ��������ɶ��ٳ���
     * @param yn :Ŀǰ����ѡ��������ɶ��ٶ�ͯ
     * @param cur :Ŀǰ����ѡ���ܽ��
     */
    private static void getMinPriceChoice(int[] adults, int[] children, double[] prices, int[] res,double[] minPrice,int[] destChoices,int x, int y,int xn,int yn,double cur) {
        if(xn>=x && yn>=y){
            if(cur<minPrice[0]){
                minPrice[0]=cur;
                copyArr(res,destChoices);
            }
            return;
        }
        for(int i=0;i<res.length;i++){
            res[i]+=1;
            getMinPriceChoice(adults,children,prices,res,minPrice,destChoices,x,y,xn+adults[i],yn+children[i],cur+prices[i]);
            res[i]-=1;
        }
    }


    /**
     * ��������Ԫ��
     * @param fromArr Դ����
     * @param toArr Ŀ������
     */
    private static void copyArr(int[] fromArr,int[] toArr){
        if(fromArr==null || toArr==null || toArr.length < fromArr.length){
            return;
        }
        for(int i=0;i<fromArr.length;i++){
            toArr[i]=fromArr[i];
        }
    }
}