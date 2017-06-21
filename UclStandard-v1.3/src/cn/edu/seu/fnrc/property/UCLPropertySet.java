package cn.edu.seu.fnrc.property;

import cn.edu.seu.fnrc.UCLPackage;

import java.util.HashMap;
import java.util.Map;

public class UCLPropertySet {
	/**
	* <p>Class description: UCLPropertySet,UCL PropertySet base class</p>
	* <p>Copyright 2016: Future network research center, Southeast University</p>
	* @author zhangcs
	* @version 1.0
	* @since 2016-12-05
	* modified by zhangcs at 2016-12-24
	*/
	
	//the head of UCLPropertySet
	private UCLPropertyHead propertyHead;
	//the propertyPart of UCLPropertySet
	/**
	 * modified by zhangcs at 2016-12-20 
	 */
	//private UCLPropertyBase[] properties=new UCLPropertyBase[16];
	private Map<Integer,UCLPropertyBase> properties=new HashMap<Integer, UCLPropertyBase>();
	
	
	public UCLPropertySet() {
		
		// TODO �Զ����ɵĹ��캯�����
		propertyHead = new UCLPropertyHead();
		
	}
	
	
	/**
	 * get the head of UCLPropertySet
	 * @return the head of UCLPropertySet
	 * @author zhangcs
	 * @since 2016-12-13
	 * modified by *** ****-**-** ***************
	 */
	public UCLPropertyHead getPropertyHead() {
		
		return propertyHead;
		
	}
	
	
	/**
	 * set the head of UCLPropertySet
	 * @param propertyHead the head of UCLPropertySet
	 * @author zhangcs
	 * @since 2016-12-13
	 * modified by *** ****-**-** ***************
	 */
	public boolean setPropertyHead(UCLPropertyHead propertyHead) {
		
		this.propertyHead = propertyHead;
		return true;
		
	}
	
	
	/**
	 * get the propertyPart of UCLPropertySet
	 * @return the propertyPart of UCLPropertySet
	 * @author zhangcs
	 * @since 2016-12-13
	 * modified by *** ****-**-** ***************
	 */
	public Map<Integer, UCLPropertyBase> getProperties() {
		
		return properties;
		
	}
	/**
	 * set the propertyPart of UCLPropertySet
	 * @param properties the propertyPart of UCLPropertySet
	 * @author zhangcs
	 * @since 2016-12-13
	 * modified by *** ****-**-** ***************
	 */
	public void setProperties(Map<Integer, UCLPropertyBase> properties) {
		
		this.properties = properties;
		
	}
	
	
	//����properthHead���
    public void setHeadCategory(int category){
    	
    	propertyHead.setCategory(category);
    	
    }
    public int getHeadCategory(){
    	
    	return propertyHead.getCategory();
    	
    }
    
    
    //����propertyHead helper
    public void setHeadHelper(int helper)
    {
        propertyHead.setHelper(helper);
    }

    public int getHeadHelper()
    {
        return propertyHead.getHelper();
    }
    
    
    //�������� ɾ������
    public boolean setProperty(UCLPropertyBase property){
    	
    	properties.put(property.getCategory(), property);
    	setSet();
    	return true;
    	
    }
    public boolean delProperty(int category){
    	
    	if(properties.get(category)!=null){
    		properties.remove(category);
    	}
    	setSet();
    	return true;
    	
    }
    
    //�������ԺŲ������Լ��е�ĳ������
    public UCLPropertyBase getProperty(int category)
    {
        if(properties.containsKey(category)){
        	return properties.get(category);
        }
        return null;
    }
    
    //�������Ժ�Ϊpos�����Ե�ֵΪvalue
    public void setPropertyVPart(int pos, String value)
    {
    	UCLPropertyBase prop = getProperty(pos);
    	if(prop!=null){
    		prop.setVPart(value);
    	}
        setSet();
    }
    
    //�������Ժ�pos��ȡ�����Ӧ�����Ե�����ֵ
    public String getPropertyVPart(int pos)
    {
        return properties.get(pos).getVPart();
    }

