/**
 *
 * Tác giả Phạm Anh Tuấn
 */
public class NumberException extends NumberFormatException {
      private int pos;
    
    public NumberException(int num) {
        pos = num;
    }
    
    @Override
    public String toString() {
        return pos + "";
    }
    
}
