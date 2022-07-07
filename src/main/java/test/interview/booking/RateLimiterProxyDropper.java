package test.interview.booking;

/**
 * User requests for a service are routed through a rate limiting proxy to ensure that the network
 * is not overloaded by non critical requests.
 * <p>
 * The proxy has the following limits:
 * <p>
 * • The number of requests in any given second cannot exceed 3. • The number of requests in any
 * given 10-second period cannot exceed 20. A ten-second period includes all requests arriving from
 * any time max(1, T-9) to T(inclusive of both) for any valid time T.
 * <p>
 * • The number of requests in any given minute cannot exceed 60. Similar to above, 1 minute is
 * from max(1, T-59) to T.
 * <p>
 * Any request that exceeds any of the above limits will be dropped by the proxy. Given the times
 * at which different requests arrive sorted ascending, find how many requests will be dropped.
 */
public class RateLimiterProxyDropper {
    public static void main(String[] args) {
        System.out.println(droppedRequests(new int[]{
                1
                , 1
                , 1
                , 1 // dropped
                , 2
                , 2
                , 2
                , 3
                , 3
                , 3
                , 3 // dropped
                , 4
                , 5
                , 5
                , 5
                , 6
                , 6
                , 6  // dropped
                , 6 // dropped
                , 7
                , 7
                , 7
                , 8
                , 8 //dropped
                , 8 //dropped
                , 8 //dropped + 1
                , 9 //dropped
                , 9 //dropped
                , 9 //dropped
                , 9 //dropped + 1
                , 9 //dropped + 1
                , 10 //dropped
                , 10 //dropped
                , 11
                , 11
                , 11
                , 11 //dropped
                , 11 //dropped
                , 11 //dropped
                , 12
                , 12
                , 12
                , 12 //dropped
                , 12 //dropped
                , 12 //dropped
                , 12 //dropped
                , 13
                , 13
                , 13
                , 13 //dropped
                , 14
                , 14
                , 14
                , 14 //dropped
                , 14 //dropped
                , 16
                , 16
                , 16
                , 16 //dropped
                , 16 //dropped
                , 16 //dropped
                , 17
                , 17
                , 17
                , 18
                , 18
                , 18
                , 18 //dropped
                , 18 //dropped
                , 18 //dropped
                , 18 //dropped
                , 18 //dropped
                , 19
                , 19
                , 19
                , 19 //dropped
                , 19 //dropped
                , 19 //dropped
                , 19 //dropped
                , 20
                , 20
                , 20
                , 20 //dropped
                , 20})); //dropped
        //Output - 67

        System.out.println(droppedRequests(new int[]{1
                , 1
                , 1
                , 1
                , 2
                , 2
                , 2
                , 3
                , 3
                , 3
                , 4
                , 4
                , 4
                , 5
                , 5
                , 5
                , 6
                , 6
                , 6
                , 7
                , 7}));

    }

    public static int droppedRequests(int[] requestTime) {
        return limit3SlidingWindow(requestTime) + limit10SlidingWindow(requestTime);
    }

    private static int limit3SlidingWindow(int[] requestTime) {
        int i = 0;
        int j = 0;
        int requestCount = 0;
        int droppedRequest = 0;

        while (j < requestTime.length) {
            if (requestTime[j] != requestTime[i]) {
                i = j;
                requestCount = 0;
            }
            if (requestTime[i] == requestTime[j]) {
                requestCount++;
            }
            if (requestCount == 4) {
                droppedRequest++;
            }
            j++;
        }
        return droppedRequest;
    }

    private static int limit10SlidingWindow(int[] requestTime) {
        int j = 0;
        int requestCount = 0;
        int droppedRequest = 0;
        int next10Sec = 10;
        while (j < requestTime.length) {
            if (requestTime[j] <= next10Sec && requestCount < 20) {
                requestCount++;
                j++;
            } else {
                if (requestTime[j] <= next10Sec) {
                    j++;
                    droppedRequest++;
                } else {
                    requestCount = 0;
                    next10Sec = next10Sec + 10;
                }
            }
        }
        return droppedRequest;
    }
}
