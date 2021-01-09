package cn.jcmenzz.tolearn.moocbd.exam;

/**
 * @author lenovo
 */
public class Week6 {
    public static void main(String[] args) {
        try {
            doSomething("&something");
        } catch (MyException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void doSomething(String s) throws MyException {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i)) && !Character.isSpaceChar(s.charAt(i))) {
                throw new MyException("String is Not a letter sequence");
            }
        }
        System.out.println("I am doing" + s);
    }
}

class MyException extends Exception {
    private String message;

    public MyException() {
        super();
    }

    public MyException(String message) throws MyException {
        for (int i = 0; i < message.length(); i++) {
            if (!Character.isLetter(message.charAt(i)) && !Character.isSpaceChar(message.charAt(i))) {
                throw new MyException();
            }
        }
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
