package cn.edu.seu.fnrc.property;

public class UCLPropertyHead extends UCLPropertyBase {
	/**
	* <p>Class description: UCLPropertyHead,UCL PropertyHead base class</p>
	* <p>Copyright 2016: Future network research center, Southeast University</p>
	* Note:�ݶ���UCL���Բ�����ͷ��ʵ�ָ���
	* @author zhangcs
	* @version 1.0
	* @since 2016-12-05
	*/
	
	
	public UCLPropertyHead() {
		// TODO �Զ����ɵĹ��캯�����
		setQuickMatcherBytesNum(2);
	}
	
	
	//number of UCLPropertySet:4b�� �����Լ��ϸ���������Ԫ�ظ���
	public int getSize(){
		
		return (int) ((lPart >> 2) & 0x0F+1);
		
	}
	public boolean setSize(int size){
		
		assert(size<=16 && size > 0);
		size--;
	    lPart = (lPart & 0xFFFFFFFFFFFFFFc3L) | (size<<2);
	    return true;
	    
	}
	
	
	//fastMatch:2B
	public int getQuickMatcher(){
		int lPartValueBytesNum = getLPartValueBytesNum();
	    int quickMatcher=0;
	    switch (lPartValueBytesNum){
	        case 1:
	            quickMatcher = (int) ((lPart >> 16) & 0x0FFFF);
	            break;
	        case 2:
	            quickMatcher = (int) ((lPart >> 24) & 0x0FFFF);
	            break;
	        case 3:
	            quickMatcher = (int) ((lPart >> 32) & 0x0FFFF);
	            break;
	        case 4:
	            quickMatcher = (int) ((lPart >> 40) & 0x0FFFF);
	            break;
	    }
	    return quickMatcher;
	}
	public boolean setQuickMatcher(long j){
		//����quickMatcher��Ϣ��������Ԫ�ظ���
		long temp = j;
	    byte size = 0;
	    for(int i=0;i<16;i++){
	    	if((temp&(0x01<<i))!=0){
	    		size++;
	    	}
	    }
	    setSize(size);

	    //����LPart��quickMatcher����
	    int lPartValueBytesNum = getLPartValueBytesNum();
	    switch (lPartValueBytesNum){
	        case 1:
	            lPart = (lPart & 0xFFFFFFFF0000FFFFL) | (j<<16);
	            break;
	        case 2:
	            lPart = (lPart & 0xFFFFFF0000FFFFFFL) | (j<<24);
	            break;
	        case 3:
	            lPart = (lPart & 0xFFFF0000FFFFFFFFL) | (j<<32);
	            break;
	        case 4:
	            lPart = (lPart & 0xFF0000FFFFFFFFFFL) | (j<<40);
	            break;
	    }
	    return true;
	}
}
