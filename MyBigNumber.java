/**
 * Tác giả: Phạm Anh Tuấn
 * Hàm sum là hàm thực hiện phép cộng hai chuỗi số
 *
*/

public class MyBigNumber{
	
	private IReceiver ireceiver;
	
	public MyBigNumber(final IReceiver ireceiver){
		this.ireceiver = ireceiver;
	}
	
	// Phuong thuc cong 2 chuoi so
	public String sum(final String s1,final String s2) {
		
		int max = str_s1;// dat gioi han chuan cua 2 chuoi
		
		String loi = "";// chuoi de bao loi
		String result = "";// chuoi luu ket qua tam thoi
		String step = "";// chuoi luu cac buoc cua phep tinh
		
		int str_s1 = s1.length();// Lay do dai chuoi 1 
		int str_s2 = s2.length();// Lay do dai chuoi 2
		
		int rem = 0;// bien luu ki tu nho tiep theo
		int flag = 0;// tao 1 bien co dinh luu lai gia tri du
		int write = 0;// bien nho
		
		if (!s1.matches("^[0-9]+$") || !s2.matches("^[0-9]+$")) {
			
			throw new NumberFormatException();
		}
		
		if (str_s1 > str_s2) { // so sanh do dai 2 chuoi de tiep tuc chay vong lap
			max = str_s1;
		} else {
			max = str_s2;
		}
		
		for (int i=0; i<max ; i++) {
			int num1 = str_s1 - i - 1;// gia tri cuoi cung cua chuoi 1
			int num2 = str_s2 - i - 1;// gia tri cuoi cung cua chuoi 2
			
			char dig_1 = '0', dig_2 = '0';// bien luu ki tu khi xuat ket qua ra
			if (num1 >= 0) {
				dig_1 = s1.charAt(num1);// cho phep lay ki tu vi tri num1 ra
			}
			if (num2 >= 0) {
				dig_2 = s2.charAt(num2);// cho phep lay ki tu vi tri num2 ra
			}
			int temp1 = dig_1 - '0';// tao bien de luu ket qua dig_1
			int temp2 = dig_2 - '0';// tao bien de luu ket qua dig_2
			
			int sumAll = temp1 + temp2;//tong 2 ki tu duoc lay ra
	
			write = (sumAll + rem) % 10;
			if (sumAll<9) {
				flag = sumAll / 10;// cong so du
			}
			if (max == 1) {
				step += "\n" + " Lay " + temp1 + " cong voi " + temp2
					+ " bang " + sumAll + "\n";
			} else if(rem == 0) {
				step += "\n" + " Buoc " + (i + 1) + ":\n" + " Lay " + temp1
					+ " cong voi " + temp2
					+ " duoc " + sumAll + "\n"
					+ " Ghi " + write
					+ " nho " + flag + "\n";
			} else {
				step += "\n" + "Buoc " + (i + 1) + " :\n"
					+ "Lay " + temp1
					+ " cong " + temp2
					+ " duoc " + sumAll + "\n"
					+ "Cong them so nho " + rem
					+ " ta duoc " + (sumAll + rem) + " \n "
					+ " Ghi " + write
					+ " nho " + flag + "\n";
			}
			rem = sumAll / 10;
			result = write + result;
		}
		if (flag != 0) {
			result = flag + result;
		}
		ireceiver.send(step);
		return result;
	}
}
