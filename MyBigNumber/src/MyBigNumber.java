import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tác giả: Phạm Anh Tuấn.
 * Hàm sum là hàm thực hiện phép cộng hai chuỗi số.
 * 
 */

public class MyBigNumber {

    private IReceiver ireceiver;

    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }

    /**
     * Hàm dùng để cộng 2 số. Trong đó đưa vào 2 chuỗi số chỉ chứ kí tự từ 0-9.
     * @param str1 chuỗi số thứ nhất.
     * @param str2 chuỗi số thứ hai.
     */
    public String sum(final String str1, final String str2) {
        String st1 = str1;
        String st2 = str2;
        String step = "";// chuoi luu cac buoc cua phep tinh
        String process = "";
        String empty = "";// tạo ra biến có kí tự rổng;
        String sum = "";//tao ra biến lưu kết quả
        int pos;
        
       
        Pattern pattern = Pattern.compile("\\D"); // Chuỗi đại diện cho kí tự số từ [0-9]
        final Matcher isError1 = pattern.matcher(st1);// biến để lưu dữ kết quả xét chuỗi s1 
        final Matcher isError2 = pattern.matcher(st2);;// biến để lưu dữ kết quả xét chuỗi s2
        int nho = 0;//tạo ra biến lưu số để nhớ nếu kết quả cộng lớn hơn 10
        int numSum = 0; // biến dùng để lưu kết qua phép cộng của từng kì tụ trong chuỗi

        char bien1 = '0';
        char bien2 = '0';

        // bắt lỗi dữ liệu nhập vào nếu có
        //kiểm tra người dùng có nhập đủ input hay không
        if (st1.equals(empty)) {
            pos = 1;
            this.ireceiver.send("Vui lòng nhập số thứ nhất: ");
            throw new NumberException(pos);
        }

        if (st2.equals(empty)) {
            pos = 1;
            this.ireceiver.send("Vui lòng nhập số thứ 2: ");
            throw new NumberException(pos);
        }

        // Kiểm tra số âm
        if (st1.charAt(0) == '-') {
            pos = 1;
            this.ireceiver.send("không hổ trợ số âm: " + st1);
            throw new NumberException(pos);
        }

        if (st2.charAt(0) == '-') {
            pos = 1;
            ireceiver.send("Không hổ trợ số âm: " + st2);
            throw new NumberException(pos);
        }

        // Kiểm tra kí tự đặc biệt
        if (isError1.find()) {
            pos = isError1.start() + 1;
            this.ireceiver.send("Vị trí " + pos + " trong chuổi " + st1 + " không phải là số");
            throw new NumberException(pos);
        }

        if (isError2.find()) {
            pos = isError2.start() + 1;
            this.ireceiver.send("Vị trí " + pos + " trong chuổi " + st2 + " không phải là số");
            throw new NumberException(pos);

        }
        int leng1 = str1.length();
        int leng2 = str2.length();
        int max =  (leng1 > leng2) ? leng1 : leng2; // lưu giá trị length của chuỗi dài nhất
        int i = 0; //biến đếm cho vòng lặp
        for (i = 1; i <= max; i++) { // chạy vòng lặp để tham chiếu đến từng kí tự của chuổi
            bien1 = ((leng1 - i) >= 0) ? st1.charAt(leng1 - i) : '0'; // nếu chuổi 1 hết ta sẽ ghi 0
            bien2 = ((leng2 - i) >= 0) ? st2.charAt(leng2 - i) : '0'; //nếu chuổi 2 hết ta sẽ ghi 0

            numSum = (bien1 - '0') + (bien2 - '0') + nho;
            sum = Integer.toString(numSum % 10) + sum; //ghi kết quả cộng vào biến kết quả

            //lưu phần nhớ là 1 nếu kết quả cộng lớn hơn 10 
            nho = numSum / 10;

            // kiểm tra xem có phần nhớ hay không
            if (nho == 1) {
                if (st2.length() - i >= 0) {
                    process = "bước " + i + ", lấy " + bien1 + " cộng " + bien2 + " cộng " 
                        + nho + " được " + numSum + ", ghi " + numSum % 10 + ", nhớ " + nho + "\n";
                } else {
                    process = "bước " + i + ", lấy " + bien1 + " cộng " + nho 
                        + " được " + numSum + ", ghi " + numSum % 10 + ", nhớ " + nho + "\n";
                }
            } else {
                if (st2.length() - i >= 0) {
                    process = "bước " + i + ", lấy " + bien1 + " cộng " 
                        + bien2 + " được " + numSum + ", ghi " + numSum % 10 + "\n";
                } else {
                    process = "bước " + i + ", lấy " + bien1 + " cộng 0" 
                        + " được " + numSum + ", ghi " + numSum % 10 + "\n";
                }
            }

            step = step + process;
        }

        // ghi phần nhớ vào nếu phép cộng vượt số
        if (nho == 1) {
            sum = Integer.toString(nho) + sum;
            step = step + "bước " + i + ", lấy " + nho + " ghi trước kết quả\n";
        }
        step = step + "kết quả cuối cùng là " + sum + "\n";

        this.ireceiver.send(step);// gửi các bước đến ireceiver để in ra màn hình

        // trả về kết quả của phép cộng
        
        return sum;
    }
}
