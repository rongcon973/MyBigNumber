
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class MyBigNumber implements stringSum{
	// Phuong thuc cong 2 chuoi so
	public static String sum(String s1, String s2){
		String result= "";
		int str_s1 = s1.length();// Lay do dai chuoi 1 
		int str_s2 = s2.length();// Lay do dai chuoi 2
		
		int max = str_s1;// dat gioi han chuan cua 2 chuoi
		
		// so sanh do dai 2 chuoi de tiep tuc chay vong lap
		if(str_s1 > str_s2){
			max = str_s1;
		}
		else{
			max = str_s2;
		}
		
		int flag = 0;// tao 1 bien co dinh luu lai gia tri du
		for(int i=0; i<max ; i++){
			int num1 = str_s1 - i - 1;// gia tri cuoi cung cua chuoi 1
			int num2 = str_s2 - i - 1;// gia tri cuoi cung cua chuoi 2
			
			char dig_1 = '0', dig_2 = '0';// bien luu ki tu khi xuat ket qua ra
			if(num1 >= 0){
				dig_1 = s1.charAt(num1);// cho phep lay ki tu vi tri num1 ra
			}
			if(num2 >= 0){
				dig_2 = s2.charAt(num2);// cho phep lay ki tu vi tri num2 ra
			}
			int temp1 = dig_1 - '0';// tao bien de luu ket qua dig_1
			int temp2 = dig_2 - '0';// tao bien de luu ket qua dig_2
			
			int sumAll = temp1 + temp2 + flag; // bien tinh Tong gia tri
			
			if(num1 >= 0){
				result += (sumAll % 10);
			}else{
				result += sumAll;
			}
			flag = sumAll/10 ; // cong so du
		}
		return result;
	}
}
