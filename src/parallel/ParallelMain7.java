package parallel;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain7 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService requestPool = Executors.newFixedThreadPool(100);

        //logic 처리 전용 스레드 풀 추가
        ExecutorService logicPool = Executors.newFixedThreadPool(400);

        int nThread = 3; //1, 2, 3, 10, 20
        for (int i = 1; i < nThread; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName, logicPool));
            Thread.sleep(1000); //스레드 순서를 확인하기 위해 약간 대기
        }
        //모든 작업 제출 후 스레드 풀 종료
        requestPool.close();
        logicPool.close();
    }

    private static void logic(String requestName, ExecutorService es) {
        log("[" + requestName + "] START");
        long startTime = System.currentTimeMillis();

        //1부터 4까지의 작업을 각각의 스레드 풀에 제출
        List<Future<Integer>> futures = IntStream.rangeClosed(1, 4)
                .mapToObj(i -> es.submit(() ->  HeavyJob.heavyTask(i, requestName)))
                .toList();

        //Future 결과 취합
        int sum = futures.stream()
                .mapToInt(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).sum();

        long endTime = System.currentTimeMillis();
        log("[" + requestName + "] time: " + (endTime - startTime) + "ms, sum: " + sum);

    }
}
