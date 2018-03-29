package ucl.property.info;

import ucl.UCLPackage;
import ucl.code.UCLCode;
import ucl.property.base.UCLPropertyBase;

import java.util.HashMap;
import java.util.Map;

import static test.Test_Pack.printPackString;

/**
 * Created by seu on 2017/6/14.
 */
public class UCLPropertiesInfo {
    public Map<Integer, String> propertyHeadMap = new HashMap<>();
    public Map<Integer, String> propertySetCategoryMap = new HashMap<>();
    public Map<Integer, Map<Integer, String>> propertyCategoryMap = new HashMap<>();

    public Map<Integer, String> entity = new HashMap<>();
    public Map<Integer, String> promap = new HashMap<>(); //provenance
    public Map<Integer, String> contentIdRulemap = new HashMap<>();
    public Map<Integer, String> seliMap = new HashMap<>();

    public Map<Integer, String> signatureMap = new HashMap<>();
    public Map<Integer, String> hash = new HashMap<>();


    public UCLPropertiesInfo() {
        initPropertyHeadMap();
        initPropertySetCategoryMap();
        initPropertyCategroyMap();

        initInfo();
    }

    public String[] split(String str, String pattern) {
        String[] res = str.split(pattern);
        return res;
    }

    public void initPropertyHeadMap() {
        propertyHeadMap.put(0,"����");
        propertyHeadMap.put(1,"����");
        propertyHeadMap.put(2,"Ӣ��");
        propertyHeadMap.put(3,"����");
        propertyHeadMap.put(4,"����");
        propertyHeadMap.put(5,"��������");
        propertyHeadMap.put(6,"��������");
        propertyHeadMap.put(7,"��������");
        propertyHeadMap.put(8,"����");
        propertyHeadMap.put(9,"����");
        // 10-14��δ����
        propertyHeadMap.put(15,"��������");
    }

    public String getPropertyLangType(int type) {
        if (!propertyHeadMap.containsKey(type)){
            return "�Զ�������";
        } else{
            return propertyHeadMap.get(type);
        }
    }

    public void initPropertySetCategoryMap() {
        // 0�����Լ��ϱ�����2��14���Լ���δ����
        propertySetCategoryMap.put(1,"�����������Լ���");
        propertySetCategoryMap.put(15,"���ݹ������Լ���");
    }

    public String getPropertySetCategory(int type) {
        if (!propertySetCategoryMap.containsKey(type))
            return "�Զ��弯��";
        else
            return propertySetCategoryMap.get(type);
    }

    public void initPropertyCategroyMap(){
        Map<Integer, String> cdps = new HashMap<>();
        cdps.put(1,"���ݱ���") ;
        cdps.put(2,"���ݹؼ���") ;
        cdps.put(3,"����ժҪ") ;
        cdps.put(4,"��������") ;
        cdps.put(5,"����ʵ��") ;
        cdps.put(6,"���ݱ��") ;
        cdps.put(7,"��Ȩ��Ϣ") ;
        cdps.put(8,"ԭ������") ;
        cdps.put(9,"�ļ���Ϣ") ;
        cdps.put(14,"����UCL") ;
        cdps.put(15,"���ݶ���") ;

        propertyCategoryMap.put(1,cdps) ;

        Map<Integer, String> cgps = new HashMap<>();
        cgps.put(3,"���ݳ���") ;
        cgps.put(4,"����ID") ;
        cgps.put(5,"����·��") ;
        cgps.put(12,"��������ǩ��") ;
        cgps.put(13,"��ȫ�ܼ���Ϣ") ;
        cgps.put(14,"����������") ;
        cgps.put(15,"ȫUCL������ǩ��") ;

        propertyCategoryMap.put(15,cgps);
    }

    public String getPropertyCategroy(int categroy, int proCategory) {
        return propertyCategoryMap.get(categroy).get(proCategory);
    }


    public void initInfo() {
        entity.put(0,"��");
        entity.put(1,"ʱ");
        entity.put(2,"��");
        entity.put(3,"��");
        entity.put(4,"��");
        entity.put(5,"����");

        promap.put(1,"��ַ������");
        promap.put(2,"������");
        promap.put(3,"Ӧ�����");


        contentIdRulemap.put(1,"URI");
        contentIdRulemap.put(2,"DOI");
        contentIdRulemap.put(3,"ISBN");
        contentIdRulemap.put(4,"ISRC");


        seliMap.put(0,"���б궨");
        seliMap.put(1,"��һ�������ṩ����֤");
        seliMap.put(2,"�ڶ��������ṩ����֤");
        seliMap.put(14,"Ȩ������������֤");


        signatureMap.put(0,"δ�����ݶ����������ǩ��");
        signatureMap.put(1,"RSA");
        signatureMap.put(2,"ECDSA");
        signatureMap.put(3,"DSA");
        signatureMap.put(4,"ECC");
        signatureMap.put(5,"HMAC");


        hash.put(1,"CRC32");
        hash.put(2,"MD5");
        hash.put(3,"SHA-256");
        hash.put(4,"SHA-512");
    }

