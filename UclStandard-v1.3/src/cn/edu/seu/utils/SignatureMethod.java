package cn.edu.seu.utils;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.KeyPair;  
import java.security.KeyPairGenerator;  
import java.security.PrivateKey;  
import java.security.PublicKey;  
import java.security.Signature;  

public class SignatureMethod {
	private KeyPairGenerator keygen;
	private KeyPair keys;
	private PublicKey pubKey;
	private PrivateKey priKey;
	private byte[] signed;
	
	public String byte2hex(byte[] b) {  
        String hs = "";  
        String stmp = "";  
        for (int n = 0; n < b.length; n++) {  
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));  
            if (stmp.length() == 1)  
                hs = hs + "0" + stmp;  
            else  
                hs = hs + stmp;  
            if (n < b.length - 1)  
                hs = hs + ":";  
        }  
        return hs.toUpperCase();  
    }  
	
	public byte[] getSigned(){
		return this.signed;
	}
	
	
	public KeyPairGenerator getKeygen(){
		return this.keygen;
	}
	
	
	public PublicKey getPubkey(){
		return this.pubKey;
	}
	
	
	public PrivateKey priKey(){
		return this.priKey;
	}
	
	
    public boolean setKeygen(int type) {  
        try {
        	switch (type) {
			case 1:
				keygen = KeyPairGenerator.getInstance("RSA");
				break;
            case 2:
            	keygen = KeyPairGenerator.getInstance("EC");
				break;
            case 3:
            	keygen = KeyPairGenerator.getInstance("DSA");
				break;

			default:
				break;
			}
            KeyPair keys = keygen.genKeyPair();  
            PublicKey pubkey = keys.getPublic();  
            PrivateKey prikey = keys.getPrivate();  
            return true;  
        } catch (java.lang.Exception e) {  
            e.printStackTrace();  
            System.out.println("������Կ��ʧ��");  
            return false;  
        }  
    }

    public byte[] setSigned(String myinfo,int type){
    	try { 
    		Signature signet = null;
            // ��˽Կ����Ϣ��������ǩ�� 
    		switch (type) {
			case 0:
				signet = Signature.getInstance("MD5withRSA"); 
				break;
            case 1:
            	signet = Signature.getInstance("SHA1withECDSA"); 
				break;
           case 2:
        	    signet = Signature.getInstance("DSA"); 
	            break;
			default:
				break;
			}
            signet.initSign(this.priKey);  
            signet.update(myinfo.getBytes());  
            byte[] signed = signet.sign(); // ����Ϣ������ǩ�� 
            System.out.println("ǩ���������ļ��ɹ�");  
            return signed;
           
        } catch (java.lang.Exception e) {  
            e.printStackTrace();  
            System.out.println("ǩ���������ļ�ʧ��"); 
            return null;
        }  
    	
    }
    
    
    public boolean validate(byte[] signed,int type,String info,PublicKey pubkey){
    	 try {
    		 Signature signetcheck = null; 
             switch (type) {
             case 0:
				signetcheck = Signature.getInstance("MD5withRSA");
				break;
            case 1:
            	signetcheck = Signature.getInstance("SHA1withECDSA");
				break;
            case 2:
            	signetcheck = Signature.getInstance("DSA");
	            break;
			default:
				break;
			}
             signetcheck.initVerify(pubkey);  
             signetcheck.update(info.getBytes());  
             if (signetcheck.verify(signed)) {   
                 System.out.println("ǩ������"); 
                 return true;
             } else{
            	 System.out.println("��ǩ������");  
            	 return false;
             }  
                 
             
         } catch (java.lang.Exception e) {  
             e.printStackTrace();  
             return false;
         }  
      	
    }

}
