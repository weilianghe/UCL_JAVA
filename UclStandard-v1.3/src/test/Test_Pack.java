package test;

import ucl.UCLPackage;
import ucl.code.UCLCode;
import ucl.code.UCLCodeExtention;
import ucl.property.generate.GenCDPSProperty;
import ucl.property.generate.GenCGPSProperty;
import ucl.property.base.UCLPropertyBase;
import ucl.property.base.UCLPropertySet;

public class Test_Pack {

	public static void printPackString(String pack){
		char[] packArr = pack.toCharArray();
		for(int i=0; i <packArr.length; i++) {
			char cur=packArr[i];

			System.out.print(Integer.toHexString((byte)cur&0xFF));
			System.out.print(":");
		}
		System.out.println();
	}
	public static boolean checkSame(String pack1,String pack2){
		char[] packArr1 = pack1.toCharArray();
		char[] packArr2 = pack2.toCharArray();
		for(int i=0; i <packArr1.length; i++) {
			char cur1=packArr1[i];
			char cur2=packArr2[i];
			if(cur1!=cur2){
				return false;
			}
		}
		return true;
	}

	public static void testUCL() {
		System.out.println("\n========== ucl test begin==========\n");
		UCLPackage ucl=new UCLPackage();

		//code
		UCLCode code=new UCLCode();
		Test_Code testclass=new Test_Code();
		testclass.set_codezc(code);
		testclass.test_codezc();
		UCLCodeExtention extention=new UCLCodeExtention();

		ucl.setUclCode(code);
		ucl.setUclCodeExtention(extention);

		//propsets

		System.out.println("\n##############��������##############\n\n");
		UCLPropertySet cdps = new UCLPropertySet();

		cdps.setHeadCategory(1);
		UCLPropertyBase title = GenCDPSProperty.genTitle("���ս�����ʵʩ��12311���ƻ� �����ٸ�ũҵ��ɫ��",2);
		UCLPropertyBase keywords = GenCDPSProperty.genKeywords(3, "����;���;����",2);
		UCLPropertyBase aabstract = GenCDPSProperty.genAbstract("ʡũί��ǰ�ڽ�̳�ٿ�ȫʡ��������ũҵ�����ƽ��ᣬ�����ӽ�����ʵʩ��12311����������ũҵʡ����ɫƷ�������ƻ�",2);
		UCLPropertyBase author = GenCDPSProperty.genAuthor(3, 2, "�޽���:�»��ձ�\\r����;����:����",2);
		UCLPropertyBase entity = GenCDPSProperty.genEntity(31, "����ʡί\\r2017\\r��̳\\r�����ƻ�\\r����;nice",2);
		UCLPropertyBase tag = GenCDPSProperty.genTag(2, "����;���" ,2);
		UCLPropertyBase copyright = GenCDPSProperty.genCopyright("�»��ձ�",2);
		UCLPropertyBase origin = GenCDPSProperty.genOriginality("�彨��",2);
		UCLPropertyBase file = GenCDPSProperty.genFileDescription("�ı�;10M",2);
		UCLPropertyBase content = GenCDPSProperty.genContObject("���ս�����ʵʩ��12311���ƻ�, ȫʡ��������ũҵ�����ƽ���",2);
		cdps.setProperty(title);
		cdps.setProperty(keywords);
		cdps.setProperty(aabstract);
		cdps.setProperty(author);
		cdps.setProperty(entity);
		cdps.setProperty(tag);
		cdps.setProperty(copyright);
		cdps.setProperty(origin);
		cdps.setProperty(file);
		cdps.setProperty(content);

		ucl.setPropertySet(cdps);


		UCLPropertySet cgps=new UCLPropertySet();
		cgps.setHeadCategory(15);
		UCLPropertyBase pro = GenCGPSProperty.genProvenance(1, "http://jiangsu.sina.com.cn/news/b/2017-05-31/detail-ifyfqqyh9080015.shtml",2);
		cgps.setProperty(pro);
		UCLPropertyBase contentid = GenCGPSProperty.genContId("sina",2);
		cgps.setProperty(contentid);
		UCLPropertyBase prog = GenCGPSProperty.genPropagation(2, "baidu;sina",2);
		cgps.setProperty(prog);
		UCLPropertyBase sigCon = GenCGPSProperty.genContSig("���ս�����ʵʩ��12311���ƻ�, ȫʡ��������ũҵ�����ƽ���", 2, 1);
		cgps.setProperty(sigCon);
		UCLPropertyBase security = GenCGPSProperty.genSecEL("��Ҫ",2);
		cgps.setProperty(security);
		UCLPropertyBase chain = GenCGPSProperty.genChainOfRes(2, "sian;seu",2);
		cgps.setProperty(chain);
		UCLPropertyBase sigUCL = GenCGPSProperty.genUCLSig(3, 1);
		cgps.setProperty(sigUCL);

		ucl.setPropertySet(cgps);


		/**
		 * ���Թ���UCL
		 */

		String rstr = "";

		UCLCode rCode = code;
		rCode.setFlag((byte)0);
		rstr += rCode.packcode();

		UCLPackage rUCL = generateRUCL();
		rstr += rUCL.pack();

		UCLPropertyBase related = GenCDPSProperty.genRelatedUCL(2, rstr, 1);
		ucl.setProperty(1, related);



		System.out.println("--------------propertySet--------------\n");
		printPackString(ucl.packPropertySets());

		System.out.println("\n##############���Դ��##############\n\n");
		System.out.println("--------------UCLPackage-------------- \n");
		int ccur=ucl.getPropertySets().get(1).getHeadCategory();
		String cur=ucl.pack();
		printPackString(ucl.pack());
		System.out.println("--------------��ʾUCL�����ֹؼ���Ϣ--------------\n");
		ucl.getUclCode().showCodezc();
		ucl.showUCL();

		String ucl1 = ucl.pack();


		System.out.println("\n##############���Խ��##############\n\n");
		UCLPackage ucl2=new UCLPackage();
		ucl2.unpack(ucl1);
		System.out.println("--------------UCLPackage--------------\n");
		printPackString(ucl2.pack());

		boolean b=checkSame(ucl.pack(),ucl2.pack());

		System.out.println("--------------�����UCL�����ֹؼ���Ϣ--------------\n");
		ucl2.getUclCode().showCodezc();
		ucl2.showUCL();

		System.out.println("========== ucl test end==========\n");
	}

