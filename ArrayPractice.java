import java.util.Scanner;

public class ArrayPractice {
    public static void main(String[] args) {
        // program 2:
        // matrix multiplication
        // int a[] = { 1, 2, 3,2,3 };
        // int b[] = { 4, 5, 6,7,9 };
        // int large = a.length > b.length ? a.length : b.length;
        // int small = a.length < b.length ? a.length : b.length;
        // int c[] = new int[large];
        // for (int i = 0; i < small; i++) {
        // c[i] = a[i] * b[i];
        // }
        // if (a.length > b.length)// 5>3
        // {
        // for (int i = b.length; i < large; i++) {
        // c[i] = a[i];
        // }
        // } else if (a.length < b.length)// 3<5
        // {
        // for (int i = a.length; i < large; i++) {
        // c[i] = b[i];
        // }
        // }

        // for (int i : c) {
        // System.out.println(i);
        // }

        // program 3:
        // find the max and min and sec min in array(without sorting)?
        // int a[]={4,5,2,1,3};
        // int max=a[0];
        // int min=a[0];
        // for(int i=1;i<a.length;i++)
        // {
        // if(max<a[i])
        // {
        // max=a[i];
        // }
        // else if(min>a[i])
        // {
        // min=a[i];
        // }
        // }
        // System.out.println("maximum:"+max);
        // System.out.println("Minimum:"+min);

        // int secmin=Integer.MAX_VALUE;
        // for(int i=0;i<a.length;i++)
        // {
        // if(min!=a[i] && a[i]<secmin)
        // {
        // secmin=a[i];
        // }
        // }
        // System.out.println("secMin:"+secmin);

        // program 4:

        // int a[]={1,2,3,4,5};
        // int first=Integer.MAX_VALUE;
        // int second=Integer.MAX_VALUE;
        // int third=Integer.MAX_VALUE;

        // for(int i=0;i<a.length;i++)
        // {
        // if(a.length<3)
        // {
        //     return -1;
        // }
        // if(a[i]==first ||a[i]==second ||a[i]==third)
        // {
        // continue;
        // }
        // if(a[i]<first){
        // third=second;
        // second=first;
        // first=a[i];
        // }
        // else if(a[i]<second)
        // {
        // third=second;
        // second=a[i];
        // }
        // else if(a[i]<third){
        // third=a[i];
        // }
        // }
        // System.out.println(third);

        // program 5:
        // Array Rotation- 1
        // int a[] = { 1, 2, 3, 4, 5 };
        // int noOfRotate = 1;
        // for (int i = 0; i < noOfRotate; i++) {
        // int last = a[a.length - 1];
        // for (int j = a.length - 1; j > 0; j--) {
        // a[j] = a[j - 1];
        // }
        // a[0] = last;
        // }
        // //foreach()
        // for(int i:a){
        // System.out.print(i+" ");
        // }
        // System.out.println(a);//[I@5b2133b1

        // program 6:
        // Array Rotation -2
        // int a[] = { 1, 2, 3, 4, 5 };
        // int noOfRotate = 1;
        // for (int i = 0; i < noOfRotate; i++) {
        // int first = a[0];
        // for (int j = 0; j < a.length - 1; j++) {
        // a[j] = a[j + 1];
        // }
        // a[a.length - 1] = first;
        // }
        // // foreach()
        // for (int i : a) {
        // System.out.print(i + " ");
        // }

        // program 7:
        // insert element in the specified element
        // Scanner sc=new Scanner(System.in);
        // int size=5;
        // int a[]=new int[size+1];
        // for(int i=0;i<size;i++)
        // {
        // a[i]=sc.nextInt();
        // }
        // int element=sc.nextInt();
        // int pos=sc.nextInt();
        // for(int i=size-1;i>=(pos-1);i--)
        // {
        // a[i+1]=a[i];
        // }
        // a[pos-1]=element;
        // for(int i:a)
        // {
        // System.out.print(i+" ");
        // }

        // program: 8
        // input:[4,4,4] output: 0
        // input:[1,2,3,1] output:2
        // int[] a={1,2,3,1};
        // int count=0;
        // int key=a[0];
        // for(int i=0;i<a.length;i++)
        // {
        // if(a[i]!=key)
        // {
        // count++;
        // }
        // else{
        // continue;
        // }
        // }
        // System.out.println(count);

        //program-9
        // Sort the array in the factorial order 
        int []a={5,4,3,2,1};
        int n=a.length;
        int fact[]=new int[n];
        for(int i=0;i<a.length;i++)
        {
            fact[i]=fact(a[i]);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(fact[i]>fact[j]){
                    int temp=fact[i];
                    fact[i]=fact[j];
                    fact[j]=temp;
                    
                    
                    int temp1=a[i];
                    a[i]=a[j];
                    a[j]=temp1;
                }
            }
        }
        for(int i:a){
            System.out.print(i+" ");
        }



    }
    public static int fact(int n)
    {
        if(n==0||n==1)
        {
            return 1;
        }
       int fact =1;
       for(int i=2;i<=n;i++)
       {
        fact=fact*i;
       }
       return fact;
    }
    

}