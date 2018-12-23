import static org.junit.Assert.*;

public class Test {

    MyBigNumber myBigNumber = new MyBigNumber();

    @org.junit.Test
    public void sum1() {
        try {
            String s = myBigNumber.sum("123", "456");
            assertEquals("579", s);
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test
    public void sum2() {
        try {
            String s = myBigNumber.sum("1235", "856");
            assertEquals("2091", s);
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test
    public void sum3() {
        try {
            String s = myBigNumber.sum("100", "900");
            assertEquals("1000", s);
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test
    public void sum4() {
        try {
            String s = myBigNumber.sum("999", "111");
            assertEquals("1110", s);
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test
    public void sum5() {
        try {
            String s = myBigNumber.sum("999", "1111");
            assertEquals("2110", s);
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test
    public void sum6() {
        try {
            String s = myBigNumber.sum("1234567890", "4");
            assertEquals("1234567894", s);
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void sum7() {
        try {
            String s = myBigNumber.sum("abs", "4");
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void sum8() {
        try {
            String s = myBigNumber.sum("-3", "4");
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void sum9() {
        try {
            String s = myBigNumber.sum("3", "4asd");
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void sum10() {
        try {
            String s = myBigNumber.sum("3", "-7");
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void sum11() {
        try {
            String s = myBigNumber.sum("-13", "-7");
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void sum12() {
        try {
            String s = myBigNumber.sum("3", "-7asdg");
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void sum13() {
        MyBigMain test = new MyBigMain();
        MyBigNumber myBigNumber = new MyBigNumber(test);
        String s = myBigNumber.sum("3", "-7asdg");
    }

    @org.junit.Test
    public void sum14() {
        try {
            String s = myBigNumber.sum("111", "999");
            assertEquals("1110", s);
        } catch (NullPointerException e) {
        }
    }

    @org.junit.Test
    public void sum15() {
        System.out.println("\n#Testcase 15:");
        String s1 = "";
        String s2 = "123";
        System.out.println("A = " + s1);
        System.out.println("B = " + s2);
        String expResult = "123";
        MyBigNumber instance = new MyBigNumber(this);
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void sum16() {
        System.out.println("\n#Testcase 16:");
        String s1 = "123";
        String s2 = "";
        System.out.println("A = " + s1);
        System.out.println("B = " + s2);
        String expResult = "123";
        MyBigNumber instance = new MyBigNumber(this);
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void sum17() {
        System.out.println("\n#Testcase 17:");
        String s1 = "";
        String s2 = "";
        System.out.println("A = " + s1);
        System.out.println("B = " + s2);
        String expResult = "0";
        MyBigNumber instance = new MyBigNumber(this);
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }

}
