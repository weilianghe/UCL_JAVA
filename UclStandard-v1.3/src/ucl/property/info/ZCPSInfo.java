package ucl.property.info;

import ucl.property.base.UCLPropertyBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * ZCPS���ӳ�估��ʾ
 * Created by seu on 2018/3/29.
 */
public class ZCPSInfo {
    public static String DEFAULT_PATTERN = ";";
    //ZCPS�ܿ�ӳ���
    public Map<Integer, String> spaceLocMap = new HashMap<>();
    public Map<Integer, String> timeMap = new HashMap<>();
    public Map<Integer, String> shapeMap = new HashMap<>();
    public Map<Integer, String> phyElectricMap = new HashMap<>();
    public Map<Integer, String> phySoundMap = new HashMap<>();
    public Map<Integer, String> phyNuclearMap = new HashMap<>();
    public Map<Integer, String> phyRadarMap = new HashMap<>();
    public Map<Integer, String> materialMap = new HashMap<>();
    public Map<Integer, String> passAbiMap = new HashMap<>();
    public Map<Integer, String> motionFeaMap = new HashMap<>();

    //��ʼ���ܿ�ӳ���
    public void init(){
        spaceLocMap.put(1,"BDS");
        spaceLocMap.put(2,"GPS");

        timeMap.put(1,"BDS");
        timeMap.put(2,"GPS");

        //���������ܿ�ӳ���
        shapeMap.put(0,"Բ��");
        shapeMap.put(1,"������");
        shapeMap.put(2,"������");
        shapeMap.put(3,"����");
        shapeMap.put(4,"������ͼ��");
        shapeMap.put(5,"��");
        shapeMap.put(6,"������");
        shapeMap.put(7,"������");
        shapeMap.put(8,"Բ����");

        //��������ܿ�ӳ���
        phyElectricMap.put(0,"�����Ų�");
        phyElectricMap.put(1,"�������Ų�");

        //���������ܿ�ӳ���
        phySoundMap.put(0,"��������");
        phySoundMap.put(1,"����������");

        //�����������ܿ�ӳ���
        phyNuclearMap.put(0,"�����˷���");
        phyNuclearMap.put(1,"�������˷���");

        //�״������ܿ�ӳ���
        phyRadarMap.put(0,"�ɱ��״���");
        phyRadarMap.put(1,"���ɱ��״���");

        //�����ܿ�ӳ���
        materialMap.put(0,"��������");
        materialMap.put(1,"���ϲ���");
        materialMap.put(2,"ľ����");
        materialMap.put(3,"ˮ�����");
        materialMap.put(4,"ʯ����");
        materialMap.put(5,"�޻��ǽ�������");
        materialMap.put(6,"�л��߷��Ӳ���");
        materialMap.put(7,"�ϳ��𽺲���");
        materialMap.put(8,"�ϳ���ά");

        //ͨ���̶��ܿ�ӳ���
        passAbiMap.put(0,"����ͨ��");
        passAbiMap.put(1,"��ͨ��");

        motionFeaMap.put(1,"�ٶȵ�λΪ����ÿ�루cm/s�������ٶȵ�λΪ����ÿ��ƽ����cm/s2��");
        motionFeaMap.put(2,"�ٶȵ�λΪ��ÿ�루m/s�������ٶȵ�λΪ��ÿ��ƽ����m/s2��");
        motionFeaMap.put(3,"�ٶȵ�λΪǧ��ÿСʱ��km/h�������ٶȵ�λΪ����ÿ��ƽ����km/h2��");
        motionFeaMap.put(4,"�ٶȵ�λΪӢ��ÿСʱ��mile/h�������ٶȵ�λΪӢ��ÿСʱƽ����mile/h2��");
    }

    public void setPropertyMap(Map<Integer, String> propertySetCategoryMap, Map<Integer, Map<Integer, String>> propertyCategoryMap){

        motionFeaMap.put(2,"�ٶȵ�λΪӢ��ÿСʱ��mile/h�������ٶȵ�λΪӢ��ÿСʱƽ����mile/h2��");

        Map<Integer, String> zcps = new HashMap<Integer, String>();
        materialMap.put(1,"Ŀ���������");
        materialMap.put(2,"�ռ�λ����Ϣ");
        materialMap.put(3,"ʱ����Ϣ");
        materialMap.put(4,"Ŀ������");
        materialMap.put(5,"��������");
        materialMap.put(6,"Ŀ�����");
        materialMap.put(7,"ͨ���̶�");
        materialMap.put(8,"�ռ����̬��");
        materialMap.put(11,"�����˶�����");
        materialMap.put(12,"����˶�����");
        materialMap.put(13,"���й켣");

        propertyCategoryMap.put(2,zcps);
    }

