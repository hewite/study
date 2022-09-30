import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class StudyArry {
    public static void main(String[] args) {













    }
    @Test
    //二分法查找要求数组必须是有序的
    public void item1(){
        int[] arr=new int[]{1,32,5,35,66,88,45,56,76878,2245,56};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Boolean isFlog=true;
        int num=45;
        int head=0;
        int end=arr.length-1;
        while(head<end){
            int middle=(head+end)/2;
            if(arr[middle]==num){
                System.out.println("找到指定元素");
                isFlog=false;
                break;
            }else if(arr[middle]>num){
                end=middle+1;
            }else{
                head=middle-1;
            }
        }
        if(isFlog){
            System.out.println("未找到指定元素");
        }
    }
    @Test
    public void scoreTest(){
        Scanner scan=new Scanner(System.in);
        Vector v=new Vector();
        int maxScore=0;
        for(;;){
            System.out.println("请输入学生成绩（负数代表结束）");
            int score=scan.nextInt();
            if(score<0)break;
            if(score>100){
                System.out.println("输入的数据非法");
                continue;
            }
            v.addElement(score);
            if(maxScore<score) maxScore=score;
        }
        for(int i=0;i<v.size();i++){
            Object obj=v.elementAt(i);
            int level=(int)obj;
            if(maxScore<level){
                maxScore=level;
            }
        }
        System.out.println(maxScore);
    }
}
