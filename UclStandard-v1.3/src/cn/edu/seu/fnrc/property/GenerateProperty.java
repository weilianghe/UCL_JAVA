package cn.edu.seu.fnrc.property;

import cn.edu.seu.fnrc.UCLPackage;

public class GenerateProperty {
	/**
	* <p>GenerateProperty�������ɱ�׼UCL��������Ժͱ�ѡ���Լ��ϣ��Զ������Ի����Լ��Ͽɲο������Զ���ʵ��</p>
	* <p>Copyright 2017: Future network research center, Southeast University</p>
	* Note:Implement the class according to the Head of ALL UCL Properties
	* @author zhangcs
	* @version 1.3
	* @since 2017-4-24
	*/
	
	
	public static void setProperty(UCLPropertyBase property, int category, int helper, String vPart){
	    assert(helper < 16);
	    property.setCategory(category);
	    property.setHelper(helper);
	    property.setVPart(vPart);
	}
	
    /**
     * SNPS, PhysicalElements, Receiver, the set had been deleted
     */
    //PhysicalElements
	public static UCLPropertyBase generateSNPSPE(int quickMatcher, String vPart, int helper){
	    UCLPropertyBase pe=new UCLPropertyBase();
	    
	    assert(quickMatcher<=0x3f);
	    
	    pe.setLPartHead(0, 5, quickMatcher);

	    setProperty(pe, 0x1, helper, vPart);
	    
	    return pe;
	}
    
    //Nominated Receiver
	public static UCLPropertyBase generateSNPSNR(String vPart, int helper){
	    UCLPropertyBase nr =new UCLPropertyBase();
	    setProperty(nr, 0x2, helper, vPart);
	    return nr;
	}

    /*
     * CDPS, title, keywords, abstract, author, entity, Tag, copyright,  originality, file Description
     */
    //title
	public static UCLPropertyBase generateCDPSTitle(String vPart, int helper){
	    UCLPropertyBase title=new UCLPropertyBase();
	    setProperty(title, 0x1, helper, vPart);

	    return title;
	}

	/*
	��һ�ӷ���������ͷ���ֽڣ����� 0 �� 7 λ�������£�
	�� 0 �� 2 λ������������δ���壻
	�� 3 �� 5 λ����ֵ�� 1 ��ʾ���ݹؼ��ʸ�����һ�㲻���� 5 ���� 111 ��ʾ���� 7 ����
	�� 6 �� 7 λ����ֵ�� 1 ��ʾ����ֵ�ӷ�����ռ�ֽ����� 10�� 11 Ϊ�Ƿ�ȡֵ
	 */
	
    //keywords
	public static UCLPropertyBase generateCDPSKeywords(int count, String vPart, int helper){
	    assert(count > 0);
	    if (count > 7) count = 8;
	    UCLPropertyBase keywords=new UCLPropertyBase();
	    keywords.setLPartHead(3, 5, count-1);

	    setProperty(keywords, 0x2, helper, vPart);
	    return keywords;
	}

    //abstract
	public static UCLPropertyBase generateCDPSAbstract(String vPart, int helper){
		UCLPropertyBase aabstract=new UCLPropertyBase();
	    setProperty(aabstract, 0x3, helper, vPart);

	    return aabstract;
	}

	/*
	��һ�ӷ���������ͷ���ֽڣ����� 0 �� 7 λ�������£�
	�� 0 �� 2 λ����ֵ��ʾ���������� 111 ��ʾ���� 6 ����
	�� 3 �� 5 λ����ֵ��ʾ���ߵ�λ������ 111 ��ʾ���� 6 ����
	�� 6 �� 7 λ����ֵ�� 1 ��ʾ����ֵ�ӷ�����ռ�ֽ����� 10�� 11 Ϊ�Ƿ�ȡֵ��
	 */
	
