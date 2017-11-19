package test;

public class ReplaceSpace {

	//题目：请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。

    
    /*
     * 时间复杂度为O(n)的解法：利用数组从后向前替换
     * 1、先遍历一次字符串，统计出要替换的字符的个数
     * 2、创建新的临时数组，数组长度为初始字符串字符个数+替换每个字符多出来的字符个数*要替换的字符个数
     * 3、从原来字符串数组后面开始向前进行复制、替换到临时数组。两个数组下标变量分别为原始字符数组长度-1，临时数组长度-1
     * 4、原始字符数组的字符如果不为空格，则把这个字符复制到临时数组的对应位置，两个数组下标都减1
     * 5、原始字符数组的字符如果为空格，则把临时数组相对应的位置从后向前依次写入替换的字符，临时数组下标减少相应的替换的字符数量
     * 6、循环复制替换，直到初始数组的下标小于0，此时替换完毕，临时数组转换成字符串后返回
     */
    public static String replaceSpace(char[] string){
        if(string==null)
            return null;
        int originalLength=string.length;
        int spaceCount=0;
        
        //统计空格数
        for(int i=0;i<originalLength;i++){
            if(string[i]==' ')
                spaceCount++;
        }
        
        //由" "-->"%20"所引起的长度变化
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
     * 时间复杂度为O(n)，利用StringBuffer实现
     * 通过indexOf(String str,int fromIndex)方法和subSequence(int start,int end)方法联合实现
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
