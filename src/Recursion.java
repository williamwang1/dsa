public class Recursion {

    public static void main(String args[]){
        int[] a = {1,2,3,4} ;
        System.out.println("final  "+region(a,0,0)) ;
    }

    public static int region(int[] a,int currentSum,int i) {
        currentSum+=a[i];
        System.out.println("out  " + currentSum) ;          //按顺序输出：递归式前面
        if(i < a.length - 1){
            region(a,currentSum,i + 1);
            System.out.println("in  " + currentSum);  //先进后出：递归式后面
        }
        System.out.println("hello  ") ;
        return currentSum ;
    }

}

/**
 * https://zhuanlan.zhihu.com/p/95798141
 *
 * 定义一个函数
 * 接下来寻找问题与子问题间的关系（即递推公式），这样由于问题与子问题具有相同解决思路
 * 要寻找最终不可再分解的子问题的解
 *
 * 反转二叉树 将左边的二叉树反转成右边的二叉树
 * 定义一个函数，这个函数代表了翻转以 root 为根节点的二叉树
 * 查找问题与子问题的关系,得出递推公式 我们之前说了，解题要采用自上而下的思考方式，
 * 那我们取前面的1， 2，3 结点来看，对于根节点 1 来说，假设 2, 3 结点下的节点都已经翻转，那么只要翻转 2， 3 节点即满足需求
 *
 * */

// https://blog.csdn.net/SpeedMe/article/details/21654357
