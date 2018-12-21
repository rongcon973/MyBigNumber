import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Tác giả: Phạm Anh Tuấn
 * 
 * 
 */

public class Test {
    public static void main(String[] args) throws Exception{
        
        String s1,s2;

        BufferedReader reader; // Lớp đọc giá trị nhập vào
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\t\t\t~ BAI TOAN CONG 2 SO ~");
        System.out.print("Nhap vao so A = ");
        s1 = reader.readLine();
        System.out.print("Nhap vao so B = ");
        s2 = reader.readLine();
        System.out.println("\t\t\t   ~ Bai giai ~");
        String[] a = {s1,s2};
        MyBigNumber.main(a);
    }
}