/**
 * Tác giả: Phạm Anh Tuấn
 * Hàm sum là hàm thực hiện phép cộng hai chuỗi số
 *
*/

public class MyBigNumber{
	
	private IReceiver ireceiver;
	
	public MyBigNumber(IReceiver ireceiver){
		this.ireceiver = ireceiver;
	}
	
	// Phuong thuc cong 2 chuoi so
	public String sum(String s1, String s2){
		int max = str_s1;// dat gioi han chuan cua 2 chuoi
		int check = 0;// bien kiem tra loi
		String loi = "";// chuoi de bao loi
		String result = "";// chuoi luu ket qua tam thoi
		String step = "";// chuoi luu cac buoc cua phep tinh
		int str_s1 = s1.length();// Lay do dai chuoi 1 
		int str_s2 = s2.length();// Lay do dai chuoi 2
		try{
			if(!s1.matches("^[0-9]+$") || !s2.matches("^[0-9]+$")){
				throw new NumberFormatException();
			}
		} catch (NumberFormatException ex){
			check = 1;
			loi = "Khong nhap ki tu, chu cai. Vui long nhap lai!";
		}
		
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
	
			result += (sumAll % 10);//tong 2 ki tu duoc lay ra

			flag = sumAll/10 ; // cong so du
			if (i == 0){
				step += "\n" + " Lay " + temp1 + " cong voi " + temp2
					+ " bang " + flag + "\n";
			} else{
				step += "\n" + " Lay " + temp1 + " cong voi " + temp2
					+ " bang " + flag + " , " + "Nho " + flag + "Ghi" + result;
			}
		}
		if(flag > 0){
			result = flag + result;
		}
		this.ireceiver.send(step);
		return result;
	}
}
