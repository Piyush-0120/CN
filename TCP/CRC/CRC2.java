import java.util.*;
public class CRC2 {
    public int[] helper(int arr[],int gen[])
    {
        int i = 0;
        int j = 0;
        int n = arr.length;
        int w = gen.length;
        for(i=0;j<n && i<=(n-w);)
        {
            if ((j-i)<w)
            {
                arr[j]=arr[j]^gen[j-i];
                j++;
            }
            else
            {
                int x = i;
                while(arr[x]!=1 && x-i<w)
                    x++;
                j=i=x;
            }
        }
        int code[] = new int[w],k=0;
        for(i=n-w;i<n;i++)
            code[k++]=arr[i];
        return code;
    }
    public static void main(String args[])
    {
        CRC2 obj = new CRC2();
        int n,w;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter data size");
        n = sc.nextInt();
        System.out.println("enter crc size");
        w = sc.nextInt();
        int gen[] = new int[w];
        System.out.println("Enter data");
        int arr[] = new int[n+w-1];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        for(int i = n;i<n+w-1;i++)
            arr[i]=0;
        System.out.println("Enter crc");
        for(int i=0;i<w;i++)
            gen[i]=sc.nextInt();
        
        int x[] =obj.helper(arr, gen);
        int r_data[] = new int[n+w-1];
        int k=n;
        System.out.println("Enter Receiever data");
        for(int i=0;i<n;i++)
            r_data[i]=sc.nextInt();
        
        for(int i=1;i<x.length;i++)
            r_data[k++]=x[i];
            
        int ans[] = obj.helper(r_data,gen);
        boolean flag= true;
        for(int a : ans)
            if (a==1){
                System.out.println("Rejected");
                flag = false;
                break;
            }
        if(flag)
            System.out.println("Accepted"); 
            
    }
}