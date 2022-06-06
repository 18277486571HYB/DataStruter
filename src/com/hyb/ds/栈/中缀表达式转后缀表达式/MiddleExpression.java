package com.hyb.ds.栈.中缀表达式转后缀表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MiddleExpression {
    public static void main(String[] args) {
        MiddleExpression middleExpression = new MiddleExpression();
        List<String> list = middleExpression.expressionToList("1+((2+3)*4)-5");
        list.forEach(System.out::println);
        System.out.println("转换成后缀表达式为:");
        List<String> rearExpression = middleExpression.toRearExpression(list);
        System.out.println(rearExpression.toString());
        System.out.println("计算后缀表达式的值为:");
        System.out.println(middleExpression.countRearExpression(rearExpression));

    }
    private final List<String> c1=new ArrayList<>(Arrays.asList("*","/"));
    private final List<String> c2=new ArrayList<>(Arrays.asList("+","-"));


    //计算后缀表达式
    public int countRearExpression(List<String> list){
        Stack<Integer> stack = new Stack<>();
        for (String s :
                list) {
            if (s.matches("\\d+"))
                stack.push(Integer.parseInt(s));
            else {
                Integer s1 = stack.pop();
                Integer s2 = stack.pop();
                int value=calculate(s2,s1,s);
                stack.push(value);
            }
        }
        return stack.pop();
    }

    private int calculate(Integer s2, Integer s1, String s) {
        switch (s.charAt(0)){
            case '*':
                return s2*s1;
            case '/':
                return s2/s1;
            case '+':
                return s2+s1;
            case '-':
                return s2-s1;
            default:
                return 0;
        }
    }

    //比较字符优先级
    public int compare(String s1,String s2){
        //优先级一样
        if ((c1.contains(s1)&&c1.contains(s2))||(c2.contains(s1)&&c2.contains(s2)))
            return 0;
        //s1>s2优先级
        else if (c1.contains(s1)&&c2.contains(s2))
            return 1;
        //s2<s2
        else
            return -1;
    }


    public List<String> toRearExpression(List<String> list){
//        1. 初始化两个栈,一个是只存放运算符或者括号的栈s1,一个是存放中间结果和数字或者运算符的的栈s2
//        因为我们s2的栈在使用过程是没有任何出栈操作的,最后的出栈只是将数据呈现出来,所以完全可以用List去代替
        Stack<String> s1 = new Stack<>();
        List<String> s2=new ArrayList<>();
//        2. 从左到右扫描中缀表达式.
        for (String s:list) {
//        3. 遇到数字,直接压入s2中.
            if (s.matches("\\d+")){
                s2.add(s);
            }else if (s1.empty())
                s1.push(s);
//        4. 遇到运算符,比较其余s1栈顶运算符的优先级(这里只是比较运算符,如果栈顶是括号,则不比较),如果s为空,或者是括号,则直接将该运算符压入到s1中;
//        如果优先级比栈顶运算符高,也直接压入栈s1中,如果优先级小于或等于栈顶运算符,将该栈顶运算符弹出,压入s2中,然后转回第4步刚开始的规则往下,一直到将该运算符压入s1中.
            else if(!s.equals("(") && !s.equals(")")){
                //如果遇到(,不可能遇到),因为)遇到(会消除
                // 或者优先级比栈顶高
                while (true){
                    if (s1.empty()){
                        s1.push(s);
                        break;
                    }
                    if (s1.peek().equals("(")||compare(s,s1.peek())>1){
                        s1.push(s);
                        break;
                    }else {
                        s2.add(s1.pop());
                    }
                }
            }
//        5. 遇到括号,如果是左括号(,直接压入s1;如果是),则依次弹出s1的运算符(只弹出运算符),直到遇到(,这个时候(和)组成一对括号,将这对括号丢弃,即s1弹出一个左括号,这个右括号不做任何动作丢弃.
            else {
                if (s.equals("("))
                    s1.push(s);
                else {
                    while (!s1.peek().equals("(")){
                        //将运算符弹出
                        s2.add(s1.pop());
                    }
                    //将(弹出,)不入s1
                    s1.pop();
                }

            }
        }
//        6. 直到中缀表达式扫描完毕,将s1中剩余的运算符依次弹出并压入s2.
        while (!s1.empty())
            s2.add(s1.pop());
//        7. 得到s2,依次出栈,组成的表达式的逆序就是后缀表达式.
        return s2;
    }


    //将表达式收集成集合
    public List<String > expressionToList(String s){

        List<String> list=new ArrayList<>();
        int length = s.length();
        StringBuilder stringBuilder = null;
        int count=0;
        //多运行一次,让最后一个数字放入集合中
        for (int i = 0; i <= length; i++) {
            if (stringBuilder==null)
                stringBuilder=new StringBuilder();
            //防止数组越界
            char c = 0;
            if (i<=length-1){
                c= s.charAt(i);
                if (c>='0'&&c<='9') {
                    count = 0;
                    stringBuilder.append(c);
                    continue;
                }

            }
            if (count==0){
                count=1;
                list.add(stringBuilder.toString());
                stringBuilder=null;
            }
            if (c=='('||c==')'||c=='*'||c=='/'||c=='+'||c=='-')
                list.add(c+"");
        }

        return list;
    }
}