    public String getMapValue(Map<Integer, String> m, int key){
        if (!m.containsKey(key)) {
            return "�޸�ӳ�䣡����";
        }
        return m.get(key);
    }

    public void showProperty(UCLPropertyBase property){
        switch (property.getCategory())
        {
            case 1:
                showName(property);
                break;
            case 2:
                showSpaceLoc(property);
                break;
            case 3:
                showTime(property);
                break;
            case 4:
                showShape(property);
                break;
            case 5:
                showPhysical(property);
                break;
            case 6:
                showMaterial(property);
                break;
            case 7:
                showPassingAbility(property);
                break;
            case 8:
                showSpaceEnemyS(property);
                break;
            case 11:
            case 12:
                showMotionFea(property);
                break;
            case 13:
                showTravellingPath(property);
        }
    }

    public void showName(UCLPropertyBase propertyBase){
        System.out.println("����:"+propertyBase.getVPart());
    }

    public void showSpaceLoc(UCLPropertyBase propertyBase){
        int parse = propertyBase.getLPartHead(2, 5);
        System.out.println("������ϵ����λ�ñ�׼:"+getMapValue(spaceLocMap, parse));
        System.out.println("λ������:"+propertyBase.getVPart());
    }

    public void showTime(UCLPropertyBase propertyBase){
        int parse = propertyBase.getLPartHead(2, 5);
        System.out.println("��ʱ��Ϣ����:"+getMapValue(timeMap, parse));
        System.out.println("ʱ��:"+propertyBase.getVPart());
    }

    public String[] split(String str, String pattern) {
        String[] res = str.split(pattern);
        return res;
    }

    public String[] getShape(String vPart){
        return split(vPart, DEFAULT_PATTERN);
    }

    public void showShape(UCLPropertyBase propertyBase){
        String[] shapes = getShape(propertyBase.getVPart());
        String shape = shapes[0];
        String loc = shapes[1];

        System.out.println("��������:"+shape+", " +getMapValue(shapeMap, Integer.parseInt(shape)));
        System.out.println("ͶӰ�߽�:"+loc);
    }

    public String[] getPhysical(String vPart){
        return split(vPart, DEFAULT_PATTERN);
    }
    public void showPhysical(UCLPropertyBase propertyBase){
        String[] physicals = getPhysical(propertyBase.getVPart());
        String electric = physicals[0];
        String sound = physicals[1];
        String nuclear = physicals[2];
        String radar = physicals[3];

        System.out.println("�������:"+electric+", " +getMapValue(phyElectricMap, Integer.parseInt(electric)));
        System.out.println("��������:"+sound+", " +getMapValue(phySoundMap, Integer.parseInt(sound)));
        System.out.println("����������:"+nuclear+", " +getMapValue(phyNuclearMap, Integer.parseInt(nuclear)));
        System.out.println("�״�����:"+radar+", " +getMapValue(phyRadarMap, Integer.parseInt(radar)));
    }

    public void showMaterial(UCLPropertyBase propertyBase){
        String value = propertyBase.getVPart();
        System.out.println("����:"+value+", " +getMapValue(materialMap, Integer.parseInt(value)));
    }
    public void showPassingAbility(UCLPropertyBase propertyBase){
        String value = propertyBase.getVPart();
        System.out.println("ͨ���̶�:"+value+", " +getMapValue(passAbiMap, Integer.parseInt(value)));
    }
    public void showSpaceEnemyS(UCLPropertyBase propertyBase){
        String[] spaceStatus = getPhysical(propertyBase.getVPart());
        String group = spaceStatus[0];
        String sky = spaceStatus[1];
        String water = spaceStatus[2];

        System.out.println("�������״̬��Ϣ:"+group);
        System.out.println("���е��һ�����Ϣ:"+sky);
        System.out.println("ˮ�µ���״����Ϣ:"+water);
    }
    public void showMotionFea(UCLPropertyBase propertyBase){
        int parse = propertyBase.getLPartHead(2, 5);
        String[] motions = getPhysical(propertyBase.getVPart());

        System.out.println("�˶����Խ�����Ϣ:"+getMapValue(motionFeaMap, parse));
        System.out.println("�ٶ�:"+motions[0]);
        System.out.println("���ٶ�:"+motions[1]);
        System.out.println("�˶��켣:"+motions[2]);
    }
    public void showTravellingPath(UCLPropertyBase propertyBase){
        int parse = propertyBase.getLPartHead(2, 5);

        System.out.println("�˶����Խ�����Ϣ:"+getMapValue(spaceLocMap, parse));
        System.out.println("�˶��켣:"+propertyBase.getVPart());
    }
}
