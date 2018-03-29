package ucl.property.generate;

import ucl.property.base.UCLPropertyBase;

/**
 * Created by seu on 2018/3/29.
 */
public class GenZCPSProperty {

    //Ŀ���������,�˴�c++�汾��helper��������Ĭ�ϲ���ֵ0����ʽʵ�֣�Java��֧�֣��ش�˵��
    public static UCLPropertyBase genName(String vPart,int helper){
        UCLPropertyBase name = new UCLPropertyBase();
        name.setProperty(0x01, helper, vPart);

        return name;
    }

    //�ռ�λ����Ϣ, Ĭ�Ͻ�������ΪGPS
    /**
     *
     * @param vPart
     * @param parse ������ϵ����λ����Ϣ����
     * 0001 ��ʾ�����й��������ǵ���ϵͳ��BDS��������ϵ����λ����Ϣ��
     * 0010 ��ʾ����ȫ��λϵͳ��GPS��������ϵ����λ����Ϣ��
     * c++�汾�в���Ĭ�ϲ���ֵ2����ʽʵ�֣�Java��֧�֣��ش�˵��
     * @param helper
     * c++�汾�в���Ĭ�ϲ���ֵ0����ʽʵ�֣�Java��֧�֣��ش�˵��
     * @return
     */
    public static UCLPropertyBase genSpaceLoc(String vPart, int parse, int helper){

        UCLPropertyBase spaceLoc = new UCLPropertyBase();
        spaceLoc.setLPartHead(2, 5, parse);
        spaceLoc.setProperty(0x2, helper, vPart);

        return spaceLoc;
    }


    //ʱ����Ϣ, Ĭ��ΪGPS��ʱʱ��
    /**
     *
     * @param vPart
     * @param parse ��ʱ��Ϣ����
     * 0001��ʾ�����й��������ǵ���ϵͳ��BDS����ʱ��Ϣ��
     * 0010��ʾPOSIXʱ���׼ʱ�䣻
     * c++�汾�в���Ĭ�ϲ���ֵ2����ʽʵ�֣�Java��֧�֣��ش�˵��
     * @param helper
     * c++�汾�в���Ĭ�ϲ���ֵ0����ʽʵ�֣�Java��֧�֣��ش�˵��
     * @return
     */
    public static UCLPropertyBase genTime(String vPart, int parse, int helper){
        UCLPropertyBase time = new UCLPropertyBase();
        time.setLPartHead(2, 5, parse);
        time.setProperty(0x3, helper, vPart);

        return time;
    }


    /**
    *Ŀ�����ΰ�������������ͶӰ�߽������֣������ķָ�����;���ָ������һ��";",��ĳ����Ϊ�ոò��ֿ�ʡ�ԣ������ű��룺
    *��һ���ּ��������������ܿ�ӳ������ȡֵ��
    *�ڶ�����ͶӰ�߽磬�ռ�λ�����꼯�ϡ�
    */
    static UCLPropertyBase genShape(String vPart, int helper){
        UCLPropertyBase shape = new UCLPropertyBase();
        shape.setProperty(0x4, helper, vPart);

        return shape;
    }


    /**
    *�������԰����˵�����ԣ��������Ժͺ��������������֣������ķָ�����;���ָ������������";",��ĳ����Ϊ�ոò��ֿ�ʡ�ԣ������ű��룺
    *��һ���ֵ�����ԣ����ݵ�������ܿ�ӳ������ȡֵ��
    *�ڶ������������ԣ��������������ܿ�ӳ������ȡֵ��
    *�������ֺ��������ԣ����ݺ����������ܿ�ӳ������ȡֵ��
    *���Ĳ����״����ԣ������״������ܿ�ӳ������ȡֵ��
    */
    public static UCLPropertyBase genPhysical(String vPart, int helper){
        UCLPropertyBase physical = new UCLPropertyBase();
        physical.setProperty(0x5, helper, vPart);

        return physical;
    }

    //Ŀ�����
    public static UCLPropertyBase genMaterial(String vPart, int helper){
        UCLPropertyBase material = new UCLPropertyBase();
        material.setProperty(0x6, helper, vPart);

        return material;
    }

    //ͨ���̶�
    public static UCLPropertyBase genPassingAbility(String vPart, int helper){
        UCLPropertyBase pass = new UCLPropertyBase();
        pass.setProperty(0x7, helper, vPart);

        return pass;
    }

    //�ռ����̬��(Space Enemy Situation)
    /**
    *�ռ�״����Ϣ�������״����Ϣ�����е���״����Ϣ��ˮ�µ���״����Ϣ�������֣������ķָ�����;���ָ����������";",��ĳ����Ϊ�ոò��ֿ�ʡ�ԣ������ű��룺
    *��һ���ֵ������״����Ϣ��
    *�ڶ����ֿ��е���״����Ϣ��
    *��������ˮ�µ���״����Ϣ��
    */
    public static UCLPropertyBase genSpaceEnemyS(String vPart, int helper){
        UCLPropertyBase spaceStatus = new UCLPropertyBase();
        spaceStatus.setProperty(0x8, helper, vPart);

        return spaceStatus;
    }

    /**
     * �����˶�����
     * Ĭ�Ϲ���Ϊ��m/s, m/s*s
     * �����˶����԰��������ٶȣ����Լ��ٶȣ����й켣�����֣������ķָ�����;���ָ����������";",��ĳ����Ϊ�ոò��ֿ�ʡ�ԣ������ű��룺
     * ��һ���־����ٶ�Ϊ��ֵ��
     * �ڶ����־��Լ��ٶ�Ϊ��ֵ��
     * �����������й켣Ϊ���꼯�ϡ�
     */
    public static UCLPropertyBase genAbsMotionFea(String vPart, int parse, int helper){
        UCLPropertyBase absMontionFea = new UCLPropertyBase();
        absMontionFea.setLPartHead(2, 5, parse);
        absMontionFea.setProperty(11, helper, vPart);

        return absMontionFea;
    }

    /**
     * ����˶�����
     * Ĭ�Ϲ���Ϊ��m/s, m/s*s
     * ����˶����԰��������ٶȣ����Լ��ٶȣ����й켣�����֣������ķָ�����;���ָ����������";",��ĳ����Ϊ�ոò��ֿ�ʡ�ԣ������ű��룺
     * ��һ���־����ٶ�Ϊ��ֵ��
     * �ڶ����־��Լ��ٶ�Ϊ��ֵ��
     * �����������й켣Ϊ���꼯�ϡ�
    */
    public static UCLPropertyBase genRelMotionFea(String vPart, int parse, int helper){
        UCLPropertyBase relMontionFea = new UCLPropertyBase();
        relMontionFea.setLPartHead(2, 5, parse);
        relMontionFea.setProperty(12, helper, vPart);

        return relMontionFea;
    }

    //���й켣, Ĭ�Ͻ�������ΪGPS
    /**
     *
     * @param vPart
     * @param parse
     * 0001��ʾ�����й��������ǵ���ϵͳ��BDS��������ϵ����λ����Ϣ��
     * 0010��ʾ����ȫ��λϵͳ��GPS��������ϵ����λ����Ϣ��
     * Ĭ�Ϲ���ΪGPS
     * @param helper
     * @return
     */
    public static UCLPropertyBase genTravellingPath(String vPart, int parse, int helper){
        UCLPropertyBase travellingPath = new UCLPropertyBase();
        travellingPath.setLPartHead(2, 5, parse);
        travellingPath.setProperty(13, helper, vPart);

        return travellingPath;
    }
}