    //author
	public static UCLPropertyBase generateCDPSAuthor(int persons, int companies, String vPart, int helper){
	    assert(persons>=0 && companies>=0);
	    persons = persons>7?7:persons;
	    companies = companies>7?7:companies;

	    UCLPropertyBase author=new UCLPropertyBase();
	    author.setLPartHead(0, 2, persons);
	    author.setLPartHead(3, 5, companies);

	    setProperty(author, 0x4, helper, vPart);
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
	public static UCLPropertyBase generateCDPSEntity(int quickMatch, String vPart, int helper){
	    assert(quickMatch >= 0 && quickMatch <= 63);

	    UCLPropertyBase entity=new UCLPropertyBase();
	    entity.setLPartHead(0, 5, quickMatch);
	    setProperty(entity, 0x5, helper, vPart);

	    return entity;
	}

	/*
	��һ�ӷ���������ͷ���ֽڣ����� 0 �� 7 λ�������£�
	�� 0 �� 2 λ������������δ���壻
	�� 3 �� 5 λ����ֵ�� 1 ��ʾ���ݱ�ǵĸ�����һ�㲻���� 5 ���� 111 ��ʾ���� 7 ����
	�� 6 �� 7 λ����ֵ�� 1 ��ʾ����ֵ�ӷ�����ռ�ֽ����� 10�� 11 Ϊ�Ƿ�ȡֵ��
	 */
	
    //Tag
	public static UCLPropertyBase generateCDPSTag(int count, String vPart, int helper){
	    assert(count >=1);
	    if (count > 7) count = 8;

	    UCLPropertyBase tag=new UCLPropertyBase();
	    tag.setLPartHead(3, 5, count - 1);
	    setProperty(tag, 6, helper, vPart);

	    return tag;
	}

    //copyright
	public static UCLPropertyBase generateCDPSCopyright(String vPart, int helper){
	    UCLPropertyBase copyright=new UCLPropertyBase();
	    setProperty(copyright, 7, helper, vPart);

	    return copyright;
	}

    //originality
	public static UCLPropertyBase generateCDPSOriginality(String vPart, int helper){
	    UCLPropertyBase originality=new UCLPropertyBase();
	    setProperty(originality, 8, helper, vPart);

	    return originality;
	}

    //file description
	public static UCLPropertyBase generateCDPSFileDescription(String vPart, int helper){
	    UCLPropertyBase file=new UCLPropertyBase();
	    setProperty(file, 9, helper, vPart);

	    return file;
	}

	/*
	��һ�ӷ���������ͷ���ֽڣ����� 0 �� 7 λ�������£�
	�� 0 �� 2 λ������������δ���壻
	�� 3 �� 5 λ����ֵ�� 1 ��ʾ UCL �ĸ����� 111 ��ʾ���� 7 ����
	�� 6 �� 7 λ����ֵ�� 1 ��ʾ����ֵ�ӷ�����ռ�ֽ����� 10�� 11 Ϊ�Ƿ�ȡֵ��
	 */
	
    //Related UCL
	public static UCLPropertyBase generateCDPSRelatedUCL(int count, String vPart, int helper){
	    assert(count >=1);
	    if (count > 7) count = 8;

	    UCLPropertyBase relatedUCL=new UCLPropertyBase();
	    relatedUCL.setLPartHead(3, 5, count - 1);
	    setProperty(relatedUCL, 14, helper, vPart);

	    return relatedUCL;
	}

    //Content Object
	public static UCLPropertyBase generateCDPSContentObject(String vPart, int helper){
	    UCLPropertyBase contentObject=new UCLPropertyBase();
	    setProperty(contentObject, 15, helper, vPart);

	    return contentObject;
	}

    /*
     * CGPS, provenance, content id, propagation path, signature of content, security energy level information,
     *       chain of responibility, signature of UCL Package
     */
    //provenance
	public static UCLPropertyBase generateCGPSProvenance(int des, String vPart, int helper){
	    assert(des < 8);
	    UCLPropertyBase provenance=new UCLPropertyBase();
	    provenance.setLPartHead(3, 5, des);
	    setProperty(provenance, 0x3, helper, vPart);

	    return  provenance;
	}

    //content id
	public static UCLPropertyBase generateCGPSContentid(String vPart, int helper){
	    UCLPropertyBase contentid=new UCLPropertyBase();
	    setProperty(contentid, 0x4, helper, vPart);

	    return contentid;
	}

    //propagation path
	public static UCLPropertyBase generateCGPSPropagation(int count, String vPart, int helper){
	    assert(count > 0);
	    if (count > 15) count = 16;

	    UCLPropertyBase propagation=new UCLPropertyBase();
	    propagation.setLPartHead(2, 5, count-1);

	    setProperty(propagation, 5, helper, vPart);

	    return propagation;
	}

    //signature of content
	public static UCLPropertyBase generateCGPSSignatureContent(String content, int alg, int helper){
	    assert(helper <= 5);
	    assert(alg < 5);

	    UCLPropertyBase signature=new UCLPropertyBase();
	    signature.setLPartHead(2, 5, alg);

	    String hashContent = UCLPackage.generateSigUCLP(helper, alg, content);
	    setProperty(signature, 12, helper, hashContent);

	    return signature;
	}

    //security
	public static UCLPropertyBase generateCGPSSecurity(String vPart, int helper){
	    assert(helper == 0 || helper == 1 || helper == 2 || helper == 14);

	    UCLPropertyBase security=new UCLPropertyBase();
	    setProperty(security, 13, helper, vPart);

	    return security;
	}
	
    //chain of responsibility
	public static UCLPropertyBase generateCGPSChain(int count, String vPart, int helper)
	{
	    assert(count >=1);
	    if (count > 15) count = 16;

	    UCLPropertyBase chain=new UCLPropertyBase();
	    chain.setLPartHead(2, 5, count-1);
	    setProperty(chain, 14, helper, vPart);

	    return chain;
	}

    //signature of UCL package
	public static UCLPropertyBase generateCGPSSignatureUCL(int alg, int helper)
	{
	    assert(helper <= 5);
	    assert(alg < 5);

	    UCLPropertyBase signature=new UCLPropertyBase();
	    signature.setLPartHead(2, 5, alg);
	    setProperty(signature, 15, helper, "");

	    return signature;
	}

    //���ɱ�ѡ����
    //static UCLPropertySet generateCDPS(String title);
    //static UCLPropertySet generateCGPS(CGPSRequired required);
	
	
}
