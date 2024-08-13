package InterviewPrep2;

/*
Implement a custom thread-safe singleton class using the double-checked locking mechanism.
 */
public class DoubleCheckedLockedSingleton {
    static class LoginService {
        private static LoginService loginService = null;

        private LoginService() {}

        public static LoginService getLoginService() throws InterruptedException {
            if(loginService == null) { // single lock
                synchronized(LoginService.class) {
                    if(loginService == null) { // double lock
                        loginService = new LoginService();
                    }
                }
            }
            return loginService;
        }
    }

    static class Thread1 extends Thread {
        DoubleCheckedLockedSingleton.LoginService loginService;

        @Override
        public void run() {
            try {
                loginService = DoubleCheckedLockedSingleton.LoginService.getLoginService();
                System.out.println(loginService);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread2 extends Thread {
        DoubleCheckedLockedSingleton.LoginService loginService;

        @Override
        public void run() {
            try {
                loginService = DoubleCheckedLockedSingleton.LoginService.getLoginService();
                System.out.println(loginService);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

}