    public void showProperty(int category, UCLPropertyBase propertyBase){
        if (category == 1) {
            switch (propertyBase.getCategory()) {
                case 1:
                case 3:
                case 7:
                case 8:
                case 15:
                    showPropertyBase(propertyBase);
                    break;
                case 2:
                    showCDPSKeywords(propertyBase);
                    break;
                case 4:
                    showCDPSAuthor(propertyBase);
                    break;
                case 5:
                    showCDPSEntity(propertyBase);
                    break;
                case 6:
                    showCDPSTag(propertyBase);
                    break;
                case 9:
                    showCDPSFileInfo(propertyBase);
                    break;
                case 14:
                    showCDPSRelatedUCL(propertyBase);
                    break;
                default:
                    System.out.println("****�Զ�������****");
            }
        }
        if (category == 15) {
            switch (propertyBase.getCategory()) {
                case 3:
                    showCGPSProvenance(propertyBase);
                    break;
                case 4:
                    showCGPSContentId(propertyBase);
                    break;
                case 5:
                    showCGPSPropagationPath(propertyBase);
                    break;
                case 12:
                    showCGPSSignatureContent(propertyBase);
                    break;
                case 13:
                    showCGPSSELI(propertyBase);
                    break;
                case 14:
                    showCGPSChainRespons(propertyBase);
                    break;
                case 15:
                    showCGPSSignatureUP(propertyBase);
                    break;
                default:
                    System.out.println("****�Զ�������****");
            }
        }
    }

    /*
     * ������
     * CDPS:
     * 1 Title
     * 3 Abstract
     * 7 CopyRight
     * 8 Originality
     * 15 content object
     */
    void showPropertyBase(UCLPropertyBase propertyBase){
        System.out.println("����ֵ: "+propertyBase.getVPart());
    }

    //CDPS, Keywords
    void showCDPSKeywords(UCLPropertyBase keywords){
        int count = keywords.getLPartHead(3, 5) + 1;
        if (count <=7){
            System.out.println("�ؼ�������: "+count);
        }
        else{
            System.out.println("�ؼ�����������7��");
        }

        System.out.print("�ؼ���: ");

        String[] keys = split(keywords.getVPart(), ";");

        System.out.println(String.join(" ", keys));

    }

