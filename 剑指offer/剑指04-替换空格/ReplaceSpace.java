package test;

public class ReplaceSpace {

	//��Ŀ����ʵ��һ�����������ַ����е�ÿ���ո��滻��"%20"�����硰We are happy.�����������We%20are%20happy.����

    
    /*
     * ʱ�临�Ӷ�ΪO(n)�Ľⷨ����������Ӻ���ǰ�滻
     * 1���ȱ���һ���ַ�����ͳ�Ƴ�Ҫ�滻���ַ��ĸ���
     * 2�������µ���ʱ���飬���鳤��Ϊ��ʼ�ַ����ַ�����+�滻ÿ���ַ���������ַ�����*Ҫ�滻���ַ�����
     * 3����ԭ���ַ���������濪ʼ��ǰ���и��ơ��滻����ʱ���顣���������±�����ֱ�Ϊԭʼ�ַ����鳤��-1����ʱ���鳤��-1
     * 4��ԭʼ�ַ�������ַ������Ϊ�ո��������ַ����Ƶ���ʱ����Ķ�Ӧλ�ã����������±궼��1
     * 5��ԭʼ�ַ�������ַ����Ϊ�ո������ʱ�������Ӧ��λ�ôӺ���ǰ����д���滻���ַ�����ʱ�����±������Ӧ���滻���ַ�����
     * 6��ѭ�������滻��ֱ����ʼ������±�С��0����ʱ�滻��ϣ���ʱ����ת�����ַ����󷵻�
     */
    public static String replaceSpace(char[] string){
        if(string==null)
            return null;
        int originalLength=string.length;
        int spaceCount=0;
        
        //ͳ�ƿո���
        for(int i=0;i<originalLength;i++){
            if(string[i]==' ')
                spaceCount++;
        }
        
        //��" "-->"%20"������ĳ��ȱ仯
        int newLength=originalLength+2*spaceCount;
        char[] temp=new char[newLength];
        int i=originalLength-1;
        int j=newLength-1;
        while(i>=0){
            if(string[i]==' '){
                temp[j]='0';
                temp[j-1]='2';
                temp[j-2]='%';
                j=j-3;
            }else{
                temp[j]=string[i];
                j=j-1;
            }
            i=i-1;
        }
        return new String(temp);
    }
    
    /*
     * ʱ�临�Ӷ�ΪO(n)������StringBufferʵ��
     * ͨ��indexOf(String str,int fromIndex)������subSequence(int start,int end)��������ʵ��
     */
    public static String replaceSpace(StringBuffer str){
        if(str==null)
            return null;
        int fromIndex=0;
        int index=0;
        StringBuffer temp =new StringBuffer();
        while(index<=str.length()){
            index=str.indexOf(" ",fromIndex);
            if(index>=0){
                temp.append(str.subSequence(fromIndex, index)).append("%20");
                index=index+1;
                fromIndex=index;
            }else{
                temp.append(str.substring(fromIndex, str.length()));
                break;
            } 
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        String string1="We are happy.";
        String string2=" We  are happy. ";
        String string3="Wearehappy.";
        //String string4=null;
        String string5="";
        String string6=" ";
        String string7="    ";
        System.out.println(replaceSpace(string1.toCharArray()));
        System.out.println(replaceSpace(string2.toCharArray()));
        System.out.println(replaceSpace(string3.toCharArray()));
        //System.out.println(replace(string4.toCharArray()));
        System.out.println(replaceSpace(string5.toCharArray()));
        System.out.println(replaceSpace(string6.toCharArray()));
        System.out.println(replaceSpace(string7.toCharArray()));
        System.out.println(replaceSpace(new StringBuffer(string1)));
        System.out.println(replaceSpace(new StringBuffer(string2)));
        System.out.println(replaceSpace(new StringBuffer(string3)));
        //System.out.println(replaceSpace(new StringBuffer(string4)));
        System.out.println(replaceSpace(new StringBuffer(string5)));
        System.out.println(replaceSpace(new StringBuffer(string6)));
        System.out.println(replaceSpace(new StringBuffer(string7)));
    }
}
