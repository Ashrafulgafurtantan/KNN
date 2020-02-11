package Knn;

//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static  void Refresh(double arr[][],int arrSize){

        for (int i = 0; i <arrSize ; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = 9999;

            }
        }

    }


    public static void Sort(double [][] array)
    {
        java.util.Arrays.sort(array, new java.util.Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[0], b[0]);
            }
        });

    }
    public static  void  Reverse(double [][] arr,int arrSize){

        for(int i=0;i<arrSize;i++) {
            for (int j = 0; j < 1; j++) {

                if(arr[i][j]==0.0){

                }
                else{

                    arr[i][j]=1/arr[i][j];
                }


            }
        }

    }

    public static  void ShowPercentage(double [][] arr,int arrSize){

        int k=0;
        while(k<arrSize-1){
        for(int i=k+1;i<arrSize;i++) {
            if (arr[i][0] != 0.0 && arr[k][1] == arr[i][1]) {

                arr[k][0]+=arr[i][0];
                System.out.println("ans = "+arr[k][0]);
                arr[i][0]=0.0;


            }
        }
        k++;
        }



        for(int i=0;i<arrSize;i++) {
            //for(int j=1;j<2;j++){
                /*if(j==1)
                {
                    int x=(int)arr[i][j];
                    x+=65;
                    char c=(char)x;
                    System.out.println(c);
                }
                else
                {
                    System.out.print(arr[i][j]+"\t");

                }*/

                if(arr[i][0]!=0.0){
                    int x=(int)arr[i][1];
                    x+=65;
                    char c=(char)x;
                    System.out.println(arr[i][0]+"\t"+c);

                }



            //}
        }








    }
    public static void Show(double [][] arr,int arrSize)
    {
        for(int i=0;i<arrSize;i++) {
            for(int j=0;j<2;j++){
                if(j==1)
                {
                    int x=(int)arr[i][j];
                    x+=65;
                    char c=(char)x;
                    System.out.println(c);
                }
                else
                {
                    System.out.print(arr[i][j]+"\t");

                }

            }
           // System.out.println();
        }

    }


    public static void main(String[] args) throws IOException {

        File trainingFile = new File("training.txt");
        File testFile = new File("test.txt");
        System.out.print("K = ");
        Scanner sc = new Scanner(System.in);
        int arrSize=sc.nextInt();
        double[][] arr = new double[arrSize][2];

        Refresh(arr,arrSize);



        // trainingInput=new FileInputStream(trainingFile);
        //FileInputStream testInput=new FileInputStream(testFile);

        BufferedReader bufferTrainingData = new BufferedReader(new FileReader(trainingFile));
        BufferedReader bufferTestData = new BufferedReader(new FileReader(testFile));
        double sum = 0;
       // String testStr=null;
        String testStr = bufferTestData.readLine();
        String trainingStr = null;
        // String trainingStr= bufferTrainingData.readLine();

       // while ((testStr = bufferTestData.readLine()) != null)
        {
            int testSum=0;

            while ((trainingStr = bufferTrainingData.readLine()) != null) {

                String[] arrOfTestStr = testStr.split(",", 11);
                String[] arrOfTrainingStr = trainingStr.split(",", 11);
                for (int i = 0; i < 10; i++) {
                    double test = Double.parseDouble(arrOfTestStr[i]);
                    double train = Double.parseDouble(arrOfTrainingStr[i]);
                    sum += Math.pow((test - train), 2);

                    //  System.out.println("test = "+test+"\t"+train);


                }
                sum = Math.sqrt(sum);
                // System.out.print("Sum = "+sum+"\t");
                double max = arr[arrSize-1][0];
                // System.out.println("max = "+max);
                //For testing
                char c = arrOfTrainingStr[10].charAt(0);

                 // System.out.println("c = "+c);





                if (sum < max) {
                    arr[arrSize-1][0] = sum;
                     c = arrOfTrainingStr[10].charAt(0);
                    int b = c;
                    b = b - 65;
                    //  System.out.println("c = "+c);

                    //   System.out.println("b = "+b);
                    arr[arrSize-1][1] = b;

                    //    int ascii=arrOfTrainingStr[10];

                    Sort(arr);
                      /*System.out.println("Show them all");

                    Show(arr,arrSize);
*/

                }
                sum = 0;
            //    Sort(arr);
              //  System.out.println("Show them all");

               // Show(arr);
                testSum++;

            }
            System.out.println("Show them all");

            Show(arr,arrSize);
            Reverse(arr,arrSize);
            System.out.println("Show them all");

            Show(arr,arrSize);
            System.out.println("Show them all");



              ShowPercentage(arr,arrSize);
           // Refresh(arr);
          //  System.out.println("Lines = "+testSum);

        }

   /*     //    while ((st = bufferTrainingData.readLine()) != null)
            System.out.println(st);
        String[] arrOfStr = st.split(",", 11);
        for(int i=0;i<arrOfStr.length;i++){
            System.out.println(arrOfStr[i]);
            int i=Integer.parseInt("200");



        }
*/



    }

}