    //����properties����propertyHead�Ŀ���ƥ��
    public int generateQuickMatcher(){
    	int quickmatcher=0;
    	for(int i:properties.keySet()){
    		quickmatcher |= (0x01<<i);
    	}
    	return quickmatcher;
    }
    
    
    //����properties����propertyHead��vPart
    public String generateHeadVPart(){
    	
    	int qm = propertyHead.getQuickMatcher();
    	StringBuilder value = new StringBuilder();
    	for(int i=0; i < 16; i++)
        {
    		if((qm&(0x01<<i))!=0){
    			value.append(properties.get(i).pack());
    		}
        }

        return value.toString();
        
    }

    //��ʼ�����ϻ�����properties�������õĺ���
    public void setSet(){
    	
    	propertyHead.setQuickMatcher(generateQuickMatcher());
        propertyHead.setVPart(generateHeadVPart());
		propertyHead.setQuickMatcher(generateQuickMatcher());
    }
    
    
    //���Լ��ϴ�����
    public String pack(){
    	
    	return propertyHead.pack();
    	
    }
    public void unpack(String propertySet){
    	
    	propertyHead.unpack(propertySet);
		String headVPart = propertyHead.getVPart();
    	int qm = propertyHead.getQuickMatcher();
    	int tmp = 0;
    	for(int i=0;i<16;i++){
    		if((qm&(0x0001<<i))!=0){
    			//�������Լ���ͷ�����Գ���ֵ�ֶ��ֽ���
                int lValueBytes = ((headVPart.toCharArray()[1+tmp] & 0x0FF) >> 6) + 1;
                //ȡ������ֵ�ֶ�
                char[] lValue = headVPart.substring(2+tmp, 2+tmp+lValueBytes).toCharArray();
                int lValueNum = 0;
                for(int j=0; j < lValue.length; j++)
                {
                	int cur = lValue[j] & 0x0FF;
                    switch (j)
                    {
                        case 0:
                            lValueNum = (0xffffff00 & lValueNum) | cur;
                            break;
                        case 1:
                            lValueNum = (0xffff00ff & lValueNum) | (cur << 8);
                            break;
                        case 2:
                            lValueNum = (0xff00ffff & lValueNum) | (cur << 16);
                            break;
                        case 3:
                            lValueNum = (0x00ffffff & lValueNum) | (cur << 24);
                            break;
                    }
                }
                String property  = headVPart.substring(tmp, tmp+lValueNum);
                UCLPropertyBase  pro=new UCLPropertyBase();
                pro.unpack(property);
                properties.put(i, pro);
                tmp += lValueNum;
    		}
    	}
    }
    
    /**
	 * ����̨������Լ���
	 * @return void
	 * @author zhangcs
	 * @since 2017-5-12
	 */
    public void showPropertySet()
    {

		if (propertyHead.getCategory() == 1 || propertyHead.getCategory() == 15) {
			System.out.println("���Լ�����: " + UCLPackage.UPI.getPropertySetCategory(propertyHead.getCategory()));
			System.out.println("���Լ����: " + (int)propertyHead.getCategory()+"    ���Ը���: "+(int)propertyHead.getSize());
			for(int category:properties.keySet()) {
				System.out.println("�������: "+properties.get(category).getCategory()+"    ������: "+UCLPackage.UPI.getPropertyCategroy
						(propertyHead.getCategory(), properties.get(category).getCategory()));
				UCLPackage.UPI.showProperty(propertyHead.getCategory(), properties.get(category));
				System.out.println("------------------------------------");
			}
		}
		else {
			System.out.println("�Զ������Լ���");
			System.out.println("���Լ����: " + propertyHead.getCategory() + "    ���Ը���: " + propertyHead.getSize());

			for(int category:properties.keySet()) {
				System.out.println("������������ֵ: "+properties.get(category).getCategory()+
						"   "+properties.get(category).getVPart());
				System.out.println("------------------------------------");
			}
		}
    }
}
