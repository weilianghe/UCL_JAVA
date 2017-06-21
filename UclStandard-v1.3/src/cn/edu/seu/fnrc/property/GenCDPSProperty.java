package cn.edu.seu.fnrc.property;

/**
 * Created by seu on 2017/6/21.
 */
public class GenCDPSProperty {

    //title
    public static UCLPropertyBase genTitle(String vPart, int helper){
        UCLPropertyBase title=new UCLPropertyBase();
        title.setProperty(0x1, helper, vPart);

        return title;
    }

    /*
    ��һ�ӷ���������ͷ���ֽڣ����� 0 �� 7 λ�������£�
    �� 0 �� 2 λ������������δ���壻
    �� 3 �� 5 λ����ֵ�� 1 ��ʾ���ݹؼ��ʸ�����һ�㲻���� 5 ���� 111 ��ʾ���� 7 ����
    �� 6 �� 7 λ����ֵ�� 1 ��ʾ����ֵ�ӷ�����ռ�ֽ����� 10�� 11 Ϊ�Ƿ�ȡֵ
     */
    //keywords
    public static UCLPropertyBase genKeywords(int count, String vPart, int helper){
        assert(count > 0);
        if (count > 7) count = 8;
        UCLPropertyBase keywords=new UCLPropertyBase();
        keywords.setLPartHead(3, 5, count-1);

        keywords.setProperty(0x2, helper, vPart);
        return keywords;
    }

    //abstract
    public static UCLPropertyBase genAbstract(String vPart, int helper){
        UCLPropertyBase aabstract=new UCLPropertyBase();
        aabstract.setProperty(0x3, helper, vPart);
        return aabstract;
    }
    /*
    ��һ�ӷ���������ͷ���ֽڣ����� 0 �� 7 λ�������£�
    �� 0 �� 2 λ����ֵ��ʾ���������� 111 ��ʾ���� 6 ����
    �� 3 �� 5 λ����ֵ��ʾ���ߵ�λ������ 111 ��ʾ���� 6 ����
    �� 6 �� 7 λ����ֵ�� 1 ��ʾ����ֵ�ӷ�����ռ�ֽ����� 10�� 11 Ϊ�Ƿ�ȡֵ��
     */

    //author
    public static UCLPropertyBase genAuthor(int persons, int companies, String vPart, int helper){
        assert(persons>=0 && companies>=0);
        persons = persons>7?7:persons;
        companies = companies>7?7:companies;

        UCLPropertyBase author=new UCLPropertyBase();
        author.setLPartHead(0, 2, persons);
        author.setLPartHead(3, 5, companies);

        author.setProperty(0x4, helper, vPart);
        return author;
    }

    /*
    ��һ�ӷ���������ͷ���ֽڣ����� 0 �� 7 λ�������£�
    �� 0 �� 5 λ����ʾ������Ϣ������ָʾ�����������Щ����ʵ�壬
    �����еĵ� X λ��0 �� X �� 5��ȡ 1����ʾ����������Ϊ X ������ʵ�壻
    �����еĵ� X λ��0 �� X �� 5��ȡ 0����ʾ����������Ϊ X ������ʵ�塣
    �� 6 �� 7 λ����ֵ�� 1 ��ʾ����ֵ�ӷ�����ռ�ֽ����� 10�� 11 Ϊ�Ƿ�ȡֵ��
     */
    //entity
    public static UCLPropertyBase genEntity(int quickMatch, String vPart, int helper){
        assert(quickMatch >= 0 && quickMatch <= 63);

        UCLPropertyBase entity=new UCLPropertyBase();
        entity.setLPartHead(0, 5, quickMatch);
        entity.setProperty(0x5, helper, vPart);

        return entity;
    }

    /*
    ��һ�ӷ���������ͷ���ֽڣ����� 0 �� 7 λ�������£�
    �� 0 �� 2 λ������������δ���壻
    �� 3 �� 5 λ����ֵ�� 1 ��ʾ���ݱ�ǵĸ�����һ�㲻���� 5 ���� 111 ��ʾ���� 7 ����
    �� 6 �� 7 λ����ֵ�� 1 ��ʾ����ֵ�ӷ�����ռ�ֽ����� 10�� 11 Ϊ�Ƿ�ȡֵ��
     */
    //Tag
    public static UCLPropertyBase genTag(int count, String vPart, int helper){
        assert(count >=1);
        if (count > 7) count = 8;

        UCLPropertyBase tag=new UCLPropertyBase();
        tag.setLPartHead(3, 5, count - 1);
        tag.setProperty(6, helper, vPart);

        return tag;
    }

    //copyright
    public static UCLPropertyBase genCopyright(String vPart, int helper){
        UCLPropertyBase copyright=new UCLPropertyBase();
        copyright.setProperty(7, helper, vPart);

        return copyright;
    }

    //originality
    public static UCLPropertyBase genOriginality(String vPart, int helper){
        UCLPropertyBase originality=new UCLPropertyBase();
        originality.setProperty(8, helper, vPart);

        return originality;
    }

    //file description
    public static UCLPropertyBase genFileDescription(String vPart, int helper){
        UCLPropertyBase file=new UCLPropertyBase();
        file.setProperty(9, helper, vPart);

        return file;
    }


    /*
    ��һ�ӷ���������ͷ���ֽڣ����� 0 �� 7 λ�������£�
    �� 0 �� 2 λ������������δ���� ��
    �� 3 �� 5 λ����ֵ�� 1 ��ʾ UCL  �ĸ����� 111 ��ʾ���� 7 ����
    �� 6 �� 7 λ����ֵ�� 1 ��ʾ����ֵ�ӷ�����ռ�ֽ����� 10�� 11 Ϊ�Ƿ�ȡֵ��
     */
    //Related UCL
    public static UCLPropertyBase genRelatedUCL(int count, String vPart, int helper){
        assert(count >=1);
        if (count > 7) count = 8;

        UCLPropertyBase relatedUCL=new UCLPropertyBase();
        relatedUCL.setLPartHead(3, 5, count - 1);
        relatedUCL.setProperty(14, helper, vPart);
        return relatedUCL;
    }

    //Content Object
    public static UCLPropertyBase genContObject(String vPart, int helper){
        UCLPropertyBase contentObject=new UCLPropertyBase();
        contentObject.setProperty(15, helper, vPart);

        return contentObject;
    }

}
