package defaultmethod.ex2;

import java.time.LocalDateTime;

public interface Notifier {
    //알림을 보내는 기능
    void notify(String message);

    //신규 기능 추가
    //void scheduleNotification(String message, LocalDateTime scheduleTime);

    //default 키워드를 사용해 기본 구현 제공
    default void scheduleNotification(String message, LocalDateTime scheduleTime) {
        System.out.println("[기본 스케줄링] message: " + message + ", time: " + scheduleTime);
    }
}