	public static UCLPackage generateRUCL() {//���ΰ��ͬѧ����C++����뽫�˴�CODE���ִ����޸�һ��
		UCLPackage ucl=new UCLPackage();

		UCLCode code_test=new UCLCode();
		
		//setUclCode(code_test);
		Test_Code testclass=new Test_Code();
		testclass.set_codezc(code_test);

		code_test.setTypeOfMedia((byte)9);
		code_test.setPriority((byte) 15);
		code_test.setFlag((byte)2); //00000010

		code_test.setVersion((byte)3);//�����Ѿ����ù������ظ�����

		ucl.setUclCode(code_test);

		UCLPropertySet cdps=new UCLPropertySet();
		cdps.setHeadCategory(1);
		UCLPropertyBase title = GenCDPSProperty.genTitle("���ս�����ʵʩ��12311���ƻ� �����ٸ�ũҵ��ɫ��",2);
		cdps.setProperty(title);

		ucl.setPropertySet(cdps);

		UCLPropertySet cgps=new UCLPropertySet();
		cgps.setHeadCategory(15);
		UCLPropertyBase pro = GenCGPSProperty.genProvenance(1, "http://jiangsu.sina.com.cn/news/b/2017-05-31/detail-ifyfqqyh9080015.shtml",2);
		cgps.setProperty(pro);
		UCLPropertyBase chain = GenCGPSProperty.genChainOfRes(2, "sian;seu",2);
		cgps.setProperty(chain);
		UCLPropertyBase sigUCL = GenCGPSProperty.genUCLSig(1, 1);
		cgps.setProperty(sigUCL);

		ucl.setPropertySet(cgps);

		UCLPropertySet personal = generatePersonalPropertySet();
		ucl.setPropertySet(personal);

		return ucl;
	}

	public static UCLPropertySet generatePersonalPropertySet() {
		UCLPropertySet personal=new UCLPropertySet();
		personal.setHeadCategory(10);

		UCLPropertyBase name=new UCLPropertyBase();
		name.setProperty(1, 1, "����");
		personal.setProperty(name);

		UCLPropertyBase school=new UCLPropertyBase();
		school.setProperty(2, 1, "SEU");
		personal.setProperty(school);

		return personal;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//�������Բ��ִ�����
		testUCL();
		//testUCLPack();
	}
}
