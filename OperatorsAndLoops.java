public class OperatorsAndLoops{
public static void main(String[]args){
int i=0;
System.out.println("Value:"+i);
i++;
System.out.println("Value:"+i++);
System.out.println("Value:"+i);
++i;
System.out.println("Value:"+i++);
System.out.println("Value:"+i++);

int z=i+i+++++i+i+++i+i++;
System.out.println(z);
System.out.println(i);

int z=i-i++---i+i-++i+i++;
System.out.println(z);
System.out.println(i);

for(int i=0;i<10;i++){
	System.out.println("i:"+i);
}

int j=10;
while(j>0){
	System.out.println("j:"+j);
}
int k=10;
do {
    System.out.println("k:"+k);
    k--;
} while (k > 0);

}
}