    //CDPS, author
    void showCDPSAuthor(UCLPropertyBase author){
        int authorCount = author.getLPartHead(0, 2);
        int comCount = author.getLPartHead(3, 5);
        if (authorCount < 7) {
            System.out.print("��������: "+authorCount);
        }
        else {
            System.out.print("������������6��   ");
        }

        if (comCount < 7) {
            System.out.println("��˾����: "+comCount);
        }
        else {
            System.out.println("��˾���������߸�");
        }

        System.out.println("���� ----- ��˾");
        String[] res = split(author.getVPart(), "\\\\r");

        for(String tmp:res) {
            String[] tr = split(tmp, ":");
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < tr.length; j++) {
                String[] ac = split(tr[j], ";");
                sb.append(String.join(" ",ac));
                if (j != tr.length - 1)
                    sb.append(" ----- ");
            }
            System.out.println(sb.toString());
        }
    }


    //CDPS, entity
    public void showCDPSEntity(UCLPropertyBase ent){

        String[] ev = split(ent.getVPart(), "\\\\r");

        for (int i = 0; i < ev.length; i++) {
            StringBuilder sb=new StringBuilder();
            sb.append(entity.get(i)+" : ");
            String[] evt = split(ev[i], ";");
            sb.append(String.join(" ",evt));
            System.out.println(sb.toString());
        }
    }

    //CDPS, tag
    public void showCDPSTag(UCLPropertyBase tag){
        int count = tag.getLPartHead(3, 5) + 1;
        if (count <=7) {
            System.out.println("�������: "+count);
        }
        else {
            System.out.println("�����������7��");
        }

        System.out.print("���ݱ��: ");
        String[] keys = split(tag.getVPart(), ";");

        System.out.println(String.join(" ", keys));
    }

    //CDPS, fileInfo
    public void showCDPSFileInfo(UCLPropertyBase fileInfo){
        String[] files = split(fileInfo.getVPart(), ";");

        System.out.print("�ļ���Ϣ: ");
        System.out.println(String.join(" ", files));
    }

    //CDPS, relatedUCL
    public void showCDPSRelatedUCL(UCLPropertyBase relatedUCL){
        int count = relatedUCL.getLPartHead(3, 5) + 1;
        if (count <=7) {
            System.out.println("����UCL����: "+count);
        }
        else {
            System.out.println("����UCL��������7��");
        }

        System.out.println("--------------------------����UCL��ʼ-----------------------------");

        //��δ����Code��չ
        String rus = relatedUCL.getVPart();
        char[] rusArr=rus.toCharArray();
        int pos = 0;
        while (pos < rus.length()) {
            String code = rus.substring(pos, pos+32);
            pos += 32;
            UCLCode uc=new UCLCode();
            uc.unpackcode(code);
            if ((uc.getFlag() & 0x2) == 0) {
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                uc.showCode();
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            }
            else {
                int lh = rusArr[pos + 1];
                int propertyLenBytes = ((lh >> 6) & 0x3) + 1;
                String lValue = rus.substring(pos + 2, pos+2+propertyLenBytes);
                char[] lValueArr=lValue.toCharArray();
                int len = 0;
                switch (propertyLenBytes)
                {
                    case 1:
                        len = (0xff & lValueArr[0]);
                        break;
                    case 2:
                        len = (0xff & lValueArr[0]) +(0xff00 & (lValueArr[1] << 8));
                        break;
                    case 3:
                        len = (0xff & lValueArr[0]) +(0xff00 & (lValueArr[1] << 8)) +
                                (0xff0000 & (lValueArr[2] << 16));
                        break;
                    case 4:
                        len = (0xff & lValueArr[0]) +(0xff00 & (lValueArr[1] << 8)) +
                                (0xff0000 & (lValueArr[2] << 16)) + (0xff000000 & (lValueArr[3] << 24));
                        break;
                }
                String ucls = code + rus.substring(pos, pos+len);
                UCLPackage ucl=new UCLPackage();
                ucl.unpack(ucls);
                printPackString(ucl.pack());
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                ucl.showUCL();
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                pos += len;
            }
        }

        System.out.println("--------------------------����UCL����-----------------------------");
    }

    //CGPS, provenance
    public void showCGPSProvenance(UCLPropertyBase provenance){
        System.out.println("���ݳ���������ʽ:  "+promap.get((int)provenance.getLPartHead(3, 5)));
        System.out.println("���ݳ���:  "+provenance.getVPart() );
    }

    //CGPS, content id
    public void showCGPSContentId(UCLPropertyBase content){
        System.out.println("����ID��������:  "+contentIdRulemap.get(content.getHelper()));
        System.out.println("��ϸ����ID��Ϣ:  "+content.getVPart() );
    }

    //CGPS, Propagation path
    public void showCGPSPropagationPath(UCLPropertyBase propagationPath){
        int count = propagationPath.getLPartHead(2, 5) + 1;
        if (count <=15) {
            System.out.println("����·������: "+count);
        }
        else{
            System.out.println("����·�����ȳ���15 ");
        }

        System.out.print("����·��: ");
        String[] keys = split(propagationPath.getVPart(), ";");

        System.out.println(String.join(" ", keys));
    }

    //CGPS, Signature of Content
    public void showCGPSSignatureContent(UCLPropertyBase sigContent){
        System.out.println("����ժҪ�㷨:  "+hash.get((int)sigContent.getLPartHead(2, 5)));
        System.out.println("����ǩ���㷨:  "+signatureMap.get(sigContent.getHelper()));
        System.out.println("ժҪ��ǩ����Ϣ:  "+sigContent.getVPart());
    }

    //CGPS, Security Energy Level Information
    void showCGPSSELI(UCLPropertyBase seli){
        System.out.println("��ȫ�ܼ���Ϣ����֤�ȼ�:  "+seliMap.get(seli.getHelper()));
        System.out.println("��ȫ�ܼ���ϸ��Ϣ:  "+seli.getVPart());
    }

    //CGPS, Chain of Responsibility
    void showCGPSChainRespons(UCLPropertyBase cr){
        int count = cr.getLPartHead(2, 5) + 1;
        if (count <= 15) {
            System.out.println("������������: "+count);
        }
        else {
            System.out.println("����������������15�� ");
        }


        System.out.print("����������ϸ��Ϣ: ");
        String[] keys = split(cr.getVPart(), ";");

        System.out.println(String.join(" ", keys));
    }

    //CGPS, Signature of ucl Package
    void showCGPSSignatureUP(UCLPropertyBase sup){
        System.out.println("����ժҪ�㷨:  "+hash.get((int)sup.getLPartHead(2, 5)));
        System.out.println("����ǩ���㷨:  "+signatureMap.get(sup.getHelper()));
        System.out.println("ժҪ��ǩ����Ϣ:  "+sup.getVPart());
    }
}